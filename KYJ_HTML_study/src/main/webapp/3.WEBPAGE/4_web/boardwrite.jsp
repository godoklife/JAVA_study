<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "header.jsp" %>
	<br><br><br><br><br>

	<div class="container">	<!--  ���� ���� -->
		<h3 class="text-center board"> ���� �� �ۼ��ϱ�</h3>
		<div class="titleline">
			���� �� �ۼ��ϱ�
		</div>
		<form action="#" method="get">	<!--  form ��� : [ �Է¹��� ���� action���� ���� �� �� �ִ�. ]  -->
			<div class="row">
				<div class="col-md-3">
					�ۼ��� : <input class="form-control" type="text" placeholder="�ۼ���" maxlength="10">
				</div>
				<div class="col-md-3">
					��й�ȣ : <input class="form-control" type="password" placeholder="�Խñ��� ��й�ȣ" maxlength="4">
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					���� : <input class="form-control" type="text" placeholder="���� ������ �ۼ����ּ���." maxlength="50">
				</div>
			</div>
			���� : <textarea class="form-control" rows="20" cols="" placeholder="���� ������ �ۼ��ϼ���."></textarea>
			
			<div class="row">
				<div class="col-md-3">
					÷������ : <input class="form-control" type="file">	<!--  ÷������ �Է� ���� -->
				</div>
			</div>
			<div class="row col-md-4 offset-4">
				<div class="col-md-4">
				<input class="form-control" type="submit" value="���">	<!--  �� ���� ��ư ->> action���� ����. -->
				</div>
				<div class="col-md-4">
				<input class="form-control" type="reset" value="�ٽ� ����">
				</div>
				<div class="col-md-4">
				<a href="#"><button>��Ϻ���</button></a> 
				</div>
			</div>
		</form>
	</div>


	<br><br><br><br><br>
	<%@include file = "footer.jsp" %>
</body>
</html>