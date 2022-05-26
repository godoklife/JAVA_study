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
		
			<div class="row">
				<div class="col-sm-8">
					<div>	<!--  제품 목록  -->
						<table class="table my-5" id="carttable">
						</table>
					</div>
					
					<div>	<!--  받는사람 정보 -->
						<h5>받는 사람</h5>
						<input id="checkbox" type="checkbox"> 회원과 동일	<!--  체크시 회원 정보 가져오기 -->
						<form>
							성명 <input id="ordername">
							연락처 <input id="orderphone">
							주소 
							<br>
								<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호">
								<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
								<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
								<span id="guide" style="color:#999;display:none"></span>
								<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
							<br>
							배송 요청사항 <input id="orderrequest">
						</form>
					</div>	
				</div>
				<div class="col-sm-4">
					<div class="paybox">
						<div>	<!--  포인트 사용 -->
							보유 포인트 : <span id="mpoint"></span> <br>
							포인트 : <input id="mpointinput"><button onclick="pointbtn()">사용하기</button>
						</div>
						<div>	<!--  결제 정보  -->
							총 상품금액 : <span id="sumprice"></span>
							배송비 : <span id="deliverypay"></span>
							포인트 사용 : <span id="pointbox"></span>
							총 결제액 : <span id="totalpay"></span>
						</div>
						<div> 결제수단 : <span id="paymethod"></span>
							<button id="samsung" onclick="paymethod('samsung')">삼성페이</button>
							<button id="card" onclick="paymethod('card')">카드</button>
							<button id="trans" onclick="paymethod('trans')">계좌이체</button>
							<button id="vbank" onclick="paymethod('vbank')">무통장입금</button>
							<button id="phone" onclick="paymethod('phone')">핸드폰결제</button>
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
						<button style="background-color:#d9f5ff;" class="form-control py-4" onclick="payment()">결제하기</button>
					</div>
				</div>
			</div>
			
			
		</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>	
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>	
	<script src="/KYJ_JSPWEB_study/js/orderpay.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>
</body>
</html>