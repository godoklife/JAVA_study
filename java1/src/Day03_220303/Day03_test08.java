package Day03_220303;

import java.util.Scanner;

public class Day03_test08 {
	public static void main(String[] args) {
		System.out.print("문제8 로그인페이지\n[ 입력 ] : 아이디와 비밀번호를 입력받기\n[ 조건 ] : 회원아이디가 admin 이고\n비밀번호가 1234 일 경우에는\n로그인 성공 아니면 로그인 실패 출력\n");
		System.out.println("--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("아이디를 입력하세요 : ");
		String ID = scanner.next();
			// char 자료형은 문자 1개를 저장한다.
			// 문자열 저장 불가능!!!
			// 따라서 String 클래스 사용하여야 한다.
		
		System.out.println("비밀번호를 입력하세요 : ");
		int PW = scanner.nextInt();
		
		boolean login = false;
		
//		if(ID.equals("admin") && (PW == 1234)) {
//			// String은 ==같은 대입연산자 사용불가!
//			// 대신 비교할 스트링1.equals(비교할 스트링2)
//			System.out.println("로그인 성공");
//			login = true;
//		}
		
		if(ID.equals("admin") ) {
			if(PW == 1234) {
				login = true;
				System.out.println("로그인 성공");
			}
			else System.out.println("비밀번호를 확인하세요");
		}
		else System.out.println("아이디를 확인하세요");
			
		if(login==false) System.out.println("로그인 실패!!");

		scanner.close();
	}
}
