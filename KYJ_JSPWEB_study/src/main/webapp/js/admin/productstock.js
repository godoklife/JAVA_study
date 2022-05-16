/* 특정 select에 DB 데이터 넣기 */

$(function getcategory(){	// js 호출시 한번 실행되는 함수
	$.ajax({
		url: "getcategory",
		data :{"type":"option"},
		success:function(args){
			$("#categorybox").html(args);
			loadstock();
		}
	})
});

/* 카테고리의 select 값이 변경될때마다 실행되는 함수 */
$("#categorybox").change(function(){
	let cno = $("#categorybox").val();
	$.ajax({
		url:"getproduct",
		data:{"type":"option", "cno":cno},
		success:function(args){
			if(args==""){
				alert("해당 카테고리의 제품이 없습니다.");
				$("#stockaddform").css('display','none');
				loadstock();
			}else{
				$("#productbox").html(args);
				$("#stockaddform").css('display','block');
				loadstock();
			}
		}
		
	});
});

function stockadd(){
	let pno = $("#productbox").val();
	let scolor = $("#scolor").val();
	let ssize = $("#ssize").val();
	let samount = $("#samount").val();
	
	$.ajax({
		url : "stockadd",
		data: {"pno":pno,
				"scolor":scolor,
				"ssize":ssize,
				"samount":samount},
		success:function(args){
			if(args==0){
				alert("예외 발생. 저장 실패");
			}else if(args==1){
				alert("저장했습니다.");
				$("#mainbox").load('productstock.jsp');
				loadstock();
			}
		}
	});
};


/* 제품명 목록 select 값이 변경 될 때 마다 */
function loadstock(){
	let pno=$("#productbox").val();
	$.ajax({
		url:"getstock",
		data:{"pno":pno},
		success:function(args){
			$("#stocklistbox").html(args);
		}
		
	});
}
$("#productbox").change(function(){
	loadstock();
});












