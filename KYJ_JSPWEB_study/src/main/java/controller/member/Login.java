package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;


/*
 *	@WebServlet("locale")의 의미
 * 	* 목적 : 서로 다른 언어들간 통신시 된다. VIEW <---> CONTROLLER
 * 	
 */
@WebServlet("/Login")	// 해당 서블릿 위치 정의문. ->> 현재는 최상단에 위치
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form으로부터 POST 받았음!!!");
		// 1. 요청
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		// 2. 객체화 -> 데이타가 적어서 생략함
		// 3. DB처리
		int result = MemberDao.instance.login(mid, mpassword);
		//4. 결과 전달
		if(result==1) {
			HttpSession session = request.getSession();	// 1. Http 내장 세션 호출
			session.setAttribute("login", mid);	// 2. 세션에 값 저장
			session.setMaxInactiveInterval(60*60);	// 세션을 1시간 동안 유지시킴.
			response.sendRedirect("/KYJ_JSPWEB_study/main.jsp");
		}else if(result==2){	// ID 혹은 PW 오류
			response.sendRedirect("/KYJ_JSPWEB_study/member/login.jsp?result=2");
		}else if(result==3){	// DB오류
			response.sendRedirect("/KYJ_JSPWEB_study/error.jsp");
		}
		
		
		doGet(request, response);
	}

}
