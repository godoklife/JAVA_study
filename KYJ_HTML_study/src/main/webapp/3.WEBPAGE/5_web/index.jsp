<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<!--  ��Ʈ��Ʈ�� ����Ʈ -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!--  ��Ʈ��� ����Ʈ -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<!--  ����� ���� CSS ����Ʈ -->
	<link href="index.css" rel="stylesheet">
</head>
<body>
	<!--  https://huns.co.kr : �ƽ� ī�� -->
	<div class="col-md-10 offset-2 fixed-top pb-1 pt-5 px-5">
		<div class="col-md-7 offset-5 d-flex justify-content-end">	<!--  ��� ���� -->
			<ul class="nav">	<!--  �ش� ����Ʈ [ ul �Ǵ� ol ]�� ���� ��ġ. -->
				<li class="tophead"><a href="login.jsp">LOGIN</a></li>
				<li class="tophead"><a href="#">JOIN</a></li>
				<li class="tophead"><a href="#">CART</a></li>
				<li class="tophead"><a href="#">MYPAGE</a></li>
				<li class="tophead"><a href="#">SNS</a></li>
				<li class="tophead"><a href="#">BOOKMARK</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 sidemenu">	<!--  ���̵�� ����-->
			<a href="#" id="hunslogo">HUNS</a>
			<ul class="nav flex-column">
				<li class="sidebar"><a href="#">BEST</a></li>
				<li class="sidebar"><a href="#">NEW</a></li>
				<li class="sidebar"><a href="#">���Ϲ��</a></li>
				<li class="sidebar" style="margin-bottom:20px;"><a href="#">1+1/�ڵ�Ʈ</a></li>
				<li class="sidebar"><a href="#">�ƿ���</a></li>
				<li class="sidebar"><a href="#">����</a></li>
				<li class="sidebar"><a href="#">����</a></li>
				<li class="sidebar"><a href="#">��Ʈ/�����</a></li>
				<li class="sidebar"><a href="#">����</a></li>
				<li class="sidebar"><a href="#">Ʈ���̴�</a></li>
				<li class="sidebar"><a href="#">�Ź�</a></li>
				<li class="sidebar"><a href="#">�Ǽ��縮</a></li>
				<li class="sidebar"><a href="#">����</a></li>
			</ul>	
			<ul class="nav flex-column mt-5">
				<li class="sidebar"><a href="#">NOTICE</a></li>
				<li class="sidebar"><a href="#">Q&A</a></li>
				<li class="sidebar"><a href="#">REVIEW</a></li>
				<li class="sidebar"><a href="#">EVENT</a></li>
			</ul>
			<div>
				<input type="text"><i class="fas fa-search"></i>
			</div>
			<div>
�����͡�+82-10-3333-2222<br>
īī��ä�� @īī����<br>
MON - FRI AM9 - PM4<br>
(LUNCH TIME PM12:30 - PM13:30)<br>
SAT, SUN, HOLIDAY CLOSE<br>
�����ð��� ���Ǵ�<br>
Q��A �Խ����� �̿��Ź�帳�ϴ�.<br>
�츮���� 1111-333-222222<br>
������ : (��)�̴��̸�<br>
			</div>
		</div>
	</div>
	
	<div class="col-md-10 offset-2 content" >	<!--  ���� -->
		<div id="maincarousel"class="carousel slide carousel-fade me-5" data-bs-ride="carousel" data-bs-interval="2000">	<!--  ĳ���� ���� -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="img/c1.png"width=100%>
				</div>
				<div class="carousel-item">
					<img src="img/c2.png"width=100%>
				</div>
				<div class="carousel-item">
					<img src="img/c3.png"width=100%>
				</div>
			</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#maincarousel" data-bs-slide="prev">
    		<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    		<span class="visually-hidden">Previous</span>
  			</button>
  			<button class="carousel-control-next" type="button" data-bs-target="#maincarousel" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  	</button>
		  	<div class="carousel-indicators">
		    <button type="button" data-bs-target="#maincarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		    <button type="button" data-bs-target="#maincarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
		    <button type="button" data-bs-target="#maincarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
		  	</div>
		</div>
		<div class="row p-3 me-5">	<!--  ��ǰ ���� -->
		<%for(int i=0; i<3; i++) { %>
			<div class="col-md-4">
				<div class="card">
					<img src="img/card1.png">
					<div class="cardbody">
						<span>[1+1+1]���̽� �� ����Ƽ</span><br>
						<span>22,900��</span>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<img src="img/card2.png">
					<div class="cardbody">
						<span>[1+1]�÷��� ���̵� �������</span><br>
						<span>29,800��</span>
						<p> 2 color / 2 size </p>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<img src="img/card3.png">
					<div class="cardbody">
						<span>[1+1]��&�� ���� ���̾�� ����Ƽ</span><br>
						<span>23,900��</span>
						<p> 2 type / 3 color / 4 size </p>
					</div>
				</div>
			</div>
			
			<% } %>
			
		</div>
		<div style="margin:200px 100px; text-align: center; ">	<!--  �ν�Ÿ�׷� -->
			<p style="font-weight: bold; font-size:23px;">INSTAGRAM
			<p style="17px;">@hunsgram</p>
			
		</div>
		<div class="row footer me-5">	<!--  footer ���� -->
			<div class="col-md-2 offset-2">
				<span class="title"> SHOP INFO.</span>
				<p> ABOUT US</p>
				<p> AGREEMENT</p>
				<p> PRIVACY POLICY</p>
				<p> SHOPPING GUIDE</p>
			</div>
			<div class="col-md-3 align-center">
				<span class="title"> CUSTOMER CENTER. </span>
				<p> 1588-3366</p>
				<p> īī��ä��:@īī��</p>
				<p> MON-FRI AM9-PM4</p>
				<p> (LUNCH TIME PM12:30 - PM13:30)</p>
				<p> SAT, SUN, HOLIDAY CLOSE </p>
				<p> �����ð��� ���Ǵ�</p>
				<p> Q��A �Խ����� �̿��Ź�帳�ϴ�.</p>
				<p> B A N K    A C C O U N T .</p>
				<p> �츮���� 1111-333-222222</p>
				<p> ������ : ȫ�浿</p>
			</div>
			<div class="col-md-5 align-center">
				<span class="title"> COMPANY INFO </span>
				<p>COMPANY : ������ ��ü CEO : ȫ�浿 TEL : +82-10-2222-3333</p>
				<p>BUSINESS NUMBER : 333-22-111111 / 2021-���Ȼ�-2222 <a href="#">[���������Ȯ��]</a></p>
				<p>ADDRESS:11111 ��⵵ �Ȼ�� ������� 222(������)2�� </p>
				<p> ADMIN:ȫ�浿 HOSTING:NONE</p>
				<p> �¶��� ���ڻ�ŷ� �������� <a href="#">[���񽺰��Ի��Ȯ��]</a></p>
				<br>
				<p> ��ǰ�ּ�/�ù�ȸ��(1588-0000)</p>
				<p> �ù�ȸ�� ��ǰ�ּ� : 11111 ��⵵ �Ȼ�� ������� 222(������)2�� </p>
				<p> </p>
				<p> </p>
				<p> </p>
			</div>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>