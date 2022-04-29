<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> get 방식 form </h1>
	<form action = "signupcontroller.jsp" method="get">
		<input type="text" name="id" placeholder="아이디를 입력하시오.">
		<input type = "password" name = "password">
		<input type = "text" name = "name">
		<input type = "submit" value = "전송!">
	</form>
	<br><br><br>
	<h1> 이하 post 방식 form</h1>
	<form action = "signupcontroller.jsp" method="post">
		<input type="text" name="id" placeholder="아이디를 입력하시오.">
		<input type = "password" name = "password">
		<input type = "text" name = "name">
		<input type = "submit" value = "전송!">
	</form>
	
</body>
</html>