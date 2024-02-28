package com.pc.emp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pc.emp.dto.Account;
import com.pc.emp.dto.Employee;
import com.pc.emp.dto.Role;

public class EmpRepositoryJDBC implements EmpRepository {
	public EmpRepositoryJDBC() {
	}

	@Override // 아이디 조회
	public Employee findByUserId(String userId) {
		Employee empolyee = null;
		EmpDAO empDAO = new EmpDAO();
		Connection con = empDAO.getConn();
		String sql = "SELECT * FROM staff WHERE userId = ?";
		System.out.println(sql);
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			System.out.println("userId: " + userId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				empolyee = new Employee();
				empolyee.setUserId(rs.getString("userId"));
				empolyee.setPassword(rs.getString("password"));
				System.out.println("rs.getString(password): " + rs.getString("password"));
				empolyee.setName(rs.getString("sname"));
				String roleStr = rs.getString("role");
				Role role = Role.fromString(roleStr);
				empolyee.setRole(role);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empolyee;
	}

	// 권한 조회 메소드
	public Role getRole(int empno) {
		EmpDAO empDAO = new EmpDAO();
		Connection con = empDAO.getConn();
		Role role = null; // Role Enum으로 선언
		String sql = "SELECT role FROM staff WHERE staffno = ?"; // 쿼리 수정: role 열 조회
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empno);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String roleStr = rs.getString("role"); // 데이터베이스에서 조회한 역할 문자열
				role = Role.fromString(roleStr); // 문자열을 Role Enum으로 변환
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return role; // Role Enum 반환
	}

	// 권한을 업데이트하는 메서드
	public boolean updateRole(int empno, String newRole) {
		EmpDAO empDAO = new EmpDAO();
		Connection con = empDAO.getConn();
		PreparedStatement ps = null;
		boolean updateSuccess = false;

		try {
			con.setAutoCommit(false); // 수동 커밋 모드 설정
			String sql = "UPDATE staff SET role = ? WHERE staffno = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, newRole);
			ps.setInt(2, empno);

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				updateSuccess = true;
			}

			con.commit(); // 변경사항 커밋
		} catch (Exception e) {
			try {
				con.rollback(); // 예외 발생 시 롤백
			} catch (SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateSuccess;
	}

	@Override
	public List<Account> getAccountList() {
		EmpDAO empDAO = new EmpDAO();
		Connection con = empDAO.getConn();
		List<Account> acctList = new ArrayList<Account>();
		String sql = "SELECT staffno, sname, userId, role FROM staff ORDER BY staffno DESC";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("userId");
				if (userId == null || userId.trim().isEmpty()) {
					continue;
				}

				Account acct = new Account();
				acct.setEmpno(rs.getInt("staffno"));
				acct.setName(rs.getString("sname"));
				acct.setUserId(rs.getString("userId"));
				String roleStr = rs.getString("role");
				Role role = Role.fromString(roleStr);
				acct.setRole(role);
				// 수정된 부분: 각 행의 정보를 acctList에 추가
				acctList.add(acct);

			}
			rs.close();
			ps.close();
			con.close();

			System.out.println("AcctList contents: " + acctList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return acctList;
	}

	@Override // 직원 목록 조회 메소드
	public List<Employee> getEmpList(Employee employee) {
		// DB 호출
		EmpDAO empDAO = new EmpDAO();
		Connection con = empDAO.getConn();
		List<Employee> empList = new ArrayList<Employee>();
		// sql문 작성
		String sql = "SELECT * FROM staff WHERE lower(sname) LIKE '%' || lower(?) || '%' ORDER BY staffno ASC";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("staffno"));
				emp.setName(rs.getString("sname"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setDuty(rs.getString("sduty"));
				emp.setSal(rs.getInt("sal"));
				emp.setDeptno(rs.getInt("offino"));
				empList.add(emp);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	// 직원 정보 조회
	public Employee getEmp(int empno) {
		// DB 호출
		EmpDAO empDAO = new EmpDAO();
		Connection con = empDAO.getConn();
		Employee emp = null;
		// sql문 작성
		String sql = "SELECT * FROM staff WHERE staffno = ?";
		System.out.println(sql);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empno);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				emp = new Employee();
				emp.setEmpno(rs.getInt("staffno"));
				emp.setName(rs.getString("sname"));
				emp.setDuty(rs.getString("sduty"));
				emp.setSal(rs.getInt("sal"));
				emp.setDeptno(rs.getInt("offino"));

			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	// 직원 추가
	public boolean addEmp(Employee emp) {
		EmpDAO empDAO = new EmpDAO();
		Connection con = empDAO.getConn();
		// SQL INSERT 문
		String sql = "INSERT INTO staff (sname, hiredate, sduty, sal, offino) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setDate(2, new Date(emp.getHiredate().getTime())); // java.util.Date를 java.sql.Date로 변환
			ps.setString(3, emp.getDuty());
			ps.setInt(4, emp.getSal());
			ps.setInt(5, emp.getDeptno());

			int result = ps.executeUpdate(); // SQL 실행

			ps.close();
			con.close();

			return result > 0; // 삽입 성공 여부 반환 (성공하면 true, 실패하면 false)
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // 예외 발생 시 실패로 처리
		}
	}

	// 직원 수정
	public boolean updateEmp(Employee employee) {
		try {
			EmpDAO empDAO = new EmpDAO();
			Connection con = empDAO.getConn();
			String sql = "UPDATE staff SET sname=?, sduty=?, sal=?, offino=? WHERE staffno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getDuty());
			ps.setInt(3, employee.getSal());
			ps.setInt(4, employee.getDeptno());
			ps.setInt(5, employee.getEmpno());
			int result = ps.executeUpdate();
			ps.close();
			con.close();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 직원 삭제
	public boolean deleteEmp(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isDeleted = false;

		try {
			EmpDAO empDAO = new EmpDAO();
			conn = empDAO.getConn();
			String sql = "DELETE FROM staff WHERE staffno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);

			int rowsAffected = pstmt.executeUpdate();
			isDeleted = rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isDeleted;
	}

	// 직원 번호 중복체크
	public boolean isEmpNumberExist(int empNumber) {
		EmpDAO empDAO = new EmpDAO();
		Connection con = empDAO.getConn();
		String sql = "SELECT COUNT(staffno) FROM staff WHERE staffno = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0;
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
