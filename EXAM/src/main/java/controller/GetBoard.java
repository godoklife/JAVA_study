package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.BoardDao;
import dto.Board;

@WebServlet("/GetBoard")
public class GetBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBoard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardnumber = Integer.parseInt(request.getParameter("boardnumber"));
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().print(BoardDao.instance.getBoard(boardnumber));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
