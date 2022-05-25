
let parentlist;

$(function(){
	// myshopping.js가 로드될 때 실행되는 펑션
	getorder();
})

function getorder(){
	$.ajax({
		url:"../product/getorder",
		success:function(result){
			parentlist = result;
			console.log(parentlist);
			view();
		}
	});
}

// 스크롤이 바닥에 '닿을때마다' 제품을 불러와서 표시하는 함수 ->> 서버 부하 감소에 매우 굿
let viewcount=2;
$(window).scroll(function(){
	// 스크롤이 바닥에 닿았을 시 
		// $(window).scroll : 브라우저 스크롤
		// $(window).scrollTop() : 스크롤막대의 상단 위치
		// $(document).height() : 문서 내 높이
		// $(window).height() : 스크롤의 높이
	if($(window).scrollTop() == $(document).height() - $(window).height()){
		viewcount++;
		view();
	}
});

function view(){
	let html="";	// 초기값 안넣어주면 undefined 뜸.
	
//	for(let i = 0; i<viewcount; i++){
	for(let i = 0; i<parentlist.length; i++){
		if(i==viewcount) break;	// 만약 i가 화면에 표시할 주문수와 동일하면 출력 금지
		
		
		
			
		html+=  '<div class="orderinfo">'	
					'<span> 주문번호 </span> <span> '+parentlist[i][0]["orderno"]+' </span>'+
					'<span> 주문날짜 </span> <span> '+parentlist[i][0]["orderdate"]+' </span>'+
					'<a href="#"><span>주문 상세보기</span></a>'+
				'</div>'+
				'<div class="orderdetailbox col-sm-10">';
			for(let j=0; j<parentlist[i].length;j++){
				let childrenlist=parentlist[i];
				
				// active의 한글 표시 처리
				let active ; 
				if(childrenlist[i]["orderdetailactive"]==0) active="상품준비중";
				else if(childrenlist[i]["orderdetailactive"]==1) active="배송중";
				else if(childrenlist[i]["orderdetailactive"]==2) active="배송완료";
				else if(childrenlist[i]["orderdetailactive"]==3) active="구매확정";
				else if(childrenlist[i]["orderdetailactive"]==4) active="취소요청";
				else if(childrenlist[i]["orderdetailactive"]==5) active="취소완료";
				else active="재고확인중";
				
				html+=
				'<div class="row product">'+
					'<div class="col-sm-2">'+
						'<img width="100%" src="/KYJ_JSPWEB_study/admin/img/'+childrenlist[j]["pimg"]+'">'+
					'</div>'+
					'<div class="col-sm-8">'+
						'<div class="row">'+
							'<div class="pname">'+childrenlist[j]["pname"]+'</div>'+
							'<div class="pcolor">'+childrenlist[j]["scolor"]+'</div>'+
							'<div class="psize">'+childrenlist[j]["ssize"]+'</div>'+
							'<div class="pamount">'+childrenlist[j]["samount"]+'</div>'+
							'<div>'+
								'<span class="activeinfo">주문 상태 : '+active+'</span>'+
							'</div>'+
						'</div>'+
					'</div>'+
					'<div class="col-sm-2 orderbuttonbox">'+
						'<button onclick="">배송 조회</button>'+
						'<button onclick="cancelbtn('+childrenlist[j]["orderdetailno"]+')" data-bs-toggle="modal" data-bs-target="#cancelmodal">취소 신청</button>'+
						'<button onclick="">리뷰 작성</button>'+
					'</div>'+
				'</div>';			
			}
				html+=	
				'</div>'+
				'</div>';
	}
	$("#orderbox").html(html);
	
}

let orderdetailno = -1;	// 선택한 버튼의 모달에 넣을 주문 상세 번호 변수
	// -1이라는 디테일 번호는 절대 없으므로 초기화 값으로 선언

function cancelbtn(no){	// 선택한 버튼의 인수 값을 변수에 대입하는 메서드
	orderdetailno = no;
}
// 취소 모달에서 취소를 처리하는 메서드
function cancel(){
	
	$.ajax({
		url:"../product/updateorderdetail",
		data:{"orderdetailno":orderdetailno, "active":4},	// active 중에서 취소 : 4
		success:function(result){
			if(result==1) {
				alert("취소 요청이 성공했습니다.");
				$("#modalclose").click();
					// 모달의 버튼 중 close 버튼에 모달 닫기 기능이 있으므로 모든 기능을 처리 후 close버튼을 클릭하여 모달 닫기.
				$("#cancelreason").val("");	// 주문취소 사유 작성란 초기화
				view();
			}else if(result==0){
				alert("요청이 실패했습니다. 관리자에게 문의 바랍니다.");
				$("#modalclose").click();
			}
			
		}
	});
	
		
}










































