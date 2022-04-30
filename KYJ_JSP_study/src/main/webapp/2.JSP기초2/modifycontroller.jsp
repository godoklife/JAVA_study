<%@page import="controller.dto.Board"%>
<%@page import="controller.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String modtitle = request.getParameter("modtitle");
    	String modcontent = request.getParameter("modcontent");
    	String bdate = request.getParameter("bdate");
    	int bno = Integer.parseInt(request.getParameter("bno"));
    	String bwriter = request.getParameter("bwriter");
    	Board board = new Board(bno, modtitle, modcontent, bwriter, bdate);
    	MemberDao.instance.boardmodify(board);
    	response.sendRedirect("view.jsp?bno="+board.getBno());
    %>