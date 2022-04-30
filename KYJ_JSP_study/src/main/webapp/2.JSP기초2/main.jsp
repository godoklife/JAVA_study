<%@page import="controller.dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.dao.MemberDao"%>
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
	<%
		Member loginuser = (Member)session.getAttribute("user");
	%>
	
	<%
		if(loginuser==null){
	%>
	<a href = "signup.jsp"><button> 회원가입 </button></a> 
	<%
		}
	%>
	
		<!--  자바스크립트 반복문 구역 -->
		<%
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
		<th> 번호 </th> <th> 작성자 </th> <th> 제목 </th> <th> 작성일 </th>
	</tr>
	<%if(MemberDao.instance.boardlist()!=null){ // sql 탐색을 두번 하는 상당히 비효율적인 조건문임.
		ArrayList<Board> result = MemberDao.instance.boardlist();
		for(int i=0; i<result.size(); i++){
	%>
		<tr>
			<td><a href = "view.jsp?bno=<%=result.get(i).getBno()%>"><%=result.get(i).getBno()%>번 </a></td>
			<td><a href = "view.jsp?bno=<%=result.get(i).getBno()%>"><%=result.get(i).getBwriter()%></a></td>
			<td><a href = "view.jsp?bno=<%=result.get(i).getBno()%>"><%=result.get(i).getBtitle()%></a></td>
			
			<td><a href = "view.jsp?bno=<%=result.get(i).getBno()%>"><%=result.get(i).getBdate()%></a></td>
			
			<!--  링크 던져주는건 get방식만 가능 : 주소에 값을 띄워주는. -->
		</tr>
		<%}%>
	<%} %>	
	</table>
	
</body>
</html>