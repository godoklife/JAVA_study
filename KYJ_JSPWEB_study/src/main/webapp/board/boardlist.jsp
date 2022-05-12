<%@page import="dao.MemberDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
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
	<div class = "container">
		<h4 class="boardlist_title"> 자유게시판 </h4>
		<!--  ----------------- 검색 처리부 -----------------  -->
		<%
			String mid = (String)session.getAttribute("login");
			request.setCharacterEncoding("utf-8");
			String key = request.getParameter("key");
			String keyword=request.getParameter("keyword");
			// 검색바에 내용이 있을 경우
			if(key!=null && keyword!=null){
				session.setAttribute("key", key);
				session.setAttribute("keyword", keyword);
			}
			// 검색바에 내용이 없을 경우
			else{
				key = (String)session.getAttribute("key");
				keyword = (String)session.getAttribute("keyword");
			}
			
		%>
		
		<!--  ----------------- 페이지 남바 계산 구역 -----------------  -->
		<%	
			// 1. 게시물 전체 개수
			int totalcount;
			if(key.equals("mid")){
				totalcount=BoardDao.instance.gettotalrow("mno", MemberDao.instance.getmno(keyword)+"");
			}else{
				totalcount=BoardDao.instance.gettotalrow(key, keyword);	// 게시글 총 개수 출력(게시판 구분 안함.)
			}
			// 2. 현재 페이지 번호
			int pagenum;
				// 요청받은 페이지 남바
				if(request.getParameter("pagenum")==null){
					pagenum = 1;
				}else{
					pagenum = Integer.parseInt(request.getParameter("pagenum"));
				}
			int currentpage=pagenum;
			// 3. 페이지당 게시물을 표시할 개수
			int listsize=10;	// 추후 사용자에게 입력받기
			// 4. 페이지당 게시물의 시작 번호
			int startrow = (currentpage-1)*listsize;
				// 1페이지 : 0 // 2페이지 : 10 // 3페이지 : 20 ~~
			// 5. 마지막 페이지 남바	
			int lastpage;	
			if(totalcount%listsize==0){		// 마지막 페이지 남바 계산부
				lastpage = totalcount/listsize;
			}else{
				lastpage = (totalcount/listsize)+1;
			}
			
			//6-2 페이지 표시 개수
			int btnsize = 5;
			
			// 6. 페이지 버튼의 시작 번호
//			int startbtn = ( (currentpage-1) / listsize ) * btnsize + 1;	// 페이지 개수 5개씩 표시할꺼임.
			int startbtn = ((currentpage/btnsize)*btnsize)+1;
				if(currentpage==1){
					startbtn=1;
				}
			// 7. 페이지 버튼의 끝 번호	
			int endbtn = startbtn + btnsize-1;
			if(endbtn>lastpage){
				endbtn=lastpage;
			}
			ArrayList<Board> boardlist;
			if(key.equals("mid")){
				boardlist = BoardDao.instance.getboardlist2(-1, startrow, listsize, "mno", MemberDao.instance.getmno(keyword)+"");
			}else{
				boardlist = BoardDao.instance.getboardlist2(-1, startrow, listsize, key, keyword);
			}
		%>
		
		
		<div class="row mb-2">
			<div class="col-md-1">
				<a href="boardlist.jsp?key=&keyword="><button class="form-control">전체글</button></a>
			</div>
			<div class="col-md-1">
				<button class="form-control">인기글</button>
			</div>
			<%
				if(mid!=null){
			%>
				<div class="col-md-1 offset-9">
					<a href="boardwrite.jsp"><button class="form-control">글쓰기</button></a>
				</div>
			<%}else{%>
				<div class="col-md-1 offset-9">
					<button disabled="disabled" class="form-control" style="background-color: gray;">글쓰기</button>
				</div>
			<%} %>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="10%">번호</th><th width="45%">제목</th><th width="17%">작성자</th><th width="8%">조회수</th><th width="20%">작성일</th>
			</tr>
			<%
				for(Board tmp : boardlist){
			%>
				<!--  행을 클릭했을때의 JS
					<tr onclick="location.href='boardview.jsp'">
					하위 페이지로 이동시 [ 식별 번호 같이 이동 ] 
						// 1. HTML : 파일명( 경로 ).jsp?변수명=값
						// 2. JS : "location.href='파일명(경로).jsp?변수병=값'"
						// 3. JAVA(JSP) : response.sendRedirect("파일명(경로).jsp");
				-->
				<tr>
					<td><%=tmp.getBno()%></td>
					<!-- <td onclick="location.href='boardview.jsp?bno=<%=tmp.getBno()%>'" style="cursor: pointer;"><%=tmp.getBtitle()%></td> -->
					<td style="text-align:left; padding-left:5%;cursor:pointer;" onclick="location.href='boardview.jsp?bno=<%=tmp.getBno()%>'"><%=tmp.getBtitle()%></td>
					<td ><%=tmp.getMid()%></td>
					<td><%=tmp.getBview()%></td>
					<td><%=tmp.getBdate()%></td>
				</tr>
			<%} %>
		</table>

		<!--  ----------------- 페이지 남바 입력 구역 -----------------  -->
		<div class="col-md-6 offset-3 d-flex justify-content-center">
			<ul class="pagination">
				<!--  첫 페이지 버튼 -->
				<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=1">처음</a>
				<!--  이전 페이지 버튼 -->
				<%if(currentpage==1){ %>
					<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage%>">이전</a></li>
				<%}else{ %>
					<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage-1%>">이전</a></li>
				<%} %>
				<!--  페이지 버튼 -->
				<%
					for(int i=startbtn; i<=endbtn; i++){
				%>
					<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=i%>"><%=i%></a></li>
				<%} %>
				<!--  다음 페이지 버튼 -->
				<%if(currentpage==lastpage) {%>
					<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage%>">다음</a></li>
				<%}else{ %>
					<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage+1%>">다음</a></li>
				<%} %>
				<!-- 마지막페이지 버튼 -->
				<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=lastpage%>">마지막</a>
				
			</ul>
		</div>
		<!--  ----------------- 검색바 입력 구역 -----------------  -->
		<form action = "boardlist.jsp?pagenum<%=currentpage%>" class= "col-md-4 offset-4 d-flex justify-content-center">
			<div class="col-md-3">	<!--  키워드 선택 버튼 -->
				<select class="form-select" name="key">	<!-- 검색할 필드 선택 -->
					<option value="btitle"> 제목 </option>
					<option value="bcontent"> 내용 </option>
					<option value="mid"> 작성자 </option>
				</select>
			</div>
			<div class="col-md-7">	<!-- 입력바 -->
				<input type="text" class="form-control" name="keyword">	<!-- 검색할 해당 필드의 값 -->
			</div>
			<div class="col-md-2">
				<input type="submit" class="form-control" value="검색">
			</div>
		</form>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	<!--  푸터 영역 -->
	<%@include file="../footer.jsp" %>
</body>
</html>