<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E L E C   M A L L</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
</head>
<body>


	

	<div class="container">
		<div class="row my-2">
			<div class="col-md-1 logo_box">	<!--  로고 div -->
				<a href="/EXAM/main.jsp">ELEC MALL</a>
			</div>
			<div class="col-md-6">	<!--  아이템 매뉴 div -->
				<div class="row">
					<div class="col-md-4">
						<a href="">스마트폰</a>
					</div>
					<div class="col-md-4">
						<a href="">노트북</a>
					</div>
					<div class="col-md-4">
						<a href="/EXAM/board/boardlist.jsp">게시판</a>
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="row">
					<div class="col-md-8 header_search"> 
						<ul class="nav">
							<li><input class="form-control" type="text"></li>
							<li><button type="button" class="form-control">검색</button></li>
						</ul>
					</div> 
					<div class="col-md-2"> 마이페이지</div>
					<div class="col-md-2"><a href="/EXAM/login.jsp"> 로그인/로그아웃</a></div>
				</div>
			</div>
		</div>
	</div>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>