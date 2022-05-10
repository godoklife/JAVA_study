package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

@WebServlet("/board/Replymodify")
public class Replymodify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Replymodify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String rcontent = (String)request.getParameter("rmodcontent");
		int rno = Integer.parseInt(request.getParameter("rno"));
		boolean result = BoardDao.instance.replymodify(rcontent, rno);
		if(result) response.getWriter().print(1);
			else response.getWriter().print(2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
