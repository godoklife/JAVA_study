<%@page import="dto.Member"%>
<%@page import="java.io.File"%>
<%@page import="dto.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  해더 영역 -->
	<%@include file="../header.jsp" %>
	
	<div class="container mt-5">
		<h1> 자유게시판 </h1>
		<%	
			int bno = Integer.parseInt(request.getParameter("bno"));
			String boardnumber =String.valueOf(bno);
			String mid = (String)session.getAttribute("login"); 
			
			if(session.getAttribute(boardnumber)==null){
				BoardDao.instance.increaseview(bno);	
				session.setAttribute(boardnumber, bno);
				session.setMaxInactiveInterval(600);	
			}
			Board board = BoardDao.instance.getboard2(bno);
			
			// 조회수 증가
			
			
			if(board != null && board.getMno()==MemberDao.instance.getmno(mid)){
		%>
				<a href="Delete2?bno=<%=board.getBno()%>"><button>삭제</button></a>
				<a href="boardmodify.jsp?bno=<%=board.getBno()%>"><button>수정</button></a>
		<%} %>	
				<a href="/KYJ_JSPWEB_study/board/boardlist.jsp"><button>목록</button></a>
	
		
		<%
			if(board!=null){
		%>
			<h4 class="boardview_title"><span class="boardview_title_text"><%=board.getBtitle()%></span></h4>
			<table class="table">
				<tr>
					<td width="25%">번호 : <%=board.getBno()%></td>
					<td width="25%">작성자 : <%=board.getMid()%></td>
					<td width="25%">작성일 : <%=board.getBdate()%></td>
					<td width="25%">조회수 : <%=board.getBview()%></td>
				</tr>	
				<tr>
					<td colspan="4">	<!--  colspan : 열 병합 // rowspan : 행 병합 -->
						<div class="boardview_content">
							<%
								String imgpath = request.getSession().getServletContext().getRealPath("/board/upload/"+board.getBfile());
							%>
							<img src="<%=imgpath%>" width=100%><br>
							<%=board.getBcontent()%>	
						</div>
					</td>
				</tr>
				<tr>
					<%if(board.getBfile()==null){ %>
						<td colspan="4" style="color:red;">첨부파일이 없습니다.</td>
					<%}else{ %>
						<td colspan="4"><a href="Filedown?bfile=<%=board.getBfile()%>"><%=board.getBfile()%></a></td>
					<%} %>
				</tr>
			</table>
			
			<div class="row">
			
			</div>
			<input type="text" id="rcontent">
			<button onclick="replywrite(<%=bno%>)">등록</button>
			
			<table id="replytable" class="table">
				<%
					ArrayList<Reply> replylist = BoardDao.instance.replylist(bno);
					for(Reply reply : replylist){
				%>
				<tr>
					<td> 작성자 : <%=reply.getMid()%><br> 작성일 : <%=reply.getRdate()%></td>
					<td> 내용 : <%=reply.getRcontent()%></td>
					<td>
						<%
							if(MemberDao.instance.getmno(mid)==reply.getMno()){
						%>
							<button onclick="replymodifyview(<%=reply.getRno()%>,<%=reply.getBno()%>)">수정</button>
							<button onclick="replydelete(<%=reply.getRno()%>)">삭제</button>
						<%}else{%>
							<button disabled="disabled">수정</button><button disabled="disabled">삭제</button>
						<%} %>
						<button onclick="rereplyview(<%=reply.getRno()%>,<%=reply.getBno()%>,'<%=mid%>')">덧덧글 달기</button>
					</td>
				</tr>
				<tr>	<!--  대댓글 입력창 -->
					<td> </td>
					<td id=<%=reply.getRno()%>></td>
				</tr>
				<!--  대댓글 출력창 -->
					<%ArrayList<Reply> rereplylist = BoardDao.instance.rereplylist(bno, reply.getRno());
						for(Reply rereply : rereplylist ){
					%>
						<tr>
							<td></td>
							<td> 작성자 : <%=rereply.getMid()%><br> 작성일 : <%=rereply.getRdate()%></td>
							<td> 내용 : <%=rereply.getRcontent()%></td>
							<td><button>수정</button><button>삭제</button></td>
						</tr>
					<%} %>
				<%} %>
			</table>
			
				
				
		<%}else if(board==null){ %>
			<H1> 이상하게 들어오지 말라 했제?? </H1>
		<%} %>
	</div>
	
	<!--  푸터 영역 -->
	<%@include file="../footer.jsp" %>
	
	<script src="/KYJ_JSPWEB_study/js/board.js" type="text/javascript"></script>
</body>
</html>