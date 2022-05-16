package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import dto.Product;

@WebServlet("/admin/productadd")
public class productadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public productadd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String realpath = request.getSession().getServletContext().getRealPath("/admin/img");
		
		MultipartRequest multi = new MultipartRequest(
				request,	// 요청 타입
				realpath, 	// 저장 위치
				1024*1024*20, 	// 파일 최대 용량 : 1024B*1024B*20 = 20메가바이트
				new DefaultFileRenamePolicy());	// 파일명 중복시 리네이밍 규칙
		
		request.setCharacterEncoding("utf-8");
		String pname = multi.getParameter("pname");

		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount"));
		String pimg = multi.getFilesystemName("pimg");	// 첨부파일은 요청시 multi.getFilesystemName("인수명")
		int cno = Integer.parseInt(multi.getParameter("cno"));
		
		Product product = new Product(0, pname, pprice, pdiscount, 0, pimg, cno);
		byte result = ProductDao.instance.psave(product);
		if(result==0) {
			response.getWriter().print(0);
		}else if(result==1) {
			response.getWriter().print(1);
		}
	}

}
