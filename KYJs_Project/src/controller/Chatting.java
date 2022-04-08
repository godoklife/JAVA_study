package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
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
    	Thread clientthread = new Thread() {
    		@Override
    		public void run() {
    			System.out.println("clientstart method가 호출되었습니다.");
    			try {
					socket = new Socket("127.0.0.1",33990);	// 서버의 ip와 포트번호를 넣어주기 [ 서버와 연결 ]
					send(Login.member.getMid()+"님이 입장하셨습니다.\n");
					receive();// 접속과 동시에 받기 메서드는 무한루프
				} catch (Exception e) {System.out.println(e);}
    		};
    	};	// 멀티스레그 구현 끝
    	
    	clientthread.start();	// 멀티스레드 실행
    }
    
    // 3. 클라이언트 종료 메서드
    public void clientstop() {
    	System.out.println("clientstop method가 호출되었습니다.");
    	try {
			socket.close();
		} catch (Exception e) {System.out.println("clientstop method exception : "+e);}
    }
    
    // 4. 서버에게 메시지를 보내는 메서드
    public void send(String msg) {
    	Thread sendthread = new Thread() {
    		@Override
    		public void run() {
    			try {
					OutputStream outputStream = socket.getOutputStream();	// 1. 출력 스트림에 소켓 설정
					outputStream.write(msg.getBytes());	// 2. 전송하기
					outputStream.flush();// 3. 출력스트림 초기화
					System.out.println("send method : "+new String(msg.getBytes()));
				} catch (Exception e) {System.out.println("send method exception : "+e);}
    		};
    	};	// 멀티스레드 구현 끝
    	sendthread.start();
    }
    // 5. 서버에게서 메시지를 받는 메서드
    public void receive() {
    	try {
			while (true) {
				System.out.println("receive test");
				System.out.println("연결된 서버의 주소 : "+socket.getInetAddress()); 
				InputStream inputStream = socket.getInputStream();	// 입력 스트림
				System.out.println("receive method 1");
				byte[] bytes = new byte[2048];	// 2KB짜리 바이트 배열 선언
				System.out.println("2");
				System.out.println("바이트 배열 : "+new String(bytes));
				inputStream.read(bytes);	// 인풋 스트림에 들어있는 데이타를 바이트 배열로 이동
				System.out.println("3");
				String message = new String(bytes);	// 바이트배열을 문자열로 변환
				System.out.println("4");
				txtcontent.appendText(message);	// textarea에 문자열 출력
				System.out.println("5");
				System.out.println("txtcontent.appendText 실행 후 String message : "+ message);
			}
		} catch (Exception e) {System.out.println("receive method exception : "+e);}
    }
    
    @FXML
    void accconnect(ActionEvent event) {
    	if(btnconnect.getText().equals("채팅방 입장")) {
    		clientstart();// 클라이언트 실행 메서드
        	txtmsg.setEditable(true);		// 접속 전에는 입력 못하게 막아놓기
        	txtcontent.setDisable(false);	// 재팅창 목록 사용 금지
        	btnsend.setDisable(false);		// 접속 전에는 버튼 사용 금지
        	txtmsg.setText("");				// 메시지 입력창 비워주기
        	txtmsg.requestFocus();
    		
    		txtcontent.appendText("==========[채팅방에 입장합니다.]==========\n");
    		btnconnect.setText("채팅방 퇴장");
    	}else if(btnconnect.getText().equals("채팅방 퇴장")) {
    		clientstop();// 클라이언트 종료 메서드
    		
    		txtcontent.appendText("==========[채팅방에서 퇴장합니다.]==========\n");
    		btnconnect.setText("채팅방 입장");
        	txtmsg.setText("채팅방 연결 후 입력 가능합니다~");
        	txtmsg.setEditable(false);		// 접속 전에는 입력 못하게 막아놓기
        	txtcontent.setDisable(true);	// 재팅 뷰어 비활성화 처리
        	btnsend.setDisable(true);		// 접속 전에는 버튼 사용 금지
    	}
    }

    @FXML
    void accsend(ActionEvent event) {	// 전송 버튼을 눌렀을 때
//  	String msg = txtmsg.getText()+"\n";
//    	send(msg);
    	send(txtmsg.getText()+"\n");	// 메시지 입력창에 입력된 텍스트 가져와서 보내기
    	txtmsg.setText("");				// 메시지 입력창 비워주기
    	txtmsg.requestFocus();			// 보내기 후 메시지 입력창으로 포커스(키보드 커서) 이동
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// 쳇방 열렸을 때 초기값 메서드
    	//txtcontent.setEditable(false);	// 채팅 뷰어에는 입력 못하게 막아놓기
    	txtmsg.setText("채팅방 연결 후 입력 가능합니다~");
    	txtmsg.setEditable(false);		// 접속 전에는 입력 못하게 막아놓기
    	txtcontent.setDisable(true);	// 재팅 뷰어 비활성화 처리
    	btnsend.setDisable(true);		// 접속 전에는 버튼 사용 금지
    	
    }

}
