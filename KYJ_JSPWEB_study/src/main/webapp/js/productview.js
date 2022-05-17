$("#color_select").change(function(){
	let color=$("#color_select").val();
	let pno=$("#pno").val();
	$.ajax({
		url:"getstocksize",
		data:{"pno":pno, "color":color},
		success:function(args){
			args=args.replace("{","");
			let list=args.replace("}","");
			let itemlist = list.split(", ");
			let html="";
				html+="<option value=''>-[필수]용량 선택-</option>";
			for(let item of itemlist){
				let size = item.split("=")[0];
				let amount = item.split("=")[1];
				html += "<option value="+size+">"+size+"</option>"
			}
			$("#size_select").html(html);
			//$("#size_select").append('<option>12</option>');	// 기존값을 날리지 않고 누적추가
		}
	});
});

	// js 배열 
		// let 배열명 = [ ] : 배열의 선언
			// 추가 : push -> 배열 내 마지막 인덱스 값 추가
			// 제거 : pop -> 배열 내 마지막 인덱스 값 삭제
let dupcheck=[];
$("#size_select").change(function(){
	let pname=$("#product_name").html();
	let color=$("#color_select").val();
	let size = $("#size_select").val();
	let amount = $("#amount").val();
	let pprice = $("#pprice").val();
	// 선택옵션 중복체크	라인
	let selected= color+size;
	selected=selected.replace("/","_")	// deletechoice id값에서 슬래시때문에 자꾸 깨져서 replace 해주는것.
	if(amount==null){
		amount=1;
	}
	let object={	// JS식 객체 선언 방법
		pname : pname,
		color : color,
		size : size,
		amount : amount,
		pprice : pprice,
		selected :selected
	}
	for(let i=0; i<dupcheck.length; i++){
		if(dupcheck[i].selected==selected){
			alert("이미 선택한 옵션 입니다.");
			return;
		}
	}
	///////////////////////////////////
	
	if(color==""){
		return;
	}
	if(size==""){
		return;
	}
	dupcheck.push(object);
	choiceshow();
});
function choiceshow(){
	/* 테이블에 추가할 내용물 */
	let html='<tr><th width="60%">상품명</th><th width="25%">상품수</th><th width="15%">가격</th></tr>';
	/* 배열 내 모든 객체의 정보를 html화 하기 */
	for(let i=0; i<dupcheck.length;i++){
		html+='<tr>'+
				'<td>'+dupcheck[i].pname+" "+dupcheck[i].color+" "+" "+dupcheck[i].size+'</td>'+
				'<td>'+
					'<div class="row g-0">'+
						'<div class="col-md-7">'+
							'<input id="amount" class="amount_input" value="1">'+
						'</div>'+
						'<div class="col-md-4">'+
							'<button id="amount_up_btn" class="amount_btn">+</button>'+
							'<button id="amount__down_btn" class="amount_btn">-</button>'+
						'</div>'+
						'<div class="col-md-1" style="text-align:center;">'+
							'<button id="cancel_btn" class="cancel_btn" onclick="deletechoice('+i+')">X</button>'+
						'</div>'+
					'</div>'+
				'</td>'+
				'<td class="jsprice">'+(dupcheck[i].amount*dupcheck[i].pprice)+' 원<br><hr>'+
				'포인트 '+(dupcheck[i].amount*dupcheck[i].pprice)*0.01+' 점</td><br>'+
			'</tr>';	
	}
	$("#select_table").html(html);	
}

function deletechoice(i){
	dupcheck.splice(i,1);
	choiceshow();
}
function amount_increase(selected){
	
}
function amount_decrease(selected){
	
}