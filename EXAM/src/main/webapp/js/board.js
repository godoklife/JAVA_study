$(document).ready(function(){
	$('#summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        minHeight: 400,	// 최소 높이
        maxHeigh: null,	// 최대 높이
        lang : 'ko-KR'
	});
});

function check(){
	let title = $("#title").val();
	let content = $("textarea#content").val();
	
	if(title==""){
		alert("제목을 입력하세요");
	}else if(content==""){
		alert("내용을 입력하세요");
	}
}