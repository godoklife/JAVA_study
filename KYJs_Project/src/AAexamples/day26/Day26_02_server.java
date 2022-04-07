package AAexamples.day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Day26_02_server {
	// ��ſ� ���� �����
		// 1. ���� ���� �����
			// ���� : Ŭ���̾�Ʈ���� ������ ���񽺸� �������ִ� ��ǻ��.
			// ���� : PC���� ��� ������.
		// 2. ���� ���� ���ε�		���ε� : ���𰡿� �������� �־��ִ°�
			// ������ ip �� port ��ȣ ��
			// ip : ��Ʈ�p �󿡼� pc�� �ĺ��ϴ� ��ȣ
			// port : pc �� ���α׷��� �ĺ��ϴ� ��ȣ
			

	
	public static void main(String[] args) {
		
		
		try {
			// 1. ���� ���� �����
			ServerSocket serverSocket = new ServerSocket();
			
			// 2. ���� ���� ���ε�							// ip�ּ�, port ����
			serverSocket.bind(new InetSocketAddress("127.168.102.50", 5000));
			
			// 3. Ŭ���̾�Ʈ�� ��û ���
			while(true) {
				System.out.println("���� �� ���� ������Դϴ�.");
				
				// 4. ��û�� ���� ��� ����
				Socket socket = serverSocket.accept();	// ��û ����
				
				// 5. ������ ������ ���� Ȯ��
				InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("Ŭ���̾�Ʈ�� ������ �����Ͽ����ϴ�. ����� Ŭ���̾�Ʈ�� �̸� : \n"+inetSocketAddress.getHostName());
				while(true){
					// 6. Ŭ���̾�Ʈ���� ������ �����ϱ�
					InputStream inputStream = socket.getInputStream();
					byte[] bytes = new byte[1000];
					inputStream.read(bytes);
					System.out.println("���� �޽��� : "+new String(bytes));
					
					// 7. Ŭ���̾�Ʈ���� �޽��� �۽��ϱ�
					System.out.print("���� �����ø� �Է��ϼ��� : ");
					Scanner scanner = new Scanner(System.in);
					String msg = scanner.next();
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(msg.getBytes());
				}
			}
		} catch (Exception e) {System.out.println("���� Ŭ���� ���� �߻� : "+e);}
	}
}
