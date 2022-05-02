// jquery : js 프레임워크
	// $ : 제이쿼리 문법.

	
$(function(){	// jquery 문법. javascript 아님.
	// 문서 실행시 반드시 실행되는 함수
		// js식 id 불러오기			: .getElementById("id")
		// jquery식 id 불러오기		: %("#id")
	
	// 아이디 체크 부분 ->> 키 입력때마다 자동 실행됨.
	$("#mid").keyup( function(){
		
			// 1. HTML 태그 내 값 가져오기
		let mid = document.getElementById("mid").value;
		//	alert(mid);
		// 2. HTML 태그 ID 가져오기
		let idcheck = document.getElementById("idcheck");	// javascript식 문법
		// 정규 표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
		
		let idj = /^[a-zA-Z0-9]{5,15}$/;	// 영어 소문자 또는 대문자 또는 숫자가 포함된 5~15글자 사이 문자열
		
			// /^ : 정규 표현식 시작
			// $/ : 정규 표현식 끝
			// [a-z] : 소문자를 찾음
			// [A-Z] : 대문자를 찾음
			// [0-9] : 숫자를 찾음
			// {최소길이,최대길이} : 최소길이 이상, 최대길이 이하만 가능
				// 정규표현식.test(변수) : 해당 변수가 정규표현식과 동일하면 true, 다르면 false 반환
			
			
		if( !idj.test(mid) ){	// mid가 정규표현식과 다르면
			// id 중복체크
				// 비동기식 동신 : 페이지 전환 없이 java [ controller ]와 통신
//			$.ajax({ 속성 : 속성값, 속성 : 속성값 })	// jquery에서 제공해주는 메서드	
			$.ajax({
				url : "../Idcheck",	// 통신할 경로
					//signup.js를 호출한 페이지인 signup.jsp가 member폴더 내에 있으므로 한번 나와야함.
				data : {"senddata" : mid},	// 해당 경로로 보내는 데이터
				success : function(result){	// 해당 경로로부터 받는 데이터
				
				}
			});	// .ajax END
			
			
			
		}else{
			idcheck.innerHTML = "사용 가능한 아이디 입니다.";
		}
		
	} );	//	$("#mid").keyup( function(){ END
	
	
	$("#mpassword").keyup(function(){
		// 비밀번호 체크
		//	let mpassword = document.getElementById("mpassword").value;	// javascript식 문법
		let mpassword = $("#mpassword").val();	// jquery식 문법
		let mpasswordcheck = $("#mpasswordcheck").val();
		
		let passwordj = /^[a-zA-Z0-9]{5,15}$/
		
		if(passwordj.test(mpassword)){
			
			if(mpassword != mpasswordcheck){
			// 비밀번호와 비밀번호체크가 같지 않다면
			$("#passwordcheck").html("입력하신 비밀번호가 서로 다릅니다.");
			}else {
				$("#passwordcheck").html("사용 가능한 비밀번호 입니다.")
			}
			
		}else{
			$("#passwordcheck").html("영문자,숫자 5~15글자 이내로 작성해주세요.")
		}
	});	// 	$("#mpassword").keyup(function(){ END
	
	$("#mpasswordcheck").keyup(function(){
		// 비밀번호 체크
		//	let mpassword = document.getElementById("mpassword").value;	// javascript식 문법
		let mpassword = $("#mpassword").val();	// jquery식 문법
		let mpasswordcheck = $("#mpasswordcheck").val();
		
		let passwordj = /^[a-zA-Z0-9]{5,15}$/
		
		if(passwordj.test(mpasswordcheck)){
			
			if(mpassword != mpasswordcheck){
			// 비밀번호와 비밀번호체크가 같지 않다면
			$("#passwordcheck").html("입력하신 비밀번호가 서로 다릅니다.");
			}else {
				$("#passwordcheck").html("사용 가능한 비밀번호 입니다.")
			}
			
		}else{
			$("#passwordcheck").html("영문자,숫자 5~15글자 이내로 작성해주세요.")
		}
	});	// 	$("#mpasswordcheck").keyup(function(){ END
	
	// 이름 체크
	$("#mname").keyup(function(){
		let mname = $("#mname").val();
		let namej = /^[가-힣]{2,10}$/;	// 가-힣 : 한글 검사 조건문
		if(namej.test(mname)){
			$("#namecheck").html("사용 가능한 이름 입니다.");
		}else{
			$("#namecheck").html("한글, 2~10자 이내만 가능합니다.");
		}
	});
	
	// 전화번호 유효성 체크
	$("#mphone").keyup(function(){
		let mphone = $("#mphone").val();
		let phonej = /^010-([0-9]{4})-([0-9]{4})$/;
			// 010 - (숫자0~9, 네자리) - (숫자0~9, 네자리) 형식 검사.
		if(phonej.test(mphone)){
			$("#phonecheck").html("사용 가능한 휴대폰번호 입니다.");
		}else{
			$("#phonecheck").html("휴대폰 번호만 입력 가능합니다.");
		}
		
	});
	
	
} );	// $(function(){ END


// 다음 스크립트 API JS
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }














