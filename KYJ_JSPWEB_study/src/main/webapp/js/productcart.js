
let jsonarray;			// json형식의 변수를 선언
let sumprice = 0;		// 상품 총 가격
let deliverypay = 0;	// 배송비
let totalpay = 0;		// 둘을 합한 금액



function tableview(){
	let tr =  '<tr>'+
'				<th width="60%">상품정보</th>'+
'				<th width="20%">수량</th>'+
'				<th width="20%">가격</th>'+
'			</tr>';
	sumprice = 0;
	deliverypay = 0;
	totalpay = 0;

			for(let i=0; i<jsonarray.length; i++){
				sumprice += jsonarray[i]["totalprice"];
				tr =  
			'<tr>'+
'				<td>'+
'					<div class="row">	<!--  row : 하위 태그를 가로 배치 -->'+
'						<div class="col-sm-2">'+
'							<img src="/KYJ_JSPWEB_stydy/img/'+jsonarray[i]["pimg"]+'" width="100%">'+
'						</div>'+
'						<div class="col-sm-10">'+
'							<div class="pnamebox">'+jsonarray[i]["pname"]+'</div>'+
'							<div class="optionbox">'+jsonarray[i]["scolor"]+' / '+jsonarray[i]["ssize"]+'</div>'+
'						</div>'+
'					</div>'+
'				</td>'+
'				<td class="align-middle">	<!-- 수량 출력  / align-middle : 수직 중앙 배치 ->> 부트스트랩 -->'+
'					<div class="row g-0">	<!--  g-0 : 그리드 간 여백 제거 ->> 부트스트랩 -->'+
'						<div class="col-sm-5 offset-3">'+
'							<!--  form-control : 입력상자 형식 꾸미기 -->'+
'							<input readonly id="" class="form-control" type="text" value="'+jsonarray[i]["samount"]+'" style="background-color:white;">'+
'						</div>'+
'						<div class="col-sm-2">'+
'							<button class="amount_btn" onclick="amountincrease('+i+')">▲</button>'+
'							<button class="amount_btn" onclick="amountdecrease('+i+')">▼</button>'+
'						</div>'+
'					</div>'+
'				</td>'+
'				<td class="align-middle">'+
'					<div class="row g-0">'+
'						<div class="col-sm-8 pricebox">'+jsonarray[i]["totalprice"].toLocaleString()+'원</div>'+
'						<div class="col-sm-4 deletebox"><button onclick="cancel('+i+')">X</button></div>'+
'					</div>'+
'				</td>'+
'			</tr>';
			}
			
			if(jsonarray.length==0){	// 만약 장바구니에 상품이 없으면
				tr+='<td colspan="3" style="text-align:center;">상품이 없습니다.</td>';
				deliverypay=0;
			}
			if(sumprice>=70000){	// 구매금액 7만원 이상이면 무료배송
				deliverypay=0;
			}else{
				deliverypay=2500;
			}
			point = sumprice*0.01;	// 적립금 = 상품구매금의 1%
			$("#pricesum").html(sumprice.toLocaleString()+' 원');
			$("#shippingfee").html(deliverypay.toLocaleString()+' 원');
			$("#totalpay").html(totalpay.toLocaleString()+' 원');
			$("#point").html(point.toLocaleString()+' 원');
			$("#carttable").html(tr);
};

function cancel(i){
	if(i==-1){	// 만약 i가 -1이면 전체 삭제
		if(confirm('전체 삭제하시겠습니까?')){		// 질문창 확인버튼: true, 취소버튼: false
			jsonarray.splice(0,jsonarray.length);	// 0번 인텍스부터 끝 인덱스까지 삭제
			tableview();
		}
		return;
	}
	
	jsonarray.splice(i,1);
	tableview();
}
function amountincrease(i){
	
	// 재고의 최대값 가져오기
	$.ajax({
		url:"getamount",
		data:{"pno":jsonarray[i]["pno"],"color":jsonarray[i]["scolor"],"size":jsonarray[i]["ssize"]},
		success:function(maxamount){
			if(jsonarray[i]["samount"]>=maxamount){
				alert("재고가 부족합니다.");
				return;
			}
			let price = parseInt(jsonarray[i]["totalprice"] / jsonarray[i]["samount"])	// 제품 한개의 금액 구하기
			jsonarray[i]["samount"]++;	// 수량증가처리
			jsonarray[i]["totalprice"] = price * jsonarray[i]["samount"];	// 증가된 수량의 총금액 업데이트
			tableview();
		}
	})
}

function amountdecrease(i){
	if(jsonarray[i]["samount<=1"]){
		alert("최소수량입니다.");
		return;
	}
	let price = parseInt(jsonarray[i]["totalprice"] / jsonarray[i]["samount"])	// 제품 한개의 금액 구하기
	jsonarray[i]["samount"]--;	// 수량증가처리
	jsonarray[i]["totalprice"] = price * jsonarray[i]["samount"];	// 증가된 수량의 총금액 업데이트
	tableview();
	
}
$(function(){
	$.ajax({
		url:'getcart',
		success:function(resultjson){
			jsonarray = resultjson;
			tableview();
		}
	});
});