package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Order;

@WebServlet("/product/saveorder")
public class saveorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public saveorder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mid = (String)request.getSession().getAttribute("login");
		int mno = MemberDao.instance.getmno(mid);
		
		String json = request.getParameter("orderjson");
		try {
			System.out.println("saveorder_servlet_1");
			JSONObject jsonObject = new JSONObject(json);
			System.out.println("saveorder_servlet_2");
			String ordername = jsonObject.getString("ordername");
			System.out.println("saveorder_servlet_3");
			String orderphone = jsonObject.getString("orderphone");		
			System.out.println("saveorder_servlet_4");
			String orderaddress = jsonObject.getString("orderaddress");
			System.out.println("saveorder_servlet_5");
			System.out.println(jsonObject.getInt("ordertotalpay"));
			int ordertotalpay = jsonObject.getInt("ordertotalpay");
			String orderrequest = jsonObject.getString("orderrequest");
			System.out.println("saveorder_servlet_6");
			Order order = new Order(0, null, ordername, orderphone, orderaddress,
					ordertotalpay, 0, orderrequest, 0, mno);
			System.out.println("saveorder_servlet_7");
			System.out.println(order.toString());
			
			// 1. 주문의 DB 처리
			boolean result = ProductDao.instance.saveorder(order);
			if(result) {
				response.getWriter().print(1);
			}else {
				response.getWriter().print(0);
			}
			
			
			// 2. 주문 상세 DB 처리 
			
		} catch (Exception e) {System.out.println("saveorder_servlet_exception : "+e);}
		
										
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
