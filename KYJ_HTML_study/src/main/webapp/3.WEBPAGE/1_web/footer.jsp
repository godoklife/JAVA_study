<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#footer{
			width : 100%;
			height : 150px;
			background-color: #2e2a2a;
			clear: both;
			margin-top : 100px;
		}
		#footer_box{
			background-color: #2e2a2a;
			width : 1150px;
			height : 150px;
			margin : 0 auto;
		}
		#footer_logo{
			float : left;
			margin : 50px 0 0 30px;
			background-color: #2e2a2a;
			
		}
		#address{
			float : right;
			list-style-type: none;
			margin : 50px 30px 0 0 ;
			color : white;
		}
		#address li{
			background-color: #2e2a2a;
		}
	</style>
	
</head>
<body>
	
	<div id = "footer">
		<div id = "footer_box"> 
			<div id = "footer_logo">	<!-- logo 삽입 위치 -->
				<img alt = "" src = "img/logo_black.png">
			</div>
			
			<ul id = "address">			<!--  주소 삽입 위치 -->
				<li>서울시 강남구 삼성동 1234 우:123-1234</li>
	            <li>TEL:031-123-1234 Email : email@domain.com</li>
	            <li>COPYRIGHT (C) 루바토 ALL RIGHTS RESERVED</li>
			</ul>
		</div>
	</div>
	
	
	
</body>
</html>