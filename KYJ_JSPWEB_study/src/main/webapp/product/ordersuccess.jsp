<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/KYJ_JSPWEB_study/css/productcart.css" rel="stylesheet">
</head>
<body>
<%@include file = "../header.jsp" %>
		<div class="container"> <!-- container(b) : 컨테이너  -->
			
			<div class="processbox"> <!-- 진행상황 표시 -->
				<span> 01 옵션선택 </span> <span> > </span>
				<span> 02 장바구니 </span> <span> > </span>
				<span> 03 주문결제 </span> <span> > </span>
				<span id="process_active"> 04 주문완료 </span>
			</div>	
		</div>
		
		<h3> 주문 완료 </h3>	

<%@include file = "../footer.jsp" %>
</body>
</html>