package AAexamples.day26;

import java.net.InetAddress;

public class Day26_01 {
	
	// ��Ʈ��ũ : �� �� �̻��� ��ǻ�͵��� ��Ÿ��� ���� �����ϰ� ����� �� �ֵ��� ��
		// ��Ÿ� : ���ڽ�ȣ�� ���� ����ϴ� ��� ��Ⱑ ���� ����ϱ� ���� �ϳ��� ��
		// �������� : ��ǻ�� ���� �Ǵ� �ܺ� ������ ��ȯ ����� �����ϴ� �԰� ( ü�� )
			// SMTP : Simple Mail Transfer Protocol
			// IP : Internet Protocol
	
	// TCP/IP 
		// TCP : Transmission Control Protocol : ��� ����
		// IP : Internet Protocol : ��� �ν� ��ȣ 
	
	public static void main(String[] args) {
		
		// 1. ���� PC�� IP �ּ� ���
			// cmd->ipconfig
		// 2. JAVA���� ���� ip�ּ� ���
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
				// �ڹ� �ܺο� ����� ��� �ݵ�� �Ϲݿ��ܰ� �߻�. try-catch ��� �ʼ�.
			System.out.println("���� PC�� �̸��� ip address : "+ inetAddress);
			System.out.println("���� PC�� �̸� : "+ inetAddress.getHostName());
			System.out.println("���� PC�� ip address : "+ inetAddress.getHostAddress());
			
			// 3. naver�� ip�ּ� Ȯ��
			InetAddress inetAddress2 = InetAddress.getByName("www.naver.com");
			System.out.println();
			System.out.println("NAVER �� �̸��� ip address : "+ inetAddress2);
			System.out.println("NAVER �� �̸� : "+ inetAddress2.getHostName());
			System.out.println("NAVER �� ip address : "+ inetAddress2.getHostAddress());
			
			// 4. facebook�� ip�ּ� Ȯ��
			InetAddress inetAddress3 = InetAddress.getByName("www.facebook.com");
			System.out.println();
			System.out.println("facebook �� �̸��� ip address : "+ inetAddress3);
			System.out.println("facebook �� �̸� : "+ inetAddress3.getHostName());
			System.out.println("facebook �� ip address : "+ inetAddress3.getHostAddress());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
