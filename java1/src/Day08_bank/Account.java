//package Day08_bank;
//
//public class Account {
//
//	// 1. �ʵ�
//	int money = 0;
//	int ano = 0;
//	String name;
//	
//	
//	// 2. ������
//	
//	public Account() {	// ���������
//	}
//
//	public Account(int ano, String name) {	// ����ڰ� ���»����� ����� ������
//		this.ano = ano;
//		this.name = name;
//	}
//	
//	
//	
//	public Account(String name, int money) {	// �Աݽ� ����� ������
//		this.money = money;
//		this.name = name;
//	}
//
//	public Account(int money, int ano, String name) {	// Ǯ������
//		this.money = money;
//		this.ano = ano;
//		this.name = name;
//	}
//	
//	
//	// 3.�޼���
//	
//	void transfer() {	// ������ü
//		while(true) {
//			boolean isCompletetransfer=false;
//			System.out.println("===============������ü===============");
//			System.out.println("��ü���� ���¹�ȣ�� �Է��ϼ���");
//			int ano = Menu.scanner.nextInt();
//			System.out.println("��ü�Ͻ� �ݾ��� �Է��ϼ���");
//			int money = Menu.scanner.nextInt();
//			System.out.printf("��ü���� ���� ��ȣ : %d\n ��ü�Ͻ� �ݾ� : %d", ano, money);
//			
//			
//			int i=0;	// ���� �ε��� �ӽ������ �迭
//			for(Account temp : Menu.accounts) {	// ���¹�ȣ �˻�
//				if(temp.ano==ano) {	//���¹�ȣ�� ��ġ�ϸ�
//					if(temp.money>money) {	// �ܰ� ����ϸ�
//						System.out.println("��ü�� �Ϸ�Ǿ����ϴ�.");
//						Menu.accounts[i].money -= money;
//						isCompletetransfer=true;
//						break;
//					}
//					else {	// �ܰ� �����ϸ�
//						System.out.println("�ܾ��� �����մϴ�.");
//						break;
//					}
//				}
//			i++;		
//			}
//			if(isCompletetransfer==false) {	// ��ġ�ϴ� ���� ã�� ���н� ���
//				System.out.println("���¹�ȣ�� Ȯ�����ּ���.");
//				break;
//			}
//		}
//	}	// transfer END
//	
//	void deposit() {	// �����Ա�
//		while(true) {
//			System.out.println("===============�����Ա�===============");
//			System.out.println("���¿� �Ա��Ͻ� �ݾ��� �Է��ϼ���.");
//			int money = Menu.scanner.nextInt();
//			System.out.printf("�Ա��� ���� ��ȣ : %d\n �Ա��Ͻ� �ݾ� : %d", ano, money);
//			
//			int i=0;
//			for(Account temp : Menu.accounts) {	
//				if(temp.ano==ano) {	//���¹�ȣ�� ��ġ�ϸ�
//					System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
//					Menu.accounts[i].money += money;
//						break;
//				}
//			i++;	// �ε��� ī��Ʈ ��
//			}
//				System.out.println("���¹�ȣ�� Ȯ�����ּ���.");
//				break;
//			
//		}	// deposit while END
//	}	// deposit END
//	
//}	// class END




package Day08_bank;

import java.util.Random;

public class Account {

	// �ʵ�
	// ���¹�ȣ, �����̸� , �ܰ� , ������
	int ano ;
	String aname ;
	int money ;
	String owner ;

	// ������
	public Account() {}

	public Account(int ano, String aname, int money, String owner) {
		this.ano = ano;
		this.aname = aname;
		this.money = money;
		this.owner = owner;
	}
	
	// �޼ҵ�
	
	// ���� ����, �Ա�, ���, ��ü, ����, �� ���¸��
	void create (String loginid) {
		Random random = new Random();
		int ano = random.nextInt(1000)+1001;
		for(Account temp : Menu.account) {
			if (temp != null && temp.ano != ano) {
				break;		
			}
		}
		System.out.print("�����̸��� �Է��ϼ��� : ");
		String aname = Menu.scanner.next();
		Account account = new Account(ano,aname,0,loginid);
		int i = 0 ;
		for (Account temp : Menu.account) {
			if(temp == null) { // ������̸� ��ü����
				Menu.account[i] = account; // ������̸� ����
			}
			i++ ; // ������ƴҽ� �ε��� 1����
		}
	}
	void in() {}
	void out() {}
	void send() {}
	void list() {}
}


