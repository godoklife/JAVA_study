let json;
				

$(function(){
	let parameter = location.search;
	getboard(parameter.split("=",2)[1]);
});

function getboard(no){
	
	$.ajax({
		url:"../GetBoard",
		data:{"boardnumber":no},	// 나중에 검색기능 추가할때 사용
		success:function(args){
			json=args
			console.log(json);
				let html =	'<div class="col-md-2">제목 : </div>'+
							'<div class="col-md-10">'+
								'<input class="form-control" type = "text" name = "" value="'+json['boardtitle']+'"><br>'+
							'</div>'+
							'<div class="col-md-2">내용 : </div>'+
							'<div class="col-md-10">'+
								'<textarea class="form-control"  name = "" id = "" rows="10" cols="20">'+json['boardcontent']+'</textarea>'+
							'</div>'+
						'</div>'+
					'</form>';
			$("#vboard").html(html);		
		}
	})
};

function mod(){
	let checkpw = prompt('비밀번호를 입력하세요');
	alert(checkpw);
	
}

function del(){
	
}