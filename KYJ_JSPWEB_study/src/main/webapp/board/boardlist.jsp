<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<Board> boardlist = BoardDao.instance.getboardlist2(-1); %>
	<!--  해더 영역 -->
	<%@include file="../header.jsp" %>
	<div class = "container mt-5">
		<h1>자유게시판</h1>
		<h3>조회수 세션 10초로 설정되어있습니다</h3>
		<%
			String mid = (String)session.getAttribute("login");
			if(mid!=null){
		%>
			<a href="boardwrite.jsp"><button>글쓰기</button></a>
		<%} %>
		<table class="table">
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
			</tr>
			<%
				for(Board tmp : boardlist){
			%>
				<!--  행을 클릭했을때의 JS
					<tr onclick="location.href='boardview.jsp'">
					하위 페이지로 이동시 [ 식별 번호 같이 이동 ] 
						// 1. HTML : 파일명( 경로 ).jsp?변수명=값
						// 2. JS : "location.href='파일명(경로).jsp?변수병=값'"
						// 3. JAVA(JSP) : response.sendRedirect("파일명(경로).jsp");
				-->
				<tr>
					<td><%=tmp.getBno()%></td>
					<!-- <td onclick="location.href='boardview.jsp?bno=<%=tmp.getBno()%>'" style="cursor: pointer;"><%=tmp.getBtitle()%></td> -->
					<td onclick="location.href='boardview.jsp?bno=<%=tmp.getBno()%>'" style="cursor:pointer;"><%=tmp.getBtitle()%></td>
					
					<td><%=tmp.getMid()%></td>
					<td><%=tmp.getBview()%></td>
					<td><%=tmp.getBdate()%></td>
				</tr>
			<%} %>
		</table>
	</div>
	<!--  푸터 영역 -->
	<%@include file="../footer.jsp" %>
</body>
</html>