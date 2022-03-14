package Day09_bank;

import java.util.Scanner;

public class Day09_6_은행계좌프로그램 {
	
	public static Bank[] accountList = new Bank[100];

		// 모든 클래스에서 사용하기 위해 main밖에서 static으로 선언.
	
	public static void main(String[] args) {
		
		// 은행계좌프로그램 [ 상속 ]
			// 은행 [ super ]
			// 국민은행 [ sub ], 신한은행 [ sub ], 하나은행 [ sub ]
			// 주 기능 : 1. 계좌생성 2. 입금 3. 출금 4. 이체 5. 내계좌목록 6. 대출
	Scanner scanner = new Scanner(System.in);
	
	while(true) {	// 종료조건 : 없음
		System.out.println("===============계좌 시스템===============");
		System.out.println("1. 계좌생성 | 2. 입금 | 3. 출금 | 4. 이체 | 5. 계좌목록 | 6. 대출");
		System.out.print("선택 >");
		int 선택 = scanner.nextInt();
		
		BankController controll = new BankController();	// 컨
		
		
		if (선택==1) {
			System.out.println("***계좌생성 페이지***");	
			System.out.println("비밀번호 : ");	
			String password = scanner.next();
			System.out.println("계좌주 : ");	
			String name = scanner.next();
			System.out.println("은행선택 | 1. 국민 | 2. 신한 | 3. 하나");
			int bankno = scanner.nextInt();
			
			String 계좌번호 = controll.계좌생성(password, name, bankno);
				// 위에서 입력받은 password, name, bankno를 controll class의 계좌생성 메서드로 던짐.
			if(계좌번호!=null) {
				System.out.println("*** 계좌 생성 ***");
				System.out.println("고객님의 계좌번호는 : "+계좌번호+" 입니다.");
			}else {
				System.out.println("계좌 생성 실패.");
			}
			
			
			
		}else if(선택==2) {
			System.out.println("***입금 페이지***");
			System.out.print("계좌번호 : ");
			String 계좌번호 = scanner.next();
			System.out.print("입금액 : ");
			int 입금액 = scanner.nextInt();
			
			boolean 입금성공여부 = controll.입금(계좌번호, 입금액);
		
			if(입금성공여부==true) {
				System.out.println(계좌번호+"에 "+입금액+"만큼 입금했습니다.");
			}else {
				System.out.println("입금 실패");
			}
				
			
		}else if(선택==3) {
			System.out.println("***출금 페이지***");	
			System.out.print("계좌번호 : ");
			String 계좌번호 = scanner.next();
			System.out.print("비밀번호 : ");
			String 비밀번호 = scanner.next();
			System.out.print("출금액 : ");
			int 출금액 = scanner.nextInt();
			
			int 출금결과 = controll.출금(계좌번호, 비밀번호, 출금액	);
			
			if(출금결과==1) {
			System.out.println("잔액 부족");	
			}else if(출금결과==2) {
			System.out.println("출금 성공");
			}else if(출금결과==3) {
			System.out.println("동일한 정보가 없습니다.");
			}
				
		}else if(선택==4) {
			System.out.println("***이체 페이지***");	
			System.out.print("계좌번호 : ");
			String 계좌번호 = scanner.next();
			System.out.print("비밀번호 : ");
			String 비밀번호 = scanner.next();
			System.out.print("이체금액 : ");
			int 이체금액 = scanner.nextInt();
			System.out.print("이체계좌 : ");
			String 이체계좌 = scanner.next();
			
			int 이체결과 = controll.이체(계좌번호, 비밀번호, 이체금액, 이체계좌);
			
			if(이체결과==1) {
				System.out.println("정상적으로 이체되었습니다.");
			}else if(이체결과==2) {
				
			}
			// 1= 정상입금, 2= 
			
		}else if(선택==5) {
			
			System.out.println("***계좌 목록 페이지***");	// 이름을 입력하면 해당하는 계좌번호만 출력
			System.out.print("이름 입력 : ");
			String name = scanner.next();
			Bank[] 내계좌목록 = controll.내계좌목록(name);
			
			System.out.println("***** 검색한 계좌주 님의 계좌 목록 *****");
			int i=1;
			for (Bank tmp : 내계좌목록) {
				if(tmp!=null) {
					System.out.println(i+"번째 계좌번호 : "+ tmp.getAnumber());
				}
				i++;
			}
			
				
			
			
		}else if(선택==6) {
			System.out.println("***대출 페이지***");	
			
		}else {
			System.out.println("잘못 선택하셨습니다");
		}
		
		}	// while END
	}	// main END
}	// class END
