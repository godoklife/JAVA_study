package AAexamples.day26;

import java.net.InetAddress;

public class Day26_01 {
	
	// 네트워크 : 두 대 이상의 컴퓨터들을 통신망을 통해 연결하고 통신할 수 있도록 함
		// 통신망 : 전자신호를 통해 통신하는 모든 기기가 서로 통신하기 위한 하나의 망
		// 프로토콜 : 컴퓨터 내부 또는 외부 데이터 교환 방식을 정의하는 규격 ( 체계 )
			// SMTP : Simple Mail Transfer Protocol
			// IP : Internet Protocol
	
	// TCP/IP 
		// TCP : Transmission Control Protocol : 통신 제어
		// IP : Internet Protocol : 통신 인식 번호 
	
	public static void main(String[] args) {
		
		// 1. 본인 PC의 IP 주소 출력
			// cmd->ipconfig
		// 2. JAVA에서 본인 ip주소 출력
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
				// 자바 외부와 통신할 경우 반드시 일반예외가 발생. try-catch 사용 필수.
			System.out.println("현재 PC의 이름과 ip address : "+ inetAddress);
			System.out.println("현재 PC의 이름 : "+ inetAddress.getHostName());
			System.out.println("현재 PC의 ip address : "+ inetAddress.getHostAddress());
			
			// 3. naver의 ip주소 확인
			InetAddress inetAddress2 = InetAddress.getByName("www.naver.com");
			System.out.println();
			System.out.println("NAVER 의 이름과 ip address : "+ inetAddress2);
			System.out.println("NAVER 의 이름 : "+ inetAddress2.getHostName());
			System.out.println("NAVER 의 ip address : "+ inetAddress2.getHostAddress());
			
			// 4. facebook의 ip주소 확인
			InetAddress inetAddress3 = InetAddress.getByName("www.facebook.com");
			System.out.println();
			System.out.println("facebook 의 이름과 ip address : "+ inetAddress3);
			System.out.println("facebook 의 이름 : "+ inetAddress3.getHostName());
			System.out.println("facebook 의 ip address : "+ inetAddress3.getHostAddress());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
