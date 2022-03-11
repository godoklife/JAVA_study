package Day08_bank;

public class Account {

	// 1. 필드
	int money = 0;
	int ano = 0;
	String name;
	
	
	// 2. 생성자
	
	public Account() {
	}

	public Account(int money, int ano, String name) {
		this.money = money;
		this.ano = ano;
		this.name = name;
	}
	
	
	// 3.메서드
	
	void deposit() {
		
		System.out.println("===============계좌입금===============");
		System.out.println("입금하실 계좌번호를 입력하세요");
		int ano = Menu.scanner.nextInt();
		
		
	}
	
}
