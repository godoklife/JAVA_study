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
	
	boolean signup(){ // ȸ������ �޼ҵ� ����
		Random random = new Random();
		System.out.println("---------- ȸ������ ������ ----------");
		System.out.print("���̵� : "); String id = Menu.scanner.next();
		for (Member temp : Menu.members) { // id �ߺ��˻� for�� ����
			if (temp != null && temp.id.equals(id)) {
				System.out.println("�˸�) ���� ������� ���̵��Դϴ�.");
				return false;
			}
		} // id �ߺ��˻� for�� ����
		
		System.out.print("��й�ȣ : "); String password = Menu.scanner.next();
		System.out.print("�̸� : "); String name = Menu.scanner.next();
		System.out.print("��ȭ��ȣ : "); String phone = Menu.scanner.next();
		
		int ano = random.nextInt(10000)+10001; // 10000~20000 �������� ����
		
		///////////////////////////////////////////
		//////////////////�ߺ��˻� �ؾ���//////////////
		///////////////////////////////////////////
		
		Member member = new Member(ano, id, password, name, phone);	
		System.out.println("�˸�) ȸ������ �Ϸ�.");
		System.out.println("�˸�) ȸ������ ���¹�ȣ�� : " + ano);
		return true;
	} // ȸ������ �޼ҵ� ����
	
	String login(){ // �α��� �޼ҵ� ����
		System.out.println("---------- �α��� ������ ----------");
		System.out.print("���̵� : "); String id = Menu.scanner.next();
		System.out.print("��й�ȣ : "); String password = Menu.scanner.next();
		for (Member temp : Menu.members) {
			if (temp != null && temp.id.equals(id) &&
				temp != null && temp.password.equals(password)) {
				// members�迭�� ��ü�� ���̵� ��й�ȣ ��ġ�ϸ� �α��μ��� & ���̵� ��ȯ
				return id; 
			}
		}
		return null; // ��ȯ�� id,admin,null �� ����� ���� �и�
	} // �α��� �޼ҵ� ����
	
	void findid(){ // ���̵�ã�� �޼ҵ� ����
		System.out.println("---------- ���̵�ã�� ������ ----------");
		System.out.print("�̸� : "); String name = Menu.scanner.next();
		System.out.print("��ȭ��ȣ : "); String phone = Menu.scanner.next();
		for(Member temp : Menu.members) { // �̸�,��ȭ ��ġã�� for�� ����
			if(temp != null && temp.name.equals(name) &&
				temp.phone.equals(phone)) {
				System.out.println(name+"���� ���̵�� : " + temp.id);
				return; // �̸�,��ȭ ��ġ�ϸ� ����
			}
		} // �̸�,��ȭ ��ġã�� for�� ����
		System.out.println("�˸�) ������ ȸ�������� �����ϴ�.");
	} // ���̵�ã�� �޼ҵ� ����
	
	void findpw(){ // ��й�ȣ ã�� �޼ҵ� ����
		System.out.println("---------- ��й�ȣã�� ������ ----------");
		System.out.print("���̵� : "); String id = Menu.scanner.next();
		System.out.print("��ȭ��ȣ : "); String phone = Menu.scanner.next();
		for(Member temp : Menu.members) { // �̸�,��ȭ ��ġã�� for�� ����
			if(temp != null && temp.id.equals(id) &&
				temp.phone.equals(phone)) {
				System.out.println(id+"���� ��й�ȣ�� : " + temp.password);
				return; // �̸�,��ȭ ��ġ�ϸ� ����
			}
		} // �̸�,��ȭ ��ġã�� for�� ����
		System.out.println("�˸�) ������ ȸ�������� �����ϴ�.");
	} // ��й�ȣ ã�� �޼ҵ� ����	
	
} // c e
