package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.Board;

@WebServlet("/BoardSave")
public class BoardSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSave() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String writerpassword = request.getParameter("writerpassword");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Board board = new Board(0, title, content, writer, null, writerpassword);
		System.out.println("BoardSave : "+board.toString());
		boolean result = BoardDao.instance.create(board);
		if(result) {
			response.getWriter().print(1);	// 저장성공시 1 맅턴
		}else {
			response.getWriter().print(0);	// 저장실패시 0 리턴
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
