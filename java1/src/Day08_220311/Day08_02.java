package Day08_220311;

public class Day08_02 {
	public static void main(String[] args) {
		
		// P.245 : final
			// ���, ������
			// ���Ǵ� ��� : 1. �ʵ� �����, 2. �����ڿ���
		
		
		// 1. ��ü ����
		Person p1 = new Person("123123-123123", "�ƹ���");
		
		// 2. rorcp so vlfem tnwjd
		// p1.nation = "USA";			// final �ʵ尡 �ƴ϶�� ���� ������.
		
		// p1.ssn = "123123123-12";		// �׷��� final �پ������Ƿ� ���� �Ұ���!
		
		p1.name = "ȫ�浿";
		
		
		
	}
}
