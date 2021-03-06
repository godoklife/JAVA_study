<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
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
	<div class = "container mt-5">			<!--  박스권 생성 -->
		<div class = "row">				<!--  가로 배치 -->
			<div class = "col-md-3">	<!--  사이드바 -->
				<%@include file = "infosidebar.jsp" %>
			</div>
			<div class = "col-md-9">	<!--  본문 영역 -->
				<h3> 내가 쓴 글 </h3>
				<%
					String mid = (String)session.getAttribute("login");
					int mno = MemberDao.instance.getmno(mid);
					ArrayList<Board> mywrite = BoardDao.instance.getboardlist2(mno,0,0,null,null);
				%>
				<table class="table">
					<tr>
						<th width="10%">번호</th><th width="55%">제목</th><th width="25%">작성일</th><th width="10%">조회수</th>
					</tr>
					<%
						if(mywrite!=null){
						for(Board tmp : mywrite){
					%>	
					<tr>
						<td><%=tmp.getBno()%></td>
						<td><a href="../board/boardview.jsp?bno=<%=tmp.getBno()%>"><%=tmp.getBtitle()%></a></td>
						<td><%=tmp.getBdate()%></td>
						<td><%=tmp.getBview()%></td>
					</tr>
					<%} %>
				</table>
				<%} %>
		<%if(mywrite==null){ %>
			<H1> NULL페이지 들어오지 말라 했제?? </H1>
		<%} %>
			</div>
		</div>
	</div>
	
	<%@include file =  "../footer.jsp" %>
</body>
</html>