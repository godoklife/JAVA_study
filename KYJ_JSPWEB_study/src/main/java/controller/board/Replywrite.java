package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import dao.BoardDao;
import dao.MemberDao;
import dto.Reply;

@WebServlet("/board/Replywrite")
public class Replywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Replywrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String rcontent = (String)request.getParameter("rcontent");
		String mid = (String)request.getSession().getAttribute("login");
		int mno= MemberDao.instance.getmno(mid);
		// 객체화
		Reply reply = new Reply(0, rcontent, null, 0, bno, mno, null);
		// DB 처리
		boolean result = BoardDao.instance.replywrite(reply);
		if(result) {
			response.getWriter().print("1");	// 성공시 1 응답
		}else {
			response.getWriter().print("2");
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
