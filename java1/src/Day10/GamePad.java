package Day10;

public interface GamePad {
	// 1. ��� �ʵ�
	
	// 2. �߻� �޼���
	public abstract void Abutton();
	public abstract void Bbutton();
	public abstract void Cbutton();
	
	// 3. ������ �޼���
	default void gamePadEnd() {
		System.out.println("�����е� ���� ");
	}
	
	// 4. ���� �޼���	
	static void charging() {
		System.out.println("�����е� ����");
	}
}
