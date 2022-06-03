package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.Member;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Signup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// signup.jsp의 name을 참조함.
    	String id = request.getParameter("mid");
    	String password = request.getParameter("mpassword");
    	String name = request.getParameter("mname");
    	String phone = request.getParameter("mphone");
    	String email1 = request.getParameter("memail");
    	String email2 = request.getParameter("memailaddress");
    		String email = email1+"@"+email2;
    	String address1 = request.getParameter("maddress1");
    	String address2 = request.getParameter("maddress2");
    	String address3 = request.getParameter("maddress3");
    	String address4 = request.getParameter("maddress4");
    		String address = address1+"_"+address2+"_"+address3+"_"+address4;
    	
    	
    	Member member = new Member(0, id, password, name, phone, email, address, 0, null);
    	System.out.println(member.toString());
    	
    	boolean result = MemberDao.instance.signup(member);
    	System.out.println(result);
    	if(result) {
    		response.sendRedirect("/KYJ_JSPWEB_study/member/signupsuccess.jsp");	// success page로 이동
		}else {
			response.sendRedirect("http://www.google.com");	// 가입 실패시 1 전송
		}
    	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

