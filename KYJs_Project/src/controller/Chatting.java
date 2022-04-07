package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import controller.login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Chatting implements Initializable{
	
    @FXML
    private AnchorPane txt;

    @FXML
    private Button btnsend;

    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextField txtmsg;

    @FXML
    private TextField txtnickname;

    @FXML
    private TextField txtserverip;

    @FXML
    private TextField txtserverport;

    @FXML
    private Label lblnickname;

    @FXML
    private Label lblserverip;

    @FXML
    private Label lblserverport;

    // 1. 클라이언트 소켓 선언.
    Socket socket;	
    
    
    /* 
     * 클라이언트쪽은 딱히 쓰레드풀을 사용할 필요는 없음.
     * 서버처럼 과부하 걸릴 일이 거~~~의 없음
     */
    
    // 2. 클라이언트 실행 메서드
    public void clientstart() {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
					socket = new Socket("127.0.0.1",1234);	// 서버의 ip와 포트번호를 넣어주기 [ 서버와 연결 ]
					
					send(Login.member.getMid()+"님이 입장하셨습니다.\n");
					
					receive();// 접속과 동시에 받기 메서드는 무한루프
				} catch (Exception e) {System.out.println(e);}
    		};
    	};	// 멀티스레그 구현 끝
    	
    	thread.start();	// 멀티스레드 실행
    }
    
    // 3. 클라이언트 종료 메서드
    public void clientstop() {
    	try {
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    // 4. 서버에게 메시지를 보내는 메서드
    public void send(String msg) {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
					OutputStream outputStream = socket.getOutputStream();	// 1. 출력 스트림
					outputStream.write(msg.getBytes());	// 2. 전송하기
					outputStream.flush();// 3. 출력스트림 초기화
				} catch (Exception e) {System.out.println(e);}
    		};
    	};	// 멀티스레드 구현 끝
    	thread.start();
    }
    // 5. 서버에게서 메시지를 받는 메서드
    public void receive() {
    	try {
			while (true) {
				InputStream inputStream = socket.getInputStream();	// 입력 스트림
				byte[] bytes = new byte[2048];	// 2KB짜리 바이트 배열 선언
				inputStream.read(bytes);	// 인풋 스트림에 들어있는 데이타를 바이트 배열로 이동
				String message = new String(bytes);	// 바이트배열을 문자열로 변환
				txtcontent.appendText(message);	// textarea에 문자열 출력
			}
		} catch (Exception e) {System.out.println(e);}
    }
    
    @FXML
    void accconnect(ActionEvent event) {
    	if(btnconnect.getText().equals("채팅방 입장")) {
    		clientstart();// 클라이언트 실행 메서드
    		
    		
    		txtcontent.appendText("==========[채팅방에 입장합니다.]==========\n");
    		btnconnect.setText("채팅방 퇴장");
    	}else if(btnconnect.getText().equals("채팅방 퇴장")) {
    		clientstop();// 클라이언트 종료 메서드
    		
    		txtcontent.appendText("==========[채팅방에서 퇴장합니다.]==========\n");
    		btnconnect.setText("채팅방 입장");
    	}
    }

    @FXML
    void accsend(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }

}
