package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.login.Login;
import dao.RoomDao;
import dto.Room;
import dto.Roomlive;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class Chatting implements Initializable{
	
    @FXML
    private AnchorPane txt;

    @FXML
    private Button btnsend;

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextField txtmsg;

    @FXML
    private TableView<Room> roomtable;

    @FXML
    private TextField txtroomname;

    @FXML
    private Button btnconnect;

    @FXML
    private Button btnadd;

    @FXML
    private Label lblselect;

    @FXML
    private TextArea txtmidlist;

    // 서버 소켓 생성 [ 모든 메서드에서 사용 가능 ]
    public Servercontrol server;
    public static Room selectroom;	// 테이블뷰에서 선택된 방을 저장하는 변수
    public void show() {	
    	// 1. db로부터 모든 방 목록 가져오기
    	ObservableList<Room> roomlist = RoomDao.roomDao.roomlist();
    	
    	// 2. 테이블뷰의 첫번째 필드를 가져와서 방 번호 필드로 설정
    	TableColumn tc = roomtable.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));
    	
    	// 3. 테이블 뷰의 두번쨰 필드를 가져와서 방 이름 필드로 설정
    	tc = roomtable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("roomname"));
    	
    	// $. 테이블 뷰의 세번쨰 필드를 가져와서 방 인원 필드로 설정.
    	tc = roomtable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("mcount"));
    	
    	// 5. 테이블뷰에 리스트를 넣어주기
    	roomtable.setItems(roomlist);
    			
    	// 6. 테이블뷰를 클릭했을때 
    	roomtable.setOnMouseClicked( e -> {
    		System.out.println("마우스로 클릭한 값 : "+e);
			if(roomtable.getSelectionModel().getSelectedItem()==null) return;	// 방 목록 없을때 클릭하면 터지는거 막는 조건문
			
    		// 7. 클릭된 객체를 가져와서 selectroom에 저장
    		selectroom = roomtable.getSelectionModel().getSelectedItem();
    		
    		// 8. 레이블에 띄워주기
    		lblselect.setText("현재 선택된 방 : "+roomtable.getSelectionModel().getSelectedItem().getRoomname());
    		
    		// 9. 비활성화 되어 있던 접속 버튼을 활성화 시키키
    		btnconnect.setDisable(false);
    	});
    	
    }
    
    @FXML
    void accadd(ActionEvent event) {	// 방 개설 버튼 클릭시
    	// 1. 컨트롤에 입력된 방 이름을 가져오기
    	String roomname = txtroomname.getText();
    	if(roomname.length()<4) {	// 방 이름이 네글자 미만이면 개설 거부
    		Alert alert = new Alert(AlertType.WARNING);
        	alert.setHeaderText("방의 제목은 최소 네 글자 이상이여야 합니다.");
        	alert.showAndWait();
    		return;
    	}
    	// 2. 방 객체화
    	Room room = new Room(0, roomname, "127.0.0.1", 0);
    	// 3. DB처리
    	RoomDao.roomDao.roomadd(room);
    	// 4. 해당 방의 서버 메모리 할당
    	server = new Servercontrol();
    	// 서버 시작! [ 인수로 ip와 port 넘기기 ] 
    	server.serverstart(room.getRoomip(), RoomDao.roomDao.getroomnum());
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("방이 개설되었습니다. 방 번호 : "+RoomDao.roomDao.getroomnum());
    	alert.showAndWait();
    	txtroomname.setText("");	// 방 제목 입력칸 공백처리
    	show();
    }

    


    // 1. 클라이언트 소켓 선언.
    Socket socket;	
    
    
    /* 
     * 클라이언트쪽은 딱히 쓰레드풀을 사용할 필요는 없음.
     * 서버처럼 과부하 걸릴 일이 거~~~의 없음
     */
    
    // 2. 클라이언트 실행 메서드
    public void clientstart(String ip, int port) {
    	Thread clientthread = new Thread() {
    		@Override
    		public void run() {
    			System.out.println("clientstart method가 호출되었습니다.");
    			try {
					socket = new Socket(ip, port);	// 서버의 ip와 포트번호를 넣어주기 [ 서버와 연결 ]
					send(Login.member.getMid()+"님이 입장하셨습니다.\n");
					receive();// 접속과 동시에 받기 메서드는 무한루프
				} catch (Exception e) {
					clientstop();
					System.out.println(e);
					}
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
				} catch (Exception e) {
					clientstop();
					System.out.println("send method exception : "+e);
					}
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
		} catch (Exception e) {
			clientstop();
			System.out.println("receive method exception : "+e);
			}
    }
    
    @FXML
    void accconnect(ActionEvent event) {
    	if(btnconnect.getText().equals("채팅방 입장")) {
    		if(selectroom==null) {
    			System.out.println("selectroom이 null이다");
    			return;
    		}
    		clientstart(selectroom.getRoomip(), selectroom.getRoomnumber());// 클라이언트 실행 메서드
    			// 현재 방에 접속된 명단 추가
    		Roomlive roomlive = new Roomlive(0, selectroom.getRoomnumber(), Login.member.getMid());
    		// db처리
    		RoomDao.roomDao.addroomlive(roomlive);
    		
    		
        	txtmsg.setEditable(true);		// 접속 전에는 입력 못하게 막아놓기
        	txtcontent.setDisable(false);	// 재팅창 목록 사용 금지
        	btnsend.setDisable(false);		// 접속 전에는 버튼 사용 금지
        	txtmsg.setText("");				// 메시지 입력창 비워주기
        	txtmsg.requestFocus();
        	
        	txtroomname.setDisable(true);	// 채팅방 입장ㅎ하면 챗방 이름 생성칸 비활성화
        	btnadd.setDisable(true);		// 채팅방 입장하면 챗방 생성버튼 비활성화
        	
    		
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
        	btnconnect.setDisable(true);
        	
        	
        	txtroomname.setDisable(false);	// 채팅방 나가면 챗방 이름 생성칸 활성화
        	btnadd.setDisable(false);		// 채팅방 나가면 채팅방 생성버튼 활성화처리
        	
        	// 1. 방 접속 명단에서 삭제하기
        	RoomDao.roomDao.roomlivedelete(Login.member.getMid());
        	// 2. 만약에 방 접속 명단이 0명이면 방 삭제
        	boolean result = RoomDao.roomDao.roomdelete(selectroom.getRoomnumber());
        	// 2-1. 서버소켓 죵료
        	if(result) {
        		server.serverstop();
        		show();	// 방 삭제 후 리프레시
        	}
        	// 2-2.
        	selectroom = null;
        	
        	// 2-3.
        	lblselect.setText("현재 선택된 방 : ");
        	
        	
    	}
    }
    
    @FXML
    void accmsg(ActionEvent event) {	// 채팅창 엔터 입력시
    	String msg  = Login.member.getMid()+" : "+txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");				// 메시지 입력창 비워주기
    	txtmsg.requestFocus();			// 보내기 후 메시지 입력창으로 포커스(키보드 커서) 이동
    	
    	// 현재 채팅장에 접속중인 아이디 출력(실시간 아님, DB에서 끌어오는거임)
    	ArrayList<Roomlive>roomlivelist = RoomDao.roomDao.getroomlivelist(selectroom.getRoomnumber());
    	txtmidlist.setText("");
    	int i = 1;
    	for(Roomlive tmp : roomlivelist) {
    		txtmidlist.appendText(i+". "+tmp.getMid()+"\n");
    		i++;
    	}
    	i=1;
    }
    
    @FXML
    void accsend(ActionEvent event) {	// 전송 버튼을 눌렀을 때
    	send(Login.member.getMid()+" : "+txtmsg.getText()+"\n");	// 메시지 입력창에 입력된 텍스트 가져와서 보내기
    	txtmsg.setText("");				// 메시지 입력창 비워주기
    	txtmsg.requestFocus();			// 보내기 후 메시지 입력창으로 포커스(키보드 커서) 이동
    	
    	// 현재 채팅장에 접속중인 아이디 출력(실시간 아님, DB에서 끌어오는거임)
    	ArrayList<Roomlive>roomlivelist = RoomDao.roomDao.getroomlivelist(selectroom.getRoomnumber());
    	txtmidlist.setText("");
    	int i = 1;
    	for(Roomlive tmp : roomlivelist) {
    		txtmidlist.appendText(i+". "+tmp.getMid()+"\n");
    		i++;
    	}
    	i=1;
    }
    
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// 쳇방 열렸을 때 초기값 메서드
    	txtmsg.setText("채팅방 연결 후 입력 가능합니다~");
    	txtmsg.setEditable(false);		// 접속 전에는 입력 못하게 막아놓기
    	txtcontent.setDisable(true);	// 재팅 뷰어 비활성화 처리
    	btnsend.setDisable(true);		// 접속 전에는 버튼 사용 금지
    	txtmidlist.setEditable(false);	// 회원 목록 사용자가 수정 금지
    	btnconnect.setDisable(true);	// 접속 전 채팅방 입장 버튼 사용 금지 ( 방을 선택하면 버튼 활성화)
    	show();

    }

}
