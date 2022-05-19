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
		
		// request, response의 전송 인코딩 타입 : 문자열!!! 제이슨이 아님!!
		response.setCharacterEncoding("utf-8");
			// 1. 응갑 객체 내 한글 인코딩 타입 설정
		response.setContentType("application/json");
			// 2. 응답객체의 전송 형태를 제이슨 형식으로 설정
		response.getWriter().print(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
