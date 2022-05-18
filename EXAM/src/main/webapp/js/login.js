function login(){
	let id = $("#id").val();
	let password = $("#password").val();
	
	if(id!="" && password!=""){
		location.replace("main.jsp?id="+id);
	}
}