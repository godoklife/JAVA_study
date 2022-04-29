<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%	// 자바 코드가 작성되는 공간
		// 폼이 전송 하기 전에는 요청할 수 없다! [ null pointer exception 발생 ]
	Calendar calendar = Calendar.getInstance();	// new 없어도 됨!!! 기본 제공 객체!
	
	int year = 2022;
	int month = 4;
	int sweek;
	int eday;
	boolean flag=false;
	if(request.getParameter("year") != null && request.getParameter("month") != null){
		// 폼이 전송되었을 때 == 널값이 아닐 때, 조건문으로 안 막아주면 페이지 실행하자마자 터짐. [ null pointer exception 발생 ]
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));
		if(month<1){
			month=12;
			year=year-1;
		}else if(month>12){
			month=1;
			year=year+1;
		}
		
		if(year < 1900 || year > 2300 || month < 1 || month > 12){
			flag = true;	// 출력 불가능한 범위이면 플래그를 true로 전환.
		}
	}
	
	calendar.set(year, month-1, 1);	// 월에서 1을 깎는 이유?? ->> 0 : 1월, 11: 12월
	sweek = calendar.get(Calendar.DAY_OF_WEEK);
	eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	%>
	
	<!--  html 작성 공간 -->
	
	<form action="4_달력.jsp" method="get">
		<!--  action : 폼이 전송될 위치(파일명) -->
		<input type="text" name="year" placeholder="연도"	>
		<input type="text" name="month" placeholder="월"	>
		<input type="submit" value="검색">
	</form>
	
	<p> 입력한 연도 : <%=year %>
	<p> 입력한 월 : <%=month %>
	
	<form action="4_달력.jsp" method="get">
		<input type="text" name="year" value="<%=year %>" >
		<input type="text" name="month" value="<%=month-1 %>" disabled = "disabled">
		<input type="submit" value="이전">
	</form>
	
	<form action="4_달력.jsp" method="get">
		<input type="text" name="year" value="<%=year %>">
		<input type="text" name="month" value="<%=month+1 %>">
		<input type="submit" value="다음">
	</form>
	<%
		if(flag){
	%>
		<h1 style="color:red;"> 출력할 수 없는 값 입니다.</h1>
	
	<%
		}
	%>	
	
	<table>
		<tr>
			<th> 일요일 </th>
			<th> 월요일 </th>
			<th> 화요일 </th>
			<th> 수요일 </th>
			<th> 목요일 </th>
			<th> 금요일 </th>
			<th> 토요일 </th>
		</tr>
		<tr>
			<!--  시작 요일까지 공백으로 매꾸기. -->
			<% for(int i=1; i<sweek; i++) { %>
				<td> </td>
			<% } %>
			<!--  1일부터 마지막일까지 1씩 증가 하면서 출력. -->
			<% for(int i=1; i<eday; i++) {%>
				<td> <%=i %> </td>
				<!--  7배수(토요일)마다 줄바꿈 해줄 필요가 있음. -->
				<% if(sweek % 7 == 0){ %>
					</tr><tr>	<!--  줄바꿈 역할 하는 라인. -->
				<% } %>
				<% sweek++; %> <!-- 일 증가할 때 마다 요일도 증가 -->
			<% } %>
			
		</tr>
	</table>
		
</body>
</html>