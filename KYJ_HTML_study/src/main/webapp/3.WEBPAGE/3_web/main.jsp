<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		#mainbox{
			width : 1150px;
			margin : 0 auto;
		}
		
		#main_top li{
			list-style: none;
			float: left;
			margin : 10px 20px;
		}
		#main_top li div{
			width : 300px;
			font-size: 12px;
		}
		#mainbox .title{
			font-weight: bold;
		}
		#main_btm{
			clear: both;
		}
		#main_btm div{
			float : left;
			font-size: 12px;
		}
		
		#main_btm img{
			width : 280px;
		}
		#mainbox .title2{
			font-weight: bold;
			margin-bottom: -5px;
		}
		#padddddding{
			padding : 0 0 0 200px;
		}
		
	</style>

</head>
<body>
	<div id = "mainbox">
		<div id = "main_top">
			<ul>
				<li>
					<img src = "img/icon1.png">
				</li>
				<li>
					<div>
						<p class="title"> 예약 안내 </p>
						스튜디오 대여는 사전에 인터넷 예약을 하져야 합니다. 예약은 1일 이전까지 가능합니다.
					</div>
				</li>
				<li id = "padddddding">
					<img src = "img/icon2.png">
				</li>
				<li>
					<div>
						<p class="title"> 포토 갤러리 </p>
						취업 사진, 가족 사진, 프로필 사진, 우정 사진 등 개인 또는 단체가 이용할 수 있습니다.
					</div>
				</li>
			</ul>
		</div>
		
		<div id = "main_btm">
			<div>
				<img src="img/image1.jpg">
				<p class="title2">촬영 스튜디오</p>
				카메라, 조명 등 촬영 장비 완비
			</div>
			<div>
				<img src="img/image2.jpg">
				<p class="title2">촬영 스튜디오</p>
				카메라, 조명 등 촬영 장비 완비
			</div>
			<div>
				<img src="img/image3.jpg">
				<p class="title2">촬영 스튜디오</p>	
				카메라, 조명 등 촬영 장비 완비
			</div>
			<div>
				<img src="img/image4.jpg">
				<p class="title2">촬영 스튜디오</p>
				카메라, 조명 등 촬영 장비 완비
			</div>
			
			
		</div>
	
	</div>
</body>
</html>