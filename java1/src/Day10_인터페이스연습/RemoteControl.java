package Day10_�������̽�����;

public interface RemoteControl {	// �������̽� ����
	
	
	// ���
		// 1. ��� �ʵ� 	: ������ ������
	public int MAX_VOLUME = 10;	// �������� �ִ� ����
	public int MIN_VOLUME = 0;	// �������� �ּ� ����
	
		// 2. �߻� �޼���	: ���� O, ���� X
	public void turnOn();		// {} �߰�ȣ ���� -> [ ���� ����! ]
	public void turnOff();		// ��.
	public void setVolume(int volume);	// ��.
	
		// 3. ����Ʈ �޼���	: ���� O, ���� O	[ java8 �̻� ]
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("���� ó�� �մϴ�.");
		} else {
			System.out.println("���� ���� �մϴ�");
		}
	}	// setMute END
	
		// 4. ���� �޼���	: ���� O, ���� O,	[ java8 �̻�, ��ü���� ȣ�� ����(static) ]
	static void changeBattery() {
		System.out.println("�������� ��ü�մϴ�");
	}
	
	
	
	
	
}
