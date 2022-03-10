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
		this.id = Day07_05_bookApp.scanner.next();
			// �޸� �Ʋ����� ���� �� class�� ���� main class�� ��ĳ�� ���.
		for(Member temp : Day07_05_bookApp.members) {	// ���̵� �ߺ� üũ
			if(temp != null && temp.id.equals(id)) {
				System.out.println("�˸�||| �ߺ��� ���̵� �Դϴ�.");
				return false;	// �ٷ� false�� ��ȯ�ϰ� �޼��� ����.
			}
		}	// ���̵� �ߺ� üũ for END
		System.out.print("��й�ȣ�� �Է����ּ��� : ");
		this.password = Day07_05_bookApp.scanner.next();
		System.out.print("�̸��� �Է����ּ��� : ");
		this.name = Day07_05_bookApp.scanner.next();
		System.out.print("����ó�� �Է����ּ��� : ");
		this.phone = Day07_05_bookApp.scanner.next();
		
		// * ȸ����ȣ �ڵ� ���� [ ���� �ֱٿ� ������ ȸ���� ��ȣ +1 ]
			// null�� ã�Ƽ� -1 �ϸ� ���� �ֱٿ� ������ ȸ���� ��ȣ ����.
		int bno = 0;	// ȸ����ȣ�� �����ϴ� ����
		int j = 0;	// �ε��� �ӽ������ ����
		for(Member temp : Day07_05_bookApp.members) {
			if(temp==null) {
				if(j==0) {
					bno = 1;
					break;
				}// ���� ù��° ȸ���̸� -1 �ε��� �����°� ����.
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
				System.out.println("ȸ������ ȸ�� ��ȣ : "+bno);
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
		return "���̵�";
	}
		// 3. ���̵� ã�� �޼���	[ �μ� X, ��ȯ X ]
	void findID() {
		
	}
		// 4. ��� ã�� �޼���	[ �μ� X, ��ȯ X ]
	void findPW() {
		
	}
		// 5. ȸ�� Ż�� �޼���
		// 6. ȸ������ ���� �޼���
	
}
