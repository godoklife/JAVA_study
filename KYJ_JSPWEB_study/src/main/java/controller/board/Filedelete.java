package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

@WebServlet("/board/Filedelete")
public class Filedelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Filedelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String bfile=BoardDao.instance.getboard2(bno).getBfile();
		
		boolean result = BoardDao.instance.deletefile(bno);
		
		if(result) {	// sql문 실행 성공하면 실제 서버내 파일도 삭제처리.
			
			String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
			File file = new File(uploadpath);
			file.delete();	
			response.getWriter().print("1");	// 성공시 js에게 1 응답
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
