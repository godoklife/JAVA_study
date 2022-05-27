// 모달에 pno 전달해주는 메서드
function pnomove(pno){
	$("#modalinput").val(pno);	
};
/* -------------- 상태변경 비동식 처리 --------------------*/
function activechange(pactive){
	let pno = $("#modalinput").val();
	$.ajax({
		url:"activechange",
		type:"get",
		data:{"pactive":pactive, "pno":pno},
		success:function(args){
			if(args==0){
				alert("activechange 예외 발생");
			}else if(args==1){
				alert("변경 성공.")
				$("#modalclosebtn").click;
				$("#producttable").load(location.href+' producttable');
			}
		}
	});
};



function getamount(pno){
	// 제품번호, 색상, 사이즈가 동일 한 경우 재고 호출
	let ssize = $("#sizebox"+pno).val();
	let scolor = $("#colorbox"+pno).val();
	
	$.ajax({
		url:'getstock',
		data:{"field":'amount', "pno":pno, "scolor":scolor, "ssize":ssize},
		success:function(args){
			if(args==""){
				$("#amountbox"+pno).html("재고없음.");
				$("#datebox"+pno).html("");
			}else{
				$("#amountbox"+pno).html(args.split(',')[0]+"개");
				$("#datebox"+pno).html(args.split(',')[1]);
			}
		}
	})
	
}

/////////////////////////////// 선택한 제품의 재고 변경 /////////////////////////////// 
function getstock(pno){
	$.ajax({
		url:"getstock",
		data:{"pno":pno},
		success:function(args){
			$("#stocklistbox").html(args)
		}
	})
}

function showupdate(sno){
	$("#updatebox").css('display','block');
	$("#sno").val(sno);	// 수정할 재고번호를 hidden에 담기
	
}
function stockupdate(){
	
	$.ajax({
		url:"stockupdate",
		data:{"sno":$("#sno").val(), "samount":$("#samount").val()},
		success:function(args){
			alert("재고 수량 변경 완료!");
			$("#modalclosebtn2").click();
			$("#updatebox").css("display","none");
			$("#samount").val(""); 
			$("#mainbox").load('productlist.jsp');
		}
	})
}

