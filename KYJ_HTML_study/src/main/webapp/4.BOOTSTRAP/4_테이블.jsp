<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1_설치.jsp" %>
	
	<table>
		<tr>
			<th> 번호 </th>
			<th> 제목 </th>
			<th> 글쓴이 </th>
		</tr>
		<tr><td> 1 </td> <td> 테이블 테스트 중 1 </td><td> 김아무개 </td> </tr>
		<tr><td> 2 </td> <td> 테이블 테스트 중 2 </td><td> 김아무개 </td> </tr>
		<tr><td> 3 </td> <td> 테이블 테스트 중 3 </td><td> 김아무개 </td> </tr>
	</table>

	<table class = "table">
		<tr>
			<th> 번호 </th>
			<th> 제목 </th>
			<th> 글쓴이 </th>
		</tr>
		<tr><td> 1 </td> <td> 테이블 테스트 중 1 </td><td> 김아무개 </td> </tr>
		<tr><td> 2 </td> <td> 테이블 테스트 중 2 </td><td> 김아무개 </td> </tr>
		<tr><td> 3 </td> <td> 테이블 테스트 중 3 </td><td> 김아무개 </td> </tr>
	</table>

	<table class = "table table-hover">	<!--  테이블 호버 : 마우스 커서를 올렸을 때 해당 행에 강조표시. -->
		<tr>
			<th> 번호 </th>
			<th> 제목 </th>
			<th> 글쓴이 </th>
		</tr>
		<tr><td> 1 </td> <td> 테이블 테스트 중 1 </td><td> 김아무개 </td> </tr>
		<tr><td> 2 </td> <td> 테이블 테스트 중 2 </td><td> 김아무개 </td> </tr>
		<tr><td> 3 </td> <td> 테이블 테스트 중 3 </td><td> 김아무개 </td> </tr>
	</table>

	<table class = "table table-hover table-dark">	<!--  테이블 호버에 블랙 스킨까지 씌운것. ->> 중첩이 가능하다!!  -->
		<tr>
			<th> 번호 </th>
			<th> 제목 </th>
			<th> 글쓴이 </th>
		</tr>
		<tr><td> 1 </td> <td> 테이블 테스트 중 1 </td><td> 김아무개 </td> </tr>
		<tr><td> 2 </td> <td> 테이블 테스트 중 2 </td><td> 김아무개 </td> </tr>
		<tr><td> 3 </td> <td> 테이블 테스트 중 3 </td><td> 김아무개 </td> </tr>
	</table>
	
		<table class = "table table-hover">	<!--  테이블 호버 : 마우스 커서를 올렸을 때 해당 행에 강조표시. -->
		<tr>
			<th> 번호 </th>
			<th> 제목 </th>
			<th> 글쓴이 </th>
		</tr>
		<tr><td> 1 </td> <td class = "align-bottom"> 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 
		테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 
		1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 테이블 테스트 중 1 </td><td> 김아무개 </td> </tr>
		<tr><td> 2 </td> <td> 테이블 테스트 중 2 </td><td> 김아무개 </td> </tr>
		<tr><td> 3 </td> <td> 테이블 테스트 중 3 </td><td> 김아무개 </td> </tr>
	</table>
	
</body>
</html>