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

    // 1. Ŭ���̾�Ʈ ���� ����.
    Socket socket;	
    
    
    /* 
     * Ŭ���̾�Ʈ���� ���� ������Ǯ�� ����� �ʿ�� ����.
     * ����ó�� ������ �ɸ� ���� ��~~~�� ����
     */
    
    // 2. Ŭ���̾�Ʈ ���� �޼���
    public void clientstart() {
    	Thread clientthread = new Thread() {
    		@Override
    		public void run() {
    			System.out.println("clientstart method�� ȣ��Ǿ����ϴ�.");
    			try {
					socket = new Socket("127.0.0.1",33990);	// ������ ip�� ��Ʈ��ȣ�� �־��ֱ� [ ������ ���� ]
					send(Login.member.getMid()+"���� �����ϼ̽��ϴ�.\n");
					receive();// ���Ӱ� ���ÿ� �ޱ� �޼���� ���ѷ���
				} catch (Exception e) {System.out.println(e);}
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
				} catch (Exception e) {System.out.println("send method exception : "+e);}
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
		} catch (Exception e) {System.out.println("receive method exception : "+e);}
    }
    
    @FXML
    void accconnect(ActionEvent event) {
    	if(btnconnect.getText().equals("ä�ù� ����")) {
    		clientstart();// Ŭ���̾�Ʈ ���� �޼���
        	txtmsg.setEditable(true);		// ���� ������ �Է� ���ϰ� ���Ƴ���
        	txtcontent.setDisable(false);	// ����â ��� ��� ����
        	btnsend.setDisable(false);		// ���� ������ ��ư ��� ����
        	txtmsg.setText("");				// �޽��� �Է�â ����ֱ�
        	txtmsg.requestFocus();
    		
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
    	}
    }

    @FXML
    void accsend(ActionEvent event) {	// ���� ��ư�� ������ ��
//  	String msg = txtmsg.getText()+"\n";
//    	send(msg);
    	send(txtmsg.getText()+"\n");	// �޽��� �Է�â�� �Էµ� �ؽ�Ʈ �����ͼ� ������
    	txtmsg.setText("");				// �޽��� �Է�â ����ֱ�
    	txtmsg.requestFocus();			// ������ �� �޽��� �Է�â���� ��Ŀ��(Ű���� Ŀ��) �̵�
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// �¹� ������ �� �ʱⰪ �޼���
    	//txtcontent.setEditable(false);	// ä�� ���� �Է� ���ϰ� ���Ƴ���
    	txtmsg.setText("ä�ù� ���� �� �Է� �����մϴ�~");
    	txtmsg.setEditable(false);		// ���� ������ �Է� ���ϰ� ���Ƴ���
    	txtcontent.setDisable(true);	// ���� ��� ��Ȱ��ȭ ó��
    	btnsend.setDisable(true);		// ���� ������ ��ư ��� ����
    	
    }

}
