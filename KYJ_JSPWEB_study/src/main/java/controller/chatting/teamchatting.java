package controller.chatting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TeamchattingDTODAO;

@WebServlet("/chatting/teamchatting")
public class teamchatting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public teamchatting() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asdasd");
		request.setCharacterEncoding("utf-8");
		String nickname = request.getParameter("nickname");
		String content = request.getParameter("content");
		String ip = request.getParameter("ip");
		boolean result = TeamchattingDTODAO.instance.savechat(nickname, content, ip);
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
