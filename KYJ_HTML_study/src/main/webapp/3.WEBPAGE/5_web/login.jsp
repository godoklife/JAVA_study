<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		*{
			border: solid 1px red;
		}
	</style>
	
	
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div class="content col-md-10 offset-2" >	<!--  ���� -->
	<div id="titlearea">
		<span class="title"> LOGIN</span>
	</div>
		<div class="col-md-4 offset-4">
			<div>
				<form action="#" method="get">
					<div>
						<input type="text" placeholder="���̵�">
						<input type="password" placeholder="��й�ȣ">
						<input type="submit" value="LOGIN"> 
					</div>
					<div id="findbox">
						<input type="checkbox"> ���̵����� &nbsp;
						�������� &nbsp;|&nbsp;
						<a href="#">���̵� ã��</a>
						<a href="#">��й�ȣ ã��</a>
					</div>
				</form>
				<img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_naver_login.gif">
				<img src="https://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_facebook_login.gif">
				<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_kakao_login.gif">
				<img src="//img.echosting.cafe24.com/skin/base_ko_KR/member/btn_apple_login.gif">
			</div>
		</div>
	
		<%@include file="footer.jsp" %>
	</div>

	
</body>
</html>