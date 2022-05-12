package controller.chatting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TeamchattingDTODAO;

@WebServlet("/chatting/teamchattingwatchdog")
public class teamchattingwatchdog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public teamchattingwatchdog() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result=TeamchattingDTODAO.instance.countchatlist();
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
