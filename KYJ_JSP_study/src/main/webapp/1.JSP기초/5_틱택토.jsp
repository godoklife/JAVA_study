<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>틱 택 토 게 임</title>
</head>
<body>

	<%!
		String [] btn = {"O", "O", "O", "O", "O", "O", "O", "O", "O"};
		// 한번 컴파일 되고 다시 실행되지 않음!
	%>
	<%
		// 한번 커파일 되고 계속 반복실행됨!.
		
		Random random = new Random();
		int computer = 0;
		System.out.println(computer);
		
		if(!(btn[computer].equals("O"))){
			System.out.println("test1");	
			while( (btn[computer].equals("O")) ){
				System.out.println("in while");	

				computer = random.nextInt(9);
			}
		}
		
		for(int i=0; i<9; i++){
			if((request.getParameter(i+"") != null && request.getParameter(i+"").equals(i+"") &&
					! (btn[i]=="X") && ! (btn[computer]=="ㅁ"))){
				btn[i] = "X";
				btn[computer]="ㅁ";
				break;
			}
		}
		// 기계의 랜덤픽 받는 부분
		
	%>
	
		<table>
			<tr>
			<% for(int i=0; i<9; i++) {%>
				<td> <form action="5_틱택토.jsp" method="get">
				<input type="hidden" name="<%=i%>" value="<%=i%>">
				<button type="submit"> [ <%=btn[i] %> ] </button> </form>
				</td>
				<% if(i%3==2){ %>
					</tr><tr>
				<% } %>
			<%} %>
			</tr>
		</table>
</body>
</html>