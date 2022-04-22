<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

	<!--  부트스트랩 CSS 부분 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	
	<!--  사용자가 정의한 CSS 부분 -->
	<link href="css/main.css" rel = "stylesheet">
	
	<!--  폰트어썸 아이콘 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>
	<div class = "fixed-top bg-white">
		<div class = "container" >	<!--  박스권 형성 : 부트스트랩 클래스 -->
		<div class = py-3>
			<!--  p : padding ->> 안쪽 여백	py : 안쪽 위아래 여백 설정 -->
			<!--  m : margin ->> 바깥쪽 여백	my : 바깥쪽 위아래 여백 설정 -->
				<div class = "row"> <!--  상단 매뉴 만들기 -->
					<div class = "col-md-4 offset-4 text-center"> <!--  12그리드 중 4그리드 사용, 4그리드는 [왼쪽에] 깡통으로 넣음.  -->
						<a href = "main.jsp" class = "header_logo"> Cirruslogic</a>
					</div>
					<div class = "col-md-4 d-flex justify-content-end" >
						<ul class = "nav"> <!--  nav : 리스트의 글머리 삭제, 가로배치. -->
							<li><a href = "http://www.naver.com" >로그인</a> | </li>
							<li><a href = "">회원가입</a> | </li>
							<li><a href = "">장바구니</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class = "navbar navbar-expand-md navbar-light bg-white">	<!--  메인 매뉴 -->
			
				<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navcl">
					<span class = "navbar-toggler-icon"></span>
				</button>
				
				<div class = "collapse navbar-collapse" id="navcl">
					<ul class= "navbar-nav col-md-12 justify-content-between">	<!--  justify-content-between : 그리드 중에서 간격 알아서 배치 -->
						<li class="nav-item"> <a href = "#">스마트폰 </a></li>
						<li class="nav-item"> <a href = "#">태블릿 </a></li>
						<li class="nav-item"> <a href = "#">노트북 </a></li>
						<li class="nav-item"> <a href = "#">스마트워치 </a></li>
						<li class="nav-item"> <a href = "#">TWS </a></li>
						<li class="nav-item"> <a href = "#">보조배터리 </a></li>
						<li class="nav-item"> <a href = "#">기타 악세서리 </a></li>
						<li class="nav-item"> <a href = "#">리뷰 </a></li>
						<li class="nav-item"> <a href = "#">고객센터 </a></li>
						<li class="nav-item"> <a href = "#"> <i class = "fas fa-search"></i> </a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<!--  부트스트랩 js 부분 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>