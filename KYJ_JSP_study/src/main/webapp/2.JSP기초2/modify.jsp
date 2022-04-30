<%@page import="controller.dto.Member"%>
<%@page import="controller.dao.MemberDao"%>
<%@page import="controller.dto.Board"%>
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
	int bno = Integer.parseInt(request.getParameter("bno"));	// 이 파라미터는 view페이지에 들어갈 때 주소에 섞어서 던져준 bnum임. main.jsp 57~59라인 참고.
	System.out.println("getparameter : "+bno);
	Board board = MemberDao.instance.viewboard(bno);
	
	%>
	<form action="modifycontroller.jsp" method="get">
		<input type="text" name="modtitle" value = "<%=board.getBtitle()%>">
		<textarea cols="50" rows="10" name = "modcontent"><%=board.getBcontent()%></textarea>
		<input type="submit" value = "수정하기">
		<input type="hidden" name = "bdate" value = "<%=board.getBdate()%>">
		<input type="hidden" name = "bno" value="<%=board.getBno()%>">
		<input type="hidden" name = "bwriter"value="<%=board.getBwriter()%>">
		
	</form>
	<a href = "view.jsp?bno=<%=board.getBno()%>"><button>뒤로가기</button></a>
</body>
</html>