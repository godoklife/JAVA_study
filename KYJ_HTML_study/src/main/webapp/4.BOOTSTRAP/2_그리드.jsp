
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		*{border: solid 1px red;}
	
	</style>

</head>
<body>

	<%@include file = "1_설치.jsp" %>
	
	<!-- 박스권 : container -->
	<!--  그리드 : 박스권 내 열을 12등분 함.(반응형) -->
	
	<div class = "container"> <!--  박스권 형성 -->
		<div class = "row">	<!--  가로 배치 -->
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
			<div class = "col-md-1"> .col-md-1</div>
		</div>
		
		<div class = "row"> <!--  row 가로배치 -->
			<div class = "col-md-8"> .col-md-8</div>
			<div class = "col-md-4"> .col-md-4</div>
		</div>
		
		<div class = "row"> <!--  row 가로배치 -->
			<div class = "col-md-4"> .col-md-4</div>
			<div class = "col-md-4"> .col-md-4</div>
			<div class = "col-md-4"> .col-md-4</div>
		</div>
		
		<div class = "row"> <!--  row 가로배치 -->
			<div class = "col-md-6"> .col-md-6</div>
			<div class = "col-md-6"> .col-md-6</div>
		</div>
		
		<div class = "container">
			<div class = "row">
				<div class = "col-md-8">
					<div class = "row">
						<div class = "col-md-4">
							외부 8 그리드 중에서 4 그리드 사용.
						</div>
						<div class = "col-md-8">
							외부 8 그리드 중에서 8 그리드 사용.
						</div>
					</div>
				</div>
				
				<div class = "col-md-4">
						<div class = "row">
							<div class = "col-md-6">
								외부 4 그리드 내 6 그리드 사용.
							</div>
							<div class = "col-md-6">
								외부 4 그리드 내 6 그리드 사용.
							</div>
						</div>
					</div>
					
			</div>
		</div>
			
		<div class = "container">
			<div class = "row">
				<div class = "col-md-5"> col-md-5</div>
				<div class = "col-md-5 offset-md-2"> col-md-5</div>		<!-- offset-md-2 : 2칸을 빈 칸으로 왼쪽에 채워준다.-->
			</div>
			<div class = "row">
				<div class = "col-md-7 offset-md-1"> col-md-7</div>
			</div>
		</div>
		
		<div class = "container">
			<div class = "row">
				<div class = "col-md-5"> col-md-5</div>
				<div class = "col-md-8"> col-md-8</div>
				
			</div>
		</div>
			
	</div>

</body>
</html>