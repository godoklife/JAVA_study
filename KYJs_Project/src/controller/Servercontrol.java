package controller;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dto.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Servercontrol implements Initializable {

    @FXML
    private Button btnserver;

    @FXML
    private TextArea txtserver;
    
    //* 서버에 연결된 클라이언트를 저장하는 메서드
    public static Vector<Client> clientlist = new Vector<>();
    	// Vector를 사용하는 이유 ? 동기화를 지원하기 때문 ! -> 멀티쓰래드를 사용해야하는데 동기화를 미지원하면 골때림
    		// Arraylist는 동기화 미지원...
    // * 멀티스레드를 관리해주는 스레드들
    public static ExecutorService threadpool;	// 선언만 하고 메모리 할당은 안해줌. 서버스타트 메서드 아랫쪽에 메모리 할당 객체 있음.
    	//ExecutorServiece : 스레드풀 구현 인터페이스
    
    // 1. 서버 소켓 선언
    ServerSocket serverSocket;
    
    
    // 2. 서버 실행 메서드
    public void serverstart() {
    	
    	try {
    		// 1. 서버 소켓 메모리 할당
        	serverSocket = new ServerSocket();
        	
        	// 2. 서버 소켓 바인딩  [ = ip와 port 를 소켓에 설정 ] 
        	serverSocket.bind(new InetSocketAddress("127.0.0.1", 1234));
        	
        	
		} catch (Exception e) {System.out.println(e);}
    		// 3. 클라이언트의 요청 대기 [ = 멀티스레드를 사용하는 이유? 1. 연결 2. 보내기 3. 받기 -> 동시에 처리하기 위해. ]
    	Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept();	// 1. 요청 수락 후에 수락된 소켓을 저장한다.
						clientlist.add(new Client(socket));		// 2. 연결된 클라이언트를 생성 후 리스트에 저장
					}	
				} catch (Exception e) {System.out.println("run exception : "+e);}
			}
		};	// 멀티스레드 구현 끝
    	// 스레드풀에 메모리를 초기화 시키기
		threadpool = Executors.newCachedThreadPool();	// 쓰레드풀에 메모리 초기화 [ 할당 ] 
			// 선언 할때 메모리 할당 해줘도 되긴 한데... 서버 켤때 할당해주는게 메모리 사용에는 더 효율적이겠지?
		threadpool.submit(runnable);
    	
    }
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
    	
    	
    }
    

    @FXML
    void accserver(ActionEvent event) {
    	if(btnserver.getText().equals("서버 실행")) {
    		
    		serverstart();
    		
    		txtserver.appendText("서버를 실행합니다.\n");	//textarea에 내용 추가
    		btnserver.setText("서버 중지");
    	}else if(btnserver.getText().equals("서버 중지")){
    		
    		serverstop();
    		
    		txtserver.appendText("장비를 정지합니다.\n");	//textarea에 내용 추가
    		btnserver.setText("서버 실행");
    	}
    }
	
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	txtserver.setEditable(false);
    	// TODO Auto-generated method stub
    	
    }
    
}
