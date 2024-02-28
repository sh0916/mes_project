<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Project 1</title>
<link rel="stylesheet" href="css/main.css">
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
<body onload="showClock()">
	<%
	// 세션에서 권한 정보 가져오기
	session = request.getSession(false);
	String role = null;
	if (session != null) {
		role = (String) session.getAttribute("role");
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
		<h1 id="mainTitle1">
			<a href="main.html"><%=displayTitle%></a>
		</h1>
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
					<%
					}
					%>
					<li><a href="boardTable.html" class="hover" title="직원 게시판">게시판</a></li>
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
							<li><a href="acctmgmt.jsp">권한관리</a></li>
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
				<!-- aside 영역내에 메뉴 추가 가능함 -->
			</aside>
			<section>
				<div class="dashboard-header">
					<div class="titleAndToggle" style="display: flex;">
						메인 페이지
						<div id="toggleDiv"></div>
					</div>
					<div id="divClock" class="clock"></div>
				</div>

				<div class="dashboard-main">
					<div class="card">
						<a href="Finished_product_management.html"
							style="color: inherit; text-decoration: none;">
							<div class="card-header">제작 현황</div>
							<div class="card-content">
								<canvas id="productionChart"></canvas>
							</div>
							<table class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>등급</th>
										<th>수량</th>
										<th>상태</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>퍼포먼스</td>
										<td>12</td>
										<td>생산</td>
									</tr>
									<tr>
										<td>2</td>
										<td>메인 스트림</td>
										<td>50</td>
										<td>출고</td>
									</tr>
									<tr>
										<td>3</td>
										<td>엔트리</td>
										<td>120</td>
										<td>출고</td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</a>
					</div>
					<div class="card">
						<div class="card-header">양품률</div>
						<div class="card-content">
							<div id="entryGage">
								<div class="gage-label">엔트리</div>
							</div>
							<div id="mainStreamGage">
								<div class="gage-label">메인스트림</div>
							</div>
							<div id="performanceGage">
								<div class="gage-label">퍼포먼스</div>
							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header">건의사항</div>
						<div class="card-content">
							<div class="list">
								<!-- row는 행임 제목 영역에 제목 -->
								<div class="row">
									<div class="cell">번호</div>
									<div class="cell">제목</div>
									<div class="cell">작성일</div>
									<div class="cell">답변</div>
								</div>
								<div class="row">
									<div class="cell">101</div>
									<div class="cell">이도연 도망감</div>
									<div class="cell">암튼어제</div>
									<div class="cell">O</div>
								</div>
								<div class="row">
									<div class="cell">103</div>
									<div class="cell">untitle</div>
									<div class="cell">Date</div>
									<div class="cell">?</div>
								</div>
								<div class="row">
									<div class="cell">104</div>
									<div class="cell">untitle</div>
									<div class="cell">Date</div>
									<div class="cell">?</div>
								</div>
								<div class="row">
									<div class="cell">107</div>
									<div class="cell">untitle</div>
									<div class="cell">Date</div>
									<div class="cell">?</div>
								</div>
							</div>
							<div class="more">
								<a href="suggestTable.html">더보기</a>
							</div>
						</div>
					</div>
					<div class="card">
						<a href="vacation.html" id="vacationLink"
							style="color: inherit; text-decoration: none;">
							<div class="card-header">휴가 내역</div> 
							<% if ("ADMIN".equals(role)) { %>
							<div class="card-content">
								<div class="vacation-dashboard">
									<div class="vacation-card">
										<div class="vacation-card-header">
											<h2>차장</h2>
										</div>
										<div class="vacation-card-content">
											<p>
												<strong>휴가 시작일:</strong><br> 2024-01-31
											</p>
											<p>
												<strong>휴가 종료일:</strong><br> 2024-02-02
											</p>
											<p>
												<strong>휴가 유형:</strong> 연차
											</p>
										</div>
									</div>
									<div class="vacation-card">
										<div class="vacation-card-header">
											<h2>팀장</h2>
										</div>
										<div class="vacation-card-content">
											<p>
												<strong>휴가 시작일:</strong><br> 2024-02-06
											</p>
											<p>
												<strong>휴가 종료일:</strong><br> 2024-02-07
											</p>
											<p>
												<strong>휴가 유형:</strong> 연차
											</p>
										</div>
									</div>
									<div class="vacation-card">
										<div class="vacation-card-header">
											<h2>직원3</h2>
										</div>
										<div class="vacation-card-content">
											<p>
												<strong>휴가 시작일:</strong><br> 2024-02-20
											</p>
											<p>
												<strong>휴가 종료일:</strong><br> 2024-02-21
											</p>
											<p>
												<strong>휴가 유형:</strong> 연차
											</p>
										</div>
									</div>
								</div>
							</div>
						<%}%>
						</a>
					</div>

					<div class="line-cards">
						<div class="line-card">
							<a href="facilityMonitoring.html"
								style="color: inherit; text-decoration: none;">
								<div class="card-header2">
									<h3>생산 라인</h3>
								</div>
								<div class="card-content2">
									<div class="status" id="cpu-status">Pending</div>
									<div class="defect-rate" id="cpu-defect-rate">불량률: 0%</div>
									<div class="defect-count" id="cpu-defect-count">불량: 0</div>
									<div class="good-count" id="cpu-good-count">통과: 0</div>
									<div class="cycle-count" id="cpu-operations">사이클 횟수: 0</div>
								</div>
							</a>
						</div>
						<div class="line-card">
							<a href="stock_status.html"
								style="color: inherit; text-decoration: none;">
								<div class="card-header2">
									<h3>재고현황</h3>
								</div>
								<div class="card-content3">
									<table class="table2">
										<thead>
											<tr>
												<th>품목</th>
												<th>양품 수량</th>
												<th>양품 재고위치</th>
												<th>불량 수량</th>
												<th>불량 재고위치</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>CPU1</td>
												<td>100</td>
												<td>A-01</td>
												<td>20</td>
												<td>A-11</td>
											</tr>
											<tr>
												<td>CPU2</td>
												<td>75</td>
												<td>A-02</td>
												<td>10</td>
												<td>A-12</td>
											</tr>
											<tr>
												<td>CPU3</td>
												<td>20</td>
												<td>A-03</td>
												<td>5</td>
												<td>B-13</td>
											</tr>
										</tbody>
									</table>
								</div>
							</a>
						</div>
					</div>
				</div>
			</section>
		</div>
		<footer>ⓒ2024 J.company System</footer>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.3.0/raphael.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/justgage/1.3.2/justgage.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>