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
				<table class="table table-hover text-center my-5" id="boardlist">
					
					
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/EXAM/js/boardlist.js"></script>
<%@include file="../footer.jsp" %>
</body>
</html>