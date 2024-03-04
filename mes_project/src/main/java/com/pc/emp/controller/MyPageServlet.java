package com.pc.emp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.pc.emp.dao.EmpRepositoryJDBC;
import com.pc.emp.dto.Absent;
import com.pc.emp.dto.Account;
import com.pc.emp.dto.BoardDTO;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		Integer sessionEmpno = (Integer) request.getSession().getAttribute("empno");
		if (sessionEmpno == null) {
			response.getWriter().write("{\"success\": false, \"message\": \"세션 정보가 유효하지 않습니다.\"}");
			return;
		}

		String action = request.getParameter("action");
		if ("update".equals(action)) {
			StringBuilder jsonBuilder = new StringBuilder();
			String line;
			try (BufferedReader reader = request.getReader()) {
				while ((line = reader.readLine()) != null) {
					jsonBuilder.append(line);
				}
			}
			String json = jsonBuilder.toString();
			Gson gson = new Gson();
			Account account = gson.fromJson(json, Account.class); // JSON을 Account 객체로 변환
			account.setEmpno(sessionEmpno);

			EmpRepositoryJDBC empRepository = new EmpRepositoryJDBC();
			// 계정 정보 등록 전 중복 확인
			if (empRepository.existsByUserId(account.getUserId())) {
				// 이미 존재하는 경우, 업데이트 거부
				response.getWriter().write("{\"success\": false, \"message\": \"이미 존재하는 userId입니다.\"}");
				return;
			}

			boolean updateSuccess = empRepository.updateAccount2(account); // 계정 정보 업데이트

			if (updateSuccess) {
				JsonObject jsonResponse = new JsonObject();
				jsonResponse.addProperty("success", true);
				jsonResponse.addProperty("message", "계정 정보가 수정되었습니다.");
				response.getWriter().write(jsonResponse.toString());
			} else {
				response.getWriter().write("{\"success\": false, \"message\": \"계정 정보 수정에 실패하였습니다.\"}");
			}

		} else if ("vacation".equals(action)) {
			StringBuilder jsonBuilder = new StringBuilder();
			String line;
			while ((line = request.getReader().readLine()) != null) {
				jsonBuilder.append(line);
			}
			String json = jsonBuilder.toString();
			Gson gson = new Gson();

			// JSON 데이터를 Map으로 변환
			Type type = new TypeToken<Map<String, String>>() {
			}.getType();
			Map<String, String> jsonData = gson.fromJson(json, type);

			// 세션에서 empno 가져오기
			Integer empno = (Integer) request.getSession().getAttribute("empno");
			if (empno == null) {
				response.getWriter().write("{\"success\": false, \"message\": \"사용자 인증이 필요합니다.\"}");
				return;
			}

			// 시작일과 종료일 문자열 추출
			String startDateString = jsonData.get("startDate");
			String endDateString = jsonData.get("endDate");
			String reason = jsonData.get("reason");

			// SimpleDateFormat을 사용하여 문자열을 java.util.Date로 변환
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedStartDate;
			java.util.Date parsedEndDate;
			try {
				parsedStartDate = format.parse(startDateString);
				parsedEndDate = format.parse(endDateString);
			} catch (ParseException e) {
				// 날짜 형식이 올바르지 않을 때 처리
				e.printStackTrace();
				response.getWriter().write("{\"success\": false, \"message\": \"날짜 형식이 올바르지 않습니다.\"}");
				return;
			}

			// java.util.Date를 java.sql.Date로 변환
			java.sql.Date startDate = new java.sql.Date(parsedStartDate.getTime());
			java.sql.Date endDate = new java.sql.Date(parsedEndDate.getTime());

			// Absent 객체 생성 및 설정
			Absent absent = new Absent();
			absent.setEmpno(empno);
			absent.setStartDate(startDate);
			absent.setEndDate(endDate);
			absent.setReason(reason);

			// 데이터베이스 업데이트 로직
			EmpRepositoryJDBC empRepository = new EmpRepositoryJDBC();
			boolean updateSuccess = empRepository.updateAbsent(absent);

			// 업데이트 성공 여부에 따라 응답 반환
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			if (updateSuccess) {
				response.getWriter().write("{\"success\": true, \"message\": \"휴가 정보가 성공적으로 업데이트되었습니다.\"}");
			} else {
				response.getWriter().write("{\"success\": false, \"message\": \"휴가 정보 업데이트에 실패했습니다.\"}");
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if ("userinfo".equals(action)) {
			String userId = (String) request.getSession().getAttribute("user");
			if (userId == null || userId.isEmpty()) {
				response.getWriter().write("{\"success\": false, \"message\": \"세션 정보가 유효하지 않습니다.\"}");
				return;
			}

			EmpRepositoryJDBC empRepository = new EmpRepositoryJDBC();
			Account account = empRepository.findByUserId(userId); // 세션에서 받은 userId로 사용자 정보 조회

			if (account != null) {
				Gson gson = new Gson();
				String accountJson = gson.toJson(account); // 조회된 Account 객체를 JSON 문자열로 변환
				response.getWriter().write(accountJson);

			} else {
				response.getWriter().write("{\"success\": false, \"message\": \"사용자 정보를 찾을 수 없습니다.\"}");
			}
		} else {	    
			try {
				showSuggestBoard(request, response);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
				System.out.println("건의게시판 못들어감");
			}
		}
		
	}
	
	void showSuggestBoard(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Connection con = getConn();
		List list = new ArrayList();
		String query = "";
		query += " select";
		query += " *";
		query += " from";
		query += " test2";
		query += " where boardType = '건의게시판'";

		System.out.println("query : " + query);
		PreparedStatement ps = con.prepareStatement(query);

//		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String boardType = rs.getString("boardType");
			int seq = rs.getInt("seq");
			String userId = rs.getString("userId");
			String num = rs.getString("num");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			Date wDate = rs.getDate("wdate");
			int hits = rs.getInt("hits");

			BoardDTO dto = new BoardDTO();
			dto.setBoardType(boardType);
			dto.setSeq(seq);
			dto.setUserId(userId);
			dto.setNum(num);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setWriter(writer);
			dto.setWdate(wDate);
			dto.setHits(hits);

			list.add(dto);
		}
		rs.close();
		ps.close();
		con.close();

		request.setAttribute("list", list);

		// 디스패쳐 포워드로 jsp로 보낸다.
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/mypage.jsp");

		try {
			dispatch.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Connection getConn() {
		// DB 접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott4_3";
		String password = "tiger";

		Connection con = null;

		try {
			// 드라이버 로딩
			// Class.forName : String 변수로 class 생성
			Class.forName(driver);

			// DB 접속
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("예외");
		}
		return con;
	}
}