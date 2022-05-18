<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E L E C   M A L L</title>
	<link href="/EXAM/css/board.css" rel="stylesheet">
	
	<!-- 게시판api( 썸머노트) css cdn -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
 	<!-- 썸머노트 기본 부트스트랩버전 3버전 css cdn -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<!-- 썸머노트 css cdn -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
	<div class = "container mt-5">
	<%
		if(session.getAttribute("id")==null){
	%>
		<h3>
			로그인 후 글쓰기가 가능합니다.
		</h3>
	<%}else{ %>
			<h2> 글 작성 페이지 </h2>
				<form action="" method="post" enctype="multipart/form-data">
				<div class="row">
					<div class="col-md-2">제목 : </div>
					<div class="col-md-10">
						<input class="form-control" type = "text" name = "" id="title"><br>
					</div>
					<div class="col-md-2">내용 : </div>
					<div class="col-md-10">
						<textarea class="form-control"  name = "" id = "content" rows="10" cols="20"></textarea>
					</div>
				</div>
					<div class="col-md-10 offset-2 mt-2">
						<div class="row button_box">
							<input type = "file" name = "" id="file">
							<button type="button" onclick="check()">등록</button>
							<input type = "reset" value="취소" style="background-color: #ff2b80;">
						</div>
					</div>
				</form>
		</div>
		<%} %>
<%@include file="../footer.jsp" %>


	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 썸머노트 js cdn  -->
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>

<script src= "/EXAM/js/board.js" type="text/javascript"></script>
</body>
</html>