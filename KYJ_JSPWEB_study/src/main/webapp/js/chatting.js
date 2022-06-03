
let websocket = null;	// js 웹 소켓 변수


$("#incontent").focus();	// 페이지 처음 열렸을 때 키보드 커서 입력창으로 이동시키기


// 채팅입력란에 엔터키 눌렀을때 이벤트
function enterkey(mid){
	if(mid=='null'){
		alert("로그인 후 채팅 입력이 가능합니다. null 문자열 받음.");
		$("#incontent").val("");
		return;
	}
	if(window.event.keyCode==13){
		if($("#incontent").val()=="\n"){
			alert("내용을 입력해주세요.");
			$("#incontent").val("");	// 엔터키 입력으로 인한 출바꿈 없애주기.
			return;
		}
		send(mid);
	}
}

// 전송 버튼을 눌렀을때 이벤트
function sendbtn(mid){
	if(mid=='null'){
		alert("로그인 후 채팅 입력이 가능합니다. null 문자열 받음.");
		return;
	}
	if($("#incontent").val()==""){
		alert("내용을 입력해주세요.");
		return;
	}
	send(mid)
}

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
	let mid = $("#mid").val();
	alert(mid);
	websocket = new WebSocket("ws://localhost:8080/KYJ_JSPWEB_study/chatting/"+mid);
		// Cha
	websocket.onopen  = function(e){onOpen(e)};
		// 여기의 onopen은 Chatting.java의 어노테이션 @OnOpen을 말하는것임.
	websocket.onmessage = function(e){onmessage(e)};
		// 실제 소켓의 동작은 어노테이션을 참조하는 웹소켓.onmessage가 하는것이지, 이 뒤의 function문은 없어도 됨.
		// (참고)마우스 커서 올려다보면 var나 method가 아닌 property라고 뜸. 
	websocket.onclose = function(e){onclose(e)};
	websocket.onerror = function(e){onerror(e)};
}


function onmessage(e){
	console.log(e);
	// json형식으로 수신하기
	// e : 메서드 이벤트 실행 정보가 담겨있는 객체
		// e.data : 메시지 내용이 담겨있는 필드
	let msg = JSON.parse(e.data);	// 수신한 문자열을 JSON형식으로 변환
	let from  = msg["from"];
	let content = msg["content"];
	let img = msg["img"];
	let date = msg["date"];
	
	let html = $("#contentbox").html();
	
	if (msg["type"]!=1){
		let memberhtml="";
		for(let i = 0; i<msg.length; i++){
			memberhtml+=
			'<div class="row p-3">	<!--  접속자 정보 표시 구역 -->'+
				'<div class="col-sm-4">	<!--  프로필 이미지 표시 구역 -->'+
					'<img width=100% class="rounded-circle" src="upload/food.jpg">'+
						'<!--  class="rounded-circle" : 부트스트랩, 이미지를 원형으로 출력-->'+
				'</div>'+
				'<div class="col-sm-8">	<!--  접속자 이름, 기능 출력 구역 -->'+
					'<div class="member_name"> '+msg[i]["mid"]+' </div>'+
					'<div class="btnbox">'+
						'<span> 귓속말 </span>'+
						'<span> 친구추가 </span>'+
					'</div>'+
				'</div>'+
			'</div>';
		}
		$("#enterlist").html(memberhtml);
		
	}else{
		if(from==$("#mid").val()){	// 내가 보냈을 때의 출력부
		html+= '<div class="secontent">'+
					'<span class="date">'+date+'</span>'+
					'<span class="content">'+content+'</span>'+
				'</div>';
		}else{	// 남이 보냈을 때의 출력부
			html+=	'<div class="row g-0">'+
						'<div class="col-sm-1 pt-3">'+
							'<img width=100% class="rounded-circle" src="upload/'+img+'">'+
						'</div>'+
						'<div class="col-sm-10">'+
							'<div class="recontent">	<!--  받은 메시지 출력 구역 -->'+
								'<div class="member_name">'+from+'</div>'+
								'<span class="content">'+content+'</span>'+
								'<span class="date">'+date+'</span>'+
							'</div>'+
						'</div>'+
					'</div>';
		}
		$("#contentbox").html(html);
		
		// 스크롤 자동으로 하단으로 내리기
		$("#contentbox").scrollTop($("#contentbox")[0].scrollHeight);
			// $("#contentbox").scrollTop : 현재 스크롤의 상단 위치
			// $("#contentbox")[0].scrollHeight : 현재 스크롤의 전채 길이
			
		}
	
}

function onOpen(e){
}

function onclose(e){
}

function onerror(e){
}

function send(mid){
	let content = $("#incontent").val();
	// json 형식으로 통신 ( JSON과 DB 중에서 선택 )
	let msg = {	// js 객채화
		type : "1",			// 타입 : 1 이면 일반 메시지, 2이면 접속,탈퇴 알림
		from : mid, 		// 보내는 사람		
		content : content,	// 채팅 내용
		img : "food.jpg",	// 프로필사진
		date : new Date().toLocaleTimeString()	// 채팅 보낸 시간
	};
	// json형식으로 통신할 떄 json 모양의 문자열로 변환
		// JSON -> 문자열 : JSON.stringify(보낼변수)
		// 문자열 -> JSON : JSON.parse(받은변수)
		
	
	websocket.send(JSON.stringify(msg));		// @OnMessage로 content 전송
	$("#incontent").val("");	// 전송 후 입력창 비워주기
	$("#incontent").focus();	// 전송 후 커서 유지
}

function exportbtn(){
	alert("test");
}