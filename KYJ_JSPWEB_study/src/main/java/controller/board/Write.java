package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.MemberDao;
import dto.Board;

@WebServlet("/board/Write")	// member와 분리하기 위해 경로 설정.
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Write() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bfile = request.getParameter("bfile");
		HttpSession session = request.getSession();	// login 세션에 mid 하나만 들어있음.
			String mid = (String)session.getAttribute("login");
		int mno = MemberDao.instance.getmno(mid);
		
		// 객체화
		Board board = new Board(0, btitle, bcontent, mno, 0, null, bfile, null);
		// DB처리
		boolean result = BoardDao.instance.write(board);
		// 결과 처리
		if(result) {
			response.sendRedirect("/KYJ_JSPWEB_study/board/boardlist.jsp");
		}else{
			response.sendRedirect("/KYJ_JSPWEB_study/error.jsp");
		}
	}

}
