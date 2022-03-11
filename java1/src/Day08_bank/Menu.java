package Day08_bank;

import java.util.Scanner;

public class Menu {
	static Scanner scanner = new Scanner(System.in);
	static Member[] members  = new Member[1000];
	
	public static void main(String[] args) {	
		
		Menu application = new Menu();
		application.menu();
		
	}	// main END
	
	void menu() {
		
		while(true) {
			Member member = new Member();
			System.out.println("=================모바일 뱅킹 프로그램=================");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 아이디 찾기 | 4. 비밀번호 찾기");
			System.out.print("선택 >");
			String ch = scanner.next();
			
			if(ch!=null && ch.equals("1")) {
				member.signup();
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				
			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				
			}	// else if ch==4 END
			
			else
				System.out.println("잘못 입력하셨습니다.");
			
		}	// menu while END
	}	// menu END
	
	void membermenu() {
		while(true) {
			System.out.println("=================일반 사용자 매뉴=================");
			System.out.println("1. 계좌생성 | 2. 입금 | 3. 출금 | 4. 이체 | 5. 대출 | 6. 계좌 목록 조회");
			System.out.print("선택 >");
			String ch = scanner.next();
			
			if(ch!=null && ch.equals("1")) {
				
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				
			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				
			}	// else if ch==4 END
			
			else if (ch!=null && ch.equals("5")) {
				
			}	// else if ch==5 END
			
			else if (ch!=null && ch.equals("6")) {
	
			}	// else if ch==6 END
			
			else
				System.out.println("잘못 입력하셨습니다.");
			
		}	// membermenu while END
	}	// membermenu END	
	
	void adminmenu() {	// 세부 매뉴 미완성. 안건들임;;
		while(true) {
			System.out.println("=================관리자 매뉴=================");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 아이디 찾기 | 4. 비밀번호 찾기");
			System.out.print("선택 >");
			String ch = scanner.next();
			
			if(ch!=null && ch.equals("1")) {
				
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				
			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				
			}	// else if ch==4 END
			
			else
				System.out.println("잘못 입력하셨습니다.");
			
		}	// adminmenu while END
	}	// adminmenu END
	
}
