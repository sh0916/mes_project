package com.pc.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pc.emp.dao.EmpRepositoryJDBC;
import com.pc.emp.dto.Account;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action"); // 액션값 가져오기

		if ("list".equals(action)) {
			// 직원 목록을 가져오는 작업 수행
			EmpRepositoryJDBC acctRepo = new EmpRepositoryJDBC();
			List<Account> acctList = acctRepo.getAccountList();
			String json = gson.toJson(acctList);

			// JSON 형식으로 응답 반환
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 액션값입니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("updateRole".equals(action)) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			String newRole = request.getParameter("newRole");

			EmpRepositoryJDBC acctRepo = new EmpRepositoryJDBC();
			boolean updateSuccess = acctRepo.updateRole(empno, newRole);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			if (updateSuccess) {
				out.print("{\"success\": true, \"message\": \"Role updated successfully.\"}");
			} else {
				out.print("{\"success\": false, \"message\": \"Failed to update role.\"}");
			}
			out.flush();
		} else {
			// 기존 doGet 메서드 호출
			doGet(request, response);
		}
	}

}
