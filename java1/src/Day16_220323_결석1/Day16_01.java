package Day16_220323_�Ἦ1;


public class Day16_01 {
	public static void main(String[] args) {
		// P. 656 ���׸� generic 
		
		// ����1) ���׸��� ������� ���� ��� �����ö����� ĳ������ ����� ������ �������ϰ� �߻�.
			// ��, �ƹ� ���³� ���� ����
		// 1. Box class�� ��ü ����
		Box box = new Box();
		
		// 2. ��ü �� set�޼���(�μ� : String) ȣ��
		box.set("�����");
		
		// 3. ��ü �� get�޼���(��ȯ���� : Object) ȣ��
			// Object -> String������ ��������ȯ �ʿ�.
		String name = (String)box.get();
		
		// 4. 
		box.set(new Apple());
			// �ڽ��� ������Ʈ��� ����Ŭ�������� ����������� �ڵ����� ����ȯ�� �ǳ�
		Apple apple = (Apple)box.get();
			// ����Ŭ�������� ����Ŭ������ �ű涧�� Ÿ��ĳ���� �� �� �� �ʿ���
			
		
	}
}
