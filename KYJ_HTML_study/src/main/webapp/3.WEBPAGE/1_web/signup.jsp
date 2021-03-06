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
		li{ list-style-type : none;} /* 글머리 제거 */
		#mastercols{
			width : 600px;
			
		}
		
		#join{
			width : 600px;	/* 폭이 없으면 가운데 정렬이 안됨. */
			margin : 0 auto;	/* 가운데 정렬 */
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
			vertical-align : top;	/* 텍스트 세로 정렬, 글자가 위쪽으로 올라감. */
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

	<!--  본문 -->
	<div id = "contents">
		<h3> 회원 가입 폼 </h3>
		<form id="join">
	
		<ul class=mastercols>
			<ul class="cols">
				<li class = "col1">아이디</li>
				<li class = "col2"><input type = "text"></li>
			</ul>
			<ul class="cols">
				<li class = "col1">비밀번호</li>	
				<li class = "col2"><input type = "password"> </li>
			</ul>
			<ul class="cols">
				<li class = "col1">비밀번호 확인</li>	
				<li class = "col2"><input type = "password"> </li>
			</ul>
			<ul  class="cols">
				<li class = "col1">이름</li>
				<li class = "col2"><input type = "text"></li>
			</ul>
			<ul class="cols">	
				<li class = "col1">이메일</li>
				<li class = "email input"><input type = "text">@
				<select class = "col2">
					<option> 직접입력 </option>
					<option> naver.com </option>
					<option> nate.com </option>
				</select></li>
			</ul>
			<ul class="cols">
				<li class = "col1"> 이메일 수신</li>
				<li>
					<input type = "radio" name = "mailReceive">	비수신
					<input type = "radio" name = "mailReceive"> 수신
				</li>
			</ul>
			<ul class="cols">
				<li class = "col1"> 가입 경로</li>
				<li> 
					<input type = "checkbox" name = "friendRecomend"> 친구추천
					<input type = "checkbox" name = "searchingInternet"> 인터넷검색
					<input type = "checkbox" name = "etc"> 기타
				</li>	
		 	</ul>
		 	<ul class="cols">
		 		<li class = "col1 hello"> 인사말 </li>
		 		<li>
		 			<textarea rows="5" cols="40"></textarea>
		 		</li>
		 	</ul>
		</ul>
		
		<div id = "btn">
			<input type="submit" value="저장하기">
			<input type="reset" value="취소하기">		
		</div>
	</form>
	</div>

	<%@include file = "footer.jsp" %>
</body>
</html>