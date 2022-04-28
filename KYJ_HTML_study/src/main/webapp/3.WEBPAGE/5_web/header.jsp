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
			<a href="index.jsp" id="hunslogo">HUNS</a>
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


</body>
</html>