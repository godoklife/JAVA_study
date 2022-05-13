// 모달에 pno 전달해주는 메서드
function pnomove(pno){
	alert(pno);
	$("#modalinput").val(pno);	
};

function activechange(active){
	alert("asdasd");
	let pno = $("#modalinput").val();
	$.ajax({
		url:activechange,
		type:"get",
		data:{"active":active, "pno":pno},
		success:function(args){
			alert("통신성공");
			if(args==0){
				alert("activechange 예외 발생");
			}else if(args==1){
				alert("변경 성공.")
			}
		}
	});
};