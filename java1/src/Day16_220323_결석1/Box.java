package Day16_220323_�Ἦ1;

public class Box {
	// 1. �ʵ�
	private Object object;	// super class [ �ֻ��� Ŭ���� ]
	// 2. ������
	// �� ����� �����Ϸ��� �˾Ƽ� �⺻������ ����
	
	// 3. �޼���
	public void set(Object object) {
		System.out.println("test");
		this.object = object;
	}
	
	public Object get() {
		return this.object;
	}
}
