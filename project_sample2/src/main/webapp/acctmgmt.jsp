<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Work Record Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/acctmgmt.css">
<style>
@font-face {
	font-family: "SOYOMapleBoldTTF";
	src:
		url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2310@1.0/SOYOMapleBoldTTF.woff2")
		format("woff2");
	font-weight: 400;
	font-style: normal;
}
</style>
</head>
<body>
	<%
	// 세션에서 권한 정보 가져오기
	session = request.getSession(false);
	String role = null;
	if (session != null) {
		role = (String) session.getAttribute("role");
	}

	if (!"ADMIN".equals(role)) {
		response.sendRedirect("main.jsp");
		return;
	}

	String displayGrade = "잘못된 접근";
	String displayTitle = "잘못된 접근";
	if ("ADMIN".equals(role)) {
		displayGrade = "관리자";
		displayTitle = "관리자 페이지";
	} else if ("WORKER".equals(role)) {
		displayGrade = "작업자";
		displayTitle = "작업자 페이지";
	}
	%>
	<div id="workerTitle">
		<div id="workerLogo">
			<a href="#"> <image
					src="${pageContext.request.contextPath}/images/logo.png"
					class="logo"></image>
			</a>
		</div>
		<h1 id="mainTitle"><a href="main.jsp"><%=displayTitle%></a></h1>
		<div id="myPage">
			<div id="myPageLogo">
				<image src="${pageContext.request.contextPath}/images/bee_happy.png"
					class="workerPic">
			</div>
			<span id="workerName"><span class="workerGrade"><%=displayGrade%><br></span>${sessionScope.name}
			</span>
		</div>
	</div>

	<div class="wrap">
		<div class="header-nav-container">
			<header>
				<!-- 모바일 헤더 코드 -->
				<div class="header-content">
					<div class="hamburger-menu">
						<span></span> <span></span> <span></span>
					</div>
					<h1 id="headerTitle" style="display: none;">
						<a href="main.html">J.company</a>
					</h1>
				</div>
				<ul>
					<li><a href="work-order.html" class="hover" title="작업지시서">작업</a></li>
					<li><a href="facilityMonitoring.html" class="hover"
						title="품질검사">설비</a></li>
					<li><a href="stock_status.html" class="hover" title="건의사항">재고관리</a></li>
					<%
					if ("ADMIN".equals(role)) {
					%>
					<li id="adminTitle"><a href="Employee_managemen.html"
						class="hover" title="직원관리">직원관리</a></li>
					<li><a href="boardTable.html" class="hover" title="직원 게시판">게시판</a></li>
					<%
					}
					%>
				</ul>
			</header>
			<nav>
				<div class="menu-bar">
					<div class="menu-bar-content">
						<ul>
							<li><a href="work-order.html">작업 지침서</a></li>
							<li><a href="work-safety.html">안전 지침서</a></li>
							<li><a href="work-quality.html">품질검사</a></li>
							<li><a href="work-report.html">작업보고</a></li>
						</ul>
					</div>
					<div class="menu-bar-content">
						<ul>
							<li><a href="facilityMonitoring.html">설비 모니터링</a></li>

							<li><a href="process.html">공정도</a></li>

							<li><a href="facilitiespage.html">설비 설정</a></li>
						</ul>
					</div>
					<div class="menu-bar-content">
						<ul>
							<li><a href="stock_status.html">재고 현황</a></li>
							<li><a href="Stock_Request.html">재고 신청</a></li>
							<li><a href="Finished_product_management.html">완제품 관리</a></li>
							<li><a href="Report_of_defective_inventory.html">재고 불량
									신고</a></li>
						</ul>
					</div>
					<%
					if ("ADMIN".equals(role)) {
					%>
					<div class="menu-bar-content" id="adminNav">
						<ul>
							<li><a href="emp">직원목록</a></li>
							<li><a href="work-record.html">근무기록</a></li>
							<li><a href="vacation.html">휴가신청</a></li>
						</ul>
					</div>
					<%
					}
					%>
					<div class="menu-bar-content">
						<ul>
							<li><a href="boardTable.html">자유게시판</a></li>
							<li><a href="suggestTable.html">건의사항</a></li>
							<li><a href="QA.html">Q&A</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="aside-section-container">
			<aside>
				<ul>
					<li><a href="emp">직원목록</a></li>
					<li><a href="#">권한관리</a></li>
					<li><a href="#">휴가신청</a></li>
				</ul>
			</aside>
			<section>
				<article class="article-container">
					<div class="accountView">
						<h1>계정목록</h1>
						<div class="accountList"></div>
						<table class="Staff_list">
								<colgroup>
								<col style="width: 15%;">
       							<col style="width: 15%;">
        						<col style="width: 25%;">
        						<col style="width: 25%;">
    								</colgroup>
							<thead>
								<tr>
									<th class="column1">직원번호</th>
									<th class="column2">성명</th>
									<th class="column3">아이디</th>
									<th class="column5">권한등급</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${accmgmt}">
									<tr>
										<td><c:out value="${acct.empno}" /></td>
										<td><c:out value="${acct.name}" /></td>
										<td><c:out value="${acct.userId}" /></td>
										<td><c:out value="${acct.role}" /></td>
									</tr>
								</c:forEach>
								<!-- 추가 직원 정보 행 -->
							</tbody>
						</table>
					</div>
				</article>
			</section>
		</div>
		<footer>ⓒ2024 J.company System</footer>
	</div>
	<script src="${pageContext.request.contextPath}/js/acctmgmt.js"></script>
</body>

</html>