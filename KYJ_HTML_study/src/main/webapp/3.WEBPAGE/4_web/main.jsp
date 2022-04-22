<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- ���� ��ġ(����)�� �ٸ� ���� �����ϱ� : -->
	<%@include file="header.jsp" %>
	
	
	<div class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000" id="cs">	
			<!-- class="carousel slide" data-bs-ride="carousel" : �ʼ����,  data-bs-interval="2000" : �ڵ� ȸ�� �ð�(���� : ms) -->
			
		<div class = "carousel-indicators">
			<button class="active" data-bs-target="#cs" data-bs-slide-to="0" ></button>
			<button data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button data-bs-target="#cs" data-bs-slide-to="2"></button>
		</div>	
		<div class = "carousel-inner">	<!-- "carousel-inner" : ĳ���� ���빰 �����̳� -->
			<div class = "carousel-item active" > <img src = "img/1.jpg"></div>	<!-- carousel-item : ���빰 ����  -->
			<div class = "carousel-item"> <img src = "img/2.jpg"></div>			<!--  active : ù ������ ����, ������ ���� ����. -->
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
	</div>	<!--  ĳ���� end -->
	
	<div class="container">
		<hr>	<!--  �Ǽ� �±� -->
		<div class = "row">
		<% for(int i=0; i<8; i++) { %>
			<div class = "col-md-4">
				<div class = "card">
					<img src = "img/p7_animation.gif">
					<div class = "card-body">
						<p class = "item">
						<span class = "title"> ������ ��10T PRO 8GB 256GB </span>
						<br>
						<span class = "content"> �����α��� ���ɱ��� ī�޶���� ������ŷ </span>
						<span class = "price_yen"> 3900���� </span> 
						<span class = "price"> 772,100�� </span>
						<br>
						<span class = "badge bg-warning text-dark my-3"> ������ </span>
						<span class = "badge bg-warning text-dark my-3"> �ؿ�Ư�� </span>
						
						
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