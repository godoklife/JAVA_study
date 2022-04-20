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
			text-align: center;
		}
		#searchbtn{
			background-color: #555555;
			color : white;
			width : 100px;
			height : 45px;
			margin-left : -7px;
			border-style: none;
		}
		#searchtxt{
			width : 400px;
			height : 40px;
			border : dotted 1px gray;
		}
		form{
			width : 1100px;
			margin : 0 auto;
			padding : 10px;
			background-color: #f9f7f9;
			text-align: center;
		}
		table{
			text-align : center;
			width : 1100px;
			margin : 0 auto;
			font-size: 15px;
			font-weight: bold;
		}
		table td{
			border-bottom: dotted 1px gray;
			padding : 10px 0;
		}
		table th{
			border-bottom: dotted 1px gray;
			border-top: dotted 1px gray;
			padding : 10px 0;
		}
		.title{
			text-align: left;
			padding-left : 30px;
		}
	</style>
</head>
<body>
	
	<%@include file = "header.jsp" %>
	<%@include file = "mainimage.jsp" %>
	
		<!--  콘텐츠 영역 -->
	<div id = "contents">
		<h3> 공지 사항 </h3>
		<div id = "boardbody">
			<form>
				<input type = "text" contextmenu="검색어를 입력해주세요." id = "searchtxt">
				<input type="submit" value = "검색" id = "searchbtn">
			</form>
			<table>
				<tr>
					<th>번호</th><th>제목</th><th>등록일</th>
				</tr>
				<tr>
					<td>3</td><td class="title">[공지사항] 개인정보 처리방침 변경안내처리방침</td><td>2017.07.13</td>
				</tr>
				<tr>
					<td>3</td><td class="title">[공지사항] 개인정보 처리방침 변경안내처리방침</td><td>2017.07.13</td>
				</tr>
				<tr>
					<td>3</td><td class="title">[공지사항] 개인정보 처리방침 변경안내처리방침</td><td>2017.07.13</td>
				</tr>
				
				
			</table>
		</div>	
	</div>	
	
	<%@include file = "footer.jsp" %>

</body>
</html>