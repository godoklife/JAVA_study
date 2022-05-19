

$(function(){
	
	$.ajax({
		url:'getcart',
		data:{},
		success:function(args){
			alert(args);
		}
		
	});
});