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
				<span id="process_active"> 03 주문결제 </span> <span> > </span>
				<span> 04 주문완료 </span>
			</div>		
		
			<div>	<!--  제품 목록  -->
				<table class="carttable">
				</table>
			</div>
			<div>	<!--  받는사람 정보 -->
				<input id="checkbox" type="checkbox">	<!--  체크시 회원 정보 가져오기 -->
				<h5>받는 사람</h5>
				<form>
					받는사람 <input id="ordername">
					연락처 <input id="orderphone">
					주소 <input id="orderaddress">
					배송 요청사항 <input id="orderrequest">
				</form>
			</div>
			<div class="col-sm-4">
				<div class="paybox">
					<div>	<!--  포인트 사용 -->
						포인트 : <input><button>사용하기</button>
					</div>
					<div>	<!--  결제 정보  -->
						총 상품금액 : <span> 29,000 원</span>
						배송비 : <span> 3,000 원</span>
						포인트 사용 : <span> 0 포인트</span>
						총 결제액 : <span>32,000 원</span>
					</div>
					<div>
						<button>카드</button>
						<button>계좌이체</button>
						<button>무통장입금</button>
						<button>핸드폰결제</button>
					</div>
				</div>
			</div>
			<div class="row my-5"> <!-- 부트스트랩만 사용되는 구역  -->
				<div class="col-sm-3 offset-3 paybox">
					<a href="/KYJ_JSPWEB_study/main.jsp">
						<button class="form-control py-4"> 계속 쇼핑하기 </button>
					</a> 
				</div>
				<div class="col-sm-3 paybox">
					<button style="background-color:#d9f5ff;" class="form-control" onclick="pay()">결제하기</button>
				</div>
			</div>
			
			
		</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>	
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>	
	<script src="/KYJ_JSPWEB_study/js/orderpay.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>
</body>
</html>