<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<!--  부트스트랩 임포트 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!--  폰트어썸 임포트 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<!--  사용자 정의 CSS 임포트 -->
	<link href="index.css" rel="stylesheet">
</head>
<body>
	<!--  https://huns.co.kr : 훈스 카피 -->
	<div class="col-md-10 offset-2 fixed-top pb-1 pt-5 px-5">
		<div class="col-md-7 offset-5 d-flex justify-content-end">	<!--  헤더 영역 -->
			<ul class="nav">	<!--  해당 리스트 [ ul 또는 ol ]를 가로 배치. -->
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
		<div class="col-md-2 sidemenu">	<!--  사이드바 영역-->
			<a href="#" id="hunslogo">HUNS</a>
			<ul class="nav flex-column">
				<li class="sidebar"><a href="#">BEST</a></li>
				<li class="sidebar"><a href="#">NEW</a></li>
				<li class="sidebar"><a href="#">당일배송</a></li>
				<li class="sidebar" style="margin-bottom:20px;"><a href="#">1+1/코디세트</a></li>
				<li class="sidebar"><a href="#">아우터</a></li>
				<li class="sidebar"><a href="#">상의</a></li>
				<li class="sidebar"><a href="#">셔츠</a></li>
				<li class="sidebar"><a href="#">니트/가디건</a></li>
				<li class="sidebar"><a href="#">팬츠</a></li>
				<li class="sidebar"><a href="#">트레이닝</a></li>
				<li class="sidebar"><a href="#">신발</a></li>
				<li class="sidebar"><a href="#">악세사리</a></li>
				<li class="sidebar"><a href="#">세일</a></li>
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
고객센터　+82-10-3333-2222<br>
카카오채널 @카카오톡<br>
MON - FRI AM9 - PM4<br>
(LUNCH TIME PM12:30 - PM13:30)<br>
SAT, SUN, HOLIDAY CLOSE<br>
업무시간외 문의는<br>
Q＆A 게시판을 이용부탁드립니다.<br>
우리은행 1111-333-222222<br>
예금주 : (주)미니이리<br>
			</div>
		</div>
	</div>
	
	<div class="col-md-10 offset-2 content" >	<!--  본문 -->
		<div id="maincarousel"class="carousel slide carousel-fade me-5" data-bs-ride="carousel" data-bs-interval="2000">	<!--  캐러셀 영역 -->
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
		<div class="row p-3 me-5">	<!--  제품 영역 -->
		<%for(int i=0; i<3; i++) { %>
			<div class="col-md-4">
				<div class="card">
					<img src="img/card1.png">
					<div class="cardbody">
						<span>[1+1+1]아이스 쿨링 반팔티</span><br>
						<span>22,900원</span>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<img src="img/card2.png">
					<div class="cardbody">
						<span>[1+1]플레인 와이드 밴딩팬츠</span><br>
						<span>29,800원</span>
						<p> 2 color / 2 size </p>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<img src="img/card3.png">
					<div class="cardbody">
						<span>[1+1]롱&숏 맞춤 레이어드 반팔티</span><br>
						<span>23,900원</span>
						<p> 2 type / 3 color / 4 size </p>
					</div>
				</div>
			</div>
			
			<% } %>
			
		</div>
		<div style="margin:200px 100px; text-align: center; ">	<!--  인스타그램 -->
			<p style="font-weight: bold; font-size:23px;">INSTAGRAM
			<p style="17px;">@hunsgram</p>
			
		</div>
		<div class="row footer me-5">	<!--  footer 영역 -->
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
				<p> 카카오채널:@카카오</p>
				<p> MON-FRI AM9-PM4</p>
				<p> (LUNCH TIME PM12:30 - PM13:30)</p>
				<p> SAT, SUN, HOLIDAY CLOSE </p>
				<p> 업무시간외 문의는</p>
				<p> Q＆A 게시판을 이용부탁드립니다.</p>
				<p> B A N K    A C C O U N T .</p>
				<p> 우리은행 1111-333-222222</p>
				<p> 예금주 : 홍길동</p>
			</div>
			<div class="col-md-5 align-center">
				<span class="title"> COMPANY INFO </span>
				<p>COMPANY : 가상의 업체 CEO : 홍길동 TEL : +82-10-2222-3333</p>
				<p>BUSINESS NUMBER : 333-22-111111 / 2021-경기안산-2222 <a href="#">[사업자정보확인]</a></p>
				<p>ADDRESS:11111 경기도 안산시 강남대로 222(강남동)2층 </p>
				<p> ADMIN:홍길동 HOSTING:NONE</p>
				<p> 온라인 선자상거래 안전서비스 <a href="#">[서비스가입사실확인]</a></p>
				<br>
				<p> 반품주소/택배회사(1588-0000)</p>
				<p> 택배회사 반품주소 : 11111 경기도 안산시 강남대로 222(강남동)2층 </p>
				<p> </p>
				<p> </p>
				<p> </p>
			</div>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>