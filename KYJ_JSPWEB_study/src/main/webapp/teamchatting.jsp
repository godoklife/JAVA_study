<%@page import="java.util.ArrayList"%>
<%@page import="dto.TeamchattingDTODAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>

	<div class="container">
		<div class="row g-0">
			<div class="col-md-8 offset-2 mt-5">
				<div class="col-md-12" id="chattingview">
				<table>
					<%
						ArrayList<TeamchattingDTODAO> chatlist = (ArrayList<TeamchattingDTODAO>)session.getAttribute("chatlist");
						if(chatlist!=null){
							for(TeamchattingDTODAO tmp : chatlist){
					%>
						<tr>
							<td>
								<div class="col-md-6">닉네임 : <%=tmp.getNickname()%></div>
								<div class="col-md-6" style="color:red;">IP : <%=tmp.getIp()%></div>
							</td>
						</tr>
						<tr>
							<td>내용:<%=tmp.getContent()%></td>
						</tr>
						<tr>
							<td>시간:<%=tmp.getDatetime()%></td>
						</tr>
					<%}} %>
					</table>
				</div>
				<div class="col-md-3">
					<input placeholder="닉네임 입력" class="form-control" type="text" id="chatnickname" style="background-color: #abd0bc;">
				</div>
				<div class="col-md-7">
					<input placeholder="메시지 입력" class="form-control" type="text" id="chatcontent" style="background-color: #eeeeee;">
				</div>
				<div class="col-md-2">
					<button class="form-control" onclick="test('<%=(String)session.getAttribute("ip")%>')">보내기</button>
				</div>
			</div>
		</div>
	</div>
	
<%@include file="footer.jsp" %>
<script src="/KYJ_JSPWEB_study/js/teamchatting.js" type="text/javascript"></script>

</body>
</html>