/*
	JavaScript의 문법
		1. 주석 : java와 동일.
		2. 변수 선언 
			A. var : 변수명 중복 O, 메모리 초기화 O
			B. const : 변수명 중복 X, 메모리 초기화 X [ 상수 -> final과 같은 속성. ]
			C. let : 변수명 중복 X, 메모리 초기화 O [ 일반적인 프로그래밍 언어에서의 변수와 같은 속성 ]
		
		※. JavaScript를 사용하는 주요 이유 : 유효성검사, [ 비동기통신 ]이 가능~!
		
		3. 내장 객체 / 메서드 
			A. alert(변수명 또는 "알릴 내용"); : 알림창 메서드
			B. document.write(메시지2 + "<br>") 	: HTML으로 직접 작성 내용 전송.(JS 형태가 아닌 HTML형태로)
				1) .write("html문 작성")						: HTML문 작성
				2) .getElementById("html 해당 태그의 id명")		: 해당 태그 가져오기
					.innerHTML="해당 태그에 넣을 데이터"			: 해당 테그에 데이터 넣기
					.textContent = "해당 테그에 넣을 데이터"		: 마찬가지.
					.style.css속성명 = 속성값					: 해당 테그에 css 속성 적용
					.value									: 해당 테그의 값 빼오기.
			C. console.log(메시지1); : 브라우저 내 F12의 콘솔 창에 변수 내용 출력.
			
		4. 반복문 / 제어문 ->> 자바와 거의 비슷
			A. for(초기값; 조건식; 증감문){ 실행문 }
			B. int(논리식) { 실행문 }

*/
 
var 메시지1 = "test";
//	alert(메시지1);
	console.log(메시지1);
var 메시지1 = "자바 var 중복변수";
//	alert(메시지1);
	
	// 변수 var : 중복 가능, 메모리 초기화 가능.

const 메시지4 = "자바 const 변수	";
//	alert(메시지4);
//	메시지4 = "const변수인 메시지4의 값을 변경합니다.";
	// 변수 const : 고정값, 중복 불가, 메모리 초기화 불가. [ 상수 ]
	
let 메시지5 = "JavaScript let 변수";
//	alert(메시지5);
	
//let 메시지5 = "JavaScript let 변수의 중복 테스트";
//	alert(메시지5);
	// let는 변수명 중복 불가능. 그러나 값은 변경 가능함.
	
let tag1 = document.getElementById("spantag1");
tag1.innerHTML = "js에서 작성된 문자";

let 가격 = 500;	// 변수 선언
let 수량 = 10;	// 변수 선언
let 총가격 = 가격 * 수량;	// 변수 연산
let tag2 = document.getElementById("spantag2");
tag2.innerHTML=총가격;

// 함수 = 메서드
	// js : function 함수명(인수){ 실행문 }
	// java : 반환타입 함수명(인수){ 실행문 }
		// 반환타입과 function 말고는 차이가 없음.
function 함수1(){
	let 색상배열 = ['red', 'white', 'black'];
	// 배열의 선언 : let 배열명 = [값1, 값2, 값3~~~]
		// 자바보다 조금 더 간편함. 
	// 배열의 호출 : 
	
	let tag3 = document.getElementById("spantag3");
	tag3.textContent = 색상배열[0];
	tag3.style.color = 색상배열[0];
	document.body.style.backgroundColor = "gray";
}

function 함수2(){	// 메서드의 선언
	// while
	let i=1;	// 변수의 선언
	while(i<=10){	// 반복문 : 10회 반복
		let tag4 = document.getElementById("orderlist1");
		tag4.innerHTML += "<li> 반복횟수 : "+i+"</li>";
		//	 자바와 똑같이 += : 대입연산자 사용 가능.
		i++
	}
	// for
	let j = 0;	// 변수의 선언
	let 제품배열 = ["갤럭시", "아이폰", "화웨이", "샤오미"]; 	// 배열의 선언
	for(j; j<제품배열.length; j++){	// 자바와 마찬가지로 배열.length 사용 가능!
		let tag5= document.getElementById("orderlist2");
		tag5.innerHTML += "<li> 반복횟수 : "+제품배열[j]+"</li>";
	}
	
}

function 함수3() {	// 누를때마다 콜라가 추가됨.
//	let 제품명 = "콜라";
	let 제품명 = document.getElementById("input1").value;	// 인풋박스의 값을 가져와서 제품명 변수에 저장.
	document.getElementById("orderlist3").innerHTML += "<li>"+제품명+"</li>";
	
}

function 함수4() {
	document.getElementById("orderlist3").innerHTML = "";
}
	
function 함수5( 이름, 성별) {	// 인수 받을때 자료형 필요 X
	document.writeln("입력하신 이름은 : "+이름);	// writeln은 자바에서의 println과 같음.
	document.writeln("입력하신 성별은 : "+성별);
	
	
}



























