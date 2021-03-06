package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

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
		System.out.println("입력값 : "+tmp);
		boolean result = MemberDao.instance.idcheck(tmp);
		if(result) {
			System.out.println("아이디체크 서블릿 : 0 출력");
			response.getWriter().print( 0 );	// 아이디 중복값이 없을 경우 0 전송
			return;
		}else {
			System.out.println("아이디체크 서블릿 : 1 출력");
			response.getWriter().print( 1 );	// 중복값이 있을 경우 1 전송.
			return;
		}
	}

	// post방식 정의 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
