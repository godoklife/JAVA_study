$("#color_select").change(function(){
	let color=$("#color_select").val();
	let pno=$("#pno").val();
	$.ajax({
		url:"getstocksize",
		data:{"pno":pno, "color":color},
		success:function(args){
			args=args.replace("{","");
			let list=args.replace("}","");
			let itemlist = list.split(", ");
			let html="";
				html+="<option value=''>-[필수]용량 선택-</option>";
			for(let item of itemlist){
				let size = item.split("=")[0];
				let amount = item.split("=")[1];
				html += "<option value="+size+">"+size+"</option>"
			}
			$("#size_select").html(html);
			//$("#size_select").append('<option>12</option>');	// 기존값을 날리지 않고 누적추가
		}
	});
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 천단위 구분 쉼표 -> 정규표현식(언어)  
			vs js( 내장메소드 : toLocaleString() )
					데이터.toLocaleString( undefinde , { maximumFractionDigits : 소수점 표시단위 } ) 
	*/
		/*
			\d{3} : 정수 3자리 패턴 
			(\d{3})+ : 앞 표현식 반복 대응 
			(\d{3})+(?!\d) : 표현식 뒤에 정수가 없는경우 [ 정수 끝 찾기 ]
			\B( ?= (\d{3})+(?!\d) ) : 문자가 없으면 뒤에 표현식 실행
		
			/^ : 정규표현식 시작 
			패턴 : ( 앞 = 문자 존재 ) , ( 뒤 = 문자열 3글자 )
					(\d {3}) = 정수3자리 
			\d : 정수    [0-9]{3}   <--->  (\d{3} )
			{ } : 길이
			+ : 앞 표현식 반복되는 부분 대응 
			x(?!y) : x 뒤에 y가 없는경우(false)  : (?!\d) : 앞에 패턴이 없는 경우 ( 뒤에 숫자가없는경우 )
			x(?=y) : x 뒤에 y가 있는경우(true)  : ( ?= (\d{3})+(?!\d) )
			\B : 문자 경계선  ( 문자제외 )   :  \B( ?= (\d{3})+(?!\d) )
			
			/g : 전역검색 [ 모든 곳 검색 ]
			/i : 대소문자 구분없는 검색 
		*/

			// 데이터.toString().replace( '정규표현식' , ',' );

let comm = "/\B( ?= (\d{3})+(?!\d))/g";


	// js 배열 
		// let 배열명 = [ ] : 배열의 선언
			// 추가 : push -> 배열 내 마지막 인덱스 값 추가
			// 제거 : pop -> 배열 내 마지막 인덱스 값 삭제
let dupcheck=[];
$("#size_select").change(function(){
	let pname=$("#product_name").html();
	let color=$("#color_select").val();
	let size = $("#size_select").val();
	let amount = $("#amount").val();
	let pprice = $("#pprice").val();
	// 선택옵션 중복체크	라인
	let selected= color+size;
	selected=selected.replace("/","_")	// deletechoice id값에서 슬래시때문에 자꾸 깨져서 replace 해주는것.
	if(amount==null){
		amount=1;
	}
	let object={	// JS식 객체 선언 방법
		pname : pname,
		color : color,
		size : size,
		amount : amount,
		pprice : pprice,
		totalprice : pprice*amount,
		point : (pprice*amount)*0.01,
		selected :selected
	}
	for(let i=0; i<dupcheck.length; i++){
		if(dupcheck[i].selected==selected){
			alert("이미 선택한 옵션 입니다.");
			return;
		}
	}
	///////////////////////////////////
	
	if(color==""){
		return;
	}
	if(size==""){
		return;
	}
	dupcheck.push(object);
	choiceshow();
});
function choiceshow(){
	/* 테이블에 추가할 내용물 */
	let html='<tr><th width="60%">상품명</th><th width="25%">상품수</th><th width="15%">가격</th></tr>';
	/* 배열 내 모든 객체의 정보를 html화 하기 */
	for(let i=0; i<dupcheck.length;i++){
		dupcheck[i].totalprice= dupcheck[i].pprice * dupcheck[i].amount;
		dupcheck[i].point = dupcheck[i].totalprice*0.01;
		
		html+='<tr>'+
				'<td>'+dupcheck[i].pname+" "+dupcheck[i].color+" "+" "+dupcheck[i].size+'</td>'+
				'<td>'+
					'<div class="row g-0">'+
						'<div class="col-md-7">'+
							'<input readonly id="amount'+i+'" class="amount_input" value="'+dupcheck[i].amount+'">'+
						'</div>'+
						'<div class="col-md-4">'+
							'<button id="amount_up_btn" class="amount_btn" onclick="amount_increase('+i+')">+</button>'+
							'<button id="amount__down_btn" class="amount_btn" onclick="amount_decrease('+i+')">-</button>'+
						'</div>'+
						'<div class="col-md-1" style="text-align:center;">'+
							'<button id="cancel_btn" class="cancel_btn" onclick="deletechoice('+i+')">X</button>'+
						'</div>'+
					'</div>'+
				'</td>'+
				'<td class="jsprice">'+dupcheck[i].totalprice.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",")+'원<br><hr>'+
				'포인트 '+dupcheck[i].point.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",")+' 점</td><br>'+
			'</tr>';	
	}
	$("#select_table").html(html);	
	/* 객체 내 총 합계 */
	let total_price= 0;
	let total_amount = 0;
	for(let i=0; i<dupcheck.length; i++){
		total_price +=dupcheck[i].totalprice;
		total_amount += dupcheck[i].amount;
	}
	$("#total_price").html( total_price.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",")+"원("+total_amount+"개)");
	
}

