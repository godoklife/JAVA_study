<%@page import="controller.dto.Member"%>
<%@page import="controller.dto.Board"%>
<%@page import="controller.dao.MemberDao"%>
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
		
		Member tmp = (Member) session.getAttribute("user");
		if(board!=null && tmp!=null && tmp.getMid().equals(board.getBwriter())){
	%>
	<a href="modify.jsp?bno=<%=board.getBno()%>"> <button>글 수정</button></a>
	<a href="deletecontroller.jsp?bno=<%=board.getBno()%>"> <button>글 삭제</button></a>
	<%
		}
	%>
	<a href="main.jsp"> <button>목록보기</button></a>
	
	
	
	<div> 제목 : <%=board.getBtitle()%></div>
	<div> 작성자 : <%=board.getBwriter()%></div>
	<div> 작성날짜 : <%=board.getBdate()%></div>
	<div> 내용 : <%=board.getBcontent()%></div>
	
</body>
</html>