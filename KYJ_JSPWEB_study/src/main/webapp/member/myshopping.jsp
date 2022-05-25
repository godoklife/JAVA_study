<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/KYJ_JSPWEB_study/css/myshopping.css" rel="stylesheet">

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
					
							<!--  주문 상세 -->
							
				</div>
			</div>
		</div>
	</div>		
	
	
	<!-- bootstrap modal 작성 구역 -->
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#cancelmodal">
</button>

<!-- Modal -->
	<div class="modal fade" id="cancelmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	주문 취소 요청 사유 
	        <textarea id="cancelreason" rows="" cols="" class="form-control"></textarea>
	      </div>
	      <div class="modal-footer">
	        <button id="modalclose" type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button type="button" onclick="cancel()" class="btn btn-primary">주문 취소 요청</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<script type="text/javascript" src="/KYJ_JSPWEB_study/js/myshopping.js"></script>
	<%@include file =  "../footer.jsp" %>
</body>
</html>