<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E L E C   M A L L</title>
	<link href="/EXAM/css/board.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
	<div class = "container mt-5">
	<%if (session.getAttribute("id")==null || !(session.getAttribute("id").equals("cirrus"))) {%>
		<h3> 자신이 작성한 게시글만 읽을 수 있습니다.</h3>	
	<%} else if (session.getAttribute("id").equals("cirrus")){ %>

			<h2> 글 작성 페이지 </h2>
				<div id="top_buttonbox">
					<button>글 삭제</button>
					<button>글 수정</button>
					<a href="/EXAM/board/boardlist.jsp"><button>뒤로가기</button></a>
				</div>
				<form action="" method="post" enctype="multipart/form-data">
				<div class="row">
					<div class="col-md-2">제목 : </div>
					<div class="col-md-10">
						<input class="form-control" type = "text" name = "" value="안녕하세요"><br>
					</div>
					<div class="col-md-2">내용 : </div>
					<div class="col-md-10">
						<textarea class="form-control"  name = "" id = "" rows="10" cols="20">반갑습니다</textarea>
					</div>
				</div>
					<div class="col-md-10 offset-2 mt-2">
						<div class="row">
							<div class="col-md-6">
								<img alt="" src="../img/robot.png">
							</div>
							<div class="col-md-6">
								<img alt="" src="../img/robot.png">
							</div>
						</div>
					</div>
				</form>
		</div>
		<%} %>
<%@include file="../footer.jsp" %>
</body>
</html>