package Day08_bank;

public class Loan {
	
	// 1. 필드
	String productName;
	int productMoney = 0;	// 대출상품 
	double percent = 0;		// 대출상품 이율 저장용
	int usedMoney = 0;		// 대출해간 금액
	int ano = 0;			// 대출해간 계좌 저장용
	boolean loanUser;
	
	// 2. 생성자
	public Loan() {}

	public Loan(String productName, int productMoney, double percent) {	// 관리자 대출상품 생성용
		this.productName = productName;
		this.productMoney = productMoney;
		this.percent = percent;
	}

	public Loan(String productName, int productMoney, double percent, int usedMoney, int ano, boolean loanUser) {	// 풀생성자
		this.productName = productName;
		this.productMoney = productMoney;
		this.percent = percent;
		this.usedMoney = usedMoney;
		this.ano = ano;
		this.loanUser = loanUser;
	}

	// 3. 메서드
	void makeProduct() {	// 인수 X, 반환값 X
		System.out.println("--------대출상품 생성--------");
		System.out.println("상품명을 입력하세요.");
		String productname = Menu.scanner.next();
		
		System.out.println("상품의 금액을 입력하세요.");
		int productmoney = Menu.scanner.nextInt();
		
		System.out.println("상품의 이자를 입력하세요.");
		double percent = Menu.scanner.nextDouble();
		
		System.out.printf("입력한 내용은 다음과 같습니다.\n 상품명 : %s\n금액 : %d\n이율 : %f\n", productname, productmoney, percent);
		System.out.println("실행하시겠습니까? y_n");
		if(Menu.scanner.next().equals("y")) {
			Loan loan = new Loan(productname, productmoney, percent);
			int i=0;
			for (Loan temp : Menu.loans) {
				if(temp==null) {
					System.out.println("저장완료");
					Menu.loans[i] = loan;
					break;
				}
			}
		}
		else if(Menu.scanner.next().equals("n")) {
			System.out.println("취소. 종료합니다.");
			return;
		}
		else 
			System.out.println("소문자 y, n만 눌러주세요.");
		
	}	// makeProduct END
	
	void useLoan(String ano) {
		System.out.println("==============대출서비스==============");
		System.out.printf("no\t상품명\t\t대출금액\t\t대출이율\n");
		int i=1;	// 번호 출력용
		for(Loan temp : Menu.loans) {
			if(temp.productName!=null)
				System.out.printf("%d%10s%10d%10f",i,temp.productName, temp.productMoney, temp.percent);
			i++;
		}
		System.out.println("이용하실 상품명을 입력하세요.");
		String pname = Menu.scanner.next();
		for(Loan temp : Menu.loans) {
			if(temp.productName.equals(pname) && temp!=null) {
				System.out.println("상품을 실행합니다.");
				for(Account temp2 : Menu.account) {
					if(temp2.ano == temp.)
				}
			}
		}
	}
	
//	void loanUserList() {
//		System.out.println("대출 사용자 목록 조회");
//		System.out.printf("계좌번호\t\t대출금액\t\t대출이자\t\t총 금액\n");
//		for (Loan temp : Menu.loans) {
//			if(temp.productName==null&&temp.loanUser==true) {
//				System.out.printf("%d\t\t%d\t\t%f\t\t%d",);
//			}
//		}
//	}
	
	
	
}
