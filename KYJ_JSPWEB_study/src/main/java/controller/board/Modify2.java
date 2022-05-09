package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dto.Board;

@WebServlet("/board/Modify2")
public class Modify2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Modify2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1");
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("2");
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/");
		MultipartRequest multi = new MultipartRequest(
				request,						// 요청 방식
				uploadpath,						// 파일 저장 경로
				1024*1024*20,					// 파일 최대 크기
				"UTF-8",						// 파일명 인코딩 타입
				new DefaultFileRenamePolicy()	// 파일명 중복시 생성 정책
				);
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		// 기존 파일명 가져오기
		Board tmp = BoardDao.instance.getboard2(bno);
		String oldfile = tmp.getBfile();
		
		if(bfile==null) {	// 새로운 첨부 파일이 없는 경우
			bfile = oldfile;
		}else {	// 새로운 첨부 파일이 있는 경우!
			String oldfilepath = uploadpath+oldfile;
			File file = new File(oldfilepath);
			file.delete();
		}
		
		Board modifiedboard = new Board(bno, btitle, bcontent, 0, 0, null, bfile, null);
		boolean result = BoardDao.instance.modify(modifiedboard);
		
		response.setCharacterEncoding("UTF-8");	// 응답 인코딩 타입 : 한글
		response.setContentType("text/html; charset=UTF-8");	// 응답 파일 타입 : HTML
		PrintWriter out = response.getWriter();	// HTML 내보내기 메서드 사용
		if(result) {
			out.println("<script>");
			out.println("alert('게시물 작성을 완료했습니다.')");
			out.println("location.href='boardlist.jsp'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('내가 이상한짓 하지 말라 했제')");
			out.println("location.href='../ㅁㄴㅇ.jsp'");
			out.println("</script>");
		}
	}
}
