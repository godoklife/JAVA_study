package Day17_220324_�Ἦ2;

public class Day17_02 {
	public static void main(String[] args) {
		
		// P.661~662
		
		// 1. box ��ü ���� [ ���׸� : Integer ]
		Box<Integer> box1 = new Box<>();
		// 2. �޼��� ȣ�� �� ������� ��ü�� ����
		box1 = Util.<Integer>boxing(100);
		// 3. �ٽ� ������ Ȯ��(int��)
		System.out.println("box1.get() : " + box1.get());	// ��°� : (int)100
		
		// P. 662~ 663
		
		// 1. p1 ��ü�� �����ϴµ� �����ڿ� ���� 1�� ���ڿ� ��� �ֱ�
			// ����?? ���׸��� Integer, String
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "���");
		// 2. ���ο� ��ü p2 ����
		Pair<Integer, String> p2 = new Pair<>(1, "���");	// new Pair���� ���׸� ��������
		
		// 3. �񱳸޼��� ȣ��
		boolean result0 = Util.compare(p1, p2);	// ?????????????????
		System.out.println("���׸� ���� ���� result0 : "+result0);
		boolean result1 = Util.<Integer,String>compare(p1, p2);
		System.out.println("���׸��� ������ result1 : "+result1);
		
		// 4. ��� ����
		if(result1)	System.out.println("������ ��ü");
		else System.out.println("�������� ���� ��ü");
				
		
		Pair<Integer, String> p3 = new Pair<Integer, String>(2, "����");
		Pair<Integer, String> p4 = new Pair<Integer, String>(3, "����");
		
		boolean result2 = Util.compare(p3, p4);
			// key�� value�� and�����Ͽ� ��,���� ��ȯ
		System.out.println(result2);
			// ���� ���
		
		
	}	// m e
}	// c e
