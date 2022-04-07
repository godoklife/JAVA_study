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

    // 1. Ŭ���̾�Ʈ ���� ����.
    Socket socket;	
    
    
    /* 
     * Ŭ���̾�Ʈ���� ���� ������Ǯ�� ����� �ʿ�� ����.
     * ����ó�� ������ �ɸ� ���� ��~~~�� ����
     */
    
    // 2. Ŭ���̾�Ʈ ���� �޼���
    public void clientstart() {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
					socket = new Socket("127.0.0.1",1234);	// ������ ip�� ��Ʈ��ȣ�� �־��ֱ� [ ������ ���� ]
					
					send(Login.member.getMid()+"���� �����ϼ̽��ϴ�.\n");
					
					receive();// ���Ӱ� ���ÿ� �ޱ� �޼���� ���ѷ���
				} catch (Exception e) {System.out.println(e);}
    		};
    	};	// ��Ƽ������ ���� ��
    	
    	thread.start();	// ��Ƽ������ ����
    }
    
    // 3. Ŭ���̾�Ʈ ���� �޼���
    public void clientstop() {
    	try {
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    // 4. �������� �޽����� ������ �޼���
    public void send(String msg) {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
					OutputStream outputStream = socket.getOutputStream();	// 1. ��� ��Ʈ��
					outputStream.write(msg.getBytes());	// 2. �����ϱ�
					outputStream.flush();// 3. ��½�Ʈ�� �ʱ�ȭ
				} catch (Exception e) {System.out.println(e);}
    		};
    	};	// ��Ƽ������ ���� ��
    	thread.start();
    }
    // 5. �������Լ� �޽����� �޴� �޼���
    public void receive() {
    	try {
			while (true) {
				InputStream inputStream = socket.getInputStream();	// �Է� ��Ʈ��
				byte[] bytes = new byte[2048];	// 2KB¥�� ����Ʈ �迭 ����
				inputStream.read(bytes);	// ��ǲ ��Ʈ���� ����ִ� ����Ÿ�� ����Ʈ �迭�� �̵�
				String message = new String(bytes);	// ����Ʈ�迭�� ���ڿ��� ��ȯ
				txtcontent.appendText(message);	// textarea�� ���ڿ� ���
			}
		} catch (Exception e) {System.out.println(e);}
    }
    
    @FXML
    void accconnect(ActionEvent event) {
    	if(btnconnect.getText().equals("ä�ù� ����")) {
    		clientstart();// Ŭ���̾�Ʈ ���� �޼���
    		
    		
    		txtcontent.appendText("==========[ä�ù濡 �����մϴ�.]==========\n");
    		btnconnect.setText("ä�ù� ����");
    	}else if(btnconnect.getText().equals("ä�ù� ����")) {
    		clientstop();// Ŭ���̾�Ʈ ���� �޼���
    		
    		txtcontent.appendText("==========[ä�ù濡�� �����մϴ�.]==========\n");
    		btnconnect.setText("ä�ù� ����");
    	}
    }

    @FXML
    void accsend(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }

}
