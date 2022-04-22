<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

	<!--  ��Ʈ��Ʈ�� CSS �κ� -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	
	<!--  ����ڰ� ������ CSS �κ� -->
	<link href="css/main.css" rel = "stylesheet">
	
	<!--  ��Ʈ��� ������ -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>
	<div class = "fixed-top bg-white">
		<div class = "container" >	<!--  �ڽ��� ���� : ��Ʈ��Ʈ�� Ŭ���� -->
		<div class = py-3>
			<!--  p : padding ->> ���� ����	py : ���� ���Ʒ� ���� ���� -->
			<!--  m : margin ->> �ٱ��� ����	my : �ٱ��� ���Ʒ� ���� ���� -->
				<div class = "row"> <!--  ��� �Ŵ� ����� -->
					<div class = "col-md-4 offset-4 text-center"> <!--  12�׸��� �� 4�׸��� ���, 4�׸���� [���ʿ�] �������� ����.  -->
						<a href = "main.jsp" class = "header_logo"> Cirruslogic</a>
					</div>
					<div class = "col-md-4 d-flex justify-content-end" >
						<ul class = "nav"> <!--  nav : ����Ʈ�� �۸Ӹ� ����, ���ι�ġ. -->
							<li><a href = "http://www.naver.com" >�α���</a> | </li>
							<li><a href = "">ȸ������</a> | </li>
							<li><a href = "">��ٱ���</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class = "navbar navbar-expand-md navbar-light bg-white">	<!--  ���� �Ŵ� -->
			
				<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navcl">
					<span class = "navbar-toggler-icon"></span>
				</button>
				
				<div class = "collapse navbar-collapse" id="navcl">
					<ul class= "navbar-nav col-md-12 justify-content-between">	<!--  justify-content-between : �׸��� �߿��� ���� �˾Ƽ� ��ġ -->
						<li class="nav-item"> <a href = "#">����Ʈ�� </a></li>
						<li class="nav-item"> <a href = "#">�º� </a></li>
						<li class="nav-item"> <a href = "#">��Ʈ�� </a></li>
						<li class="nav-item"> <a href = "#">����Ʈ��ġ </a></li>
						<li class="nav-item"> <a href = "#">TWS </a></li>
						<li class="nav-item"> <a href = "#">�������͸� </a></li>
						<li class="nav-item"> <a href = "#">��Ÿ �Ǽ����� </a></li>
						<li class="nav-item"> <a href = "#">���� </a></li>
						<li class="nav-item"> <a href = "#">������ </a></li>
						<li class="nav-item"> <a href = "#"> <i class = "fas fa-search"></i> </a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<!--  ��Ʈ��Ʈ�� js �κ� -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>