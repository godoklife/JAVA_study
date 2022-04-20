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
			width : 1150px;		/* ���� ���� */
			height : 100px;		/* ���� ���� */
			margin : 0 auto;	/* �ڽ��� ��� ���� */
		}
		#logo{
			float : left;
			margin : 10px 0 0 10px;		/* 12�ú��� �ð���� �� */
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
			display: inline;	/* ����Ʈ�� �⺻���� block ��, �ζ������� �ٲٸ� ���ٷ� �޸��� ���� */
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
		</div>	<!--  ��� ���� �ΰ� ���� -->
		<div id = "menus">		<!--  ��� �Ŵ� ���� -->
			<div id = "top_menu">
				<a href = "login.jsp"> �α��� </a>| 
				<a href = "signup.jsp"> ȸ������ </a>|
				<a href = "board.jsp"> �������� </a>
			</div>
			<ul id = "main_menu">
				<li> ���� �̷� </li>
				<li> ���� ���� </li>
				<li> ���� �۰� </li>
				<li> ������1 </li>
				<li> ������2 </li>
			</ul>
		</div>	
	</div>
</body>
</html>