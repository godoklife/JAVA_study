<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<br><br><br><br><br>
	
	<div class="container">
		<h3 class="text-center titleline"> ���� �� </h3>
		
		<!--  ��ư ��ġ�� -->
		<div>
			<a href="boardlist.jsp"> <button class="btn btn-outlise-info">��Ϻ���</button>  </a>
			<a href="boardlist.jsp"> <button class="btn btn-outlise-info">����</button> </a>	<!--  �ۼ��� ����. [ ��ȿ�� �˻� �ʿ� ] -->
			<a href="boardlist.jsp"> <button class="btn btn-outlise-info">����</button> </a>	<!--  �ۼ��� ����. [ ��ȿ�� �˻� �ʿ� ] -->
			<a href="boardlist.jsp"> <button class="btn btn-outlise-info">�亯</button> </a>	<!--  ������ ����. [ ��ȿ�� �˻� �ʿ� ] -->
		</div>		
		<!--  �ۼ��� �Է��� ���� -->
		<div>	<!-- div �ڽ��� �⺻�� : display : block, span �ڽ��� �⺻�� : display : inline -->
			<div><span>�ۼ���</span> <span>���缮</span></div>
			<div><span>�ۼ�����</span> <span>2022-04-25</span></div>
		</div>
		<div>
			<input type = "text" value="ȯ�� ��û�� ��" class="form-control" readonly>
		</div>
		<div>
			<textarea rows="20" cols="" class="form-control" style="resize:none;" readonly> �̴��̸��̴��̸�</textarea>
			<!--  readonly="readonly" ->> �б� ����, ���� �Ұ�. ->> �׳� readonly��� ��� ��. -->
		</div>
		
		<div class="row my-4">
			<h4> ÷�� ���� </h4>
			<div class="col-md-3">
				<img alt="" src="img/p1.jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/p2.jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/p3.jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="img/p4.jpg" width="100%">
			</div>
		</div>
		<!--  �����ڰ� �亯�� ���� -->
		<h4> �亯 </h4>
		<p> �亯�� : </p>
		<div>
			<span>������ �亯 �ۼ��� - </span>
			<textarea rows="" cols="" class="form-control"  style="resize:none;" ></textarea>
		</div>
		
	</div>
	
	
	<br><br><br><br><br>
	<%@include file="footer.jsp" %>
</body>
</html>