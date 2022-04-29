<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
//	session.invalidate();	// 모든 세션을 날리기
	session.setAttribute("user", null);	// 해당 세션에 널값으로 대체
	
	response.sendRedirect("main.jsp");
%>