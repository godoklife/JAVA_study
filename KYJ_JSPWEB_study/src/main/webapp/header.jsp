<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>P H O N E T A K U</title>
	<!--  부트스트랩 CSS CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 사용자 정의 CSS -->
	<link href="/KYJ_JSPWEB_study/css/main.css" rel="stylesheet">
	<!-- 폰트어썸[ 아이콘 ]  -->
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

</head>
<body>
	<!-- 해더페이지는 서로 다른 페이지(경로)에서 실행되어야 하기 때문에 절대경로로 작성해야함. -->
	<%
		String loginid = (String)session.getAttribute("login");	// 세션 호출, 기본타입 : Object
	%>
	<div style="background-color:#abd0bc;">
		<%if(loginid!=null && loginid.equals("admin")) {%>
			<marquee scrollamount="5" class="topmarquee"> 관리자 계정으로 로그인 하셨습니다!!!</marquee>
		<%} %>
		<div class="container">
		
			<div class = "row py-4">
				<div class="col-md-4">
					<img src=""><span id="logo">LOGO</span>
				</div>
				<div class="col-md-5 offset-3 d-flex justify-content-end">
				<ul class="nav">	<!--  nav : li 를 가로배치하는 부트스트랩 -->
					<li><a href="/KYJ_JSPWEB_study/teamchatting.jsp" style="color:red;">DB형 채팅방</a> | </li>
					<li><a href="/KYJ_JSPWEB_study/board/chatting.jsp" style="color:red;">소켓형 채팅방</a> | </li>
					<li><a href="/KYJ_JSPWEB_study/main.jsp">HOME</a> | </li>
					<!--  로그인이 되지 않은 상태 -->
					<% if(loginid==null) { %>
						<li> <a href="/KYJ_JSPWEB_study/member/login.jsp"> 로그인 </a> | </li>
						<li><a href="/KYJ_JSPWEB_study/member/signup.jsp"> 회원가입 </a> | </li>
					<% } else if (loginid!=null) {%>
					<!--  만약 로그인 아이다가 admin이면 관리자 페이지로 이동 -->
						<%if(loginid.equals("admin")) {%>
							<li> <a href = "/KYJ_JSPWEB_study/admin/dashboard.jsp" style="color:#ff2b80;">관리페이지</a> | </li>
						<%} %>
						<li><a href="/KYJ_JSPWEB_study/Logout" id="logout"> 로그아웃 </a> | </li>
						<li><a href="/KYJ_JSPWEB_study/member/info.jsp"> 회원정보</a> | </li>
					<% } %>
					<li><a href="/KYJ_JSPWEB_study/board/boardlist.jsp?key=&keyword=">자유게시판</a></li>
					</ul>
				</div>
			</div>
			<!--  본 매뉴 -->
			<div class="navbar navbar-expand-md navbar-light bg-white">
				<ul class="nav col-md-10 offset-1 justify-content-between">
					<li class="nav-item dropdown"> <a href="#" data-bs-toggle="dropdown">애플<i class="fab fa-apple"></i></a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">PROMAX</a>
							<a class="dropdown-item" href="#">PRO</a>
							<a class="dropdown-item" href="#">GENERAL</a>
							<a class="dropdown-item" href="#">MINI</a>
							<a class="dropdown-item" href="#">SE</a>
						</div>
					</li>
					<li class="nav-item dropdown"> <a href="#">구글<i class="fab fa-google"></i></a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">PRO</a>
							<a class="dropdown-item" href="#">GENERAL</a>
							<a class="dropdown-item" href="#">A</a>
						</div>
					</li>
					<li class="nav-item dropdown"> <a href="#" data-bs-toggle="dropdown">삼성</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Z</a>
							<a class="dropdown-item" href="#">S</a>
							<a class="dropdown-item" href="#">A</a>
							<a class="dropdown-item" href="#">M</a>
						</div>
					</li>
					<li class="nav-item dropdown"> <a href="#" data-bs-toggle="dropdown">화웨이</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">P</a>
							<a class="dropdown-item" href="#">Mate</a>
							<a class="dropdown-item" href="#">HONOR</a>
						</div>
					</li>
					<li class="nav-item dropdown"> <a href="#" data-bs-toggle="dropdown">샤오미</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Mi</a>
							<a class="dropdown-item" href="#">RedMi</a>
							<a class="dropdown-item" href="#">BlackShark</a>
							<a class="dropdown-item" href="#">POCO</a>
						</div>
					</li>
					<li class="nav-item"> <a href="#">원플러스</a></li>
					<li class="nav-item"> <a href="#">아수스</a></li>
					<li class="nav-item dropdown"> <a href="#" data-bs-toggle="dropdown">소니</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">PRO</a>
							<a class="dropdown-item" href="#">1</a>
							<a class="dropdown-item" href="#">5</a>
							<a class="dropdown-item" href="#">10</a>
						</div>
					</li>
					<li class="nav-item"> <input type="text" class="header_input" size="15"><a href="#"><i class="fas fa-search"></i></a></li>
					<li class="nav-item"> <a href="/KYJ_JSPWEB_study/product/productcart.jsp">장바구니<span class="shoppingbox">5</span></a></li>
				</ul>
			</div>
		</div>
	</div>
	
	
	<!-- 사용자 정의 JS -->
	<script src="/KYJ_JSPWEB_study/js/main.js" type="text/javascript"></script>
	<!-- 부트스트랩 스크립트 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jquery 최신 CDN -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>