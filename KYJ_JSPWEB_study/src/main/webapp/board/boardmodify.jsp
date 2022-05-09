<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <!-- 게시판api( 썸머노트) css cdn -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
 	<!-- 썸머노트 기본 부트스트랩버전 3버전 css cdn -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<!-- 썸머노트 css cdn -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<%
		String mid = (String)session.getAttribute("login");
		int mno = MemberDao.instance.getmno(mid);

		int bno = Integer.parseInt(request.getParameter("bno"));
		Board result = BoardDao.instance.getboard2(bno);
		
		if(mid!=null){
	%>
		<div class = "container mt-5">
			<h2> 글 수정하기 </h2>
			<a href="boardlist.jsp"><button>글목록</button></a>
			<form action="../board/Modify2?bno=<%=result.getBno()%>" method="post" enctype="multipart/form-data">
				<!--  form 전송 인코딩 타입 : 기본 타입은 첨부파일 첨부 불가능. -->
				<!--  form 첨부파일 전송 인코딩 타입 : enctype="multipart/form-data" ->> 걍 외워. 자주 쓸꺼임. -->
				제목 : <input type = "text" name = "btitle" value="<%=result.getBtitle()%>"><br>
				<textarea name = "bcontent" id = "summernote"><%=result.getBcontent()%></textarea>
				첨부파일 : <input type = "file" name = "bfile"><br>
				<%if(result.getBfile()!=null){%>
					<button type="button" onclick="filedelete(<%=result.getBno()%>)" style="display:inline !important;"><%=result.getBfile()%> : 삭제하기</button><br>
				<%} %>
				<input type ="submit" value="등록">
				<input type = "reset" value="취소">
			</form>
		</div>
	<%} else{ %>
		<h1 class = "mt-5"> 로그인 하고 글쓰기 페이지에 들어오쎄요????</h1>
	<%} %>
	
	<%@include file="../footer.jsp" %>
   <!-- 썸머노트 기본 부트스트랩버전 3버전 js cdn -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 썸머노트 js cdn  -->
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
    <!--  사용자 정의 보드 js -->
    <script src= "/KYJ_JSPWEB_study/js/board.js" type="text/javascript"></script>
</body>
</html>