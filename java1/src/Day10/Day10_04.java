package Day10;

import java.util.ArrayList;

public class Day10_04 {
	
	// ����
	// 1. �����	2. ���� 3. ������ 4. ���/�ݺ��� 5. �迭 | 6. Ŭ���� 7. �������̽�
		// Ŭ����, �������̽��� ��ü���⿡ ����.
	public static void main(String[] args) {
		
		// �迭	vs ����Ʈ
		// �迭[�ε��� 0���� ���ʴ�� ����]
		String[] �迭�̸� = new String[100];
		System.out.println("�迭 : "+�迭�̸�);
		�迭�̸�[0] = "���缮";	
		System.out.println("�迭[0] : "+�迭�̸�[0]);
		
		// ����Ʈ[ Ŭ���� ����� �迭���� ]
		ArrayList<String> ����Ʈ�̸� = new ArrayList<>();
		// ArrayList<�ڷ���> �̸� = new ArrayList<>();
			// <�ڷ���> : �ڷ���
			// ����Ʈ�� : ����Ʈ �̸� �ƹ��ų�
			// new : �޸� �Ҵ�
			// ArrayList<>(); : ������
		����Ʈ�̸�.add("�����");
		����Ʈ�̸�.add("�����");
		����Ʈ�̸�.add("�����");
		System.out.println("����Ʈ : "+����Ʈ�̸�);
		����Ʈ�̸�.add("���缮");	// �ε�����ȣ ���� �߰� ����.
		System.out.println("����Ʈ[0] : "+����Ʈ�̸�.get(0));
			// ����Ʈ��.get(�ε���) : �ش� �ε����� ��ü ȣ�� �޼���
		System.out.println("����Ʈ ����(������) : "+����Ʈ�̸�.size());
			// ����Ʈ��.size() : �ش� ����Ʈ�� ���� ȣ�� �޼���
	}
}
