let jsonarray;
let totalpay=0;
$(function(){
	getcart();
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


























