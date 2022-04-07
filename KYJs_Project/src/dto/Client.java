package dto;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.Servercontrol;

public class Client {
	// 서버에 접속된 클라이언트의 클래스
	
	// 1. 소캣
	public Socket socket;	// public 이여야 패키지가 달라도 접근이 가능!!!
	
	// 2. 생성자
	public Client(Socket socket) {
		this.socket = socket;
		receive();	// 서버와 연결된 클라이언트 객체가 생성될 때 받는 메서드
	}
	
	// 3. 서버로 메시지 받는 메서드 [ 실행조건 : 서버와 클라이언트가 연결되었을 때 ]
	public void receive() {	
		
		// 멀티스레드의 구현 방법 2가지 - Thread(class), Runnable(interface)
			// 런너블 : run 메서드를 필수적으로 구현해야함.
			
		Runnable runnable = new Runnable() { // 익명 구현 객체
			@Override
			public void run() {
				try {
					InputStream inputStream = socket.getInputStream();
					byte[] bytes = new byte[2048];
					inputStream.read(bytes);
					String msg = new String(bytes);	// 바이트 배열을 문자열로 변환 [ 문자열 클래스 기능 ]
					// 서버가 받은 메시지를 현재 서버에 접속된 모든 클라이언트에게 다시 보내기
					for(Client client : Servercontrol.clientlist) {
						client.send(msg);
					}
					
				} catch (Exception e) {System.out.println("run exception : "+e);}
			}
		};
		
	}
	// 4. 서버가 메시지 보내는 메서드 [ 실행 조건 : 서버가 메시지를 받았을때 ] 
	public void send(String msg) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					// 1. 출력 스레드
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(msg.getBytes());
				} catch (Exception e) {System.out.println(e);}
			}
		};
	}
}
