package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dto.Member;

@WebServlet("/product/getmember")
public class getmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getmember() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = (String)request.getSession().getAttribute("login");
		int mno = MemberDao.instance.getmno(mid);
		Member member = MemberDao.instance.getmember(mid);
		
		// dto -> json 변환하기
		JSONObject jsonObject = new JSONObject();	// 1. JSON객체 선언
		try {
			jsonObject.put("mno", member.getMno());
			jsonObject.put("mid", member.getMid());
			jsonObject.put("mpassword", member.getMpassword());
			jsonObject.put("mname", member.getMname());
			jsonObject.put("mphone", member.getMphone());
			jsonObject.put("memail", member.getMemail());
			jsonObject.put("maddress", member.getMaddress());
			jsonObject.put("mpoint", member.getMpoint());
			jsonObject.put("mdate", member.getMdate());
			// json -> js 통신 [ ] 
			response.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("application/json");	
				// 설정하지 않으면 json이 아닌 바이트열로 통신하게 됨. 설정 필수
			response.getWriter().print(jsonObject);	// json객체 전송
		} catch (Exception e) {System.out.println(e);}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
