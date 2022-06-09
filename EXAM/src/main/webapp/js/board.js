$(document).ready(function(){
	
});

function save(){
	let writer = $("#writer").val();
	if(writer==""){
		alert("글쓴이를 입력하세요");
		return;
	}
	
	let writerpassword = $("#writerpassword").val();
	if(writerpassword==""){
		alert("비밀번호를 입력하세요");
		return;
	}
	
	let title = $("#title").val();
	if(title==""){
		alert("제목을 입력하세요");
		return;
	}
	
	let content = $("#content").val();
	if(content==""){
		alert("내용을 입력하세요");
		return;
	}
	
	$.ajax({
		url:"../BoardSave",
		data:{"writer":writer,
				"writerpassword":writerpassword,
				"title":title,
				"content":content},
		success:function(args){
			if(args==1){
				alert("작성에 성공했습니다.");
				window.location.href="/EXAM/board/boardlist.jsp";
			}else if(args==0){
				alert("SQL에 예외가 발행했습니다. 콘솔 로그를 확인하세요.");
			}
		}
	})
	
}