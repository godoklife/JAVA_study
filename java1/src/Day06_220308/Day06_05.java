package Day06_220308;

public class Day06_05 {
	public static void main(String[] args) {
		
		// P.207
		
		// 1. ������ ���� �ʵ忡 �� �ֱ�
		Korean k1 = new Korean();
			k1.name = "���缮";
			k1.ssn = "000202-1231231";
		System.out.println("k1�� �̸�"+k1.name);
		System.out.println("k1�� ����"+k1.nation);
		System.out.println("k1�� �ι�"+k1.ssn);

		// 2. �����ڸ� ���� �ʵ忡 �� �ֱ�
		Korean k2 = new Korean("���ڹ�", "111-111");
		System.out.println("k2�� �̸�"+k2.name);
		System.err.println("k2�� ����"+k2.nation);
		System.out.println("k2�� �ι�"+k2.ssn);
		
		//////////////////////////////////////////////
		Korean �ѱ���1 = new Korean();
			// �ѱ��� 1���� �̸��� ����, ������ ���ѹα��̰�, �ι�X
		
		Korean �ѱ���2 = new Korean("���缮");
			// �ѱ��� 2���� �̸��� ���缮�̰�, ������ ���ѹα��̰�, �ι� X
		
		Korean �ѱ���3 = new Korean("��ȣ��", "12312-123123");
			// �ѱ��� 3���� �̸��� ��ȣ���̰�, �ι��� �ְ�, ������ ���ѹα��̴�.
		
		Korean �ѱ���4 = new Korean("�Ϻ�", "�ŵ���", "123123-12");
			// �ѱ��� 4���� ������ �Ϻ��̰�, �̸��� �ŵ����̰�, �ι��� �ִ�.
		
	}
}
