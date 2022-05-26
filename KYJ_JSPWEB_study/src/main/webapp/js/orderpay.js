let jsonarray;			// json형식의 변수를 선언

let sumprice = 0;		// 상품 총 가격	
let deliverypay = 0;	// 배송비
let totalpay=0;			// 둘을 합한 금액
let point=0;			// 포인트 변수 선언

let member;				// 서블릿에서 전달받은 맴버의 json객체를 저장할 변수
let mpoint = 0;			// 회원이 사용할 예정인 포인트

let pay_method;			// 결제 방식
$(function(){
	
	
		// 체크박스가 변경되었을때 실행되는 이벤트
	$.ajax({
		url:"getmember",
		success:function(args){
			member=args;
			getcart();
		}
	});
	
	// 받는 사람 정보가 기존 회원과 동일하다는 버튼을 누른 경우 배송정보 불러오는 메서드	
	$("#checkbox").change(function(){	
		if($("#checkbox").is(":checked")){	// 체크박스가 체크되었을 떄
			$("#ordername").val(member['mname']);
			$("#orderphone").val(member['mphone']);
			$("#sample4_postcode").val(member['maddress'].split('_')[0]);
			$("#sample4_roadAddress").val(member['maddress'].split('_')[1]);
			$("#sample4_jibunAddress").val(member['maddress'].split('_')[2]);
			$("#sample4_detailAddress").val(member['maddress'].split('_')[3]);
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
			cartview();
		}
	});
}

function cartview(){
			sumprice = 0; /*상품 총가격 */
			deliverypay = 0; // 배송비 
			totalpay = 0; // 총주문액 
			
			let tr = '<tr> <!-- 헤더 -->'+
'					<th width="60%">상품정보</th>'+
'					<th width="20%">수량</th> 		'+
'					<th width="20%">가격</th> '+
'				</tr>'
			
			for( let i = 0 ; i<jsonarray.length; i++ ){
				
				sumprice += jsonarray[i]["totalprice"]; // 누적합계
				
				tr += 
				'<tr>'+
'					<td> <!--  상품정보 열 -->'+
'						<div class="row"> <!-- row(b) : 하위 태그를 가로배치   -->'+
'							<div class="col-sm-2"> <!-- col-sm-2(b) : 12그리드 중 2그리드 사용 -->'+
'								<img alt="" src="/jspweb/admin/productimg/'+jsonarray[i]["pimg"]+'" width="70%"> '+
'							</div>'+
'							<div class="col-sm-10">'+
'								<div class="pnamebox"> '+jsonarray[i]["pname"]+' </div>'+
'								<div class="optionbox">'+jsonarray[i]["scolor"]+' / '+jsonarray[i]["ssize"]+'</div>'+
'							</div>'+
'						</div>   '+
'						<br>'+
'					</td> '+
'					<td class="align-middle">'+
'						<div class="row g-0"> '+
'							<div class="col-sm-5 offset-3">'+ jsonarray[i]["samount"] +' 개 </div>'+
'						</div>'+
'					</td>'+
'					<td class="align-middle">'+
'						<div class="row g-0">'+
'							<div class="col-md-8 pricebox">'+jsonarray[i]["totalprice"].toLocaleString()+'원</div>'+
'						</div>'+
'					</td>'+
'				</tr>';
			}
			// 만약에 총가격이 7만원 이상이면 배송비 무료
			if( sumprice >= 70000 ){ deliverypay = 0;}
			else{ deliverypay = 2500; }
			
			// 만약에 장바구니에 상품이 없으면 
			if( jsonarray.length == 0 ){
				tr += '<td style="text-align: center" colspan="3">'+ 
						'상품이 없습니다. '+
						'</td>';
				deliverypay = 0; 
			}
			// 총주문금액 = 총가격 + 배송비 - 사용포인트 
			totalpay = sumprice + deliverypay - mpoint;
			// 포인트 
			point = parseInt( sumprice * 0.01 ); /* js : parseInt( 데이터 ) : -> 정수형 변환 */
			// 출력 
			$("#carttable").html( tr );
			$("#mpoint").html( member["mpoint"] );
			$("#pointbox").html( mpoint );
			$("#totalpay").html( totalpay );
}
function paymethod(method){
	$("#paymethod").val(method);
	pay_method=method;	// 변수에 넣기
	
}


function payment(){
	if(pay_method==null){	// 결제 수단을 선택하지 않았을 경우
		alert("결제 방법을 선택해 주세요.")
		return;
	}
	else if(totalpay<=0){
		alert("결제할 금액이 없습니다.");
		return;
	}
	var IMP = window.IMP;
    IMP.init("imp62383723"); // 예: imp00000000
    	// https://admin.iamport.kr/settings 에 식별코드 있음.
     // IMP.request_pay(param, callback) 결제창 호출
      IMP.request_pay({ // param
          pg: "html5_inicis",
          pay_method: pay_method,
          merchant_uid: "1000000001",	// 주문번호 ( 내가 만들어서 넣어야함. )
          name: "PHONETAKU",						// 상품명
          amount: totalpay,						// 결제 금액, 프로젝트 만들떄는 totalpay 변수 넣어.
          buyer_email: member["memail"],		
          buyer_name: member["mname"],
          buyer_tel: member["mphone"],
          buyer_addr: member["maddress"],
          buyer_postcode: member["maddress"].split('_')[0],	// 우편번호만
      }, function (rsp) { // callback
          if (rsp.success) {
              alert("현질완료 버튼");
          } else {
              // 결제 실패 시 로직,
              alert("saveorder() 실행.");
              saveorder();
          }
      });
}

// 주문처리 메서드
function saveorder(){
	
	let ordername = $("#ordername").val();
	let orderphone = $("#orderphone").val();
	let orderaddress = 
		$("#sample4_postcode").val()+"_"+
		$("#sample4_roadAddress").val()+"_"+
		$("#sample4_jibunAddress").val()+"_"+
		$("#sample4_detailAddress").val()+"_";
	let ordertotalpay = totalpay;
	let orderrequest = $("#orderrequest").val();
	
	let orderjson={
		ordername : ordername,
		orderphone : orderphone,
		orderaddress : orderaddress,
		ordertotalpay : ordertotalpay,
		orderrequest : orderrequest
	}
	
	$.ajax({
		url:"saveorder",
		data:{"orderjson":JSON.stringify(orderjson)},
		function:function(args){
			if(args==1){
				location.href = "/KYJ_JSPWEB_study/product/ordersuccess.jsp" ;
			}else{
				location.href = "/KYJ_JSPWEB_study/error.jsp" ;
			}
		}
	});
};



function pointbtn(){
	
	// 만약 포인트가 5000점 이상이 아니라면
	mpoint = $("#mpointinput").val();
	if(mpoint==0){
		mpoint=0;
	}else if(mpoint<5000){
		alert("포인트는 최소 5,000점부터 사용 가능합니다.");
		mpoint = 0;
		return;
	}else{
		cartview();	// 포인트가 바뀔때마다 새로고침
		
	}
	
}























