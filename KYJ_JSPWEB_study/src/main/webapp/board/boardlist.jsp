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
	<div class = "container mt-5">
		<h1>자유게시판</h1>
		<a href="boardwrite.jsp"><button>글쓰기</button></a>
		<table class="table">
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
			</tr>
			<%
				
			%>
			<tr>
				<!--  for문 위치 -->
			</tr>
		</table>
	</div>
	<!--  푸터 영역 -->
	<%@include file="../footer.jsp" %>
</body>
</html>