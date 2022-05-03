<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@include file = "../header.jsp" %>
	<div class="container my-5 col-md-4 offset-4 text-center">
		<form action="../Login" method = "post">
			로그인 : <input type = "text" name = "mid"><br>
			비밀번호 : <input type = "text" name = "mpassword">
			<input type = "submit" value = "로그인">
			<!--  만약 로그인 실패시 자바 실행 -->
			<%
				String result = request.getParameter("result");
				if(result != null && result.equals("2")){
			%>
				<h1>아이디나 비밀번호를 확인하세요.</h1>	
			<%
				}
			%>
		</form>
	</div>
	<%@include file = "../footer.jsp" %>

</body>
</html>