package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.MemberDao;
import dto.Reply;

@WebServlet("/board/Rereplywrite")
public class Rereplywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rereplywrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int rindex = Integer.parseInt(request.getParameter("rno"));
			// rindex : 어떤 덧글의 대댓글인지 식별하기 위한 번호 ->> 부모 덧글번호
		int bno = Integer.parseInt(request.getParameter("bno"));
		String rcontent = (String)request.getParameter("rrcontent");
		String mid = (String)request.getSession().getAttribute("login");
			int mno = MemberDao.instance.getmno(mid);
		Reply reply = new Reply(0, rcontent, null, rindex, bno, mno, null);
		boolean result = BoardDao.instance.replywrite(reply);
		if(result) response.getWriter().print("1");	// 성공시 1 리턴
		else response.getWriter().print("2");	// 실패시 2 리턴
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
