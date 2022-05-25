package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.ProductDao;

@WebServlet("/admin/getchart")
public class getchart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getchart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		JSONArray json = ProductDao.instance.getchart(type);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
