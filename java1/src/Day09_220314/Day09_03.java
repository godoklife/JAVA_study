package Day09_220314;

public class Day09_03 {
	public static void main(String[] args) {
		
		// P.294~ 295
			// ���� super() ������ �����Ϸ��� �ڵ����� �߰�����.
			// super() : �θ�Ŭ���� �� �� ������ ȣ��
			// super(�μ�1, �μ�n...) �� �θ�Ŭ���� �� [n�� �μ�] ������ ȣ��
			
		// 1. ����Ŭ������ ��ü ����
		Student student = new Student("�����", "123123-123123", 1);
		
		// 2. ����Ŭ������ ���� ��ü�� ����Ŭ���� �� ��� ����
		System.out.println("name : "+student.name);
		System.out.println("ssn : "+student.ssn);
		System.out.println("studnet no : "+student.studentNo);
		
		
	}
}
