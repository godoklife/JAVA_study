<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		*{background-color: black;}
		
		.carousel-item{ /* ��Ʈ��Ʈ������ �̹� ������ Ŭ������ ���� �� �� �ִ�. */
			width : 100%;
			height : 100%;
		}
		
	</style>
</head>
<body>
	
	<%@include file = "1_��ġ.jsp" %>
	
	<div class = "container" >	<!--  �ڽ��� -->
	
		<div id = "cs" class = "carousel slide" data-bs-ride = "carousel" data-bs-interval = "2000">	<!--  ĳ���� ���� -->
			<!--  data-bs-interval = "500" : ȭ�� �ڵ���ȯ �ð�(ms����) -->
			
			<!--  ĳ���� �ε������� -->
			<div class = "carousel-indicators">
				<button type = "button" data-bs-target = "#cs" data-bs-slide-to="0" ></button>		<!--  �ε��������� �ε����� 0������ ����. -->
				<button type = "button" data-bs-target = "#cs" data-bs-slide-to="1"></button>
				<button type = "button" data-bs-target = "#cs" data-bs-slide-to="2" class = "active"></button>	<!--   active�� �ִ� �׸���� ����. active ������ ���� ����. -->
			</div>
			
			<div class = "carousel-inner">
				<div class = "carousel-item"> 
					<img alt = "" src = "../pizza3.jpg" width = "800px">
					<div class = "carousel-caption">	<!-- �̹��� �� ���� ����. -->
						<h2> ġŲ���� ���� �սô�.</h2>
					</div>
				</div>
				<div class = "carousel-item"> 
					<img alt = "" src = "../cat.jpg" width = "800px">
				</div>
				<div class = "carousel-item active"> 	<!--  active�� �ִ� �׸���� ����. active�� ������ ��� �Ѱ��� �־�� ��. -->
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