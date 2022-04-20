<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		#footer{
			background-color: #292c32;
			height : 200px;
			clear: both;
		}
		#footer_box{
			width : 1150px;
			margin : 0 auto;
			color : white;
			font-size : 10px;
		}
		#footer_box li{
			list-style: none;
		}
		
		#footer_left{
			float : left;
			margin : 30px 20px;
		}
		#footer_mid{
			float : left;
			margin : 30px 230px;
		}
		#footer_right{
			float : left;
			margin : 30px 20px;
		}
		#company li{
			display: inline;
		}
		#copyleft{
			font-size : 13px;
		}
		
		
	
	</style>


</head>
<body>

	<div id = "footer">
		<div id = "footer_box">
			<div id = "footer_left">
				<span>고객 센터</span>
				<h2>Tel : 1588 - 3366</h3>
			</div>
			
			<div id = "footer_mid">
				<ul>
					<li>
						<ul id = "company">
							<li>회사소개 | </li>
							<li>개인정보처리방침 | </li>
							<li>이용약관 | </li>
							<li>제휴안내</li>
						</ul>
					</li>
					<li>주소 : 경기도 용인시 수지구 미니이리 123</li>
					<li>email : photo@licos.com</li>
					<li id = "copyleft">COPYRIGHT @ 2021 The 스튜디오. ALL RIGHTS RESERVED.</li>
				</ul>
			</div>
			
			<div id = "footer_right">
				<img src = "img/facebook.png">
				<img src = "img/blog.png">
				<img src = "img/instagram.png">
			</div>
		</div>
	</div>
	
</body>
</html>