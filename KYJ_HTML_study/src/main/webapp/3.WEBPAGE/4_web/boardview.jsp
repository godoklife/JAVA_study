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
			<span>�ۼ���</span> <span>���缮</span>
		</div>
		<div>
			<span> ���� </span> <span></span>
		</div>
		<div>
			<textarea rows="20" cols="" class="form-control" style="resize:none;" readonly> �̴��̸��̴��̸�</textarea>
			<!--  readonly="readonly" ->> �б� ����, ���� �Ұ�. ->> �׳� readonly��� ��� ��. -->
		</div>
		<!--  �����ڰ� �亯�� ���� -->
		<div>
			<span>������ �亯 �ۼ��� - </span>
			<textarea rows="" cols="" class="form-control"  style="resize:none;" ></textarea>
		</div>
		
	</div>
	
	
	<br><br><br><br><br>
	<%@include file="footer.jsp" %>
</body>
</html>