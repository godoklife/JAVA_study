package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.MemberDao;
import dao.ProductDao;

@WebServlet("/product/getcart")
public class getcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getcart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = (String)request.getSession().getAttribute("login");
		int mno = MemberDao.instance.getmno(mid);
		JSONArray jsonArray = ProductDao.instance.getcart(mno);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArray.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
