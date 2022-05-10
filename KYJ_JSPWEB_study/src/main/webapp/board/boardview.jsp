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
				session.setMaxInactiveInterval(10);	// 테스트용으로 30초 셋팅
			}
			Board result = BoardDao.instance.getboard2(bno);
			
			// 조회수 증가
			
			
			if(result != null && result.getMno()==MemberDao.instance.getmno(mid)){
		%>
				<a href="Delete2?bno=<%=result.getBno()%>"><button>삭제</button></a>
				<a href="boardmodify.jsp?bno=<%=result.getBno()%>"><button>수정</button></a>
		<%} %>	
				<a href="/KYJ_JSPWEB_study/board/boardlist.jsp"><button>목록</button></a>
	
		
		<%
			if(result!=null){
		%>
			<h4 class="boardview_title"><span class="boardview_title_text"><%=result.getBtitle()%></span></h4>
			<table class="table">
				<tr>
					<td>번호</td><td>제목</th><th>내용</th><th>작성자</th><th>작성일</th><th>첨부파일</th><th>조회수</th>
				</tr>
				<tr>
					<td><%=result.getBno()%></td>
					<td><%=result.getBtitle()%></td>
					<td><%=result.getBcontent()%></td>
					<td><%=result.getMid()%></td>
					<td><%=result.getBdate()%></td>
					<%if(result.getBfile()==null){ %>
						<td style="color:red;">첨부파일이 없습니다.</td>
					<%}else{ %>
						<td><a href="Filedown?bfile=<%=result.getBfile()%>"><%=result.getBfile()%></a></td>
					<%} %>
					<td><%=result.getBview()%></td>
				</tr>
			</table>
			
			<h3>덧글</h3>
			<input type="text" id="rcontent">
			<button onclick="replywrite(<%=bno%>)">등록</button>
			
			<table id="replytable" class="table">
				<%
					ArrayList<Reply> replylist = BoardDao.instance.replylist(bno);
					for(Reply tmp : replylist){
				%>
				<tr>
					<td> 작성자 : <%=tmp.getMid()%><br> 작성일 : <%=tmp.getRdate()%></td>
					<td> 내용 : <%=tmp.getRcontent()%></td>
					<td><button>수정</button><button>삭제</button><button onclick="rereplyview(<%=tmp.getRno()%>,<%=tmp.getBno()%>)">대댓글 달기</button></td>
				</tr>
				<tr>	<!--  대댓글 입력창 -->
					<td> </td>
					<td id=<%=tmp.getRno()%>></td>
				</tr>
				<!--  대댓글 출력창 -->
					<%ArrayList<Reply> rereplylist = BoardDao.instance.rereplylist(bno, tmp.getRno());
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
			
				
				
		<%}else if(result==null){ %>
			<H1> 이상하게 들어오지 말라 했제?? 캣제??? 그랫제???? </H1>
		<%} %>
	</div>
	
	<!--  푸터 영역 -->
	<%@include file="../footer.jsp" %>
	
	<script src="/KYJ_JSPWEB_study/js/board.js" type="text/javascript"></script>
</body>
</html>