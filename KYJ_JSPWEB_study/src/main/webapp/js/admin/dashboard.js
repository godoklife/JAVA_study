$(function(){
	// 이 페이지(dashboard.js)가 불러와질때 실행되는 메서드
})
/* 사이드바의 버튼 클릭시 특정 태그에 페이지 열기 */
function pagechange(page){
	$("#mainbox").load(page+".jsp");
	// $ : jquery 문법
		// 특정 태그 호출 : $("#태그이름").load
	// 태그.load(페이지경로)
}
/* 사이드바 위치 변경을 이용한 사이드바 열기& 닫기 */
$(function(){
	let side = $("#sidebar"); /* 반복 사용을 위해 태그 ID를 변수에 담음. */
	side.find('span').on('click',function(){
		/* find('미니이리') : 해당 태그 내 특정 태그 찾기 */
		// .on('click',function(){ 실행코드 }); ->> 클릭했을 때 함수가 실행됨.
		side.toggleClass('open');	/* 메서드 ->> 대소문자 주의 */
		if(side.hasClass('open')){	/* 메서드 ->> 대소문자 주의 */
			side.stop(true).animate({left:"0px"},200);	// 200 : 움직이는 속도
			// side 태그의 애니메이션 효과 : 해당 태그의 left 위치를 0px로 설정. 애니메이션을 결들인.
		}else{
			side.stop(true).animate({left:"-200px"},200);
			// side 태그의 상태가 'open' 을 갖지 않으면 ->> 이미 열려있는 상태면 left 위치를 -200으로 설정.
		}
	});	
});