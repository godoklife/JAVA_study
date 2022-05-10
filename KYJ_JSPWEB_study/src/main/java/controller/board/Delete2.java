package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.Board;

@WebServlet("/board/Delete2")
public class Delete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// *** DB 삭제 전에 파일명 먼저 뺴오기!!
		Board board = BoardDao.instance.getboard2(bno);
		String bfile = board.getBfile();
		
		// 게시글 삭제 실행
		boolean result = BoardDao.instance.delete(bno);
		
	
			//	JAVA에서 HTML 작성하기
			response.setCharacterEncoding("UTF-8");	// 응답 인코딩 타입 : 한글
			response.setContentType("text/html; charset=UTF-8");	// 응답 파일 타입 : HTML
			PrintWriter out = response.getWriter();	// HTML 내보내기 메서드 사용
			
			// 1. HTML 내보내기
//			out.println("<html>");
//			out.println("<body>");
//			out.println("</body>");
//			out.println("</html>");
		if(result) {
			// 
			String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
			File file = new File(uploadpath);
			file.delete();	// 파일 삭제 메써드.
			
			// 2. JS 내보내기
			out.println("<script>");
			out.println("alert('해당 게시물이 삭제 되었습니다.')");
			out.println("location.href='boardlist.jsp'");
			out.println("</script>");
			

			
		}else {
			out.println("<script>");
			out.println("alert('삭제 실패 : 관리자에게 문의하세요...')");
			out.println("history.back();");	// history.back() : 이전페이지로 되돌려 보내기.
			out.println("</script>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
