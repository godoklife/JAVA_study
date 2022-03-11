//package Day08_bank;
//
//public class Account {
//
//	// 1. 필드
//	int money = 0;
//	int ano = 0;
//	String name;
//	
//	
//	// 2. 생성자
//	
//	public Account() {	// 깡통생성자
//	}
//
//	public Account(int ano, String name) {	// 사용자가 계좌생성시 사용할 생성자
//		this.ano = ano;
//		this.name = name;
//	}
//	
//	
//	
//	public Account(String name, int money) {	// 입금시 사용할 생성자
//		this.money = money;
//		this.name = name;
//	}
//
//	public Account(int money, int ano, String name) {	// 풀생성자
//		this.money = money;
//		this.ano = ano;
//		this.name = name;
//	}
//	
//	
//	// 3.메서드
//	
//	void transfer() {	// 계좌이체
//		while(true) {
//			boolean isCompletetransfer=false;
//			System.out.println("===============계좌이체===============");
//			System.out.println("이체받을 계좌번호를 입력하세요");
//			int ano = Menu.scanner.nextInt();
//			System.out.println("이체하실 금액을 입력하세요");
//			int money = Menu.scanner.nextInt();
//			System.out.printf("이체받을 계좌 번호 : %d\n 이체하실 금액 : %d", ano, money);
//			
//			
//			int i=0;	// 계좌 인덱스 임시저장용 배열
//			for(Account temp : Menu.accounts) {	// 계좌번호 검색
//				if(temp.ano==ano) {	//계좌번호가 일치하면
//					if(temp.money>money) {	// 잔고도 충분하면
//						System.out.println("이체가 완료되었습니다.");
//						Menu.accounts[i].money -= money;
//						isCompletetransfer=true;
//						break;
//					}
//					else {	// 잔고가 부족하면
//						System.out.println("잔액이 부족합니다.");
//						break;
//					}
//				}
//			i++;		
//			}
//			if(isCompletetransfer==false) {	// 일치하는 계좌 찾기 실패시 출력
//				System.out.println("계좌번호를 확인해주세요.");
//				break;
//			}
//		}
//	}	// transfer END
//	
//	void deposit() {	// 계좌입금
//		while(true) {
//			System.out.println("===============계좌입금===============");
//			System.out.println("계좌에 입금하실 금액을 입력하세요.");
//			int money = Menu.scanner.nextInt();
//			System.out.printf("입금할 계좌 번호 : %d\n 입금하실 금액 : %d", ano, money);
//			
//			int i=0;
//			for(Account temp : Menu.accounts) {	
//				if(temp.ano==ano) {	//계좌번호가 일치하면
//					System.out.println("입금이 완료되었습니다.");
//					Menu.accounts[i].money += money;
//						break;
//				}
//			i++;	// 인덱스 카운트 업
//			}
//				System.out.println("계좌번호를 확인해주세요.");
//				break;
//			
//		}	// deposit while END
//	}	// deposit END
//	
//}	// class END




package Day08_bank;

import java.util.Random;

public class Account {

	// 필드
	// 계좌번호, 계좌이름 , 잔고 , 소유주
	int ano ;
	String aname ;
	int money ;
	String owner ;

	// 생성자
	public Account() {}

	public Account(int ano, String aname, int money, String owner) {
		this.ano = ano;
		this.aname = aname;
		this.money = money;
		this.owner = owner;
	}
	
	// 메소드
	
	// 계좌 생성, 입금, 출금, 이체, 대출, 내 계좌목록
	void create (String loginid) {
		Random random = new Random();
		int ano = random.nextInt(1000)+1001;
		for(Account temp : Menu.account) {
			if (temp != null && temp.ano != ano) {
				break;		
			}
		}
		System.out.print("계좌이름을 입력하세요 : ");
		String aname = Menu.scanner.next();
		Account account = new Account(ano,aname,0,loginid);
		int i = 0 ;
		for (Account temp : Menu.account) {
			if(temp == null) { // 빈공간이면 객체대입
				Menu.account[i] = account; // 빈공간이면 대입
			}
			i++ ; // 빈공간아닐시 인덱스 1증가
		}
	}
	void in() {}
	void out() {}
	void send() {}
	void list() {}
}


