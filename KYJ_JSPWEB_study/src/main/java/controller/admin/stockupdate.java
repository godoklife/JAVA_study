package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/admin/stockupdate")
public class stockupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public stockupdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno=Integer.parseInt(request.getParameter("sno"));
		int samount=Integer.parseInt(request.getParameter("samount"));
		
		boolean result = ProductDao.instance.stockupdate(sno, samount);
		if(result) response.getWriter().print(1);// 정상동작시 1 전달
		else response.getWriter().print(0);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
