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
	<div class = "container mt-5">

			<h2> 게시글 보기 </h2>
				<div id="top_buttonbox">
					<button onclick="del()">글 삭제</button>
					<button onclick="mod()">글 수정</button>
					<a href="/EXAM/board/boardlist.jsp"><button>뒤로가기</button></a>
				</div>
				<form action="" method="post" enctype="multipart/form-data" >
					<div class="row" id="vboard">
				
		</div>
<script type="text/javascript" src="/EXAM/js/boardview.js"></script>
<%@include file="../footer.jsp" %>
</body>
</html>