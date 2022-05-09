<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
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
	
	<div class="container mt-5">
		<h1> 게시판 상세보기 </h1>
		<%
			int bno = Integer.parseInt(request.getParameter("bno"));
			Board result = BoardDao.instance.getboard(bno);
			if(result!=null){
		%>
			<table class="mx-3">
				<tr>
					<th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일</th><th>첨부파일</th>
				</tr>
				<tr>
					<td><%=result.getBno()%></td>
					<td><%=result.getBtitle()%></td>
					<td><%=result.getBcontent()%></td>
					<td><%=result.getMid()%></td>
					<td><%=result.getBdate()%></td>
					<td><a href="Filedown?bfile=<%=result.getBfile()%>"><%=result.getBfile()%></a></td>
				</tr>
			</table>
		
		<%}else if(result==null){ %>
			<H1> NULL </H1>
		<%} %>
	</div>
	
	<!--  푸터 영역 -->
	<%@include file="../footer.jsp" %>
</body>
</html>