package controller.chatting;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.TeamchattingDTODAO;

@WebServlet("/chatting/teamchattingview")
public class teamchattingview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public teamchattingview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("통신성공");
		ArrayList<TeamchattingDTODAO> chatlist = TeamchattingDTODAO.instance.loadchat();
		HttpSession session = request.getSession();
		session.setAttribute("chatlist", chatlist);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
