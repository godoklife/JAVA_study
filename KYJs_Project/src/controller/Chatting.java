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

    // ���� ���� ���� [ ��� �޼��忡�� ��� ���� ]
    public Servercontrol server;
    public static Room selectroom;	// ���̺�信�� ���õ� ���� �����ϴ� ����
    public void show() {	
    	// 1. db�κ��� ��� �� ��� ��������
    	ObservableList<Room> roomlist = RoomDao.roomDao.roomlist();
    	
    	// 2. ���̺���� ù��° �ʵ带 �����ͼ� �� ��ȣ �ʵ�� ����
    	TableColumn tc = roomtable.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));
    	
    	// 3. ���̺� ���� �ι��� �ʵ带 �����ͼ� �� �̸� �ʵ�� ����
    	tc = roomtable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("roomname"));
    	
    	// $. ���̺� ���� ������ �ʵ带 �����ͼ� �� �ο� �ʵ�� ����.
    	tc = roomtable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("mcount"));
    	
    	// 5. ���̺�信 ����Ʈ�� �־��ֱ�
    	roomtable.setItems(roomlist);
    			
    	// 6. ���̺�並 Ŭ�������� 
    	roomtable.setOnMouseClicked( e -> {
    		System.out.println("���콺�� Ŭ���� �� : "+e);
			if(roomtable.getSelectionModel().getSelectedItem()==null) return;	// �� ��� ������ Ŭ���ϸ� �����°� ���� ���ǹ�
			
    		// 7. Ŭ���� ��ü�� �����ͼ� selectroom�� ����
    		selectroom = roomtable.getSelectionModel().getSelectedItem();
    		
    		// 8. ���̺� ����ֱ�
    		lblselect.setText("���� ���õ� �� : "+roomtable.getSelectionModel().getSelectedItem().getRoomname());
    		
    		// 9. ��Ȱ��ȭ �Ǿ� �ִ� ���� ��ư�� Ȱ��ȭ ��ŰŰ
    		btnconnect.setDisable(false);
    	});
    	
    }
    
    @FXML
    void accadd(ActionEvent event) {	// �� ���� ��ư Ŭ����
    	// 1. ��Ʈ�ѿ� �Էµ� �� �̸��� ��������
    	String roomname = txtroomname.getText();
    	if(roomname.length()<4) {	// �� �̸��� �ױ��� �̸��̸� ���� �ź�
    		Alert alert = new Alert(AlertType.WARNING);
        	alert.setHeaderText("���� ������ �ּ� �� ���� �̻��̿��� �մϴ�.");
        	alert.showAndWait();
    		return;
    	}
    	// 2. �� ��üȭ
    	Room room = new Room(0, roomname, "127.0.0.1", 0);
    	// 3. DBó��
    	RoomDao.roomDao.roomadd(room);
    	// 4. �ش� ���� ���� �޸� �Ҵ�
    	server = new Servercontrol();
    	// ���� ����! [ �μ��� ip�� port �ѱ�� ] 
    	server.serverstart(room.getRoomip(), RoomDao.roomDao.getroomnum());
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("���� �����Ǿ����ϴ�. �� ��ȣ : "+RoomDao.roomDao.getroomnum());
    	alert.showAndWait();
    	txtroomname.setText("");	// �� ���� �Է�ĭ ����ó��
    	show();
    }

    


    // 1. Ŭ���̾�Ʈ ���� ����.
    Socket socket;	
    
    
    /* 
     * Ŭ���̾�Ʈ���� ���� ������Ǯ�� ����� �ʿ�� ����.
     * ����ó�� ������ �ɸ� ���� ��~~~�� ����
     */
    
    // 2. Ŭ���̾�Ʈ ���� �޼���
    public void clientstart(String ip, int port) {
    	Thread clientthread = new Thread() {
    		@Override
    		public void run() {
    			System.out.println("clientstart method�� ȣ��Ǿ����ϴ�.");
    			try {
					socket = new Socket(ip, port);	// ������ ip�� ��Ʈ��ȣ�� �־��ֱ� [ ������ ���� ]
					send(Login.member.getMid()+"���� �����ϼ̽��ϴ�.\n");
					receive();// ���Ӱ� ���ÿ� �ޱ� �޼���� ���ѷ���
				} catch (Exception e) {
					clientstop();
					System.out.println(e);
					}
    		};
    	};	// ��Ƽ������ ���� ��
    	
    	clientthread.start();	// ��Ƽ������ ����
    }
    
    // 3. Ŭ���̾�Ʈ ���� �޼���
    public void clientstop() {
    	System.out.println("clientstop method�� ȣ��Ǿ����ϴ�.");
    	try {
			socket.close();
		} catch (Exception e) {System.out.println("clientstop method exception : "+e);}
    }
    
    // 4. �������� �޽����� ������ �޼���
    public void send(String msg) {
    	Thread sendthread = new Thread() {
    		@Override
    		public void run() {
    			try {
					OutputStream outputStream = socket.getOutputStream();	// 1. ��� ��Ʈ���� ���� ����
					outputStream.write(msg.getBytes());	// 2. �����ϱ�
					outputStream.flush();// 3. ��½�Ʈ�� �ʱ�ȭ
					System.out.println("send method : "+new String(msg.getBytes()));
				} catch (Exception e) {
					clientstop();
					System.out.println("send method exception : "+e);
					}
    		};
    	};	// ��Ƽ������ ���� ��
    	sendthread.start();
    }
    // 5. �������Լ� �޽����� �޴� �޼���
    public void receive() {
    	try {
			while (true) {
				System.out.println("receive test");
				System.out.println("����� ������ �ּ� : "+socket.getInetAddress()); 
				InputStream inputStream = socket.getInputStream();	// �Է� ��Ʈ��
				System.out.println("receive method 1");
				byte[] bytes = new byte[2048];	// 2KB¥�� ����Ʈ �迭 ����
				System.out.println("2");
				System.out.println("����Ʈ �迭 : "+new String(bytes));
				inputStream.read(bytes);	// ��ǲ ��Ʈ���� ����ִ� ����Ÿ�� ����Ʈ �迭�� �̵�
				System.out.println("3");
				String message = new String(bytes);	// ����Ʈ�迭�� ���ڿ��� ��ȯ
				System.out.println("4");
				txtcontent.appendText(message);	// textarea�� ���ڿ� ���
				System.out.println("5");
				System.out.println("txtcontent.appendText ���� �� String message : "+ message);
			}
		} catch (Exception e) {
			clientstop();
			System.out.println("receive method exception : "+e);
			}
    }
    
    @FXML
    void accconnect(ActionEvent event) {
    	if(btnconnect.getText().equals("ä�ù� ����")) {
    		if(selectroom==null) {
    			System.out.println("selectroom�� null�̴�");
    			return;
    		}
    		clientstart(selectroom.getRoomip(), selectroom.getRoomnumber());// Ŭ���̾�Ʈ ���� �޼���
    			// ���� �濡 ���ӵ� ��� �߰�
    		Roomlive roomlive = new Roomlive(0, selectroom.getRoomnumber(), Login.member.getMid());
    		// dbó��
    		RoomDao.roomDao.addroomlive(roomlive);
    		
    		
        	txtmsg.setEditable(true);		// ���� ������ �Է� ���ϰ� ���Ƴ���
        	txtcontent.setDisable(false);	// ����â ��� ��� ����
        	btnsend.setDisable(false);		// ���� ������ ��ư ��� ����
        	txtmsg.setText("");				// �޽��� �Է�â ����ֱ�
        	txtmsg.requestFocus();
        	
        	txtroomname.setDisable(true);	// ä�ù� ���夾�ϸ� ê�� �̸� ����ĭ ��Ȱ��ȭ
        	btnadd.setDisable(true);		// ä�ù� �����ϸ� ê�� ������ư ��Ȱ��ȭ
        	
    		
    		txtcontent.appendText("==========[ä�ù濡 �����մϴ�.]==========\n");
    		btnconnect.setText("ä�ù� ����");
    	}else if(btnconnect.getText().equals("ä�ù� ����")) {
    		clientstop();// Ŭ���̾�Ʈ ���� �޼���
    		
    		txtcontent.appendText("==========[ä�ù濡�� �����մϴ�.]==========\n");
    		btnconnect.setText("ä�ù� ����");
        	txtmsg.setText("ä�ù� ���� �� �Է� �����մϴ�~");
        	txtmsg.setEditable(false);		// ���� ������ �Է� ���ϰ� ���Ƴ���
        	txtcontent.setDisable(true);	// ���� ��� ��Ȱ��ȭ ó��
        	btnsend.setDisable(true);		// ���� ������ ��ư ��� ����
        	btnconnect.setDisable(true);
        	
        	
        	txtroomname.setDisable(false);	// ä�ù� ������ ê�� �̸� ����ĭ Ȱ��ȭ
        	btnadd.setDisable(false);		// ä�ù� ������ ä�ù� ������ư Ȱ��ȭó��
        	
        	// 1. �� ���� ��ܿ��� �����ϱ�
        	RoomDao.roomDao.roomlivedelete(Login.member.getMid());
        	// 2. ���࿡ �� ���� ����� 0���̸� �� ����
        	boolean result = RoomDao.roomDao.roomdelete(selectroom.getRoomnumber());
        	// 2-1. �������� �շ�
        	if(result) {
        		server.serverstop();
        		show();	// �� ���� �� ��������
        	}
        	// 2-2.
        	selectroom = null;
        	
        	// 2-3.
        	lblselect.setText("���� ���õ� �� : ");
        	
        	
    	}
    }
    
    @FXML
    void accmsg(ActionEvent event) {	// ä��â ���� �Է½�
    	String msg  = Login.member.getMid()+" : "+txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");				// �޽��� �Է�â ����ֱ�
    	txtmsg.requestFocus();			// ������ �� �޽��� �Է�â���� ��Ŀ��(Ű���� Ŀ��) �̵�
    	
    	// ���� ä���忡 �������� ���̵� ���(�ǽð� �ƴ�, DB���� ������°���)
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
    void accsend(ActionEvent event) {	// ���� ��ư�� ������ ��
    	send(Login.member.getMid()+" : "+txtmsg.getText()+"\n");	// �޽��� �Է�â�� �Էµ� �ؽ�Ʈ �����ͼ� ������
    	txtmsg.setText("");				// �޽��� �Է�â ����ֱ�
    	txtmsg.requestFocus();			// ������ �� �޽��� �Է�â���� ��Ŀ��(Ű���� Ŀ��) �̵�
    	
    	// ���� ä���忡 �������� ���̵� ���(�ǽð� �ƴ�, DB���� ������°���)
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
    	// �¹� ������ �� �ʱⰪ �޼���
    	txtmsg.setText("ä�ù� ���� �� �Է� �����մϴ�~");
    	txtmsg.setEditable(false);		// ���� ������ �Է� ���ϰ� ���Ƴ���
    	txtcontent.setDisable(true);	// ���� ��� ��Ȱ��ȭ ó��
    	btnsend.setDisable(true);		// ���� ������ ��ư ��� ����
    	txtmidlist.setEditable(false);	// ȸ�� ��� ����ڰ� ���� ����
    	btnconnect.setDisable(true);	// ���� �� ä�ù� ���� ��ư ��� ���� ( ���� �����ϸ� ��ư Ȱ��ȭ)
    	show();

    }

}
