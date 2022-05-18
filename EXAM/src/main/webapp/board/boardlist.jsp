<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E L E C   M A L L</title>
	<link href="/EXAM/css/board.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
	<div class="container">
		<div class="row">
			<div>
				<a href="/EXAM/board/boardwrite.jsp"><button>글 작성</button></a>
				<table class="table table-hover text-center my-5">
					<tr class="">
						<th width="5%">글번호</th><th width="50%">제목</th>
						<th width="20%">작성자</th><th width="20%">작성일</th>
						<th width="5%">조회수</th>
					</tr>
					<tr>
						<td>1</td><td><a href="boardview.jsp">안녕하세요</a></td>
						<td>cirrus</td><td>10:10</td>
						<td>1</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
<%@include file="../footer.jsp" %>
</body>
</html>