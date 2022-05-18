<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div class="row my-5">
			<div>
				아이디 : <input type="text" id="id"><br>
				비밀번호 : <input type="password" id="password"><br>
				
			
				<button type="button" onclick="login()">로그인</button>
				<button disabled="disabled">회원가입</button>
			</div>
		</div>
	</div>
	
	
	
	
	<%@include file="footer.jsp" %>
	<script src="js/login.js" type="text/javascript"></script>
</body>
</html>