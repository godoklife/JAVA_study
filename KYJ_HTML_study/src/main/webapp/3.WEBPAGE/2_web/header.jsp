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
		li{
			list-style : none;
		}
		#menus li{
			list-style: none;
			/* float: left; */
			display: inline;
		}
		#main_menu li{
			font-family: "CookieRun-Regular";
			font-size: 20px;
			margin : 0 0 0 50px;
		}
		#header{ height : 200px;}
		#box{width : 1100px; margin: 0 auto;}
		#logo{
			float : left;
			margin: 50px 0 0 50px;
		}
		#menus{
			float: right;
			text-align: right;
		}
		#top_menu{
			margin-top: 50px;
		}
		
		
		
		
		
	</style>

</head>
<body>

	<div id = "header"> <!-- 헤더 전체 -->
		<div id = "box">	<!-- 헤더 내 박스권 -->
			<div id = "logo">	<!-- 로고 -->
				<img alt = "" src = "img/samsung.jpg" width="150" height="50">
			</div>	
			
			<div id = "menus">	<!--  메뉴 박스 -->
				
				<ul id = "top_menu">		<!--  상단 매뉴 -->
					<li> 홍길동(gildong)님 |</li>
					<li> <a href = "#">로그아웃</a> |</li>
					<li> <a href = "#">정보수정</a> |</li>
				</ul>	
				
				<ul id = "main_menu">	<!--  하단 매뉴 -->
					<li> <a href = "index.jsp">Home</a></li>
					<li> <a href = "#">출석부</a></li>
					<li> <a href = "gallary.jsp">작품갤러리</a></li>
					<li> <a href = "#">게시판</a></li>
				</ul>
				
			</div>
		</div>
	</div>




</body>
</html>