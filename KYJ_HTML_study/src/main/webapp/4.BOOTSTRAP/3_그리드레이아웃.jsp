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
	<!--  ��Ʈ��Ʈ�� ��ġ�ϱ� �������� ����Ʈ �ϱ�. -->
	<%@include file = "1_��ġ.jsp" %>
	
	<div class = "container">
		<div class = "row">
			<div class = "col-md-2">
				<ul>
					<li> �̴��̸�1 </li>
					<li> �̴��̸�2 </li>
					<li> �̴��̸�3 </li>
					<li> �̴��̸�4 </li>
				</ul>
			</div>
			<div class = col-md-8>
				<div class = "row">
					<div class = "col-md-5 offset-2"> �̴��̸� ������2</div>
					<div class = "col-md-5"> �̴��̸� </div>
				</div>
			</div>
			
		</div>
	</div>

</body>
</html>