package dto;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.Servercontrol;

public class Client {
	// ������ ���ӵ� Ŭ���̾�Ʈ�� Ŭ����
	
	// 1. ��Ĺ
	public Socket socket;	// public �̿��� ��Ű���� �޶� ������ ����!!!
	
	// 2. ������
	public Client(Socket socket) {
		this.socket = socket;
		receive();	// ������ ����� Ŭ���̾�Ʈ ��ü�� ������ �� �޴� �޼���
	}
	
	// 3. ������ �޽��� �޴� �޼��� [ �������� : ������ Ŭ���̾�Ʈ�� ����Ǿ��� �� ]
	public void receive() {	
		
		// ��Ƽ�������� ���� ��� 2���� - Thread(class), Runnable(interface)
			// ���ʺ� : run �޼��带 �ʼ������� �����ؾ���.
			
		Runnable runnable = new Runnable() { // �͸� ���� ��ü
			@Override
			public void run() {
				try {
					InputStream inputStream = socket.getInputStream();
					byte[] bytes = new byte[2048];
					inputStream.read(bytes);
					String msg = new String(bytes);	// ����Ʈ �迭�� ���ڿ��� ��ȯ [ ���ڿ� Ŭ���� ��� ]
					// ������ ���� �޽����� ���� ������ ���ӵ� ��� Ŭ���̾�Ʈ���� �ٽ� ������
					for(Client client : Servercontrol.clientlist) {
						client.send(msg);
					}
					
				} catch (Exception e) {System.out.println("run exception : "+e);}
			}
		};
		
	}
	// 4. ������ �޽��� ������ �޼��� [ ���� ���� : ������ �޽����� �޾����� ] 
	public void send(String msg) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					// 1. ��� ������
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(msg.getBytes());
				} catch (Exception e) {System.out.println(e);}
			}
		};
	}
}
