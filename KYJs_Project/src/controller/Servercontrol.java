package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
	import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Servercontrol{	// ���� FXML�� ���� ���� ���� �ڹ� �
	
	
	// ��øŬ���� [ Client ] START
		// ��øŬ������ ����� ����?? clientlist�� static���� ������ �� ����, new�� ��ü�� ����� �޸𸮰� ���� ��������� ������ ������ �ȵ�.
		// �׷��� �޸� ������ �Ϸ��� ��øŬ������ ���� �� �ۿ� ����.
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
						while(true) {
							InputStream inputStream = socket.getInputStream();
							byte[] bytes = new byte[2048];
							inputStream.read(bytes);
							String msg = new String(bytes);	// ����Ʈ �迭�� ���ڿ��� ��ȯ [ ���ڿ� Ŭ���� ��� ]
							// ������ ���� �޽����� ���� ������ ���ӵ� ��� Ŭ���̾�Ʈ���� �ٽ� ������
							for(Client client : clientlist) {
								client.send(msg);
							}
						}
					} catch (Exception e) {System.out.println("Client class receive method exception : "+e);}
				}
			};
			threadpool.submit(runnable);
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
					} catch (Exception e) {System.out.println("Client class send method exception : "+e);}
				}
			};
			threadpool.submit(runnable);
		}
	}	// Client ��øŬ���� END
	
    //* ������ ����� Ŭ���̾�Ʈ�� �����ϴ� �޼���
    public Vector<Client> clientlist = new Vector<>();	// ���ӵ� Ŭ���̾�Ʈ���� ����� ����Ʈ
    	// Vector�� ����ϴ� ���� ? ����ȭ�� �����ϱ� ���� ! -> ��Ƽ�����带 ����ؾ��ϴµ� ����ȭ�� �������ϸ� �񶧸�
    		// Arraylist�� ����ȭ ������...
    // * ��Ƽ�����带 �������ִ� �������
    public ExecutorService threadpool;	// ���� �ϰ� �޸� �Ҵ��� ������. ������ŸƮ �޼��� �Ʒ��ʿ� �޸� �Ҵ� ��ü ����.
    	//ExecutorServiece : ������Ǯ ���� �������̽�
    
    // 1. ���� ���� ����S
    ServerSocket serverSocket;
    // 2. ���� ���� �޼��� [ �μ��� IP�� PORT�ѹ��� �޾Ƽ� �������� ���ε�(����) ] 
    public void serverstart(String ip, int port) {
    	try {
    		// 1. ���� ���� �޸� �Ҵ�
        	serverSocket = new ServerSocket();
        	// 2. ���� ���� ���ε�  [ = ip�� port �� ���Ͽ� ���� ] 
        	serverSocket.bind(new InetSocketAddress(ip, port));
		} catch (Exception e) {System.out.println("Server class serverstart method |serverSocket binding | Execption : "+e);}
    		// 3. Ŭ���̾�Ʈ�� ��û ��� [ = ��Ƽ�����带 ����ϴ� ����? 1. ���� 2. ������ 3. �ޱ� -> ���ÿ� ó���ϱ� ����. ]
    	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept();	// 1. ��û ���� �Ŀ� ������ ������ �����Ѵ�.
						clientlist.add(new Client(socket));		// 2. ����� Ŭ���̾�Ʈ�� ���� �� ����Ʈ�� ����
					}	
				} catch (Exception e) {System.out.println("Server class serverstart method |serverSocket acception | Execption : "+e);}
			}
		};	// ��Ƽ������ ���� ��
    	// ������Ǯ�� �޸𸮸� �ʱ�ȭ ��Ű��
		threadpool = Executors.newCachedThreadPool();	// ������Ǯ�� �޸� �ʱ�ȭ [ �Ҵ� ] 
			// ���� �Ҷ� �޸� �Ҵ� ���൵ �Ǳ� �ѵ�... ���� �Ӷ� �Ҵ����ִ°� �޸� ��뿡�� �� ȿ�����̰���?
		threadpool.submit(runnable);
    }	// serverstart method END
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
    }	// serverstop method END
}	// Servercontrol class END
