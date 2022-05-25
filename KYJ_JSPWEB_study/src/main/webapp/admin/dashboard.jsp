<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
	<!--  부트스트랩 CSS CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 사용자 정의 CSS -->
	<link href="/KYJ_JSPWEB_study/css/main.css" rel="stylesheet">
	<link href="/KYJ_JSPWEB_study/css/admin.css" rel="stylesheet">
	<!-- 폰트어썸[ 아이콘 ]  -->
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

</head>
<body>
	<%
		if(session.getAttribute("login")==null || !(session.getAttribute("login").equals("admin"))){
			response.sendRedirect("/KYJ_JSPWEB_study/error.jsp");
		}
	%>
	<marquee scrollamount="5" class="topmarquee"> 관리자 페이지 입니다!!! 조작시 주의요망. </marquee>
	<!--  사이드바 영역 -->
	<div id = "sidebar">
		<!--  사이드바 열고 닫기 사용 -->
		<span class="sidebarbtn" id="sidebarbtn">사이드바</span>
		<ul>
			<li><h6>폰타쿠샵 <br> 관리자 모드 </h6></li>
			<li><button onclick="pagechange('productlist')">제품 목록</button></li>
			<li><button onclick="pagechange('productadd')">제품 등록</button></li>
			<li><button onclick="pagechange('productstock')">제품 재고</button></li>
			<li><button onclick="#">주문 현황</button></li>
			<li><button onclick="#">주문 배송</button></li>
			<li><button onclick="pagechange('productsales')">매출 관리</button></li>
			<li><a href="/KYJ_JSPWEB_study/main.jsp">홈으로 이동</a></li>
			<li><a href="/KYJ_JSPWEB_study/Logout">로그아웃</a></li>
		</ul>
	</div>
	<!-- 페이지 전환시 페이지가 표시되는 구역 -->
	<div class="contaier" id="mainbox">
		<h1>관리자 페이지 입니다.</h1>
	</div>
	
	
	
	
	<!-- jquery 최신 CDN -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<!-- 사용자 정의 JS -->
	<script src="/KYJ_JSPWEB_study/js/main.js" type="text/javascript"></script>
	<script src="/KYJ_JSPWEB_study/js/admin/dashboard.js" type="text/javascript"></script>
	<!-- 부트스트랩 스크립트 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<!--  amChart5 CDN -->
	<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/locales/de_DE.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/geodata/germanyLow.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/fonts/notosans-sc.js"></script>

	<script src="https://cdn.amcharts.com/lib/5/percent.js"></script>

</body>
</html>