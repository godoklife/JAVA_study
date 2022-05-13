/*---------------------- 카테고리 추가 버튼 ----------------------*/
function categorybtn(){
	$("#categoryinput").html(
		'<div class="row">'+
			'<div class="col-md-3 offset-2">'+
				'<input class="form-control" type="text" id="cname" placeholder="카테고리명">'+
			'</div>'+
			'<div class="col-md-2">'+
				'<button class="form-control" onclick="categoryadd()" type="button">등록</button>'+
			"</div>"+
		'</div>'
	);
};
/*---------------------- 카테고리 등록 눌렀을 시 실행 ----------------------*/
function categoryadd(){
	let cname= $("#cname").val();
	$.ajax({
		url:"categoryadd",
		data:{"cname":cname},
		success : function(args){
			if(args==0){
				alert("예외 발생. 관리자에서 문의 바람. 에러내용 : "+args)
			}else if(args==1){
				alert("카테고리 추가 완료.");
				getcategory();
			}else if(args==2){
				alert("이미 존재하는 카테고리 입니다. 등록 실패")
			}
		}
	});
};
/*---------------------- 카테고리 호출->> 스크립트 호출시 즉시 실행 ----------------------*/
function getcategory(){
	$.ajax({
		url:"getcategory",
		success:function(args){
			$("#categorybox").html(args);
		}
	});
};

$(function firstgetcategory(){
	getcategory();
});

/*---------------------- form 전송 ----------------------*/
function productadd(){
	var form = $("#addform")[0];		// form을 가져옴. 배열 지정 안하면 쓰래기값 가져오니 꼭 지정할것.
	var formData = new FormData(form);	// js를 지원하는 FormData 클래스를 이용한 form 태그의 객체화
	
	$.ajax({
		url:"productadd",
		type:'POST',	// 1. get : default / 2. post : 첨부파일, 보안용 등
		contentType:false,	
			// true : URL 인코딩 타입 문자열 O->>get방식때 사용(default), false : 문자열 사용 X
		processData:false,
			// true : 문자열 전송 O(default), false : 문자열 전송 X
		data:formData,
		success:function(args){
			if(args==0){
				alert("예외 발생. 예외값 : "+args);
			}else if(args==1){
				alert("등록이 완료되었습니다.");
				form.reset();
			}else if(args==2){
				alert("이미 등록되어있는 제품명입니다. 등록실패");
			}
		}
	});
};

/*----------------------  첨부파일 이미지 표시 ----------------------*/
/******* 첨부파일이 변경되면 특정 태그에 첨부파일 이미지 표시 *******/
$("#pimg").change(function(e){

//	alert(e);
//	alert(e.target);
//	alert(e.target.files[0]);
//	alert($("#pimg").val());	// 클라이언트의 fakepath.***.jpg가 찍힘. ->> 파일명밖에 얻을수가 없음.

	// 클라이언트가 업로드시 업로드 파일의 경로 알기
	let reader = new FileReader();	// 파일 읽어오는 클래스
	reader.readAsDataURL(e.target.files[0]);	
	reader.onload=function(e){
		$("#preview").attr("src",e.target.result);
	}

});


/*---------------------- reserved ----------------------*/