<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
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
	
	<%
		//1. 세션에 저장된 회원 아이디 호출하기
		String mid = (String)session.getAttribute("login");
		// 2. 
		Member member = MemberDao.instance.getmember(mid);
	%>
	<div class = "container mt-5">
		<div class = "row">
			<div class = "col-md-3">
				<%@include file = "infosidebar.jsp" %>
			</div>
			<div class = "col-md-9">
				<%
					if(request.getParameter("result")!=null && request.getParameter("result").equals("1")){
				%>
					<div> 회원 정보가 수정되었습니다.</div>
				<%} else if(request.getParameter("result")!=null && request.getParameter("result").equals("2")){ %>
					<div> 회원 정보 수정에 실패하였습니다.</div>
				<%} else if(request.getParameter("result")!=null && request.getParameter("result").equals("3")){ %>
					<div> 기존 비밀번호가 일치하지 않습니다.</div>
				<%} %>
				<h3> 회원정보 수정</h3>
				<form action="../Update" method="post">
					
					아이디 : <%=member.getMid()%>
					비밀번호 : <button type = "button" onclick = "passwordchange()">비밀번호 변경하기</button>><br>
						<div id = "passwordbox" style = "display: none;"> 
							<input type = "password" name = "oldpassword">
							<input type = "password" name = "newpassword">
						</div>
					
					
					이름 : <input type = "text" name="mname" value= "<%=member.getMname()%>"><br>
					연락처 : <input type = "text" name="mphone" value= "<%=member.getMphone()%>"><br>
					
					E-mail : <input type = "text" id = "memail" name = "memail" value = "<%=member.getMemail().split("@")[0]%>">
					@<input type = "text" id = "memailaddress" name = "memailaddress" value = "<%=member.getMemail().split("@")[1]%>">
					<select id = "emailselect">
						<option value = "">직접 입력</option>
						<option value = "hanmir.com">hanmir.com</option>
						<option value = "licos.com">licos.com</option>
						<option value = "hanmail.net">hanmail.net</option>
					</select>
					
					주소<input type = "hidden" name="mno" value = "<%=member.getMno()%>"><br>
					<!--  다음 우편번호 HTML -->
					<input type="text" id="sample4_postcode" name="maddress1" value= "<%=member.getMaddress().split("_")[0]%>">
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample4_roadAddress" name="maddress2" value= "<%=member.getMaddress().split("_")[1]%>">
					<input type="text" id="sample4_jibunAddress" name="maddress3" value= "<%=member.getMaddress().split("_")[2]%>">
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" id="sample4_detailAddress" name="maddress4" value= "<%=member.getMaddress().split("_")[3]%>">
					<!--  다음 우편번호 HTML 끝-->
					<br>
					<input type="submit" value = "변경적용">
					<a href="update.jsp"><button type = "button">변경취소</button></a>
				</form>
			</div>
			
		</div>
	</div>
	<!-- 다음 우편번호 API script -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!--  signup.js 불러오기 ->> 여기는 상대 경로로 해도 별 문제 없음. -->
	<script src="../js/signup.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>
</body>
</html>