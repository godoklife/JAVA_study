<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	request.setCharacterEncoding("UTF-8");
    	String id = request.getParameter("mid");
    	String password = request.getParameter("mpassword");
    	String name = request.getParameter("mname");
    	String phone = request.getParameter("mphone");
    	String email = request.getParameter("email");
    	String address = request.getParameter("maddress");
    	
    	Member member = new Member(0, id, password, name, phone, email, address, 0, null);
    	
    	
    %>