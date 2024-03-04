package com.pc.emp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pc.emp.dto.BoardDTO;

import java.util.*;

@WebServlet("/main3")
public class MainServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showSuggestBoard(request, response);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			System.out.println("건의게시판 못들어감");
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

		//	디스패쳐 포워드로 jsp로 보낸다.
		RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");

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
