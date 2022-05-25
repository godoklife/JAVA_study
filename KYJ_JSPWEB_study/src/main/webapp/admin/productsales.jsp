<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
		#chartdiv1, #chartdiv2 {
		  width: 100%;
		  height: 500px;
		}
	</style>

</head>
<body>
	<h3> 매출 관리 페이지 </h3>
	
	<div class="container">
		<div id="chartdiv1">	<!--  일 매출 차트->> amChart API 사용 -->
		
		</div>
		
		<div class="row">
			<div class="col-sm-6">	<!--  일 매출 테이블 -->
			
			</div>
			
			<div class="col-sm-6">	<!--  카테고리별 차트 -->
				<div id="chartdiv2">	<!--  pie형 차트->> amChart API 사용 -->
		
				</div>
			</div>
		</div>
		
	</div>
<script src="/KYJ_JSPWEB_study/js/admin/productsales.js" type="text/javascript"></script>	
</body>
</html>