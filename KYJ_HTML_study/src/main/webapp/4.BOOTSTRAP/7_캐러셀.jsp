<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		*{background-color: black;}
		
		.carousel-item{ /* 부트스트랩에서 이미 정의한 클래스를 수정 할 수 있다. */
			width : 100%;
			height : 100%;
		}
		
	</style>
</head>
<body>
	
	<%@include file = "1_설치.jsp" %>
	
	<div class = "container" >	<!--  박스권 -->
	
		<div id = "cs" class = "carousel slide" data-bs-ride = "carousel" data-bs-interval = "2000">	<!--  캐러셀 생성 -->
			<!--  data-bs-interval = "500" : 화면 자동전환 시간(ms단위) -->
			
			<!--  캐러셀 인디케이터 -->
			<div class = "carousel-indicators">
				<button type = "button" data-bs-target = "#cs" data-bs-slide-to="0" ></button>		<!--  인디케이터의 인덱스는 0번부터 시작. -->
				<button type = "button" data-bs-target = "#cs" data-bs-slide-to="1"></button>
				<button type = "button" data-bs-target = "#cs" data-bs-slide-to="2" class = "active"></button>	<!--   active가 있는 항목부터 시작. active 없으면 시작 안함. -->
			</div>
			
			<div class = "carousel-inner">
				<div class = "carousel-item"> 
					<img alt = "" src = "../pizza3.jpg" width = "800px">
					<div class = "carousel-caption">	<!-- 이미지 내 설명문 삽입. -->
						<h2> 치킨말고 피자 합시다.</h2>
					</div>
				</div>
				<div class = "carousel-item"> 
					<img alt = "" src = "../cat.jpg" width = "800px">
				</div>
				<div class = "carousel-item active"> 	<!--  active가 있는 항목부터 시작. active는 무조건 어디 한곳에 있어야 함. -->
					<img alt = "" src = "../cucumber.jpg" width = "800px">
				</div>
				
				<button class="carousel-control-prev" type="button" data-bs-target="#cs" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  	</button>
				
				<button class="carousel-control-next" type="button" data-bs-target="#cs" data-bs-slide="next">
			   	<span class="carousel-control-next-icon" aria-hidden="true"></span>
			   	<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
		
	</div>

</body>
</html>