let json;

$(function(){
	getlist();
});

function getlist(){
	let today = (dateFormat(new Date())).split(" ",2)[0];
	let html=	'<tr>'+
				'<th width="5%">글번호</th><th width="50%">제목</th>'+
				'<th width="20%">작성자</th><th width="20%">작성일</th>'+
				'<th width="5%">0</th>'+
				'</tr>';
	$.ajax({
		url:"../GetBoardList",
		data:{},	// 나중에 검색기능 추가할때 사용
		success:function(args){
			json=args;
			for(let i=json.length-1; i>=0; i--){
				if(today==json[i]['boarddatetime'].split(" ",2)[0]){
					html +=	'<tr>'+
							'<td>'+json[i]['boardnumber']+'</td><td><a href="boardview.jsp?boardnumber='+json[i]['boardnumber']+'">'+json[i]['boardtitle']+'</a></td>'+
							'<td>'+json[i]['boardwriter']+'</td><td>'+json[i]['boarddatetime'].split(" ",2)[1]+'</td>'+
							'<td>0</td>'+
						'</tr>';
				}else{
				html +=	'<tr>'+
							'<td>'+json[i]['boardnumber']+'</td><td><a href="boardview.jsp?boardnumber='+json[i]['boardnumber']+'">'+json[i]['boardtitle']+'</a></td>'+
							'<td>'+json[i]['boardwriter']+'</td><td>'+json[i]['boarddatetime']+'</td>'+
							'<td>0</td>'+
						'</tr>';
				}
			}
			$("#boardlist").html(html);		
		}
	})
};

function dateFormat(date) {
        let month = date.getMonth() + 1;
        let day = date.getDate();
        let hour = date.getHours();
        let minute = date.getMinutes();
        let second = date.getSeconds();

        month = month >= 10 ? month : '0' + month;
        day = day >= 10 ? day : '0' + day;
        hour = hour >= 10 ? hour : '0' + hour;
        minute = minute >= 10 ? minute : '0' + minute;
        second = second >= 10 ? second : '0' + second;

        return date.getFullYear() + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
}