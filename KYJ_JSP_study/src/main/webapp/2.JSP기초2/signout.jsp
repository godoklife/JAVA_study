<%@page import="controller.dto.Member"%>
<%@page import="controller.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member user = (Member)session.getAttribute("user");
	MemberDao memberDao = new MemberDao();
	memberDao.signout(user.getMnum());
	System.out.println(user.getMid()+" 님은 삭제되었습니다.");
	session.setAttribute("user", null);	// 해당 세션에 널값으로 대체
	response.sendRedirect("main.jsp");
	
%>