package Day08_bank;

public class Account {

	// 1. �ʵ�
	int money = 0;
	int ano = 0;
	String name;
	
	
	// 2. ������
	
	public Account() {
	}

	public Account(int money, int ano, String name) {
		this.money = money;
		this.ano = ano;
		this.name = name;
	}
	
	
	// 3.�޼���
	
	void deposit() {
		
		System.out.println("===============�����Ա�===============");
		System.out.println("�Ա��Ͻ� ���¹�ȣ�� �Է��ϼ���");
		int ano = Menu.scanner.nextInt();
		
		
	}
	
}
