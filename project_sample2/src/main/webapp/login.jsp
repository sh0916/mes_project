<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<form name="frm" action="login" method="post"
		onsubmit="return fn_action();">
		<header>
			<div class="logo">
				<img src="${pageContext.request.contextPath}/images/logo.png"
					class="logo">
			</div>
		</header>
		<nav>
			<div class="input">
				<input type="text" name="userid" class="input1" autofocus
					placeholder="아이디"><br> <input type="password"
					name="password" class="input2" placeholder="비밀번호">
			</div>
			<div id="error" style="color: red;">
				<%=request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : ""%>
			</div>
			<button type="submit" name="login" class="btn1">
				<strong>로그인</strong>
			</button>
		</nav>
	</form>
	<script src="js/login.js"></script>
</body>

</html>