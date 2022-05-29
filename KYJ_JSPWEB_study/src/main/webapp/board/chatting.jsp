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
					
					<div id="enterlist">
						<!--  chatting.js에서 출력 -->
					</div>
					
				</div>
				<div class="col-sm-8">	<!--  채팅창 구역 -->
					<div class="contentbox" id="contentbox" >
					<!--  chatting.js 구현 구역 -->
					</div>
					<% String mid = (String)session.getAttribute("login");%>
					<input type="hidden" value="<%=mid%>" id="mid">
					<div class="row g-0"> <!--  입력 상자 혹은 전송 버튼 -->
						<div class="col-sm-10" >
							<textarea id="incontent" class="form-control" onkeyup="enterkey('<%=mid%>')" row="2" cols=""></textarea>
						</div>
						<div class="col-sm-2">	<!--  전송 버튼 -->
							<button class="form-control sendbtn" onclick="sendbtn('<%=mid%>')">전송</button>
							<button class="form-control sendbtn" onclick="exportbtn()">저장</button>
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