<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		@font-face {
	    font-family: 'CookieRun-Regular';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/CookieRun-Regular.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
		}
		a{
			text-decoration: none;
			color : black;
		}
		a:hover{
			color : orange;
		}
		ul{
			padding : 0px;
			margin : 0px;
		}
		#header{
			width : 1150px;		/* 가로 길이 */
			height : 100px;		/* 세로 길이 */
			margin : 0 auto;	/* 박스권 가운데 정렬 */
		}
		#logo{
			float : left;
			margin : 10px 0 0 10px;		/* 12시부터 시계방향 순 */
		}
		#menus{
			float : right;
		}
		#top_menu{
			text-align: right;
			margin-top : 20px;			
		}
		#main_menu{
			margin-top : 20px;
			font-family: "CookieRun-Regular";
			font-size : 20px;
		}
		#main_menu li{
			display: inline;	/* 리스트의 기본값은 block 블럭, 인라인으로 바꾸면 한줄로 쭈르륵 나옴 */
			margin-left: 80px;
		}
		a{
			text-decoration: none;
			color : black;
		}
		a:hover{
			color : orange;
		}
	</style>
</head>
<body>
	<div id = "header">
		<div id = "logo">
			<a href = "index.jsp"><img alt = "" src = "img/logo.png"> </a>
		</div>	<!--  상단 좌측 로고 삽입 -->
		<div id = "menus">		<!--  상단 매뉴 삽입 -->
			<div id = "top_menu">
				<a href = "login.jsp"> 로그인 </a>| 
				<a href = "signup.jsp"> 회원가입 </a>|
				<a href = "board.jsp"> 공지사항 </a>
			</div>
			<ul id = "main_menu">
				<li> 사진 이론 </li>
				<li> 사진 구도 </li>
				<li> 사진 작가 </li>
				<li> 갤러리1 </li>
				<li> 갤러리2 </li>
			</ul>
		</div>	
	</div>
</body>
</html>