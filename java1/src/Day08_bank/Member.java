package Day08_bank;

import java.util.Random;

public class Member { // c s

	int ano ;
	String id ;
	String password ;
	String name ;
	String phone ;
	
	public Member() {}
	public Member(String id, String password, String name, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	public Member(int ano, String id, String password, String name, String phone) {
		this.ano = ano;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	boolean signup(){
		Random random = new Random();
		System.out.println("---------- ȸ������ ������ ----------");
		System.out.print("���̵� : "); String id = Menu.scanner.next();
		for (Member temp : Menu.members) {
			if (temp != null && temp.id.equals(id)) {
				System.out.println("�˸�) ���� ������� ���̵��Դϴ�.");
				return false;
			}
		}
		System.out.print("��й�ȣ : "); String password = Menu.scanner.next();
		System.out.print("�̸� : "); String name = Menu.scanner.next();
		System.out.print("��ȭ��ȣ : "); String phone = Menu.scanner.next();
		
		
		int ano = random.nextInt(10000)+10001;	// 10000~20000 ���� ���¹�ȣ �߱�
		
		Member member = new Member(ano, id, password, name, phone);	
		System.out.println("�˸�) ȸ������ �Ϸ�.");
		System.out.println("�˸�) ȸ������ ���¹�ȣ�� : " + ano);
		return true;
	}
	void login(){}
	void findid(){}
	void findpw(){}
	
	
	
} // c e
