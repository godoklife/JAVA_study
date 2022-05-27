
let websocket = null;	// js 웹 소켓 변수


$("#incontent").focus();	// 페이지 처음 열렸을 때 키보드 커서 입력창으로 이동시키기


// 채팅입력란에 엔터키 눌렀을때 이벤트
function enterkey(){
	if(window.event.keyCode==13){
		alert("엔타 입력 감지!!");
		$("#incontent").val("");	// 전송 후 입력창 비워주기
		$("#incontent").focus();	// 전송 후 커서 유지
	}
}

// 전송 버튼을 눌렀을때 이벤트
function sendbtn(){
	alert("전송 버튼 감지!!!");
	$("#incontent").focus();	// 전송 후 커서 유지
}

// 채팅 소켓 실행
function start(){
	// js에서 사용되는 웹소캣 클래스(ws://IP번호:port/프로젝트명/서버소켓이름)
	websocket = new WebSocket("ws://localhost:8080/KYJ_JSPWEB_study/chatting");
	
	
}