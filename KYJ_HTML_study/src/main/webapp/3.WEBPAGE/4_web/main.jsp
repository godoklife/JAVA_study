<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 현재 위치(파일)에 다른 파일 포함하기 : -->
	<%@include file="header.jsp" %>
	
	
	<div class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000" id="cs">	
			<!-- class="carousel slide" data-bs-ride="carousel" : 필수요소,  data-bs-interval="2000" : 자동 회전 시간(단위 : ms) -->
			
		<div class = "carousel-indicators">
			<button class="active" data-bs-target="#cs" data-bs-slide-to="0" ></button>
			<button data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button data-bs-target="#cs" data-bs-slide-to="2"></button>
		</div>	
		<div class = "carousel-inner">	<!-- "carousel-inner" : 캐러셀 내용물 컨테이너 -->
			<div class = "carousel-item active" > <img src = "img/1.jpg"></div>	<!-- carousel-item : 내용물 지정  -->
			<div class = "carousel-item"> <img src = "img/2.jpg"></div>			<!--  active : 첫 아이템 지정, 없으면 동작 안함. -->
			<div class = "carousel-item"> <img src = "img/3.jpg"></div>
		</div>
		
		<button class="carousel-control-prev" type="button" data-bs-target="#cs" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	    </button>
	    <button class="carousel-control-next" type="button" data-bs-target="#cs" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	 	</button>
	</div>	<!--  캐러셀 end -->
	
	<div class="container">
		<hr>	<!--  실선 태그 -->
		<div class = "row">
		<% for(int i=0; i<8; i++) { %>
			<div class = "col-md-4">
				<div class = "card">
					<img src = "img/p7_animation.gif">
					<div class = "card-body">
						<p class = "item">
						<span class = "title"> 샤오미 미10T PRO 8GB 256GB </span>
						<br>
						<span class = "content"> 디자인깡패 성능깡패 카메라깡패 가성비킹 </span>
						<span class = "price_yen"> 3900위안 </span> 
						<span class = "price"> 772,100원 </span>
						<br>
						<span class = "badge bg-warning text-dark my-3"> 무료배송 </span>
						<span class = "badge bg-warning text-dark my-3"> 해운특송 </span>
						
						
						</p>
					</div>
				</div>
			</div>
			<% } %>
		</div>
	</div>



	<%@include file = "footer.jsp" %>
</body>
</html>