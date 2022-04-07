package AAexamples.day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day26_02_client {

	public static void main(String[] args) {
		
		// 1. �Ϲ� ���� �����	(������ �ƴϱ⿡)
		Socket socket = new Socket();
		
		
		try {
			while(true) {
				// 2. ���� �������� �����ϱ�
				socket.connect(new InetSocketAddress("127.168.102.50", 5000));
				System.out.println("������ ���� ����.");
				while(true) {
					// 3. ������ ������ �۽��ϱ� : ��Ʈ���� �̿��� �ܺ� ��Ʈ��ũ ���
					System.out.println("�������� ���� �޽��� �Է� : ");
					Scanner scanner = new Scanner(System.in);
					String msg = scanner.next();
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(msg.getBytes());
					
					// 4. �����κ��� �޽��� �����ϱ�
					InputStream inputStream = socket.getInputStream();
					byte[] in = new byte[1024];
					inputStream.read(in);
					System.out.println("�����κ��� ���� �޽��� : "+new String(in));
					
				}
			}	
		}catch(Exception e) {System.out.println("Ŭ���̾�Ʈ ���� �߻� : "+e);}
	}
}
