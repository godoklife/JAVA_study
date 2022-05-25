package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/product/updateorderdetail")
public class updateorderdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateorderdetail() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderdetailno = Integer.parseInt(request.getParameter("orderdetailno"));
		int active = Integer.parseInt(request.getParameter("active"));
		if(ProductDao.instance.cancelorder(orderdetailno, active)) {
			response.getWriter().print(1);	// SQL 저장 성공시 1 응답
		}else {
			response.getWriter().print(0);	// 실패시 0 응답
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
