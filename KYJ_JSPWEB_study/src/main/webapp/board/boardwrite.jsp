<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class = "container mt-5">
		<h2> 글쓰기 </h2>
		<a href="boardlist.jsp"><button>글목록</button></a>
		<form action="../board/Write" method="post">
			제목 : <textarea name = "btitle"></textarea>
			내용 : <textarea name = "bcontent" id = "summernote"></textarea>
			첨부파일 : <input type = "file" name = "bfile">
			<input type ="submit" value="등록">
			<input type = "reset" value="취소">
		</form>
	</div>
	
	
	
	<%@include file="../footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <!--  썸머노트 한글 버전 cdn -->
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
    <!--  사용자 정의 보드 js -->
    <script src= "/KYJ_JSPWEB_study/js/board.js" type="text/javascript"></script>
</body>
</html>