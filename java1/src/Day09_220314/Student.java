package Day09_220314;

public class Student extends People {
		//  ����Ŭ������ extends ����Ŭ������
	// 1. �ʵ�
	public int studentNo;
	// 2. ������
	public Student(String name, String ssn, int studentNo) {
		// �θ�Ŭ���� �� ��� �ʵ� �ʱ�ȭ ��� 2����
			// 1. �ʵ忡 �����Ѵ�
			// this.name = name;
			// this.ssn = ssn;
			// 2. �����ڿ� ����
			// super(name, ssn)
		super(name, ssn);
		this.studentNo = studentNo;
		
	}
	// 3. �޼���
	
	
}
