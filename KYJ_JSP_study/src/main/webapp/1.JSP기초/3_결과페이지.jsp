<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <!--  
    
    	전 페이지로부터(3_제어문.jsp) request!!
    	request : 서블릿에서 제공해주는 내장 객체 ( 미리 정의, 선언되어진 객체.)
    	request.getParameter("요청할 변수의 name");
     -->
     
     <%
     
     	String 이름 = request.getParameter("name");
     	String 색상 = request.getParameter("color");
     	System.out.println("이름 : "+이름);
     	System.out.println("색상 : "+색상);
     	
     	// 제어문도 작성이 가능하네??
     	boolean admincheck=true;
     	if(!(이름.equals("관리자"))){
     		admincheck=false;
     	}
     	int 반복횟수 = Integer.parseInt(request.getParameter("number"));
     		// request.는 String형 으로만 리턴한다!!!! -> Integer.parseInt 필요함.
     %>
     
<html>
<head>
	<style type="text/css">
	
	*{
		background-color: <%=색상%>
	}
	#star{
		font-size: 10px;
	}
	</style>
</head>
	<body>
		작성한 이름 : <%=이름 %> <br>
		선택한 색상 : <%=색상 %> <br>
		현재 보이는 페이지는 3_결과페이지.jsp입니다.
		
		<!--  제어문 -->
		<%
			if(admincheck == true){
			// 자바 끝!!
		%>
		<div> <h1> YOU ARE ADMINISTRATOR </h1></div>		
		<%
			}
		%>
		<!--  반복문 -->
		<%
			for(int i=0; i<반복횟수; i++){
				for(int j=0; j<=i; j++){
		%>
				<span id="star">★</span>	

			<%
				}
			%>
		<br>				
				
		<%
			}
		%>
		
		
		
	</body>
</html>