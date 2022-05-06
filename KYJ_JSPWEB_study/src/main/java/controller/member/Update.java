package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.Member;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		
		
			
			
		int mno = Integer.parseInt(request.getParameter("mno"));
//		String mid = request.getParameter("mid");
		String mphone = request.getParameter("mphone");
		String mname = request.getParameter("mname");
		String email = request.getParameter("memail");
		String emailaddress = request.getParameter("memailaddress");
			String memail = email+"@"+emailaddress;
		String address1 = request.getParameter("maddress1");
		String address2 = request.getParameter("maddress2");
		String address3 = request.getParameter("maddress3");
		String address4 = request.getParameter("maddress4");
			String maddress = address1+"_"+address2+"_"+address3+"_"+address4;
		
			Member member;
		if(oldpassword.equals("") || newpassword.equals("")) {	// 만약 패스워드 변경이 없으면
			member = new Member(mno, null, null, mname, mphone, memail, maddress, mno, null);
		}else {
			// 기존 패스워드 체크
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("login");
			boolean result = MemberDao.instance.passwordcheck(mid, oldpassword);	// 메서드 만들어야함.
			if(result) {	// 기존 패스워드가 DB것과 동일하면
				member = new Member(mno, null, newpassword, mname, mphone, memail, maddress, mno, null);
			}else {			// 그렇지 않으면
				response.sendRedirect("/KYJ_JSPWEB_study/member/update.jsp?result=3");
				return;
			}
		}
		boolean result = MemberDao.instance.update(member);
		if(result) {
			response.sendRedirect("/KYJ_JSPWEB_study/member/update.jsp?result=1");
		}else {
			response.sendRedirect("/KYJ_JSPWEB_study/member/update.jsp?result=2");
		}
	}

}
