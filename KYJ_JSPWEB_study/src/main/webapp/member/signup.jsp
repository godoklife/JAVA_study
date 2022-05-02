<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  해더 영역 -->
	<%@include file="../header.jsp" %>
	
	<div class="container">
		<h3> 회원 가입 페이지</h3>
		<form action="">
			아이디 : <input type="text" id = "mid" placeholder="아이디를 입력하세요"><br>
			<span id = "idcheck"> </span><br>
			비밀번호 : <input type="password" id = "mpassword" placeholder="비밀번호를 입력하세요"> <br>
			비밀번호 확인 : <input type="password" id = "mpasswordcheck" placeholder="비밀번호를 한번 더 입력하세요"><br>
			<span id = "passwordcheck"> </span><br>
			이름 : <input type = "text" id = "mname" placeholder="이름을 입력하세요"><br>
			<span id = "namecheck"> </span><br>
			전화번호 : <input type = "text" id = "mphone" placeholder = "전화번호를 입력하세요"><br>
			<span id = "phonecheck"> </span><br>
			E-mail : <input type = "text" id = "memail" placeholder = "이메일주소를 입력하세요"><br>
			주소 : 
			<!--  다음 우편번호 HTML -->
			<input type="text" id="mpostnumber" placeholder="우편번호">
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="mroadaddress" placeholder="도로명주소"><br>
			<input type="text" id="mjibunaddress" placeholder="지번주소"><br>
			<span id="guide" style="color:#999;display:none"></span><br>
			<input type="text" id="mdetailaddress" placeholder="상세주소"><br>
			<input type="text" id="mextraaddress" placeholder="참고항목"><br>
			<!--  다음 우편번호 HTML 끝-->
			<button onclick="signup()" type = "button">가입하기!</button><br>	
		</form>
	</div>
	
	
	
	<!-- 다음 우편번호 API script -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!--  signup.js 불러오기 ->> 여기는 상대 경로로 해도 별 문제 없음. -->
	<script src="../js/signup.js" type="text/javascript"></script>
	
	<!--  푸터 영역 -->
	<%@include file="../footer.jsp" %>
</body>
</html>