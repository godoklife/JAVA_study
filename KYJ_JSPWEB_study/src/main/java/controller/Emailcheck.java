package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

@WebServlet("/Emailcheck")
public class Emailcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Emailcheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String emailString = request.getParameter("email");
		boolean result = MemberDao.instance.emailcheck(emailString);
		if(result) {
			System.out.println(result);
			response.getWriter().print( 0 );	// 중복값이 없으면 0 반환
			return;
		}else {
			System.out.println(result);
			response.getWriter().print( 1 );	// 중복값이 있으면 1 반환
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
