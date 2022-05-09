package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/Filedown")
public class Filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Filedown() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bfile= request.getParameter("bfile");
		
		// 서버에서 해당 파일 찾기 [ 서버 : 탐켓 내 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload"+"\\"+bfile);
		System.out.println(uploadpath);
		
		// 파일의 객체화
		File file = new File(uploadpath);
		// 다운로드 형식
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(bfile,"UTF-8")+";");
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// 아래 코드는 실행되지 않음 : response.setHeader 때문에.
			// 아래 코드들은 이미지 파일 읽어서 웹페이지에 출력하는 내용임.
		
							// 다운로드 형식 HTML		// 다운로드 화면에서 표시할 파일명
		// 바이트 형식으로 내보내기 : 통신 준비
			// 서버(탐켓)가 PC에 있는 파일을 스트림으로 가져오는 단계
		BufferedInputStream instream = new BufferedInputStream(new FileInputStream(file));
			// 1. 바이트 배열 필요
		byte[] bytes = new byte[(int)file.length()];	// 파일의 크기 만큼 바이트 배열 선언
			// 2. 파이트 읽어오기
		instream.read(bytes);
		// 출력스트림
			// 서버가 PC에 있는 파일을 스트림으로 읽었고, 이제 내보내는 단계.
				// response : (서블릿)웹 응답 객체
		BufferedOutputStream outstream = new BufferedOutputStream(response.getOutputStream());
		outstream.write(bytes);
		
		// 스트림 닫기
		instream.close();
		outstream.close();
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
