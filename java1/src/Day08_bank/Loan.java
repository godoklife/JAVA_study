package Day08_bank;

public class Loan {
	
	// 1. �ʵ�
	String productName;
	int productMoney = 0;	// �����ǰ 
	double percent = 0;		// �����ǰ ���� �����
	int usedMoney = 0;		// �����ذ� �ݾ�
	int ano = 0;			// �����ذ� ���� �����
	boolean loanUser;
	
	// 2. ������
	public Loan() {}

	public Loan(String productName, int productMoney, double percent) {	// ������ �����ǰ ������
		this.productName = productName;
		this.productMoney = productMoney;
		this.percent = percent;
	}

	public Loan(String productName, int productMoney, double percent, int usedMoney, int ano, boolean loanUser) {	// Ǯ������
		this.productName = productName;
		this.productMoney = productMoney;
		this.percent = percent;
		this.usedMoney = usedMoney;
		this.ano = ano;
		this.loanUser = loanUser;
	}

	// 3. �޼���
	void makeProduct() {	// �μ� X, ��ȯ�� X
		System.out.println("--------�����ǰ ����--------");
		System.out.println("��ǰ���� �Է��ϼ���.");
		String productname = Menu.scanner.next();
		
		System.out.println("��ǰ�� �ݾ��� �Է��ϼ���.");
		int productmoney = Menu.scanner.nextInt();
		
		System.out.println("��ǰ�� ���ڸ� �Է��ϼ���.");
		double percent = Menu.scanner.nextDouble();
		
		System.out.printf("�Է��� ������ ������ �����ϴ�.\n ��ǰ�� : %s\n�ݾ� : %d\n���� : %f\n", productname, productmoney, percent);
		System.out.println("�����Ͻðڽ��ϱ�? y_n");
		if(Menu.scanner.next().equals("y")) {
			Loan loan = new Loan(productname, productmoney, percent);
			int i=0;
			for (Loan temp : Menu.loans) {
				if(temp==null) {
					System.out.println("����Ϸ�");
					Menu.loans[i] = loan;
					break;
				}
			}
		}
		else if(Menu.scanner.next().equals("n")) {
			System.out.println("���. �����մϴ�.");
			return;
		}
		else 
			System.out.println("�ҹ��� y, n�� �����ּ���.");
		
	}	// makeProduct END
	
	void useLoan(String ano) {
		System.out.println("==============���⼭��==============");
		System.out.printf("no\t��ǰ��\t\t����ݾ�\t\t��������\n");
		int i=1;	// ��ȣ ��¿�
		for(Loan temp : Menu.loans) {
			if(temp.productName!=null)
				System.out.printf("%d%10s%10d%10f",i,temp.productName, temp.productMoney, temp.percent);
			i++;
		}
		System.out.println("�̿��Ͻ� ��ǰ���� �Է��ϼ���.");
		String pname = Menu.scanner.next();
		for(Loan temp : Menu.loans) {
			if(temp.productName.equals(pname) && temp!=null) {
				System.out.println("��ǰ�� �����մϴ�.");
				for(Account temp2 : Menu.account) {
					if(temp2.ano == temp.)
				}
			}
		}
	}
	
//	void loanUserList() {
//		System.out.println("���� ����� ��� ��ȸ");
//		System.out.printf("���¹�ȣ\t\t����ݾ�\t\t��������\t\t�� �ݾ�\n");
//		for (Loan temp : Menu.loans) {
//			if(temp.productName==null&&temp.loanUser==true) {
//				System.out.printf("%d\t\t%d\t\t%f\t\t%d",);
//			}
//		}
//	}
	
	
	
}
