<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<br><br><br><br><br>
	
	<div class="container">
		<h3 class="text-center titleline"> 문의 글 </h3>
		
		<!--  버튼 위치부 -->
		<div>
			<a href="boardlist.jsp"> <button class="btn btn-outlise-info">목록보기</button>  </a>
			<a href="boardlist.jsp"> <button class="btn btn-outlise-info">삭제</button> </a>	<!--  작성자 가능. [ 유효성 검사 필요 ] -->
			<a href="boardlist.jsp"> <button class="btn btn-outlise-info">수정</button> </a>	<!--  작성자 가능. [ 유효성 검사 필요 ] -->
			<a href="boardlist.jsp"> <button class="btn btn-outlise-info">답변</button> </a>	<!--  관리자 가능. [ 유효성 검사 필요 ] -->
		</div>		
		<!--  작성자 입력한 내용 -->
		<div>	<!-- div 박스권 기본값 : display : block, span 박스권 기본값 : display : inline -->
			<span>작성자</span> <span>유재석</span>
		</div>
		<div>
			<span> 제목 </span> <span></span>
		</div>
		<div>
			<textarea rows="20" cols="" class="form-control" style="resize:none;" readonly> 미니이리미니이리</textarea>
			<!--  readonly="readonly" ->> 읽기 전용, 수정 불가. ->> 그냥 readonly라고만 적어도 됨. -->
		</div>
		<!--  관리자가 답변한 내용 -->
		<div>
			<span>관리자 답변 작성란 - </span>
			<textarea rows="" cols="" class="form-control"  style="resize:none;" ></textarea>
		</div>
		
	</div>
	
	
	<br><br><br><br><br>
	<%@include file="footer.jsp" %>
</body>
</html>