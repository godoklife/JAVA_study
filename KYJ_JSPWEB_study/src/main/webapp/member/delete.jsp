<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file = "../header.jsp" %>
	<%String mid = (String)session.getAttribute("login"); %><!--  세션 정보 불러오기 -->
	<div class = "container mt-5">			<!--  박스권 만들기 -->
		<div class = "row">				<!--  내용물 가로 배치 -->
			<div class = "col-md-3">	<!--  사이드바 영역 -->
				<%@include file = "infosidebar.jsp" %>
			</div>
			<div class = "col-md-9">	<!--  본문 영역 -->
				<h3> 회원 탈퇴 페이지 </h3>
				<input type="password" id=mpassword name="mpassword">
				<button id="btncofirm"onclick="passwordcheck('<%=mid%>')">확인</button>
				<span id="checkmsg"></span>
				<button id="btndelete" style="display: none;" onclick="mdelete('<%=mid%>')">탈퇴승인</button>
			
			</div>
		</div>
	</div>
	<!-- 사용자정의 js파일 포함  -->
	<script src="../js/info.js" type="text/javascript"></script>
	
	<%@include file = "../footer.jsp" %>
</body>
</html>