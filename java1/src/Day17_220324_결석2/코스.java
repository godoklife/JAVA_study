package Day17_220324_�Ἦ2;

public class �ڽ�<T> {
	// < ���׸� �̸� > : �ܺηκ��� ������ �ڷ��� -> ���� ���Ƿ� ���� ����.
	
	// 1. �ʵ�
	private String name;
	// ���ڿ� ���� : ������
	private T[] students;
	
	// ??? �迭 : �л� �迭 -> �ܺο��� ���� �ڷ��� [ �Ű� ]
		// ????????????????
	
	// 2. ������
		// �ܺηκ��� ������� �ο����� �޾Ƽ�, �ο�����ŭ ���׸�Ÿ������ �迭 �� �޸� �Ҵ�.
	public �ڽ�() {
		// TODO Auto-generated constructor stub
	}

	public �ڽ�(String name, int capacity) {
		this.name = name;
		students = (T[]) new Object[capacity];
			// * �Ű�Ÿ������ new(�޸��Ҵ�) �Ұ�
			// 1. new Object[�μ��� ���� �ο���] : �ο��� ��ŭ Object �迭 ���� ����
			// 2. Object �迭 -> T[] �迭�� ��������ȯ
			// * super-> subŬ������ ��������ȯ�� �翬?�� ����
	}
	
	// 3. �޼���
		// ������ ȣ�� �޼���
	public String getName() {
		return name;
	}
		// �л� �迭 ȣ�� �ż���
	public T[] getStudents() {
		return students;
	}
		// �л� �迭�� ��ü �߰��ϴ� �޼���(ArrayList Ŭ���� ���� ��İ� ����)
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}	// add end
	
}	// c e
