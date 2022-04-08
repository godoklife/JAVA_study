package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
	import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Servercontrol{	// 이제 FXML과 관련 없는 순수 자바 쏘쓰
	
	
	// 중첩클래스 [ Client ] START
		// 중첩클래스를 사용한 이유?? clientlist를 static으로 선언할 수 없고, new로 객체를 만들면 메모리가 새로 만들어지기 때문에 공유가 안됨.
		// 그래서 메모리 공유를 하려면 중첩클래스를 쓰는 수 밖에 없음.
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
						while(true) {
							InputStream inputStream = socket.getInputStream();
							byte[] bytes = new byte[2048];
							inputStream.read(bytes);
							String msg = new String(bytes);	// 바이트 배열을 문자열로 변환 [ 문자열 클래스 기능 ]
							// 서버가 받은 메시지를 현재 서버에 접속된 모든 클라이언트에게 다시 보내기
							for(Client client : clientlist) {
								client.send(msg);
							}
						}
					} catch (Exception e) {System.out.println("Client class receive method exception : "+e);}
				}
			};
			threadpool.submit(runnable);
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
					} catch (Exception e) {System.out.println("Client class send method exception : "+e);}
				}
			};
			threadpool.submit(runnable);
		}
	}	// Client 중첩클래스 END
	
    //* 서버에 연결된 클라이언트를 저장하는 메서드
    public Vector<Client> clientlist = new Vector<>();	// 접속된 클라이언트들이 저장될 리스트
    	// Vector를 사용하는 이유 ? 동기화를 지원하기 때문 ! -> 멀티쓰래드를 사용해야하는데 동기화를 미지원하면 골때림
    		// Arraylist는 동기화 미지원...
    // * 멀티스레드를 관리해주는 스레드들
    public ExecutorService threadpool;	// 선언만 하고 메모리 할당은 안해줌. 서버스타트 메서드 아랫쪽에 메모리 할당 객체 있음.
    	//ExecutorServiece : 스레드풀 구현 인터페이스
    
    // 1. 서버 소켓 선언S
    ServerSocket serverSocket;
    // 2. 서버 실행 메서드 [ 인수로 IP와 PORT넘버를 받아서 서버소켓 바인딩(생성) ] 
    public void serverstart(String ip, int port) {
    	try {
    		// 1. 서버 소켓 메모리 할당
        	serverSocket = new ServerSocket();
        	// 2. 서버 소켓 바인딩  [ = ip와 port 를 소켓에 설정 ] 
        	serverSocket.bind(new InetSocketAddress(ip, port));
		} catch (Exception e) {System.out.println("Server class serverstart method |serverSocket binding | Execption : "+e);}
    		// 3. 클라이언트의 요청 대기 [ = 멀티스레드를 사용하는 이유? 1. 연결 2. 보내기 3. 받기 -> 동시에 처리하기 위해. ]
    	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept();	// 1. 요청 수락 후에 수락된 소켓을 저장한다.
						clientlist.add(new Client(socket));		// 2. 연결된 클라이언트를 생성 후 리스트에 저장
					}	
				} catch (Exception e) {System.out.println("Server class serverstart method |serverSocket acception | Execption : "+e);}
			}
		};	// 멀티스레드 구현 끝
    	// 스레드풀에 메모리를 초기화 시키기
		threadpool = Executors.newCachedThreadPool();	// 쓰레드풀에 메모리 초기화 [ 할당 ] 
			// 선언 할때 메모리 할당 해줘도 되긴 한데... 서버 켤때 할당해주는게 메모리 사용에는 더 효율적이겠지?
		threadpool.submit(runnable);
    }	// serverstart method END
    // 3. 서버 종료 메서드
    public void serverstop() {
    	// 1. 접속된 모든 클라이언트들의 소켓 닫기
    	try {
    		for(Client client : clientlist) {
        		client.socket.close();
        	}	
    		// 2. 서버 소켓 닫기
    		serverSocket.close();
    		// 3. 스레드풀 닫기
    		threadpool.shutdown();
		} catch (Exception e) {System.out.println("serverstop Exception : "+e);}
    }	// serverstop method END
}	// Servercontrol class END
