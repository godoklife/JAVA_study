<%@page import="controller.dao.MemberDao"%>
<%@page import="controller.dto.Board"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="controller.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	request.setCharacterEncoding("UTF-8");	// 데이타 요청시 인코딩 타입 설정.
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	Member tmp = (Member) session.getAttribute("user");
    	String writer = tmp.getMid();
    	Date nowtime = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String date = sdf.format(nowtime);	// 현재 날짜, 시간 포맷 변경하기.
    	
    	Board board = new Board(0, title, content, writer, date);
    	
    	MemberDao memberDao = new MemberDao();
    	boolean result = memberDao.write(board);
    	if(result){
    		response.sendRedirect("main.jsp");
    	}
    	
    	
    	
    %>