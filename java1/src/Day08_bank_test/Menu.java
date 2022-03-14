package Day08_bank_test;

import java.util.Scanner;

public class Menu {

static Scanner scanner = new Scanner(System.in);
static Member[] member = new Member[1000];


	public static void main(String[] args) {	
	
		Menu bankingapp = new Menu();
		bankingapp.mainMenu();
		
	}	// main END
	
	void mainMenu() {
		while(true) {
			System.out.println("=============모바일 뱅킹 프로그램=============");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 아이디찾기 | 4. 비밀번호 찾기");
			System.out.print("입력 >");
			String ch=scanner.next();
			if(ch.equals("1")) {
// 왜 고장???				boolean joinResult = member.join();
			}
			else if(ch.equals("2")) {
				
			}
			else if(ch.equals("3")) {
				
			}
			else if(ch.equals("4")) {
				
			}
			else
				System.out.println("알림) 잘못 입력하셨습니다.");
		}	// mainMenu while END
	}	// mainMenu END
	
}	// class END