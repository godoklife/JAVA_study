package Day08_bank;

public class Member { // c s

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
	
	boolean signup(){ // ȸ������ �޼ҵ� ����
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

		Member member = new Member(id, password, name, phone);	
			
		// Members �迭�� ����� ã�Ƽ� �ֱ�
		int i = 0 ;
		for (Member temp : Menu.members) {
			if(temp == null) { // ������̸� ��ü����
				Menu.members[i] = member; // ������̸� ����
				return true; // ȸ������ �޼ҵ� ����
			}
			i++ ; // ������ƴҽ� �ε��� 1����
		}
		return false;
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
