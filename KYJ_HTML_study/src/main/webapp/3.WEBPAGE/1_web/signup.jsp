<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		#contents{
			width : 1150px;
			margin : 0 auto;
		}		
		h3{ text-align : center; }
		li{ list-style-type : none;} /* �۸Ӹ� ���� */
		#mastercols{
			width : 600px;
			
		}
		
		#join{
			width : 600px;	/* ���� ������ ��� ������ �ȵ�. */
			margin : 0 auto;	/* ��� ���� */
			border-top : solid 2px red;
			border-bottom : solid 2px red;
			padding : 30px;
		}
		.cols{ padding : 5px; }
		.cols li{display : inline-block;}
		.col1{ width : 150px;}
		.col2 input, select {
			width : 200px;
			height : 30px;
		}
		.email input{
			width : 100px;
			height : 30px;	
		}		
		.hello{	/* col1 hello */
			vertical-align : top;	/* �ؽ�Ʈ ���� ����, ���ڰ� �������� �ö�. */
		}
	
		
		#btn{
			width : 600px;
			margin : 0 auto;
			text-align : right;
		}
		#button input{
			padding : 10px 20px;
			margin-top : 20px;
		}
		
	
	</style>

</head>
<body>
	<%@include file = "header.jsp" %>
	<%@include file = "mainimage.jsp" %>

	<!--  ���� -->
	<div id = "contents">
		<h3> ȸ�� ���� �� </h3>
		<form id="join">
	
		<ul class=mastercols>
			<ul class="cols">
				<li class = "col1">���̵�</li>
				<li class = "col2"><input type = "text"></li>
			</ul>
			<ul class="cols">
				<li class = "col1">��й�ȣ</li>	
				<li class = "col2"><input type = "password"> </li>
			</ul>
			<ul class="cols">
				<li class = "col1">��й�ȣ Ȯ��</li>	
				<li class = "col2"><input type = "password"> </li>
			</ul>
			<ul  class="cols">
				<li class = "col1">�̸�</li>
				<li class = "col2"><input type = "text"></li>
			</ul>
			<ul class="cols">	
				<li class = "col1">�̸���</li>
				<li class = "email input"><input type = "text">@
				<select class = "col2">
					<option> �����Է� </option>
					<option> naver.com </option>
					<option> nate.com </option>
				</select></li>
			</ul>
			<ul class="cols">
				<li class = "col1"> �̸��� ����</li>
				<li>
					<input type = "radio" name = "mailReceive">	�����
					<input type = "radio" name = "mailReceive"> ����
				</li>
			</ul>
			<ul class="cols">
				<li class = "col1"> ���� ���</li>
				<li> 
					<input type = "checkbox" name = "friendRecomend"> ģ����õ
					<input type = "checkbox" name = "searchingInternet"> ���ͳݰ˻�
					<input type = "checkbox" name = "etc"> ��Ÿ
				</li>	
		 	</ul>
		 	<ul class="cols">
		 		<li class = "col1 hello"> �λ縻 </li>
		 		<li>
		 			<textarea rows="5" cols="40"></textarea>
		 		</li>
		 	</ul>
		</ul>
		
		<div id = "btn">
			<input type="submit" value="�����ϱ�">
			<input type="reset" value="����ϱ�">		
		</div>
	</form>
	</div>

	<%@include file = "footer.jsp" %>
</body>
</html>