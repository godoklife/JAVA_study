package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Product;

@WebServlet("/admin/getproduct")
public class getproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getproduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		int cno = Integer.parseInt(request.getParameter("cno"));
		ArrayList<Product> tmp = ProductDao.instance.getproductlist();
		String html="";
		PrintWriter out = response.getWriter();
		if(type!=null && type.equals("option")) {
			for(Product tmp2 : tmp) {
				if(tmp2.getCno()==cno) {
					html += "<option value=\""+tmp2.getPno()+"\">"+tmp2.getPname()+"</option>";
				}
			}
		}
		out.print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
