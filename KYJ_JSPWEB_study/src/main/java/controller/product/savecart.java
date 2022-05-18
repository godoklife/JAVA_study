package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/product/savecart")
public class savecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public savecart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("json");
		System.out.println(data);
		try {
			// 1. 통신한 데이터를 JSONArray형으로 형변환
			JSONArray jsonArray	= new JSONArray(data);
			// 2.반복문을 이용한  jsonArray에서 jsonobject 호출
			for(int i=0; i<jsonArray.length(); i++) {
				// 3. jsonarray 배열 내 i번쨰 객체 호출
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				// 4. 해당 객체 내 키를 이용한 벨류값 호출
				System.out.println(jsonObject.get("pname"));
				System.out.println(jsonObject.get("color"));
				System.out.println(jsonObject.get("size"));
				System.out.println(jsonObject.get("amount"));
				System.out.println(jsonObject.get("pprice"));
				System.out.println(jsonObject.get("totalprice"));
				System.out.println(jsonObject.get("point"));
				System.out.println(jsonObject.get("selected"));
			}
			
			
		} catch (Exception e) {System.out.println(e);}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
