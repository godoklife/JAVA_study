<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="1_설치.jsp" %>
	
	<form>
		<label> 이름 </label>
		<input type = "text" placeholder = "이름">
		<label> 이메일 </label>		
		<input type = "text" placeholder="이메일">
		<button type = "submit"> 확인 </button>
	</form>
	<br><br><br>

	<form >		<!--  부트스트랩 사용 : form-group -->
		<div class ="form-group">		<!--  컨트롤 묶음 : form-group -->
		<label> 이름 </label>
		<input type = "text" placeholder = "이름">
		</div>
		<div class ="form-group">
		<label> 이메일 </label>		
		<input type = "text" placeholder="이메일">
		</div>
		<div class ="form-group">
		<button type = "submit"> 확인 </button>
		</div>
	</form>
	<br><br><br>

	<!--  부트스트랩 사용 : form-control -->
	<input type = "text" class = "form-control">
	<input type = "password" class = "form-control">
	<input type = "datetime-local" class = "form-control">
	<textarea rows="5" cols="20" class = "form-control"></textarea>
	
	<div class = "form-check">
		<input type = "checkbox" class = "form-check-input">		<!--  딱히 기본 기능하고 다른건 없음. 약~~간 더 이쁜 정도. -->
	</div>
	<div class = "form-check">
		<input type = "radio" class = "form-check-input">
	</div>
	
	<br><br><br>

	<div class = "container row">	<!--  클래스명1 스페이스바 클래스명2 스페이스바 클래스명3 이런식으로 동시에 사용 가능. -->
		<div class = "col-md-2"> <input type = "text" class="form-control"></div>		
		<div class = "col-md-2 offset-3"> <input type = "text" class="form-control"></div>		
		<div class = "col-md-2 offset-3"> <input type = "text" class="form-control"></div>		
	</div>
	
	<br><br><br>
	
	
	<button type = "button"> 버튼 </button>	
	<button type = "button" class = "btn btn-primary"> 버튼 </button>	
	<button type = "button" class = "btn btn-secondary"> 버튼 </button>	
	<button type = "button" class = "btn btn-info"> 버튼 </button>	
	<button type = "button" class = "btn btn-success"> 버튼 </button>	
	
	<div class = "container">
		<div class = "row">
			<div class = "col-md-3"> <img alt = "" src = "../cat.jpg" width = "100%"> </div>
			<div class = "col-md-3"> <img alt = "" src = "../cat.jpg" width = "100%" class = "rounded"> </div>				<!--  모서리 둥글게 -->
			<div class = "col-md-3"> <img alt = "" src = "../cat.jpg" width = "100%" style="border-radius: 30px"> </div>	<!--  모서리 둥글게는 그냥 CSS 쓰자. -->
			<div class = "col-md-3"> <img alt = "" src = "../cat.jpg" width = "100%"> </div>
			<div class = "col-md-3"> <img alt = "" src = "../cat.jpg" width = "100%"> </div>
		</div>
	</div>
	
	
	
	
</body>
</html>