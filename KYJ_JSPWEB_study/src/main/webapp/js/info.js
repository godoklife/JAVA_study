function passwordcheck(mid){
	
	// * jquery 문법
	let mpassword = $("#mpassword").val();
	// * javascript 문법으로 작성할 경우??
	// let mpassword = document.getElementById("mpassword").value;
	
	// 비동기 통신 = jquery에서 제공해주는 통신 메서드
		// [js(view) ->> java(controller)]
	// $.ajax({ 속성명 : 속성값, 속성명2 : 속성값2 });
	
	$.ajax({
		url : "../Passwordcheck",	// 어디로 보낼건가?
		data : {"mid" : mid, "mpassword" : mpassword},	// 보낼 데이터 {""받는측에서 인지하는 변수명" : 보내는측에서 보낼 변수명}
		type : "POST",	// POST로 던져줄 것인가? GET으로 던져줄 것인가? 지정
		success : function(result){	// 통신 성공시 리턴값을 result에 담음.
			if(result == 1){
				alert("리턴값 1 회신 : 입력값과 DB값 일치.");
				$("#checkmsg").html("정말 탈퇴하시겠습니까?");
				$("#mpassword").css("display" , "none"); // 제이쿼리 css 적용  [ .css( "속성명" , "속성값") ]
				$("#btndelete").css("display" , "block");
				$("#btncofirm").css("display" , "none");
			}else{
				alert("리턴값 0 회신 : 입력값과 DB값 다름");
				$("#checkmsg").html("동일한 패스워드가 아닙니다.");
			}
		}
	});	// $.ajax END
}

function mdelete( mid ){
	$.ajax({
		url : "../Delete",
		data : { "mid" : mid } , 
		type : "get",
		success : function( result ){
			if( result == 1 ){
				alert("회원탈퇴 완료 되었습니다.");
				// js에서 하이퍼링크 [ 페이지연결 ]
				// <a href="경로">
				// location.href="경로">
				location.href="/KYJ_JSPWEB_study/Logout"; // 서블릿 
			}else{
				location.href="https://www.google.com/asd"; // 페이지
			}
		}
	});
	
}