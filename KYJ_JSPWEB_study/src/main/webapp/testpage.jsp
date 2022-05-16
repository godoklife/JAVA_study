<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  부트스트랩 CSS CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<%for(int i=1; i<=5; i++) {%>
				<%if(i==1 || i==5) {%>
				<%for(int j=1; j<=6; j++){%>
					<div class="col-md-2">말판</div>
				<%}} %>	
				<%if(i!=5){ %>
				<div class="col-md-2">말판</div>
				<div class="col-md-2 offset-8">말판</div>
			<%}} %>
		</div>
	</div>
</body>
</html>