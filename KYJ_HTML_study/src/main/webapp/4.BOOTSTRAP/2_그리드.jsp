
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

	<%@include file = "1_��ġ.jsp" %>
	
	<!-- �ڽ��� : container -->
	<!--  �׸��� : �ڽ��� �� ���� 12��� ��.(������) -->
	
	<div class = "container"> <!--  �ڽ��� ���� -->
		<div class = "row">	<!--  ���� ��ġ -->
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
		
		<div class = "row"> <!--  row ���ι�ġ -->
			<div class = "col-md-8"> .col-md-8</div>
			<div class = "col-md-4"> .col-md-4</div>
		</div>
		
		<div class = "row"> <!--  row ���ι�ġ -->
			<div class = "col-md-4"> .col-md-4</div>
			<div class = "col-md-4"> .col-md-4</div>
			<div class = "col-md-4"> .col-md-4</div>
		</div>
		
		<div class = "row"> <!--  row ���ι�ġ -->
			<div class = "col-md-6"> .col-md-6</div>
			<div class = "col-md-6"> .col-md-6</div>
		</div>
		
		<div class = "container">
			<div class = "row">
				<div class = "col-md-8">
					<div class = "row">
						<div class = "col-md-4">
							�ܺ� 8 �׸��� �߿��� 4 �׸��� ���.
						</div>
						<div class = "col-md-8">
							�ܺ� 8 �׸��� �߿��� 8 �׸��� ���.
						</div>
					</div>
				</div>
				
				<div class = "col-md-4">
						<div class = "row">
							<div class = "col-md-6">
								�ܺ� 4 �׸��� �� 6 �׸��� ���.
							</div>
							<div class = "col-md-6">
								�ܺ� 4 �׸��� �� 6 �׸��� ���.
							</div>
						</div>
					</div>
					
			</div>
		</div>
			
		<div class = "container">
			<div class = "row">
				<div class = "col-md-5"> col-md-5</div>
				<div class = "col-md-5 offset-md-2"> col-md-5</div>		<!-- offset-md-2 : 2ĭ�� �� ĭ���� ���ʿ� ä���ش�.-->
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