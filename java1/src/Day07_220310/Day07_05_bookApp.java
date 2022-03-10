package Day07_220310;

import java.util.Scanner;

public class Day07_05_bookApp {	// class START
	
	// main 밖에 변수를 선언하는 이유??? 모든 메서드에서 사용하기 위함.
		// 지역변수 : 중괄호 { 변수 선언 } 내에서 선언된 변수, 괄호 밖을 못나감.
			// 서로 다른 { } 중괄호 내에서 사용시 -> 전력 변수
		// static : 프로그램 종료시까지 메모리 할당.
			// 프로그램 시작시 메모리 할당, 종료시 메모리 초기화.
			// 프로그램 전반전으로 모든 곳에 사용되는 경우 사용.(ex. Scanner)
			// static은 메모리를 우선할당 하는데, static 외의 메모리(메서드, 필드)를 읽지 못함.
	static Scanner scanner = new Scanner(System.in);
	static Member[] members = new Member[100];	// 모든 class(member)에서 사용하는 회원 배열.
	
	
	// 0. 코드를 읽어주는 시작 메서드 [ thread ]
	public static void main(String[] args) {	// main START
		
		
		// 외부 호출 방식
		// 내 노션에 메모해둔것 참고할것.
		
		Day07_05_bookApp application = new Day07_05_bookApp();
		application.menu();
		
	}	// main END
	
	// 1. 초기 매뉴 메서드
	void menu() {
		while(true) {
			System.out.println("--------------도서 대여 프로그램--------------");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 아이디 찾기 | 4. 비밀번호 찾기");
			System.out.print("선택>");
			int ch = scanner.nextInt();
			
			Member member = new Member();	// ch== 1~4 모두 사용하니까 밖에다 선언함.
			
			boolean signupCheck = false;	// 아이디 가입 성공 여부 기록 스위치
			
			if(ch==1) {	
				boolean result = member.signup();	// 회원가입 메서드 호출
				if(result) {	// member.signup()의 반환값은 T, F임.
					System.out.println("회원가입 성공!");
				}
				else {
					System.err.println("가입에 실패했습니다.");
				}
			}	// if(ch==1) END
			
			else if(ch==2) {
				member.login();// 로그인 메서드 호출
					// 1. 일반 회원 메뉴 메서드 호출
					// 2. 관리자 메뉴 메서드 호출
			}	// if(ch==2) END
			
			else if(ch==3) {
				// 아이디 찾기 메서드 호출
			}	// if(ch==3) END
			
			else if(ch==4) {
				// 비번 찾기 메서드 호출
			}	// if(ch==4) END
			
			else {
				// 이제 말 안해도 뭔지 알지??
				System.out.println("알림____잘못 입력하였습니다.");
			}	// 예외값 END
		}
	}	//	void menu END
	// 2. 일반 회원 메뉴 메서드
	void membermenu() {
		
	}	// 일반 회원 메뉴 메서드 END
	// 3. 관리자 메뉴 메서드
	void adminmenu() {
		
	}	// 관리자 메뉴 메서드 END
}	// class END
