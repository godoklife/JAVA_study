<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- jsp : html과 java를 동시에 작성할 수 있는 파일 -->
		<!--  html : <마크업 language> / java 태그 필요 -->
		<h3> 선언문 태그 : 변수 생성 ->> 메모리 할당 [ 변수 생성 O, 객체 선언 O, 클래스 정의 O, 메서드 정의 X, 함수 정의 O]</h3>
		<h5> 그러나 선언문 태그는 보통 mvc모델에서 m으로 빼기 때문에 쓸 일이 거의~~~ 없음.</h5>
		<h3> 스크립트 태그 : 변수 생성 ->> 메모리 할당 [ 변수 생성 O, 객체 선언 O, 클래스 정의 O, 메서드 정의 O, 함수 정의 X]</h3>
		<h3> 표현식 태그 : 메모리 호출</h3>
		
		<%!
			// <%! 느낌표가 들어간 부분은 [ 선언문 작성란. ] 
			int 변수1 = 10;
			Date date1 = new Date();
			// System.out.println("JSP 파일에서 작성된 코드!! (1)");	// 컴파일 에러 발생.
			int 함수1() {
				return 1;
			}
			class 클래스1{				// 사용자 정의 클래스 생성 가능.
				String 필드1 = "유재석";
			}
			
			클래스1 객체1 = new 클래스1();	// 사용자 정의 클래스 객체 생성 가능.
		%>
		<% 
			// 자바 언어가 작성될 수 있는 공간. [ 스크립트 작성란. ]
			int 변수2 = 20;
			Date date2 = new Date();
			System.out.println("JSP 파일에서 작성된 코드!! (2)");
			System.out.println("JSP 파일에서 생성된 객체 : (2) : " +date2);
			//int 함수2(){
			//	return 2;
			//}
			class 클래스2{
				String 필드2 = "박명수";
			}
			
			클래스2 객체2 = new 클래스2();
			
		%>
		
		<!--  여기서부터 다시 HTML 구역 -->
		<h3> 표현식 사용 구역 </h3>
		선언문의 변수 : <%=변수1 %> <br>
		선언문의 객체 : <%=date1 %> <br>
		선언문의 함수 : <%=함수1() %> <br>
		선언문의 사용자 정의 객체 : <%=객체1.필드1 %> <br>
		<hr>
		스크립트문의 변수 : <%=변수2 %>  <br>
		스크립트문의 객체 : <%=date2 %>	<br>
		스크립트문의 함수 : 불가능!!
		스크립트문의 사용자 정의 객체 : <%=객체2.필드2 %>  <br>
		
		

</body>
</html>