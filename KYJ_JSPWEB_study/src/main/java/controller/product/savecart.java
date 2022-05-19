package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Cart;
import dto.Stock;

@WebServlet("/product/savecart")
public class savecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public savecart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("json");
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println(data);
		try {
			// 1. 통신한 데이터를 JSONArray형으로 형변환
			JSONArray jsonArray	= new JSONArray(data);
			// 2.반복문을 이용한  jsonArray에서 jsonobject 호출
			
			int error=-1;	// 에러난 인덱스 체크용 변수
			
			for(int i=0; i<jsonArray.length(); i++) {
				// 3. jsonarray 배열 내 i번쨰 객체 호출
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				// 4. 해당 객체 내 키를 이용한 벨류값 호출
//				System.out.println(jsonObject.get("pname"));
//				System.out.println(jsonObject.get("color"));
//				System.out.println(jsonObject.get("size"));
//				System.out.println(jsonObject.get("amount"));
//				System.out.println(jsonObject.get("pprice"));
//				System.out.println(jsonObject.get("totalprice"));
//				System.out.println(jsonObject.get("point"));
//				System.out.println(jsonObject.get("selected"));
				
				// 5. json -> dto
				String mid = (String)request.getSession().getAttribute("login");
				int mno = MemberDao.instance.getmno(mid);
				int amount = Integer.parseInt(jsonObject.get("amount").toString());
				int totalprice = Integer.parseInt(jsonObject.get("totalprice").toString());
				ArrayList<Stock> list =  ProductDao.instance.getStock(pno);
				int sno =0;
				for(Stock s : list) {
					if(s.getSsize().equals(jsonObject.get("size")) 
							&& s.getScolor().equals(jsonObject.get("color"))) {
						sno = s.getSno();
					}
				}
				Cart cart = new Cart(0, amount, totalprice, sno, mno);
				boolean result = ProductDao.instance.savecart(cart);
				if(result==false) {
					error++;
					response.getWriter().print(error);	// 에러난 인덱스 전송
				}
				
				
//				System.out.println("");
//				System.out.println("json->dto : "+cart.toString());
			}
			if(error==-1) {
				response.getWriter().print(-1);
			}
			
			
			
		} catch (Exception e) {System.out.println(e);}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
