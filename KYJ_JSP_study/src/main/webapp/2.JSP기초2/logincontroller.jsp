<%@page import="controller.dto.Member"%>
<%@page import="controller.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	request.setCharacterEncoding("UTF-8");
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	
    	MemberDao memberDao = new MemberDao();
    	Member user = memberDao.login(id, password);
    	if(user!=null){
    		response.sendRedirect("main.jsp");
    		session.setAttribute("user", user);
    		// 서블릿 내장 객체 : session
    			// 서버 (탐캣) 내 메모리 생성. ->> 모든 페이지(파일)에서 접근할 수 있는 공용 메모리 생성.
    			// 단, 해당 메모리는 사용자의 브라우저 마다 생성됨.
    				// 위 선언문은 loginid라는 변수명으로 사용자가 로그인 한 'id'를 저장.
    	} else {
    		response.sendRedirect("http://www.google.com");
    		System.out.println("로그인 실패!!!");
    	}
    			
    	
    	
    
    %>