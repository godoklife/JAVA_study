<%@page import="dto.Orderdetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
		#chartdiv1, #chartdiv2, #chartdiv3 {
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
			
			
			<%
				ArrayList<Orderdetail> list =  ProductDao.instance.getorderdetail();
			%>
			<table class="table">
				<tr>
					<th> 주문상세번호 </th>
					<th> 주문수량</th>
					<th> 주문가격 </th>
					<th> 주문번호</th>
					<th> 재고번호</th>
				</tr>
				<%
					for(Orderdetail orderdetail : list) {
						
				%>
					<tr onclick="getchart2(<%=orderdetail.getSno()%>)">
						<td><%=orderdetail.getOrderdetailno()%></td>
						<td><%=orderdetail.getSamount()%></td>
						<td><%=orderdetail.getTotalprice()%></td>
						<td><%=orderdetail.getOrderno()%></td>
						<td><%=orderdetail.getSno()%></td>
					</tr>				
				<%
					}
				%>
			</table>
			</div>
			
			<div class="col-sm-6">	<!--  카테고리별 차트 -->
				<div id="chartdiv2">	<!--  pie형 차트->> amChart API 사용 -->
		
				</div>
			</div>
			<div>
				<div id="chartdiv3"></div>
			</div>
		</div>
		
	</div>
<script src="/KYJ_JSPWEB_study/js/admin/productsales.js" type="text/javascript"></script>	
</body>
</html>