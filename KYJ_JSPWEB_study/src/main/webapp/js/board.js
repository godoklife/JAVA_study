$(document).ready(function(){
	$('#summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        minHeight: 400,	// 최소 높이
        maxHeigh: null,	// 최대 높이
        lang : 'ko-KR'
	});
});

function filedelete(bno){
	// HTML에서 js로 변수 전달하는법???
		// 1. 메서드 인수로 전달 filedelete(bno)  ->> 이번에는 인수로 받을꺼임~!
		// 2. 태그의 value 혹은 html 이동(input type = "hidden" value = "미니이리" id = "bno")
			// 후 let 변수명 = %("#id명").val(); 로 변수에 넣어주면 됨.
	
	$.ajax({
		url : "../board/Filedelete",
		data : {"bno" : bno},
		success : function(args){
			if(args==1){
				alert("파일 삭제 성공.");
				location.reload();
			}else if(args==2){
				alert("파일 삭제 실패. 관리자에게 문의하세요.");
			}
		}
		
	});
}

function replywrite(bno){
	let rcontent = $("#rcontent").val();
	$.ajax({
		url: "../board/Replywrite",
		data:{"bno" : bno, "rcontent" : rcontent},
		success: function(args){
			if(args==1) {
				alert("덧글을 저장하였습니다.");	
				$("#rcontent").val("");
				$("#replytable").load(location.href+" #replytable");	// 띄워쓰기 주의!!!!
					// id replytable만 새로고침. 단, 띄워쓰기 주의!
			}
			else location.replace("/KYJ_JSPWEB_study/error.jsp");
		}
	});
}

function rereplyview(rno, bno){
	$("#"+rno).html(
		'<input type="text" id="rrcontent">'+
		'<button onclick="rereplywrite('+rno+','+bno+')">대댓글 등록</button>'
	);
}
function rereplywrite(rno, bno){
	alert("대댓글쓰기 rno : "+rno+" bno : "+bno);
	let rrcontent = $("#rrcontent").val();
	$.ajax({
		url:"../board/Rereplywrite",
		data:{"rno":rno, "bno":bno, "rrcontent":rrcontent},
		success:function(args){
			if(args==1){
				alert("대댓글을 저장했습니다.");
				
			}
		}
	})
}









