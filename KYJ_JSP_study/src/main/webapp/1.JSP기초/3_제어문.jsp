<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// <%! 선언부 내용 작성 %//>
		// <%! 스크립트부 내용 작성 %//>
		// <%= 표현식 : 메모리 호출 %//>
	%>
	
	<form action = "3_결과페이지.jsp">
		이름 : <input type="text" name="name"><br>
		<!--  input : 입력 상자, name : 식별 이름 -->
		배경색 : <select name = "color">
			<option value = "blue"> 파랑 </option>
			<option value = "red"> 빨강 </option>
			<option value = "yellow"> 노랑 </option>
			<option value = "black"> 깜장 </option>
		</select>
		<!--  select : 선택 상자 -->
		반복횟수 : <input type="text" name="number"><br>
				
		<input type = "submit" value="전~~송">
	</form>
	<br>
	현제 출력중인 페이지는 3_제어문.jsp 입니다.
	
	
</body>
</html>