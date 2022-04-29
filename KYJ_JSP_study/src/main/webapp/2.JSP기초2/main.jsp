<%@page import="controller.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 회원제 게시판 </h3>
	<a href = "signup.jsp"><button> 회원가입 </button></a> 
	
	
	
		<!--  자바스크립트 반복문 구역 -->
		<%
			Member loginuser = (Member)session.getAttribute("user");
			if(loginuser != null){
				System.out.println("세션이 살아 있읍니다.");
		%>
			<div> <h1><%=loginuser.getMid() %>님 어서오세요!</h1>
			<h3> 회원번호 [PK] : <%=loginuser.getMnum() %></h3>
			<h3> 회원명 : <%=loginuser.getMname() %></h3></div>
			<h3> 회원비번 : <%=loginuser.getMpassword() %></h3>
			<br><br>
			<a href = "write.jsp"><button> 글 작성 </button></a>
			<a href = "logout.jsp"><button> 로그아웃 </button></a>
			<a href = "signout.jsp"><button>회원탈퇴 버튼</button></a>
		<%
			}else if(loginuser==null){
				System.out.println("세션이 비어있읍니다,,,,");
		%>
		<br><br>
		<form action="logincontroller.jsp" method=get>
			<input type = "text" name = "id">
			<input type = "password" name = "password">
			<input type = "submit" value = "login"> 
		</form>
		
		<%
			}
		%>
	<table> 
	<tr>
		<th> 번호 </th> <th> 제목 </th> <th> 내용 </th> <th> 작성자 </th>
	</tr>
		
	</table>
	
</body>
</html>