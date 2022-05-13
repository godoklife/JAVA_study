<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/KYJ_JSPWEB_study/css/productadd.css" rel="stylesheet">

</head>
<body>
	
	<h3 class="admin_title">제품 등록 페이지</h3>
	<div class = "row">
		<form id="addform" class="col-md-6">
			<div class="row">
				<div class="col-md-2">
					<span>제품명</span>
				</div>
				<div class="col-md-5">
					<input class="form-control" type = "text" id="pname" name = "pname" placeholder="제품명">
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<span>가격</span>
				</div>
				<div class="col-md-5">
					<input class="form-control" type = "text" id="pprice" name = "pprice" placeholder="가격">
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<span>할인율</span>
				</div>
				<div class="col-md-5">
					<input class="form-control" type = "text" id="pdiscount" name = "pdiscount" placeholder="할인율">
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<span>카테고리</span>
				</div>
				<div class="col-md-5">
					<button class="form-control" onclick="categorybtn()" type="button">카테고리 추가</button>
				</div>
			</div>
			<div id="categoryinput">
				<!-- js로 호출되는 구역 -->
			</div>		
			<div id="categorybox">
				<!--  DB에 저장도니 카테고리 만큼만 표기 [DB -> 서블릿 -> JS -> HTML] -->
				<!--  js로 호출되는 구역, DB내 카테고리 만큼 레디오 버튼 생성, 출력 -->
			</div>
			대표이미지 : <input type = "file" id="pimg" name = "pimg" placeholder=""><br>
			<button class="form-control" type="button" onclick="productadd()">추가</button>
			<!-- <input type="reset" value="초기화">  -->
		</form>
		<div class="col-md-6">
			<h5>이미지 미리보기</h5>
			<img id="preview">
		</div>
	</div>
		
	
<!-- 사용자 정의 js 호출 -->	
<script src="/KYJ_JSPWEB_study/js/admin/productadd.js" type="text/javascript"></script>

</body>
</html>