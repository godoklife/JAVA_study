

$(function(){
	$.ajax({
		url:'getcart',
		success:function(jsonarray){
			let html="";
			for(let i=0; i<jsonarray.length; i++){
				
				html+= 
				'<tr>'+
				'<td><img width="20%" src="../admin/img/'+jsonarray[i]['pimg']+'"></td>'+
				'<td>'+
					'제품명<br>'+
					'옵션'+
				'</td>'+
				'<td>수량</td>'+
				'<td>금액</td>'+
				'<td><button>X</button></td>'+
			'</tr>'
			}
			$("#carttable").html(html);
		}
	});
});