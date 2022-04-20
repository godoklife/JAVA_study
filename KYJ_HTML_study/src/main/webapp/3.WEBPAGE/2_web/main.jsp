<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		
		#sidebar{
			width : 200px;
			float : left;
		}
		#main{
			width : 880px;
			float : right;
		}
		#sidebar .title1{
			background-color: #0ca9a3;
			color : white;
			padding : 15px;
			font-size: 18px;
		}
		#sidebar .comment{
			padding : 15px;
			line-height: 150%;
		}
		#search input{
			width : 120px;
			height : 30px;
		}
		#search button{
			margin-left: 5px;
			padding : 6px 10px;
		}
		#sidebar .title2{
			border-top: solid 2px black;
			border-bottom: solid 1px #eeeeee;
			padding : 15px;
			margin : 10px 0 ;
			font-size: 15px;
		}
		#sidebar .list{
			margin : 20px 0px;
		}
		#sidebar .list li{
			margin : 10px;
		}
		
		#left_main{
			width : 430px;
			float : left;
		}
		#right_main{
			width : 430px;
			float : right;
		}
		#left_main .title1{
			border-bottom: solid 2px black;
			padding-bottom: 10px;
		}
		#left_main .items{
			height : 30px;
		}
		#left_main .items .subject{
			float: left;
		}
		#left_main .itmes .date{
			float : right;
		}
		
		#right_main .items{
			float : right;
			width : 200px;
			margin-top : 30px;
		}
		#right_main .subject{
			margin-top : 10px;
			font-size : 15px;
			font-weight: bold;
		}
		#right_main .date{
			margin-top : 5px;
		}
		
		
	</style>
	
</head>
<body>

	<div id = "box">
		<div id = "sidebar">	<!-- �����Ŵ� -->
			<h3 class = "title1"> The ����ŷ</h3>
			<p class = "comment"> �ȳ��ϼ���. ���� �� ����� ������ �����ϰ� �����ϴ� �����Դϴ�.</p>
			<div id = "search">
				<input type="text"> <button>�˻�</button>
			</div>
			<h3 class = "title2"> ����ŷ/�丮</h3>
			<ul class = "list">
				<li> ��Ű ����� </li>
				<li> �� ����� </li>
				<li> ��ī�� ����� </li>
			</ul>
			<h3 class = "title2"> �ֱ� ���� </h3>
			<ul class = "list">
				<li> ��Ű ����� </li>
				<li> �� ����� </li>
				<li> ��ī�� ����� </li>
			</ul>
			
		</div>
		<div>	<!-- ���θŴ� -->
		
		</div>
		<div id = "main">
			<div id = "left_main">	<!-- �Խ��� ���� -->
				<h3 class = "title1">�˸�</h3>
				<ul class = "boardul">
					<li class = "items"> <div class = "subject"> ��Ű Ŭ���� �����մϴ�. </div> <div class= "date">09.30</div></li>
					<li class = "items"> <div class = "subject"> ��Ű Ŭ���� ������մϴ�. </div> <div class= "date">09.30</div></li>
					<li class = "items"> <div class = "subject"> ��Ű Ŭ���� �����մϴ�. </div> <div class= "date">09.30</div></li>
					<li class = "items"> <div class = "subject"> ��Ű Ŭ���� ������մϴ�. </div> <div class= "date">09.30</div></li>
					<li class = "items"> <div class = "subject"> ��Ű Ŭ���� �����մϴ�. </div> <div class= "date">09.30</div></li>
				</ul>
				<h3 class = "title1">�Խ���</h3>
				<ul class = "boardul">
					<li class = "items"> <div class = "subject"> �ȳ��ϼ��� �ݰ����ϴ�. </div> <div class= "date">09.30</div></li>
					<li class = "items"> <div class = "subject"> �ȳ��ϼ��� �ݰ����ϴ�. </div> <div class= "date">09.30</div></li>
					<li class = "items"> <div class = "subject"> �ȳ��ϼ��� �ݰ����ϴ�. </div> <div class= "date">09.30</div></li>
					<li class = "items"> <div class = "subject"> �ȳ��ϼ��� �ݰ����ϴ�. </div> <div class= "date">09.30</div></li>
					<li class = "items"> <div class = "subject"> ��Ű Ŭ���� �����մϴ�. </div> <div class= "date">09.30</div></li>
				</ul>
			</div>
			
			<div id = "right_main">	<!--  ��ǰ ���� -->
				<h3 class = "title1">���� Ŭ����</h3>
				<ul class = "items">
					<li> <img src = "img/bread1.png"></li>
					<li class = "subject">������ �����[2]</li>
					<li class = "date"> 22.04.20</li>
				</ul>
				<ul class = "items">
					<li> <img src = "img/bread2.png"></li>
					<li class = "subject">������ �����[10]</li>
					<li class = "date"> 22.04.20</li>
				</ul>
				<ul class = "items">
					<li> <img src = "img/bread3.png"></li>
					<li class = "subject">������ �����[1]</li>
					<li class = "date"> 22.04.20</li>
				</ul>
				<ul class = "items">
					<li> <img src = "img/bread4.png"></li>
					<li class = "subject">������ �����[0]</li>
					<li class = "date"> 22.04.20</li>
				</ul>
			
			</div>
			
		</div>
		
	</div>


</body>
</html>