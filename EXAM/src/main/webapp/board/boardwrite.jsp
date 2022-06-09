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
</head>
<body>
<%@include file="../header.jsp" %>
	<div class = "container mt-5">
	

			<h2> 글 작성 페이지 </h2>
				<form action="" method="post" enctype="multipart/form-data">
				<div class="row">
					<div class="col-md-3">
						<input type="text" class="form-control" id="writer" placeholder="글쓴이" >
					</div>
					<div class="col-md-3">
						<input type="password" class="form-control" id="writerpassword" placeholder="비밀번호" >
					</div>
					
					<div class="col-md-12">
						<input class="form-control" type = "text" name = "" id="title" placeholder="제목"><br>
					</div>
					<div class="col-md-12">
						<textarea class="form-control"  name = "" id = "content" rows="10" cols="20" placeholder="내용"></textarea>
					</div>
				</div>
					<div class="col-md-10 offset-2 mt-2">
						<div class="row button_box">
							<input type = "file" name = "" id="file">
							<button type="button" onclick="save()">등록</button>
							<input type = "reset" value="취소" style="background-color: #ff2b80;">
						</div>
					</div>
				</form>
		</div>

<%@include file="../footer.jsp" %>


	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 썸머노트 js cdn  -->

<script src= "/EXAM/js/board.js" type="text/javascript"></script>
</body>
</html>