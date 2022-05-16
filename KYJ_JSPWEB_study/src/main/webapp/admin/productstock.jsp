<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>재품 재고 현황</h3>
	제품 목록
	<select id="categorybox">
		<!--  제품 목록이 출력되는 부분 -->
	</select>
	<select id="productbox">
		<!--  제품명이 줄력되는 부분 -->
	</select>
	
	<form id="stockaddform" style="display:none;">
		색상	<input id="scolor" type="text" class="form-control">
		사이즈<input id="ssize" type="text" class="form-control">
		수량	<input id="samount" type="text" class="form-control">
		<button type="button" onclick="stockadd()">재고 추가</button>
	</form>
	
	<table class="table table-hover">
		<tr>
			<th>색상</th><th>용량</th><th>수량</th><th>비고</th>
		</tr>
		<tr id="stocklistbox">
			<!-- 제고리스트가 getstock.java에 의해 출력 -->
		</tr>
	</table>
	
	<script src="/KYJ_JSPWEB_study/js/admin/productstock.js" type="text/javascript"></script>
</body>
</html>