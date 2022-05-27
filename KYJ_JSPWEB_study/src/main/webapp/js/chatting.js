
let websocket = null;	// js 웹 소켓 변수


$("#incontent").focus();	// 페이지 처음 열렸을 때 키보드 커서 입력창으로 이동시키기


// 채팅입력란에 엔터키 눌렀을때 이벤트
function enterkey(){if(window.event.keyCode==13){send();}}

// 전송 버튼을 눌렀을때 이벤트
function sendbtn(){send();}

/*
1. new WebSocket : 웹 소켓 클래스
	* 메서드
		1) websocket.OnOpen : 서버소켓 연결이 되었을 떄 이벤트
		2) websocket.OnMessage : 


*/

start();	// 테스트 목적으로 웹소켓 1회 무조건 실행
// 채팅 소켓 실행
function start(){
	// js에서 사용되는 웹소캣 클래스(ws://IP번호:port/프로젝트명/서버소켓이름)
	websocket = new WebSocket("ws://localhost:8080/KYJ_JSPWEB_study/chatting");
	websocket.onopen;
		// 여기의 onopen은 Chatting.java의 어노테이션 @OnOpen을 말하는것임.
	websocket.onmessage = function(e){onmessage(e)}
		// 실제 소켓의 동작은 어노테이션을 참조하는 웹소켓.onmessage가 하는것이지, 이 뒤의 function문은 없어도 됨.
		// (참고)마우스 커서 올려다보면 var나 method가 아닌 property라고 뜸. 
}

function onOpen(e){
	alert("서버 소켓으로 들어왔습니다."+e);
	console.log(e);
}

function onmessage(e){
	alert("메시지를 수신합니다." +e+" 내용물 : "+e.data);
	console.log(e);
}

function send(){
	alert("메시지를 전송합니다.");
	let msg = $("#incontent").val();
	websocket.send(msg);		// @OnMessage로 msg 전송
	$("#incontent").val("");	// 전송 후 입력창 비워주기
	$("#incontent").focus();	// 전송 후 커서 유지
}