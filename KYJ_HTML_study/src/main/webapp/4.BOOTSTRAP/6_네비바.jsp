<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "1_��ġ.jsp" %>
	
	<div class = "container"> <!--  �ڽ��� -->
		<div class = "navbar navbar-expand-md navbar-light">	<!--  �׺���̼� �� , navbar-expand-md : �Ŵ�(���빰) ���η� ������ -->
		
			
		
			<!--  �޴� ����� �۾����� ��� -->
			<!-- �ٽ� Ŭ����, �Ӽ� : class = "navbar-toggler" data-bs-toggle = "collapse" data-bs-target = "#navmenu" -->
			<button class = "navbar-toggler" type = "button" data-bs-toggle = "collapse" data-bs-target = "#navmenu" aria-controls = "navbarcontents" 
				aria-expended = "false" aria-label = "Toggle navi"  > 	<!--  data-bs-target�� ������ id�� �ҷ��´�. -->
				
				<!--  �̴��̸� -->
				
				<span class = "navbar-toggler-icon"></span>
			</button>
			
		
			<div class = "collapse navbar-collapse" id = "navmenu">		<!-- collapse navbar-collapse : ��Ʈ��Ʈ������ ������ ��� �������� ���λ���� 760px ���Ϸ� �������� div�� �������.-->
				<a href = "#" class = "navbar-brand">LOGO</a>
				<ul class = "navbar-nav">	<!--  �۸Ӹ��� �� ����. -->
					<li class = "nav-item"> <a href = "#" class = "nav-link">�޴� 1 </a> </li>		<!--  nav-link : ��ũ ���� ���ֱ�(������ �� �ٲ� ��.��) -->
					<li class = "nav-item"> <a href = "#" class = "nav-link">�޴� 2 </a> </li>		
					<li class = "nav-item"> <a href = "#" class = "nav-link">�޴� 3 </a> </li>
					<li class = "nav-item dropdown">		<!--  ����ٿ� �޴� -->
						<!--  �ϴ� �ؽ�Ʈ�� Ŭ������ �� �޴� ��ġ�� -->
						<a href = "#" class = "nav-link" data-bs-toggle = "dropdown" aria-haspopup = "true" aria-expanded = "false" id = "navdrop">����ٿ�</a>	<!-- id���� ���� ���ϴ°�. -->
					
						<!--  
							nav-link : �����۸�ũ ���� (��������, ����, ����)
							dropdown-toggle : �Ʒ� ȭ��ǥ �߰�(����ٿ� �Ŵ���� ������ �߰�, �� ��� ����.)
							data-bs-toggle="dropdown" : ����ٿ� �Ŵ� �����̶�� ����
							
						-->
						
					
						<div class = "dropdown-menu" aria-labelledby = "navdrop"> 
							<!-- 
								dropdown-menu : ���� �������� �����ִ� ���·� ���(������ ������ ����� �� ��ó��ä�� ����.)
								dropdown-item : ��ü ����. �Ⱥٿ��ָ� ������ �������� �Ѱ��� ���������� ������ �ȵ�.
							 -->
							<a class = "dropdown-item" href = "#"> ����ٿ� �޴� 1 </a>
							<a class = "dropdown-item" href = "#"> ����ٿ� �޴� 2 </a>
							<a class = "dropdown-item" href = "#"> ����ٿ� �޴� 3 </a>
						</div>
					</li>
				</ul>	<!--  �׺���̼� ��� �� -->
				
				<form action = "">
					<div class = "row">
						<div class = "col-md-5">
							<input type = "text" class = "form-control" placeholder = "�˻���">
						</div>
						<div class = "col-md-5">
							<button class = "btn btn-info" type = "submit"> �˻� </button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	

</body>
</html>