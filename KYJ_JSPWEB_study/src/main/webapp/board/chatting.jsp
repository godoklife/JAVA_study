<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/KYJ_JSPWEB_study/css/chatting.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="container">	<!-- 박스권 생성 -->
		<div class="col-sm-6 offset-3 chattingbox">	<!--  채팅 관련 구역 -->
			<div class="row">	<!--  하위 태그의 가로 배치 -->
				<div class="col-sm-4"> <!--  접속자 목록 표시 구역 -->
					<h5 class="enter_title"> 접속자 목록</h5>
					
					<div class="row p-3">	<!--  접속자 정보 표시 구역 -->
						<div class="col-sm-4">	<!--  프로필 이미지 표시 구역 -->
							<img width=100% class="rounded-circle" src="upload/food.jpg">
								<!--  class="rounded-circle" : 부트스트랩, 이미지를 원형으로 출력-->
						</div>
						<div class="col-sm-8">	<!--  접속자 이름, 기능 출력 구역 -->
							<div class="member_name"> 유재석 </div>
							<div class="btnbox">
								<span> 귓속말 </span>
								<span> 친구추가 </span>
							</div>
						</div>
					</div>
					
					<div class="row p-3">	<!--  접속자 정보 표시 구역 -->
						<div class="col-sm-4">	<!--  프로필 이미지 표시 구역 -->
							<img width=100% class="rounded-circle" src="upload/food.jpg">
								<!--  class="rounded-circle" : 부트스트랩, 이미지를 원형으로 출력-->
						</div>
						<div class="col-sm-8">	<!--  접속자 이름, 기능 출력 구역 -->
							<div class="member_name"> 유재석 </div>
							<div class="btnbox">
								<span> 귓속말 </span>
								<span> 친구추가 </span>
							</div>
						</div>
					</div>
					
				</div>
				<div class="col-sm-8">	<!--  채팅창 구역 -->
					<div class="contentbox">
						<!-- ----------------------- -->
						<div class="secontent">	<!--  보낸 메시지 출력 구역 -->
							<span class="date"> AM 00:01</span>
							<span class="content"> HELLO </span>
						</div>
						<div class="alarm">
							<span>강호동 님이 입장 했습니다.</span>
						</div>
						<div class="row g-0">
							<div class="col-sm-1 pt-3">
								<img width=100% class="rounded-circle" src="upload/food.jpg">
							</div>
							<div class="col-sm-10">
								<div class="recontent">	<!--  받은 메시지 출력 구역 -->
									<div class="member_name"> 유재석 </div>
									<span class="content"> HELLO </span>
									<span class="date"> AM 00:01</span>
								</div>
							</div>
						</div>
						<!-- ----------------------- -->
					</div>
					
					<div class="row g-0"> <!--  입력 상자 혹은 전송 버튼 -->
						<div class="col-sm-10" >
							<textarea id="incontent" class="form-control" onkeyup="enterkey()" row="2" cols=""></textarea>
						</div>
						<div class="col-sm-2">	<!--  전송 버튼 -->
							<button class="form-control sendbtn" onclick="sendbtn()">전송</button>
						</div>
					</div>
					
					<div class="btnbox">	<!--  폰트 크기 줄이려고 쓴 클래스명 -->
						<span>첨부파일</span>
						<span>이모키톤</span>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	<%@include file="../footer.jsp" %>
	<script type="text/javascript" src="/KYJ_JSPWEB_study/js/chatting.js"></script>
</body>
</html>