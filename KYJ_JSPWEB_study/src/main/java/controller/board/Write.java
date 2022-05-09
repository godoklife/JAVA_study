package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		// 파일 저장 경로	->> 백슬레시를 슬래시로 바꿔줘야 함.
			// 1. 이클립스 프로젝트 경로
//		String uploadpath = "C:/Users/XPS15/git/JAVA_study/KYJ_JSPWEB_study/src/main/webapp/board/upload";
			// 2. 탐켓 폴더
				// 서버 경로 찾기 : request.getSession().getServletContext().getRealPath("찾을 폴더의 프로젝트명을 제외한 최상단부터의 경로");
		System.out.println("현 서버의 경로 : "+request.getSession().getServletContext().getRealPath("/board/upload"));
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload");
		
		// 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(request, uploadpath, 1024*1024*20, "UTF-8", new DefaultFileRenamePolicy());
													// 요청방식,	파일 저장 경로,	파일 최대 크기,		파일명 인코딩 타입,	동일한 파일명이 있을 경우 자동 이름 변환
			// cos 라이브러리를 쓰면 multipartrequest 객체를 만든 뒤 request 대신 해당 객체를 사용하면 됨.
		
		// 데이터 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		// 첨부파일 패스 가져올때는 getParameter 대신 getFilesystemName("name") 사용.
			HttpSession session = request.getSession();	// login 세션에 mid 하나만 들어있음.
			String mid = (String)session.getAttribute("login");
		int mno = MemberDao.instance.getmno(mid);
		
		// 객체화
		Board board = new Board(0, btitle, bcontent, mno, 0, null, bfile, mid);
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
