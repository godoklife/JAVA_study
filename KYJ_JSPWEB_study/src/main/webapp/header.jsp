<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KYJ's 쇼핑몰</title>
	<!--  부트스트랩 CSS CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 사용자 정의 CSS -->
	<link href="/KYJ_JSPWEB_study/css/main.css" rel="stylesheet">

</head>
<body>
	<!-- 해더페이지는 서로 다른 페이지(경로)에서 실행되어야 하기 때문에 절대경로로 작성해야함. -->
	<a href="/KYJ_JSPWEB_study/main.jsp"> main page </a>
	<a href="/KYJ_JSPWEB_study/member/login.jsp"> 로그인 </a>
	<a href="/KYJ_JSPWEB_study/member/signup.jsp"> 회원가입 </a>
	
	<div class="container">
		해더 영역 컨테이너
	</div>
	
	
	
	<!-- 사용자 정의 JS -->
	<script src="js/main.js" type="text/javascript"></script>
	<!-- 부트스트랩 스크립트 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>