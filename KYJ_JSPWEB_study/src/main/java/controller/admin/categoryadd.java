package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/admin/categoryadd")
public class categoryadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public categoryadd() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cname=request.getParameter("cname");
		byte result = ProductDao.instance.csave(cname);
		if(result==1) {
			response.getWriter().print(1);
		}else if(result==0) {
			response.getWriter().print(0);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
