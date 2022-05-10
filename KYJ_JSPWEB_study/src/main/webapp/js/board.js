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

function rereplyview(rno, bno, mid){
	if(mid==null){
		alert("로그인을 해 주세요.");
		return;
	}
	$("#"+rno).html(
		'<div class="row">'+
			'<div class="col-md-10">'+
				'<textarea id="rrcontent" class="form-control" rows=3></textarea>'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control py-4 my-1" onclick="rereplywrite('+rno+','+bno+')">대댓글 등록</button>'+
			'</div>'+
		'</div>'
	);	
}
function rereplywrite( rno , bno ){ // 대댓글 쓰기 메소드 
	let rrcontent = $("#rrcontent").val();
	$.ajax({
		url : "../board/Rereplywrite" , 
		data : { "rno" : rno , "bno" : bno  , "rrcontent" : rrcontent} ,
		success : function( result ){
			if( result == 1 ){
				 alert("대댓글 작성 되었습니다."); // 성공 메시지 알림 
				 $("#rrcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("대댓글작성이 실패했습니다."); }
		}
	});
}


function replydelete(rno){
	$.ajax({
		url:"../board/Replydelete",
		data:{"rno":rno},
		success : function(args){
			if(args==1){
				alert("덧글을 삭제하였습니다.");
				$("#replytable").load(location.href+" #replytable");
			}else alert("삭제 실패.");
		}
	});
}



function replymodifyview(rno, bno){
	$("#"+rno).html(
		'<div class="row">'+
			'<div class="col-md-10">'+
				'<textarea id="rmodcontent" class="form-control" rows=3></textarea>'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control py-4 my-1" onclick="replymodifywrite('+rno+')">덧글 수정</button>'+
			'</div>'+
		'</div>'
	);	
}
function replymodifywrite( rno , bno ){ // 덧글 수정 메서드
	let rmodcontent = $("#rmodcontent").val();
	$.ajax({
		url : "../board/Replymodify" , 
		data : { "rno" : rno ,"rmodcontent" : rmodcontent} ,
		success : function( result ){
			if( result == 1 ){
				 alert("덧글을 수정하였습니다."); // 성공 메시지 알림 
				 $("#rmodcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("덧글 수정을 실패했습니다."); }
		}
	});
}


