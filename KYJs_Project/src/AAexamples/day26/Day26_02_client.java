package AAexamples.day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day26_02_client {

	public static void main(String[] args) {
		
		// 1. 일반 소켓 만들기	(서버가 아니기에)
		Socket socket = new Socket();
		
		
		try {
			while(true) {
				// 2. 서버 소켓으로 연결하기
				socket.connect(new InetSocketAddress("127.168.102.50", 5000));
				System.out.println("서버와 연결 성공.");
				while(true) {
					// 3. 서버에 데이터 송신하기 : 스트림을 이용한 외부 네트워크 통신
					System.out.println("서버에게 보낼 메시지 입력 : ");
					Scanner scanner = new Scanner(System.in);
					String msg = scanner.next();
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(msg.getBytes());
					
					// 4. 서버로부터 메시지 수신하기
					InputStream inputStream = socket.getInputStream();
					byte[] in = new byte[1024];
					inputStream.read(in);
					System.out.println("서버로부터 받은 메시지 : "+new String(in));
					
				}
			}	
		}catch(Exception e) {System.out.println("클라이언트 예외 발생 : "+e);}
	}
}
