let totalcount;
$(function() {	// 지금 js가 로드되면 한번 실행되고 끝나는 메서드. totalcount 초기화용 아작쓰 실행.
		$.ajax({
		url:"chatting/teamchattingwatchdog",
		success:function(args){
			totalcount=args;
			$.ajax({
				url:"chatting/teamchattingview",
				success:function(args){
					$("#chattingview").load(location.href+" #chattingview");
				}
					// 뭐 전달할것도 없고 받을것도 없음. 그냥 서블릿 한번 실행시키면 끝.
			})
		}
	});
});

function test(ip){
	let content=$("#chatcontent").val();
	let nickname=$("#chatnickname").val();
	$.ajax({
		url:"chatting/teamchatting",
		data:{"content":content, "nickname":nickname, "ip":ip},
		success:function(args){
			if(args==1){
				alert("sucksex");
			}else if(args==2){
				alert("실_____________패");
			}
		}
	});
}




$(function() {
	timer = setInterval(function watchdog(){
		$.ajax({
		url:"chatting/teamchattingwatchdog",
		success:function(args){
			if(args>totalcount){
				totalcount=args;
				$("#chattingview").load(location.href+" #chattingview");
			}else if(args<totalcount){
				totalcount=args;
				alert("DB직접건드리는중");
			}else if(args==0){
				totalcount=args;
				alert("DB에 들어있는게 없음");
			}
		}
	});
	}, "1000"); // 밀리초 만큼 반복 실행 
});

