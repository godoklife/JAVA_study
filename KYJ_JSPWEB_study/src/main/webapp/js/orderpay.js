let jsonarray;			// json형식의 변수를 선언
let sumprice = 0;		// 상품 총 가격	
let deliverypay = 0;	// 배송비
let totalpay=0;			// 둘을 합한 금액

$(function(){
	getcart();
	
	// 받는 사람 정보가 기존 회원과 동일하다는 버튼을 누른 경우 배송정보 불러오는 메서드
	$("#checkbox").change(function(){
		// 체크박스가 변경되었을때 실행되는 이벤트
		if($("#checkbox").is(":checked")){	// 체크박스가 체크되었을 떄
		
			$.ajax({
				url:"getmember",
				success:function(args){
					$("#ordername").val(args['mname']);
					$("#orderphone").val(args['mphone']);
					$("#sample4_postcode").val(args['maddres'].split('_')[0]);
					$("#sample4_roadAddress").val(args['maddres'].split('_')[1]);
					$("#sample4_jibunAddress").val(args['maddres'].split('_')[2]);
					$("#sample4_detailAddress").val(args['maddres'].split('_')[3]);
				}
			});
		
			
			
		}else{	// 체크박스가 체크되어있지 않을때 실행되는 이벤트
			$("#ordername").val("");
			$("#orderphone").val("");
			$("#address1").val("");
			$("#address2").val("");
			$("#address3").val("");
			$("#address4").val("");
			
		}
	});
});

// 장바구니 데이터(json) 호출 메서드
function getcart(){
	$.ajax({
		url:'getcart',
		success:function(resultjson){
			jsonarray = resultjson;
			for(let i = 0; i<jsonarray.length; i++){
				totalpay+=jsonarray[i]["totalprice"];
			}
		}
	});
}

function cartview(){
	let html=	'<tr>'+
					'<th width="60%">제품명</th><th width="20%">수량</th><th width="20%">가격</th>'+
				'</tr>';
	sumprice = 0;
	deliverypay = 0;
	totalpay = 0;

			for(let i=0; i<jsonarray.length; i++){
				sumprice += jsonarray[i]["totalprice"];
				tr +=  
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
}

function pay(){
	alert('돈"줘"');
	var IMP = window.IMP;
    IMP.init("imp62383723"); // 예: imp00000000
    	// https://admin.iamport.kr/settings 에 식별코드 있음.
     // IMP.request_pay(param, callback) 결제창 호출
      IMP.request_pay({ // param
          pg: "html5_inicis",
          pay_method: "card",
          merchant_uid: "1000000001",	// 주문번호 ( 내가 만들어서 넣어야함. )
          name: "시진핑핑이샵",						// 상품명
          amount: 5999,						// 결제 금액, 프로젝트 만들떄는 totalpay 변수 넣어.
          buyer_email: "godoklife1@gmail.com",		
          buyer_name: "김용준",
          buyer_tel: "010-5353-5228",
          buyer_addr: "경기도 안산시 상록구 반석로 44, 103동 1003호",
          buyer_postcode: "15541"
      }, function (rsp) { // callback
          if (rsp.success) {
              // 결제 성공 시 로직,
              alert("현질완료 버튼");
          } else {
              // 결제 실패 시 로직,
              alert("주문취소 버튼");
              saveorder();
          }
      });
}

function saveorder(){
	alert("DB처리");
	$.ajax({
		url:"saveorder",
		data:{},
		function:function(args){
			alert("DB처리 완료");
		}
	});
};



























