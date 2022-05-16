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
import dto.Stock;

@WebServlet("/admin/getstock")
public class getstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getstock() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		String field=request.getParameter("field");
		
		
		ArrayList<Stock> result = ProductDao.instance.getStock(pno);
		String html="";
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(field!=null && field.equals("amount")) {
				// 제품리스트 페이지에서 선택된 색상과 사이즈에 해당하는 재고량 출력 구역
			String scolor = request.getParameter("scolor");
			String ssize = request.getParameter("ssize");
			for(Stock tmp : result) {
				if(tmp.getScolor().equals(scolor) && tmp.getSsize().equals(ssize)) {
					out.print(tmp.getSamount()+","+tmp.getSlastmoddate());
				}
			}
		}else {	// 재품 재고 페이지에서 사용되는 제품별 재고 정보 출력 구역
			for(Stock tmp : result) {
				if(tmp.getPno()==pno) {
					html +=
							"<tr>" +
									"<td> "+tmp.getScolor()+" <td>" +
									"<td> "+tmp.getSsize()+" <td>" +
									"<td> "+tmp.getSamount()+" <td>" +
									"<td>"
									+ "<button onclick=\'showupdate("+tmp.getSno()+")\'>수정</button>"
									+ "<button>삭제</button>"
									+ "<td>" +
								"</tr>";
				}
			}
		}
		out.print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
