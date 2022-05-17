<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/KYJ_JSPWEB_study/css/productview.css">
</head>
<body>
	<%@include file="../header.jsp"%>
	<%
		int pno=Integer.parseInt(request.getParameter("pno"));
		Product product = ProductDao.instance.getproduct(pno);
		boolean nodiscount=false;
		if (product.getPdiscount()==0)	nodiscount=true;
		ArrayList<Stock> stocks = ProductDao.instance.getStock(pno);
		Set<String> sizelist = new TreeSet<>();	// 사이즈 중복 제거  set컬렉션 선언
		for(Stock s : stocks){					// 사이즈 중복값 제거용
			sizelist.add(s.getSsize());
		}
		Set<String> colorlist = new TreeSet<>();	// 색상 중복 제거  set컬렉션 선언
		for(Stock c : stocks){					// 중복값 제거용
			colorlist.add(c.getScolor());
		}
		
		
		DecimalFormat df = new DecimalFormat("###,###,###,###원");
		int discountedprices= product.getPprice()-((int)((product.getPdiscount()*product.getPprice())));
		int discountprice = product.getPprice()-discountedprices;
			// 할인된 금액
		int point = (int)(discountedprices * 0.01);	// 적립금 : 할인된 금액의 0.01퍼
	%>
	<input type="hidden" id="pno" value="<%=pno%>" >
	<div class="container">
		<div class="row viewbox">
			<div class="row">
				<div class="col-md-6"> <!--  이미지 구역 -->
					<img src="../img/<%=product.getPimg()%>">
				</div>
				<div class="col-md-6">	<!--  상품의 정보 -->
					<div class="infobox">
						<h2 id="product_name"class="view_title"><%=product.getPname()%></h2>
						<div>
							<%if(nodiscount){ // 할인이 없을시 출력되는 내용 %>	
							<span class="price"><%=df.format(product.getPprice())%></span>
							<input type="hidden" id="pprice" value="<%=product.getPprice()%>">
							<%}else{ // 할인이 있을 시 출력되는 내용%>
							<span class="price_dis"><%=df.format(discountedprices)%></span>
							<span class="price"><%=df.format(product.getPprice())%></span>
							<span class="discount_ratio"><%=(int)(product.getPdiscount()*100)%>% 할인!</span>
							<input type="hidden" id="pprice" value="<%=discountedprices%>">
							<%} %>
						</div>
						<div>
							<span class="size_box"> 
								<% for(String s : sizelist){ %>
									<%=s+" " %>
								<% }%>
							</span>
						</div>
						<table class="table info_t">
							<tr>
								<td> 배송비 </td>
								<td> FREE </td>
							</tr>
							<tr>
								<td> SAVE </td>
								<td> 할인액: <%=discountprice%> 원 + 포인트: <%=point%> 점</td>
							</tr>
							<tr>
								<td> COLOR </td>
								<td> 
									<select id="color_select" class="form-select info_t">
										<option>-[필수]색상 선택-</option>
										<%for(String c : colorlist){ %>
											<option value="<%=c%>"><%=c%></option>
										<%} %>
									</select>
								</td>
							</tr>
							<tr>
								<td> 용량 </td>
								<td> 
									<select id="size_select" class="form-select info_t">
										<option value=''>-[필수]용량 선택-</option>
									</select>
								</td>
							</tr>
						</table>
						<table id="select_table"class="table my-5">
				<!-- 			<tr><th width="60%">상품명</th><th width="25%">상품수</th><th width="15%">가격</th></tr>	 -->
							
						</table>
						<div class="row">
							<div class="col-md-6"> 총 상품금액 </div>
							<div class="col-md-6 total_price"> 29,800 원</div>
						</div>
						<div class="row g-1">
							<div class="col-md-4"><button class="info_buy_btn">바로 구매하기</button></div>
							<div class="col-md-4"><button class="info_btn">장바구니 담기</button></div>
							<div class="col-md-4"><button class="info_btn">찜 하기</button></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/KYJ_JSPWEB_study/js/productview.js" type="text/javascript"></script>
	<%@include file="../footer.jsp"%>
</body>
</html>