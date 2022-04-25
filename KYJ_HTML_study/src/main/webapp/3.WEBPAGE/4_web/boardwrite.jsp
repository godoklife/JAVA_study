<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "header.jsp" %>
	<br><br><br><br><br>

	<div class="container">	<!--  본문 영역 -->
		<h3 class="text-center board"> 문의 글 작성하기</h3>
		<div class="titleline">
			문의 글 작성하기
		</div>
		<form action="#" method="get">	<!--  form 양식 : [ 입력받은 값을 action으로 전송 할 수 있다. ]  -->
			<div class="row">
				<div class="col-md-3">
					작성자 : <input class="form-control" type="text" placeholder="작성자" maxlength="10">
				</div>
				<div class="col-md-3">
					비밀번호 : <input class="form-control" type="password" placeholder="게시글의 비밀번호" maxlength="4">
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					제목 : <input class="form-control" type="text" placeholder="문의 제목을 작성해주세요." maxlength="50">
				</div>
			</div>
			내용 : <textarea class="form-control" rows="20" cols="" placeholder="문의 내용을 작성하세요."></textarea>
			
			<div class="row">
				<div class="col-md-3">
					첨부파일 : <input class="form-control" type="file">	<!--  첨부파일 입력 상자 -->
				</div>
			</div>
			<div class="row col-md-4 offset-4">
				<div class="col-md-4">
				<input class="form-control" type="submit" value="등록">	<!--  폼 전송 버튼 ->> action으로 전송. -->
				</div>
				<div class="col-md-4">
				<input class="form-control" type="reset" value="다시 쓰기">
				</div>
				<div class="col-md-4">
				<a href="#"><button>목록보기</button></a> 
				</div>
			</div>
		</form>
	</div>


	<br><br><br><br><br>
	<%@include file = "footer.jsp" %>
</body>
</html>