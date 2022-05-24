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
<%@include file="../header.jsp" %>


	<div class="container">
	
		<div class="processbox">
			<span> 01 옵션선택 </span> <span> > </span>
			<span id="process_active"> 02 장바구니 </span> <span> > </span>
			<span> 03 주문결제 </span> <span> > </span>
			<span> 04 주문완료 </span>
		</div>
		
		<table class="table my-5" id="carttable" >	<!-- id="carttable" -->
			<!--  js에서 데이터가 들어가는 위치 -->
		</table>
		<div class="col-sm-2">	<!--  상품 전체 삭제 버튼 -->
			<button class="form-control" onclick="cancel(-1)">상품 전체 삭제</button>
		</div>
		<div class="paybox">
			<span> 총 상품금액 </span><span id="pricesum"></span>
			<span> + </span>
			<span>배송비</span> <span id="shippingfee"></span>
			<span> = </span>
			<span>총 결제금액</span> <span id="totalpay"></span>
			<div class="pointbox">
				<span>주문시 적립 예정 포인트 : </span> <span id="point"></span>
			</div>
		</div>
		<div class="row my-5"> <!-- 부트스트랩만 사용되는 구역  -->
				<div class="col-sm-3 offset-3">
					<a href="/KYJ_JSPWEB_study/main.jsp">
						<button class="form-control py-4"> 계속 쇼핑하기 </button>
					</a> 
				</div>
				<div class="col-sm-3">
					<a href="/KYJ_JSPWEB_study/product/orderpay.jsp">
					<button style="background-color:#d9f5ff;" class="form-control py-4">결제하기</button>
					</a>
				</div>
			</div>
		
	</div>
	


<%@include file="../footer.jsp" %>
<script src="/KYJ_JSPWEB_study/js/productcart.js" type="text/javascript"></script>
</body>
</html>