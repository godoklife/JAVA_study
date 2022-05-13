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
import dto.Category;

@WebServlet("/admin/getcategory")
public class getcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getcategory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인수값 없음, 
		ArrayList<Category> tmp = ProductDao.instance.getcategorylist();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();	// servlet->html 전송 객체 생성
		String html = "";	// html로 던질 문자열
		
		// 6개마다 줄바꿈 처리
		byte index=1;
		for(Category tmp2 : tmp) {
			html += "<input type=\"radio\" name=\"cno\" value=\""+tmp2.getCno()+"\">"+tmp2.getCname();
			index++;
			if(index==6) {
				html+="<br>";
				index=1;
			}
		}
		
		out.print(html);	// html로 문자열 던지기
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
