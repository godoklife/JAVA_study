/*
 * Day07_05_bookApp
 * 
 * �ɹ� ���� Ŭ����
 * 
 */

package Day07_220310;

public class Member {
	
	// 1. �ʵ�
	int mno;			// ȸ����ȣ
	String id;			// ���̵�
	String password;	// ��й�ȣ
	String name;		// �̸�
	String phone;		// ����ó
	
	// 2. ������
		// ���ǻ���
	
	// 3. �޼���
		// 1. ȸ������ �޼��� [ �μ� X, ��ȯ O ]
	boolean signup() {	// ���� ������ true, ���н� false ��ȯ
		System.out.println("ȸ������ ������ ������");
		return true;
	}
		// 2. �α��� �޼���	[ �μ� X, ��ȯ O ]
	String login() {	// �α��� ������ ���̵�, ���н� null ��ȯ
		return "���̵�";
	}
		// 3. ���̵� ã�� �޼���	[ �μ� X, ��ȯ X ]
	void findid() {
		
	}
		// 4. ��� ã�� �޼���	[ �μ� X, ��ȯ X ]
	void findpw() {
		
	}
		// 5. ȸ�� Ż�� �޼���
		// 6. ȸ������ ���� �޼���
	
}
