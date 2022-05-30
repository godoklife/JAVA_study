package controller.board;

import javax.websocket.Session;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONArray;
import org.json.JSONObject;

// @WebServlet("클래스로 들어오는 경로 정의");
// @ServerEndpoint("서버소켓 클래스로 들어오는 경로 정의"); ->> 서버 소켓 통신시 사용
@ServerEndpoint("/chatting/{mid}")	
	// path에 인수를 받을 수 있음.
	// 만약 인수를 여러개 받고싶다면 /chatting/{mid}/{mno}/{mname} 이런식으로.
public class Chatting {
	
	/*
	 * 웹소켓 통신에서는 어노테이션(골뱅이)를 따라감.
	 * 메서드명은 인식 안하나 가능하면 동일하게 가자.
	 */
	
	// 0. 접속자 명단
	public static Map<Session, String> clients = new Hashtable<>();	
		// 동기식 처리를 위해 ArrayList(비동기) 대신 Vector 사용
	
	
	
	
	
	// 1. 소켓 오픈
		// 클라이언트 ->> 서버소켓으로 들어왔을 때
	@OnOpen
	public void OnOpen(Session session, @PathParam("mid") String mid) throws IOException{
		if(mid.equals("null")) return;	// 비 로그인 사용자는 표시 X
		clients.put(session, mid);	// 해당 세션(키)과 접속된 아이디(값)을 저장							// @ServerEndpoint("/chatting/{mid}")의 mid 가져온거
		// 1. 모든 세션의 접속된 아이디를 json형태로 변환
		JSONArray array = new JSONArray();
		for(Session s : clients.keySet()) {	
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("mid", clients.get(s));
				jsonObject.put("type", 2);
				// Map객체.keyset() : map 객체 내 모든 키 호출
				// Map객체.get(키) : map 객체 내 해당 키에 해당하는 값 호출
				array.put(jsonObject);
			} catch (Exception e) {System.out.println(e);}
		}
		// 2. 전송 
		for(Session s : clients.keySet()) {
			s.getBasicRemote().sendText(array.toString());
		}
		
		
	}
	// 2. 소켓 닫기
		// 클라이언트가 나갔을 때 
	@OnClose
	public void Onclose(Session session, @PathParam("mid") String mid) throws IOException{
		clients.remove(session);	// 해당 세션 제거
		
		JSONArray array = new JSONArray();
		for(Session s : clients.keySet()) {	
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("mid", clients.get(s));
				jsonObject.put("type", 2);
				array.put(jsonObject);
			} catch (Exception e) {System.out.println(e);}
		}
		// 2. 전송 
		for(Session s : clients.keySet()) {
			s.getBasicRemote().sendText(array.toString());
		}
		
	}
	
	// 3. 소켓 메시지 보내기
		// 서버소켓 ->> 모든 클라이언트에게 소켓 메시지 전송
	@OnMessage
	public void OnMessage(String msg, Session session) throws IOException{
		
		for(Session s : clients.keySet()) {	
			// 리스트에 존재하는 세션들에게 반복문을 통해 메시지 보내기
			// map객체.keyset() : 모든 키를 호출
			s.getBasicRemote().sendText(msg);
		}
	}
	
}
