
let parentlist;

$(function(){
	// myshopping.js가 로드될 때 실행되는 펑션
	
	$.ajax({
		url:"../product/getorder",
		success:function(result){
			parentlist = result;
			console.log(parentlist);
			view();
		}
	});
})

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
	let html;
	
//	for(let i = 0; i<viewcount; i++){
	for(let i = 0; i<parentlist.length; i++){
		if(i==viewcount) break;	// 만약 i가 화면에 표시할 주문수와 동일하면 출력 금지
			
		html+=  '<div class="row">'+
'					<div class="col-sm-3">	<!--  주문정보 box -->'+
'						<span> '+parentlist[i][0]["orderno"]+' </span>'+
'						<span> '+parentlist[i][0]["orderdate"]+' </span>'+
'					</div>'+
'					<div class="col-sm-9">	<!--  주문 상세정보 box -->';
			for(let j=0; j<parentlist[i].length;j++){
				let childrenlist=parentlist[i];
				html+=
'				<div class="row">'+
'							<div class="col-sm-8">'+
'								<span> <img width="100%" src="/KYJ_JSPWEB_study/admin/img/'+childrenlist[i]["pimg"]+'"> </span>'+
'								<span> '+childrenlist[i]["pname"]+' </span>	'+
'								<span> '+childrenlist[i]["scolor"]+' '+childrenlist[i]["ssize"]+' </span>'+
'							</div>'+
'							<div class="col-sm-4">'+
'								<button type="button"> 배송조회 </button>'+
'								<button type="button"> 교환, 반품 신청 </button>'+
'								<button type="button"> 리뷰 작성 </button>'+
'							</div>'+
'						</div>';
			}
				html+=	
'					</div>'+
'				</div>';
	}
	$("#orderbox").html(html);
	
}














































