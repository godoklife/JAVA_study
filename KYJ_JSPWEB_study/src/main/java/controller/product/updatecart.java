package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ProductDao;

@WebServlet("/product/updatecart")
public class updatecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updatecart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String json = request.getParameter("json");	// json 변수 요청
		System.out.println(json);
		try {
			JSONArray jsonArray = new JSONArray(json);	// 일단 String으로 받은 데이터를 json 배열로 형변환
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);	// 객체 채 key를 이용한 value 호출
				int cartno = Integer.parseInt(jsonObject.get("cartno").toString());	// 상동
				int samount = Integer.parseInt(jsonObject.get("samount").toString());
				int totalprice = Integer.parseInt(jsonObject.get("totalprice").toString());
				boolean result = ProductDao.instance.updatecart(cartno, samount, totalprice);
				if(result) {
					response.getWriter().print(1);
				}else {
					response.getWriter().print(0);	// 업데이트 실패시 ->> SQL 예외 발생시 0 리턴
				}
			}
		} catch (Exception e) {System.out.println(e);}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
