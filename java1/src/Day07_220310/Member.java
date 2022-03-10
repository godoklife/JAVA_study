/*
 * Day07_05_bookApp
 * 
 * �ɹ� ���� Ŭ����
 * 
 */

package Day07_220310;

public class Member {
	
	// 1. �ʵ�
	int mno;			// ȸ����ȣ [ �ڵ���ȣ, �ߺ�X ]
	String id;			// ���̵� [ �ߺ� X ]
	String password;	// ��й�ȣ
	String name;		// �̸�
	String phone;		// ����ó
	
	// 2. ������
	public Member() { }
	
	public Member(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}



	// 3. �޼���
		// 1. ȸ������ �޼��� [ �μ� X, ��ȯ O ]
	boolean signup() {	// ���� ������ true, ���н� false ��ȯ
		System.out.println("--------------ȸ������ �Ŵ�--------------");
		System.out.print("���̵� �Է����ּ��� : ");
		String id = Day07_05_bookApp.scanner.next();
			// �޸� �Ʋ����� ���� �� class�� ���� main class�� ��ĳ�� ���.
		for(Member temp : Day07_05_bookApp.members) {	// ���̵� �ߺ� üũ
			if(temp != null && temp.id.equals(id)) {
				System.out.println("�˸�||| �ߺ��� ���̵� �Դϴ�.");
				return false;	// �ٷ� false�� ��ȯ�ϰ� �޼��� ����.
			}
		}	// ���̵� �ߺ� üũ for END
		System.out.print("��й�ȣ�� �Է����ּ��� : ");
		String password = Day07_05_bookApp.scanner.next();
		System.out.print("�̸��� �Է����ּ��� : ");
		String name = Day07_05_bookApp.scanner.next();
		System.out.print("����ó�� �Է����ּ��� : ");
		String phone = Day07_05_bookApp.scanner.next();
		
		// * ȸ����ȣ �ڵ� ���� [ ���� �ֱٿ� ������ ȸ���� ��ȣ +1 ]
			// null�� ã�Ƽ� -1 �ϸ� ���� �ֱٿ� ������ ȸ���� ��ȣ ����.
		int bno = 0;	// ȸ����ȣ�� �����ϴ� ����
		int j = 0;	// �ε��� �ӽ������ ����
		for(Member temp : Day07_05_bookApp.members) {
			if(temp==null) {
				if(j==0) {	// ���� ù��° ȸ���̸� -1 �ε��� �����°� ����.
					bno = 1;
					break;
				}	
				bno = Day07_05_bookApp.members[j-1].mno +1;
					//null�� �� [ ������ȸ�� ] ��ȣ�� +1
				break;
			}
			j++;	
		}
		
		Member member = new Member(mno, id, password, name, phone);
			// ��� �ʵ带 �޴� ���ڷ� ��ü ����.
		
		//for (int i=0; i< Day07_05_bookApp.members.length ; i++) �� �Ʒ��� ����.
		int i=0;
		for(Member temp : Day07_05_bookApp.members) {	// �迭�� �� ������ ã������ temp�� �����ϱ�.
			if (temp==null) {	// temp�� �� �����̸�
				Day07_05_bookApp.members[i] = member;	// �� �ε����� ���ο� ȸ�� ���� ����
				System.out.println("ȸ������ ȸ�� ��ȣ : "+bno);	// ȸ�� ��ȣ ���
				return true;	// ȸ������ ���������� true ��ȯ.
			}
			i++;
		}
		return false;	// if���� ���� ���ϸ� false ��ȯ�ϰ� ����.(ȸ������ �����ߴٰ� ����)
		// 1. �װ��� ���� �Է¹޴´� [ id, pw, name, phonenumber ] 
		
			// * scanner ��ü�� �ٸ� Ŭ���� �� static���·� ����Ǿ� ����. 
			// * Ŭ������ . �ʵ��
				// -> ������ �޸𸮿� �ö� �ִ�.
		// 2. 4�� ���� -> ��üȭ -> 1��
		// 3. �迭 �� �� ������ ã�Ƽ� ���ο� ȸ�� [ ��ü ] �����
		// 4. ���� ������ true ��ȯ, ���н� false ��ȯ
	}	// signup END
	
		// 2. �α��� �޼���	[ �μ� X, ��ȯ O ]
	String login() {	// �α��� ������ ���̵�, ���н� null ��ȯ
		System.out.println("--------------�α��� �޴�--------------");
		System.out.print("���̵� �Է��ϼ��� : ");
		String id = Day07_05_bookApp.scanner.next();
		System.out.print("��й�ȣ�� �Է��ϼ��� : ");
		String password = Day07_05_bookApp.scanner.next();
		
		
		for(Member temp : Day07_05_bookApp.members) {
			if(temp.id!=null && temp.id.equals(id) && temp.password.equals(password)) {
				return temp.id;
			}
		}
		return null;
	}
		
		// 3. ���̵� ã�� �޼���	[ �μ� X, ��ȯ X ]
	void findID() {
		System.out.println("--------------���̵� ã��--------------");
		System.out.print("�̸� : ");
		String name = Day07_05_bookApp.scanner.next();
		System.out.print("����ó : ");
		String phone = Day07_05_bookApp.scanner.next();
		// �Է¹��� ���� �迭���� ã��
		
		for(Member temp : Day07_05_bookApp.members) {
			if (temp != null && temp.name.equals(name) && temp.phone.equals(phone)){
				System.out.println("ȸ������ ���̵� : " + temp.id);
				return;
			}
		}
		System.out.println("������ ������ �����ϴ�.");
	}
		// 4. ��� ã�� �޼���	[ �μ� X, ��ȯ X ]
	void findPW() {
		System.out.println("--------------��й�ȣ --------------");
		System.out.print("���̵� : ");
		String id = Day07_05_bookApp.scanner.next();
		System.out.print("����ó : ");
		String phone = Day07_05_bookApp.scanner.next();
		// �Է¹��� ���� �迭���� ã��
		
		for(Member temp : Day07_05_bookApp.members) {
			if (temp != null && temp.id.equals(id) &&
					temp.phone.equals(phone)){
				System.out.println("ȸ������ ���̵� : " + temp.password);
				return;
			}
		}
		System.out.println("������ ������ �����ϴ�.");
	}
		// 5. ȸ�� Ż�� �޼���
		// 6. ȸ������ ���� �޼���
	
}
