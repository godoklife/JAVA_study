<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


</head>
<body>
	<!--  해더 영역 -->
	<%@include file="header.jsp" %>
	<%
		String ipAddress=request.getRemoteAddr();
		if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
		    InetAddress inetAddress=InetAddress.getLocalHost();
		    ipAddress=inetAddress.getHostAddress();
		}
		session.setAttribute("ip", ipAddress);
		System.out.println("main.jsp 클라이언트IP 주소: "+ipAddress);
	 
	%>
	<!--  메인 영역 -->
	<div class = "container">
		<div class = "row">
			<div id="mainslide" class="carousel slide" data-bs-ride="carousel" data-bs-interbal="3000">	<!--  캐러셀 영역 -->
			<div class="carousel-indicators">
			    <button type="button" data-bs-target="#mainslide" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
			    <button type="button" data-bs-target="#mainslide" data-bs-slide-to="1" aria-label="Slide 2"></button>
			    <button type="button" data-bs-target="#mainslide" data-bs-slide-to="2" aria-label="Slide 3"></button>
			    <button type="button" data-bs-target="#mainslide" data-bs-slide-to="3" aria-label="Slide 4"></button>
		  	</div>
				<div class="carousel-inner"><!--  캐러셀 이미지 영역 -->
					<div class="carousel-item active">
						<img src="img/productimg/apple/general/iphone-13-blue-select-2021.png">
					</div>
					<div class="carousel-item">
						<img src="img/productimg/apple/general/iphone-13-green-select.png">
					</div>
					<div class="carousel-item">
						<img src="img/productimg/apple/general/iphone-13-midnight-select-2021.png">
					</div>
					<div class="carousel-item">
						<img src="img/productimg/apple/general/iphone-13-pink-select-2021.png">
					</div>
				</div>
				<!-- 이전(왼쪽)버튼 -->
				<button class="carousel-control-prev" type="button" data-bs-target="#mainslide" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>
				<!-- 다음(오른쪽)버튼 -->
				<button class="carousel-control-next" type="button" data-bs-target="#mainslide" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
				
			</div>
			<div class="row adbox">	<!--  광고 영역 -->
				<div class="col-md-6">	<!--  traning -->
					<img src="img/productimg/xiaomi/redmi_k50_pro/allcolor.png" width=100%>
				</div>
				<div class="col-md-6">	<!-- 1+n -->
					<img src="img/productimg/xiaomi/redmi_k50_pro/allcolor.png" width=100%>
				</div>
				
			</div>
			<div class="main_box">	<!--  BEST -->
				<h6 class="main_title"> BEST SELLING</h6>
				<div class="row">
					<div class="col-md-3 best_box">
						<img src="img/productimg/xiaomi/12/black.png">
					</div>
					<div class="col-md-3 best_box">
						<img src="img/productimg/xiaomi/12/blue.png">
					</div>
					<div class="col-md-3 best_box">
						<img src="img/productimg/xiaomi/12/green.png">
					</div>
					<div class="col-md-3 best_box">
						<img src="img/productimg/xiaomi/12/pink.png">
					</div>
				</div>
			</div>
			<div class="main_box">	<!--  신상품 -->
				<h6 class="main_title"> NEW ARRIVAL</h6>
				<div class="row">
					<%
						// 천 단위 쉼표 -> 형식 클래스
						DecimalFormat df = new DecimalFormat("###,###,### 원");
						ArrayList<Product>list = ProductDao.instance.getproductlist();
						for(Product tmplist : list){
					%>
					<div class="col-md-4 best_box">
						<!--  제품 이미지 클릭시 pno를 가지고 상세페이지로 이동. -->
						<div class="imgbox">
							<a href="product/productview.jsp?pno=<%=tmplist.getPno()%>">
								<img src="img/<%=tmplist.getPimg()%>">
							</a>
						</div>
						<div class="p_item">
							<div class="p_title"> <%=tmplist.getPname()%> </div>
							<!--  제품별 모든 사이즈 가져오기 -->
							<%
								ArrayList<Stock>stocklist = ProductDao.instance.getStock(tmplist.getPno());
								Set<String> sizelist = new TreeSet<>();
								for(Stock tmpstock : stocklist){
									sizelist.add(tmpstock.getSsize());
								}
							%>
							
							<div class="p_size">
							<%for(String tmp : sizelist){	// 해당 사이즈 목록 표시%>
								<%=tmp+" " %>
									
							<%	}%>
							
								
							</div>
							<div class="row">
							<% if(tmplist.getPdiscount()==0){	// 만약 할인이 없으면%>
							<div class="p_discountprice col-md-7">  <%=tmplist.getPprice()%></div>
							<div class="p_review col-md-5"> 리뷰 : 고정값 건 </div>
							<%}else{ 	// 할인이 있으면%>
								<%
								float discountprice= tmplist.getPprice()*tmplist.getPdiscount();// 할인이 있으면%>
							<div class="p_originalprice"> <%=df.format(tmplist.getPprice())%></div>
							<div class="p_discountprice col-md-7"> <%=df.format(discountprice)%></div>
							<div class="p_review col-md-5"> 리뷰 : 고정값 건 </div>
							<%} %>
							</div>
						</div>
					</div>
					<%} %>
				</div>
			</div>
			<div>	<!-- 실시간 구매 후기 -->
			
			</div>
		</div>	
	</div>	

	<!--  푸터 영역 -->
	<%@include file="footer.jsp" %>
</body>
</html>