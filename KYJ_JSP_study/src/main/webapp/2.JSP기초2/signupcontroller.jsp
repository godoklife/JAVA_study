<%@page import="controller.dao.MemberDao"%>
<%@page import="controller.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%	// 현 페이지는 자바 형식의 컨트롤러로 사용.
    	// HTML도 작성 가능하나 분리가 필요하기에 자바문만 작성.
    	
    	// request : 서버가 ->> 클라이언트 에게 요청!
    		// 요청시 한글이 지원되는 인코딩으로 변환해주어야 함.
    	request.setCharacterEncoding("UTF-8");	// UTF-8형식으로 요청.
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	String name = request.getParameter("name");
    	
    	// dto ->> 객체화
    	Member member = new Member(0, id, password, name);
    	
    	// 객체(dto) ->> dao(DB)
    	MemberDao memberDao = new MemberDao();
    	
    	// dao 가입 메서드 실행
    	boolean result = memberDao.signup(member);
    	
    	if(result){
    		response.sendRedirect("main.jsp");	// 해당 웹 페이지로 이동시킴.
    		// respone.sendRedirect("URL")
    	}
    %>