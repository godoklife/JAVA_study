<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고___장</title>
	<style type="text/css">
		*{
			margin:0;
			padding:0;
		}
		#error{
			background-image: "img/robot.png";
			margin : 7% auto;
			text-align: center;
			
		}
	</style>
	
	<!--  부트스트랩 CSS CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
		<%	String ipAddress=request.getRemoteAddr();
			if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
			    InetAddress inetAddress=InetAddress.getLocalHost();
			    ipAddress=inetAddress.getHostAddress();
			}
			session.setAttribute("ip", ipAddress);
			System.out.println("main.jsp 클라이언트IP 주소: "+ipAddress); 
			LocalDateTime ldt = LocalDateTime.now();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분 ss초");
//			String nowtime = sdf.format(ldt);
			
		%>

<!-- 
	<div class="container">
		<div class="row">
			<div class="col-md-3 offset-6">
				고장났읍니다.
			</div>
			<div class="col-md-3">
				<img src="img/robot.png">
			</div>
		</div>
	</div>
 -->
	<div id="error">
	<%
		if(Integer.parseInt(request.getParameter("err"))==1){
	%>		
		<span style="color:red;font-size:20px;">정상적인 방법으로 관리자 페이지에 접속하세요.</span><br>
	<%}else{ %>
		고장나쓰요<br>
	<%} %>
		접속 아이피 : <%=ipAddress%><br>
		실행시간 : <%=ldt%><br>
	</div>

</body>
</html>