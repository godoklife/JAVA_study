package AAexamples.day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Day26_02_server {
	// 통신용 서버 만들기
		// 1. 서버 소켓 만들기
			// 서버 : 클라이언트에게 정보나 서비스를 제공해주는 컴퓨터.
			// 소켓 : PC간의 통신 종착점.
		// 2. 서버 소켓 바인딩		바인딩 : 무언가에 설정값을 넣어주는것
			// 서버에 ip 및 port 번호 설
			// ip : 네트웤 상에서 pc를 식별하는 번호
			// port : pc 내 프로그램을 식별하는 번호
			

	
	public static void main(String[] args) {
		
		
		try {
			// 1. 서버 소켓 만들기
			ServerSocket serverSocket = new ServerSocket();
			
			// 2. 서버 소켓 바인딩							// ip주소, port 설정
			serverSocket.bind(new InetSocketAddress("127.168.102.50", 5000));
			
			// 3. 클라이언트의 요청 대기
			while(true) {
				System.out.println("서버 가 연결 대기중입니다.");
				
				// 4. 요청이 있을 경우 수락
				Socket socket = serverSocket.accept();	// 요청 수락
				
				// 5. 수락된 소켓의 정보 확인
				InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("클라이언트와 연결이 성공하였습니다. 연결된 클라이언트의 이름 : \n"+inetSocketAddress.getHostName());
				while(true){
					// 6. 클라이언트에게 테이터 수신하기
					InputStream inputStream = socket.getInputStream();
					byte[] bytes = new byte[1000];
					inputStream.read(bytes);
					System.out.println("받은 메시지 : "+new String(bytes));
					
					// 7. 클라이언트에게 메시지 송신하기
					System.out.print("보낼 메지시를 입력하세요 : ");
					Scanner scanner = new Scanner(System.in);
					String msg = scanner.next();
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(msg.getBytes());
				}
			}
		} catch (Exception e) {System.out.println("서버 클래스 예외 발생 : "+e);}
	}
}
