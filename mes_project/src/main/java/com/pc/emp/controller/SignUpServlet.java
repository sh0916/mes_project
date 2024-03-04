package com.pc.emp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pc.emp.dao.EmpRepositoryJDBC;
import com.pc.emp.dto.Account;
import com.pc.emp.dto.Employee;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("search".equals(action)) {
			searchAccount(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/signup.jsp");
	        dispatcher.forward(request, response);
		}
	}

	// get name
	private void searchAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		try {
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmpRepositoryJDBC acctRepo = new EmpRepositoryJDBC();
			Account account = acctRepo.getAcct(empno); // 데이터베이스에서 직원 정보 조회

			PrintWriter out = response.getWriter();

			if (account != null) {
				// 직원 정보를 JSON 형태로 변환
				String json = new Gson().toJson(account);
				out.print(json);
			} else {
				// 직원 정보가 없는 경우, 오류 메시지를 포함한 JSON 응답
				out.print("{\"success\":false, \"message\":\"해당 직원을 찾을 수 없습니다.\"}");
			}
			out.flush();
		} catch (NumberFormatException e) {
			response.getWriter().print("{\"success\":false, \"message\":\"잘못된 직원 번호 형식입니다.\"}");
			response.getWriter().flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
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
			// 필수 필드 검사
	        if (account.getEmpno() == 0 || account.getUserId() == null || account.getUserId().trim().isEmpty() ||
	            account.getPassword() == null || account.getPassword().trim().isEmpty() ||
	            account.getEMail() == null || account.getEMail().trim().isEmpty() ||
	            account.getTel() == null || account.getTel().trim().isEmpty()) {
	            
	            response.getWriter().write("{\"success\": false, \"message\": \"계정 정보 업데이트에 실패했습니다. 필수 정보가 누락되었습니다.\"}");
	            return;
	        }
			EmpRepositoryJDBC empRepository = new EmpRepositoryJDBC();
			// 이미 등록된 계정일 경우 리턴
			if (!empRepository.isAccountInfoEmpty(account.getEmpno())) {
	            response.getWriter().write("{\"success\": false, \"message\": \"계정 정보 등록에 실패했습니다. 이미 정보가 저장된 사용자입니다.\"}");
	            return;
	        }
			// 계정 정보 등록 전 중복 확인
	        if (empRepository.existsByUserId(account.getUserId())) {
	            // 이미 존재하는 경우, 업데이트 거부
	            response.getWriter().write("{\"success\": false, \"message\": \"이미 존재하는 userId입니다.\"}");
	            return;
	        }
			
			boolean updateSuccess = empRepository.updateAccount(account); // 계정 정보 업데이트

			if (updateSuccess) {
				JsonObject jsonResponse = new JsonObject();
			    jsonResponse.addProperty("success", true);
			    jsonResponse.addProperty("message", "계정 등록이 완료되었으며, 관리자 승인까지 영업일 기준 2~3일 소요된 후 로그인 가능합니다.");
			    response.getWriter().write(jsonResponse.toString());
			} else {
				response.getWriter().write("{\"success\": false, \"message\": \"계정 정보 등록에 실패했습니다.\"}");
			}

		}

	}

}
