<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file = "../header.jsp" %>
	<div class = "container mt-5">			<!--  박스권 생성 -->
		<div class = "row">				<!--  가로 배치 -->
			<div class = "col-md-3">	<!--  사이드바 -->
				<%@include file = "infosidebar.jsp" %>
			</div>
			<div class = "col-md-9">	<!--  본문 영역 -->
				<h3> 내 정보 </h3>
				<%
					// 1. 세션 호출 ->> 현재 로그인 된 사용자의 아이디 가져오기
					String mid = (String)session.getAttribute("login");
					// 2. DB 메서드 호출
					Member member = MemberDao.instance.getmember(mid);
					// 3. HTML에 객체를 풀어서 보여주기
				%>
				<form>	<!--  업데이트 기능 없음!! 걍 출력용 form -->
					<div class = "row mb-3">
						<label class = "col-md-3 col-form-label">회원번호</label>
						<div class = "col-md-9">
							<input type = "text" class = "form-control" value = <%=member.getMno() %>>
						</div>
					</div>
					<div class = "row mb-3">
						<label class = "col-md-3 col-form-label">아이디</label>
						<div class = "col-md-9">
							<input type = "text" class = "form-control" value = <%=member.getMid()%>>
						</div>
					</div>
					<div class = "row mb-3">
						<label class = "col-md-3 col-form-label">이름</label>
						<div class = "col-md-9">
							<input type = "text" class = "form-control" value = <%=member.getMname()%>>
						</div>
					</div>
					<div class = "row mb-3">
						<label class = "col-md-3 col-form-label">연락처</label>
						<div class = "col-md-9">
							<input type = "text" class = "form-control" value = <%=member.getMphone()%>>
						</div>
					</div>
					<div class = "row mb-3">
						<label class = "col-md-3 col-form-label">이메일</label>
						<div class = "col-md-9">
							<input type = "text" class = "form-control" value = <%=member.getMemail()%>>
						</div>
					</div>
					<div class = "row mb-3">
						<label class = "col-md-3 col-form-label">주소</label>
						<div class = "col-md-9">
							<input type = "text" class = "form-control" value = <%=member.getMaddress()%>>
						</div>
					</div>
					<div class = "row mb-3">
						<label class = "col-md-3 col-form-label">포인트</label>
						<div class = "col-md-9">
							<input type = "text" class = "form-control" value = <%=member.getMpoint()%>>
						</div>
					</div>
					<div class = "row mb-3">
						<label class = "col-md-3 col-form-label">가입날짜</label>
						<div class = "col-md-9">
							<input type = "text" class = "form-control" value = <%=member.getMdate()%>>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<%@include file =  "../footer.jsp" %>
</body>
</html>