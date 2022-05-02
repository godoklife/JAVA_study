<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  해더 영역 -->
	<%@include file="../header.jsp" %>
	
	<div class="container">
		<h3> 회원 가입 페이지</h3>
		<form action="">
			아이디 : <input type="text" id = "mid" placeholder="아이디를 입력하세요">
			<span id = "idcheck"> </span>
			비밀번호 : <input type="password" id = "mpassword" placeholder="비밀번호를 입력하세요"> 
			비밀번호 확인 : <input type="password" id = "mpasswordcheck" placeholder="비밀번호를 한번 더 입력하세요">
			이름 : <input type = "text" id = "mname" placeholder="이름을 입력하세요">
			전화번호 : <input type = "text" id = "mphone" placeholder = "전화번호를 입력하세요">
			E-mail : <input type = "text" id = "memail" placeholder = "이메일주소를 입력하세요">
			주소 : <input type = "text" id = "maddress" placeholder = "주소를 입력하세요">
			<button onclick="signup()" type = "button">가입하기!</button>
		</form>
	</div>
	
	
	
	
	
	<!--  푸터 영역 -->
	<script src="../js/signup.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>