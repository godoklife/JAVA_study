<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "1_설치.jsp" %>
	
	<div class = "container"> <!--  박스권 -->
		<div class = "navbar navbar-expand-md navbar-light">	<!--  네비게이션 바 , navbar-expand-md : 매뉴(내용물) 가로로 눕히기 -->
		
			
		
			<!--  메뉴 사이즈가 작아지는 경우 -->
			<!-- 핵심 클래스, 속성 : class = "navbar-toggler" data-bs-toggle = "collapse" data-bs-target = "#navmenu" -->
			<button class = "navbar-toggler" type = "button" data-bs-toggle = "collapse" data-bs-target = "#navmenu" aria-controls = "navbarcontents" 
				aria-expended = "false" aria-label = "Toggle navi"  > 	<!--  data-bs-target에 지정한 id를 불러온다. -->
				
				<!--  미니이리 -->
				
				<span class = "navbar-toggler-icon"></span>
			</button>
			
		
			<div class = "collapse navbar-collapse" id = "navmenu">		<!-- collapse navbar-collapse : 부트스트랩에서 정의한 대로 브라우저의 가로사이즈가 760px 이하로 내려가면 div를 감춰버림.-->
				<a href = "#" class = "navbar-brand">LOGO</a>
				<ul class = "navbar-nav">	<!--  글머리가 다 빠짐. -->
					<li class = "nav-item"> <a href = "#" class = "nav-link">메뉴 1 </a> </li>		<!--  nav-link : 링크 밑줄 없애기(색상은 안 바뀜 ㅡ.ㅡ) -->
					<li class = "nav-item"> <a href = "#" class = "nav-link">메뉴 2 </a> </li>		
					<li class = "nav-item"> <a href = "#" class = "nav-link">메뉴 3 </a> </li>
					<li class = "nav-item dropdown">		<!--  드랍다운 메뉴 -->
						<!--  하단 텍스트를 클랙했을 때 메뉴 펼치기 -->
						<a href = "#" class = "nav-link" data-bs-toggle = "dropdown" aria-haspopup = "true" aria-expanded = "false" id = "navdrop">드랍다운</a>	<!-- id값은 내가 정하는거. -->
					
						<!--  
							nav-link : 하이퍼링크 설정 (밑줄제거, 여백, 색상)
							dropdown-toggle : 아래 화살표 추가(드랍다운 매뉴라는 아이콘 추가, 별 기능 없음.)
							data-bs-toggle="dropdown" : 드랍다운 매뉴 형식이라고 선언
							
						-->
						
					
						<div class = "dropdown-menu" aria-labelledby = "navdrop"> 
							<!-- 
								dropdown-menu : 이하 아이템이 접혀있는 상태로 출력(없으면 페이지 실행될 때 펼처진채로 나옴.)
								dropdown-item : 객체 구분. 안붙여주면 어디부터 어디까지가 한개의 아이템인지 구분이 안됨.
							 -->
							<a class = "dropdown-item" href = "#"> 드랍다운 메뉴 1 </a>
							<a class = "dropdown-item" href = "#"> 드랍다운 메뉴 2 </a>
							<a class = "dropdown-item" href = "#"> 드랍다운 메뉴 3 </a>
						</div>
					</li>
				</ul>	<!--  네비게이션 목록 끝 -->
				
				<form action = "">
					<div class = "row">
						<div class = "col-md-5">
							<input type = "text" class = "form-control" placeholder = "검색어">
						</div>
						<div class = "col-md-5">
							<button class = "btn btn-info" type = "submit"> 검색 </button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	

</body>
</html>