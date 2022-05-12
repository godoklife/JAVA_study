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
			<div class = "col-md-6"> <img src = "img/testcat.jpg" width="100%"></div>
			<div class = "col-md-6"> <video controls src="img/testcatmp4.mp4" width= "100%"></video>
			</div>
		</div>	
	</div>	

	<!--  푸터 영역 -->
	<%@include file="footer.jsp" %>
</body>
</html>