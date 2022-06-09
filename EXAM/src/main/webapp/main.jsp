<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E L E C   M A L L</title>

</head>
<body>
	<%@include file="header.jsp" %>
	<%
		//session.setAttribute("id", request.getParameter("id"));
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">	<!--  상단 캐러셀 영역 -->
				<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="img/productimg/apple/promax/apple-iphone-13-pro-max-1.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/productimg/google/6_pro/google-pixel-6-pro-2.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/productimg/samsung/Z_FOLD_3/silver/1.webp" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
			<div class="col-md-12 main_item_img">	<!--  캐러셀 하단 상품이미지 출력 구역 -->
				<div class="row">
					<div class="col-md-4">
						<a href="#"><img src="img/productimg/xiaomi/redmi_k50_pro/starlight.png"></a>
					</div>
					<div class="col-md-4">
						<a href="#"><img src="img/productimg/xiaomi/redmi_k50_pro/green.png"></a>
					</div>
					<div class="col-md-4">
						<a href="#"><img src="img/productimg/xiaomi/redmi_k50_pro/gray.png"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>