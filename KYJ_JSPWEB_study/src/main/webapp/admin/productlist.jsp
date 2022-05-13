<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/KYJ_JSPWEB_study/css/productlist.css" rel="stylesheet">
</head>
<body>
	<h3>제품 목록 페이지</h3>
	<table class="table table-hover">
		<tr>
			<th>제품번호</th><th>대표이미지</th><th>제품명</th><th>가격</th><th>할인율</th><th>할인판매가</th>
			<th>제품판매상태</th><th>카테고리</th><th>색상</th><th>사이즈(용량)</th><th>재고량</th>
			<th>수정일</th><th>비고(버튼)</th>
		</tr>
		
		<%
			ArrayList<Product> products = ProductDao.instance.getproductlist();
			for(Product tmp : products){
		%>
			<tr>
			<th><%=tmp.getPno()%></th><th><div class="img"><div class="scale"><img src="/KYJ_JSPWEB_study/admin/img/<%=tmp.getPimg()%>"></div></div></th><th><%=tmp.getPname()%></th><th><%=tmp.getPprice()%></th><th><%=tmp.getPdiscount()%></th><th><%=(tmp.getPprice()*tmp.getPdiscount())%></th>
			<th><%=tmp.getPactive()%></th><th><%=tmp.getCno()%></th><th>X</th><th><%=tmp.getPno()%></th><th><%=tmp.getPno()%></th>
			<th><%=tmp.getPno()%></th>
			<th>
				<div class="row">
					<a href="#"><button data-bs-toggle="modal" data-bs-target="#activemodal">제품 삭제</button></a>
					<a href="#"><button>제품 수정</button></a>
					<a href="#"><button onclick="pnomove(<%=tmp.getPno()%>)"data-bs-toggle="modal" data-bs-target="#activemodal">상태 변경</button></a>
					<a href="#"><button>재고 변경</button></a>
				</div>
			</th>
			</tr>
		<%} %>
	</table>
	
	<button data-bs-toggle="modal" data-bs-target="#activemodal">모달버튼</button>
	
	<!-- 상태 변경 모달 구역 -->

<div class="modal fade" id="activemodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5><!-- 모달 제목 -->
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        스무-스 한 모달
        <input type="hidden" id="modalinput">
      </div>
      <div class="modal-footer">
     	<button type="button" class="btn btn-primary" onclick="activechange(0)">준비</button>
     	<button type="button" class="btn btn-primary" onclick="activechange(1)">판매</button>
     	<button type="button" class="btn btn-primary" onclick="activechange(2)">품절</button>
     	<button type="button" class="btn btn-primary" onclick="activechange(3)">중단</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>

<!--  이미지 출력 모달 -->
<div class="modal fade" id="imgmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">이미지 확대</h5><!-- 모달 제목 -->
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        이미지 위치
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
	<script src="/KYJ_JSPWEB_study/js/admin/productlist.js"type="text/javascript"></script>
</body>
</html>