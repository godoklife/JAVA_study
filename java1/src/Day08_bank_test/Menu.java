package Day08_bank_test;

import java.util.Scanner;

public class Menu {
Scanner scanner = new Scanner(s)		
	public static void main(String[] args) {	
		
		
	}	// main END
	
	void menu() {
	
		while(true) {
			System.out.println("=================모바일 뱅킹 프로그램=================");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 아이디 찾기 | 4. 비밀번호 찾기");
			System.out.print("선택 >");
			String ch = scanner.next();
			Member member = new Member();
			if(ch!=null && ch.equals("1")) {
			boolean result = member.signup();
				if (result) {
					System.out.println("알림) 회원가입 성공.");
				}
				else {
					System.out.println("알림) 회원가입 실패");
				}
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				String result = member.login();
				if (result == null ) {
					System.out.println("알림) 동일한 회원정보가 없습니다.");
				}
				else if(result.equals("admin")){
					// 2. 관리자 메뉴 메소드 호출
					System.out.println("알림) 안녕하세요~ " + result + "님");
					adminmenu();
				}
				else {
					// 3. 일반회원 메뉴 메소드 호출
					System.out.println("알림) 안녕하세요~ " + result + "님");
					membermenu(result);
				}
					

			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				member.findid();
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				member.findpw();
			}	// else if ch==4 END	
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}	// menu while END
	}	// menu END
	
	void membermenu(String loginid) {
		while(true) {
			System.out.println("=================일반 사용자 매뉴=================");
			System.out.println("1. 계좌생성 | 2. 입금 | 3. 출금 | 4. 이체 | 5. 대출 | 6. 계좌 목록 조회");
			System.out.print("선택 >");
			String ch = scanner.next();
			Account account = new Account();
			if(ch!=null && ch.equals("1")) {
				account.create(loginid);
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				account.in();
			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				account.out();
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				account.send();
			}	// else if ch==4 END
			
			else if (ch!=null && ch.equals("5")) {
				
			}	// else if ch==5 END
			
			else if (ch!=null && ch.equals("6")) {
				account.list();
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