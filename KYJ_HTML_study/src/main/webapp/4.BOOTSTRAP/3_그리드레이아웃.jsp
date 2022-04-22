<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
	
		*{border: solid 1px red; list-style-type: none;}
		
	</style>

</head>
<body>
	<!--  부트스트랩 설치하기 귀찮으니 임포트 하기. -->
	<%@include file = "1_설치.jsp" %>
	
	<div class = "container">
		<div class = "row">
			<div class = "col-md-2">
				<ul>
					<li> 미니이리1 </li>
					<li> 미니이리2 </li>
					<li> 미니이리3 </li>
					<li> 미니이리4 </li>
				</ul>
			</div>
			<div class = col-md-8>
				<div class = "row">
					<div class = "col-md-5 offset-2"> 미니이리 오프셋2</div>
					<div class = "col-md-5"> 미니이리 </div>
				</div>
			</div>
			
		</div>
	</div>

</body>
</html>