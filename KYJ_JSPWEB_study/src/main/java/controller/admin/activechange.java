package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/admin/activechange")
public class activechange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public activechange() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pactive = Integer.parseInt(request.getParameter("pactive"));
		int pno = Integer.parseInt(request.getParameter("pno"));
		byte result = ProductDao.instance.activechange(pno, pactive);
		if(result==0) {
			response.getWriter().print(0);	// 에러 발생시 0 출력
		}else if(result==1) {
			response.getWriter().print(1);	// 정상작동시 1 출력
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
