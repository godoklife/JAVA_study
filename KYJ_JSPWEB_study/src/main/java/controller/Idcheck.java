package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL : 프로잭트명 / 경로(컨트롤러로 안들어가도 됨.)
@WebServlet("/Idcheck")
public class Idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Idcheck() {
    	super();
    }
    
    // get방식 정의 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String tmp = request.getParameter("senddata");
		// 1. dao를 이용한 해당 id가 있는지 체크
		// 2. 만약에 해당 아이디가 존재하면 1->> ㅁㄴㅇ  2->> ㅁㄴㅇ
		
		
		System.out.println("입력값 : "+tmp);
		
		// 요청할 때 request
		// 응답할 때 response
			// ajax에게 데이터 보내기
		response.getWriter().print(1);	// 
		
		response.getWriter().print(2);	// 
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// post방식 정의 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
