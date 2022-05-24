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
				<h3> 주문 현황 </h3>
				<div id="orderbox">
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/KYJ_JSPWEB_study/js/myshopping.js"></script>
	<%@include file =  "../footer.jsp" %>
</body>
</html>