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
    
    //* ������ ����� Ŭ���̾�Ʈ�� �����ϴ� �޼���
    public static Vector<Client> clientlist = new Vector<>();
    	// Vector�� ����ϴ� ���� ? ����ȭ�� �����ϱ� ���� ! -> ��Ƽ�����带 ����ؾ��ϴµ� ����ȭ�� �������ϸ� �񶧸�
    		// Arraylist�� ����ȭ ������...
    // * ��Ƽ�����带 �������ִ� �������
    public static ExecutorService threadpool;	// ���� �ϰ� �޸� �Ҵ��� ������. ������ŸƮ �޼��� �Ʒ��ʿ� �޸� �Ҵ� ��ü ����.
    	//ExecutorServiece : ������Ǯ ���� �������̽�
    
    // 1. ���� ���� ����
    ServerSocket serverSocket;
    
    
    // 2. ���� ���� �޼���
    public void serverstart() {
    	
    	try {
    		// 1. ���� ���� �޸� �Ҵ�
        	serverSocket = new ServerSocket();
        	
        	// 2. ���� ���� ���ε�  [ = ip�� port �� ���Ͽ� ���� ] 
        	serverSocket.bind(new InetSocketAddress("127.0.0.1", 1234));
        	
        	
		} catch (Exception e) {System.out.println(e);}
    		// 3. Ŭ���̾�Ʈ�� ��û ��� [ = ��Ƽ�����带 ����ϴ� ����? 1. ���� 2. ������ 3. �ޱ� -> ���ÿ� ó���ϱ� ����. ]
    	Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept();	// 1. ��û ���� �Ŀ� ������ ������ �����Ѵ�.
						clientlist.add(new Client(socket));		// 2. ����� Ŭ���̾�Ʈ�� ���� �� ����Ʈ�� ����
					}	
				} catch (Exception e) {System.out.println("run exception : "+e);}
			}
		};	// ��Ƽ������ ���� ��
    	// ������Ǯ�� �޸𸮸� �ʱ�ȭ ��Ű��
		threadpool = Executors.newCachedThreadPool();	// ������Ǯ�� �޸� �ʱ�ȭ [ �Ҵ� ] 
			// ���� �Ҷ� �޸� �Ҵ� ���൵ �Ǳ� �ѵ�... ���� �Ӷ� �Ҵ����ִ°� �޸� ��뿡�� �� ȿ�����̰���?
		threadpool.submit(runnable);
    	
    }
    // 3. ���� ���� �޼���
    public void serverstop() {
    	// 1. ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �ݱ�
    	try {
    		for(Client client : clientlist) {
        		client.socket.close();
        	}	
    		
    		// 2. ���� ���� �ݱ�
    		serverSocket.close();
    		// 3. ������Ǯ �ݱ�
    		threadpool.shutdown();
		} catch (Exception e) {System.out.println("serverstop Exception : "+e);}
    	
    	
    }
    

    @FXML
    void accserver(ActionEvent event) {
    	if(btnserver.getText().equals("���� ����")) {
    		
    		serverstart();
    		
    		txtserver.appendText("������ �����մϴ�.\n");	//textarea�� ���� �߰�
    		btnserver.setText("���� ����");
    	}else if(btnserver.getText().equals("���� ����")){
    		
    		serverstop();
    		
    		txtserver.appendText("��� �����մϴ�.\n");	//textarea�� ���� �߰�
    		btnserver.setText("���� ����");
    	}
    }
	
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	txtserver.setEditable(false);
    	// TODO Auto-generated method stub
    	
    }
    
}
