<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 등록</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/signup.css">
<style>
@font-face {
	font-family: "SOYOMapleBoldTTF";
	src:
		url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2310@1.0/SOYOMapleBoldTTF.woff2")
		format("woff2");
	font-weight: 400;
	font-style: normal;
}

body {
	font-family: "SOYOMapleBoldTTF";
}
</style>
</head>
<body>
	<h1>계정 등록</h1>
	<div class="signupBox">
		<div class="searchBox">
			<label for="SearchEmpNo">직원번호 검색</label> <input type="text"
				id="SearchEmpNo" name="SearchEmpNo">
			<div class="searchMessage"></div>
			<button type="submit" name="action" value="search" class="search"
				onclick="searchEmployee()">조회</button>
		</div>
		<div class="nameBox">
			<label for="name">성명</label> <input type="text" id="name" name="name"
				value="${employee.name}" data-original="${employee.name}" readonly
				placeholder="직원 번호를 조회하면, 해당하는 직원의 이름이 표시됩니다.">
		</div>
	</div>
	<div id="account-form">
		<div class="idBox">
			<label for="userId">아이디</label> <input type="text" id="userId"
				name="userId">
			<div class="idLength"></div>
		</div>
		<div class="passBox">
			<label for="password">비밀번호</label> <input type="text" id="password"
				name="password">
			<div class="passLength"></div>
		</div>
		<div id="email-input-container">
			<label for="email-input">Email</label> <input type="email"
				id="email-input" name="email" autocomplete="off" placeholder="ex.jcompany@example.com">
			<div id="suggestions"></div>
			<div class="mailCheck"></div>
		</div>
		<div class="telBox">
			<label for="tel">전화번호</label> <input type="text" id="tel" name="tel"  placeholder="ex.010-1234-5678">
			<div class="telCheck"></div>
		</div>
		<div class="submitArea">
			<div id="updateMessage"></div>
			<button type="submit" id="update" name="action" value="update"
				class="update" onclick="updateAccount()">계정 등록</button>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/signup.js"></script>
</body>
</html>