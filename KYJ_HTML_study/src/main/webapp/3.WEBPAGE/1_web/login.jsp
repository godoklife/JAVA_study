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
		table{
			margin : 0 auto;
		}
		form{
			width : 500px;
			margin : 0 auto;
			font-size : 12px;
		}
		#btn{
			height : 50px;
			width : 70px;
			font-size : 10px;
		}
		.txt{
			width : 100px
		}
	
	</style>

</head>
<body>
	<%@include file = "header.jsp" %>
	<%@include file = "mainimage.jsp" %>

	<!--  본문 -->
	<div id = "contents">
		<form>
			<table>
				<tr>
					<th colspan=3><h3> 로그인 </h3></th>
				<tr>
				<td>아이디</td> <td><input type="text" class="txt"></td><td rowspan=2><input type="submit" value="로그인" id="btn"></td>
				</tr>
				<tr>
				<td>비밀번호</td><td><input type = "password" class="txt"></td>
			</tr>
		</table>
	</form>
	</div>

	<%@include file = "footer.jsp" %>
</body>
</html>