function deletechoice(i){
	dupcheck.splice(i,1);
	choiceshow();
}
// 해당 인덱스의 상품수 증가 펑션
function amount_increase(i){
	let pno = $("#pno").val();
	$.ajax({
		url:"getamount",
		data:{'pno':pno, 'color':dupcheck[i].color, 'size':dupcheck[i].size},
		success:function(maxstock){
			if(maxstock==0){
				alert("재고가 없습니다.")
			}else if(dupcheck[i].amount>=maxstock){
				alert("재고가 부족합니다.");
				return;
			}else{
				dupcheck[i].amount ++;	// 해당 인덱스의 객체 내 수량 증가 처리
				choiceshow();
			}
		}
	});
}
// 해당 인덱스의 상품수 감소 함수
function amount_decrease(i){
	if(dupcheck[i].amount==1){
		alert("수량을 더이상 줄일수 없습니다.");
		return;
	}
	dupcheck[i].amount --;	// 말 안해도 알제??
	choiceshow();
}

// 찜하기 버튼을 눌렀을 때 함수
function saveplike(mid){
	if(mid=='null'){
		alert("로그인이 필요한 기능 입니다.");
		return;
	}
	let pno = $("#pno").val();
	$.ajax({
		url:"savelike",
		data:{'mid':mid, 'pno':pno},
		success:function(args){
			if(args==1){
				alert("찜 목록에 저장했습니다.");
			}else if(args==2){
				alert("찜 목록에서 삭제했습니다.");
			}else if(args==3){
				alert("SQL 예외 발생");
			}
			$("#btnbox").load(location.href+" #btnbox");	
			}
		});
}

// 현재 선택된 제품들을 장바구니에 담기
function savecart(mno){
	if(mno==0){	//MemberDao.instance.getmno(mid) mid가 널이면 예외나면서 0을 리턴함.
		alert("비회원은 장바구니 사용불가");
		return;
	}
	if(dupcheck.length<=0){
		alert("선택된 상품이 없습니다.");
		return;
	}
	
	// 서블릿에게 배열 보내기
		// JSON
			// JS : JSON API 내장
				// JSON.stringify() : 배열이나 객체를 JSON 형식으로 변환하는 메서드
			// JAVA : API 내장 X ->> 별도 임포트 필요
	$.ajax({
		url:"savecart",
		data:{'json':JSON.stringify(dupcheck), 'pno':$("#pno").val()},
		success:function(args){
			if(args==-1){
				alert("장바구니에 담았습니다.");
			}else{
				alert("장바구니에 담는 중 문제가 발생했습니다 : "+(args+1)+"번 상품");
			}
			
		}
		
	});
};





















