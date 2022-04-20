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

	<div id = "header"> <!-- ��� ��ü -->
		<div id = "box">	<!-- ��� �� �ڽ��� -->
			<div id = "logo">	<!-- �ΰ� -->
				<img alt = "" src = "img/samsung.jpg" width="150" height="50">
			</div>	
			
			<div id = "menus">	<!--  �޴� �ڽ� -->
				
				<ul id = "top_menu">		<!--  ��� �Ŵ� -->
					<li> ȫ�浿(gildong)�� |</li>
					<li> <a href = "#">�α׾ƿ�</a> |</li>
					<li> <a href = "#">��������</a> |</li>
				</ul>	
				
				<ul id = "main_menu">	<!--  �ϴ� �Ŵ� -->
					<li> <a href = "index.jsp">Home</a></li>
					<li> <a href = "#">�⼮��</a></li>
					<li> <a href = "gallary.jsp">��ǰ������</a></li>
					<li> <a href = "#">�Խ���</a></li>
				</ul>
				
			</div>
		</div>
	</div>




</body>
</html>