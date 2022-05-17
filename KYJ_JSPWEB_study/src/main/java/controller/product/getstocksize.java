package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

@WebServlet("/product/getstocksize")
public class getstocksize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getstocksize() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int pno = Integer.parseInt(request.getParameter("pno"));
		String scolor = request.getParameter("color");
		ArrayList<Stock> list = ProductDao.instance.getStock(pno);
		// 제품별 사이즈와 재고
		// 사이즈 이름 & 재고 리턴
		Map<String, String> map = new TreeMap<String, String>();
		for(Stock s : list) {
			if(s.getScolor().equals(scolor)) {
				if(s.getSamount()==0) {
					map.put(s.getSsize(), "품절");
				}else {
					map.put(s.getSsize(), s.getSamount()+"개");
				}
			}
		}
		System.out.println(map.toString().toString());
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(map);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
