package controller.board;

import javax.websocket.Session;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

// @WebServlet("클래스로 들어오는 경로 정의");
// @ServerEndpoint("서버소켓 클래스로 들어오는 경로 정의"); ->> 서버 소켓 통신시 사용
@ServerEndpoint("/chatting")
public class Chatting {
	
	/*
	 * 웹소켓 통신에서는 어노테이션(골뱅이)를 따라감.
	 * 메서드명은 인식 안하나 가능하면 동일하게 가자.
	 */
	
	// 0. 접속자 명단
	public static List<Session> clients = new Vector<>();	
		// 동기식 처리를 위해 ArrayList(비동기) 대신 Vector 사용
	
	
	
	
	
	// 1. 소켓 오픈
		// 클라이언트 ->> 서버소켓으로 들어왔을 때
	@OnOpen
	public void OnOpen(Session session) {
		System.out.println("서버 소켓에 유저가 들어왔습니다."+session.toString());
		clients.add(session);	// 해당 세션을 접속 명단에 추가
		System.out.println("현재 들어온 세션들 : "+clients.toString());
	}
	// 2. 소켓 닫기
		// 클라이언트가 나갔을 때 
	@OnClose
	public void Onclose(Session session) {
		clients.remove(session);	// 해상 세션 제거
	}
	
	// 3. 소켓 메시지 보내기
		// 서버소켓 ->> 모든 클라이언트에게 소켓 메시지 전송
	@OnMessage
	public void OnMessage(String msg, Session session) throws IOException{
		System.out.println(session+"의 메시지: "+msg);
		for(Session s : clients) {	// 리스트에 존재하는 세션들에게 반복문을 통해 메시지 보내기
			s.getBasicRemote().sendText(msg);
		}
	}
	
}
