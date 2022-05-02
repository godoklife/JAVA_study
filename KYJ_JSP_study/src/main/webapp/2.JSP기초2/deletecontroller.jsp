<%@page import="controller.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	int bno = Integer.parseInt(request.getParameter("bno"));
    	MemberDao.instance.boarddelete(bno);
    	response.sendRedirect("main.jsp");
    %>
    
