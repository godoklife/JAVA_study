package Day09_220314;

public class CellPhone {	// Ŭ���� ����
	
	// 1. �ʵ�
	String model;
	String color;
	
	// 2. ������
	
	// 3. �޼���
	void powerOn() {
//	��ȯŸ�� �޼����(�μ�) {�����ڵ�}	// �μ��� ���� ��ȯŸ�Ե� ����.
//	��ȯŸ���� void�� ��쿡��! return ���� ����.		
		System.out.println("������ �մϴ�.");
	}
	
	void powerOff() {
		System.out.println("������ ���ϴ�");
	}
	
	void bell() {
		System.out.println("���� �︳�ϴ�.");
	}
	
	void sendVoice(String message) {
//	��ȯŸ�� �޼����(�μ�) {�����ڵ�}	
//	message��� �ܺο��� ������ �μ��� ������, ��ȯ�� ����.
		System.out.println("���� : "+message);
	}
	
	void receiveVoice(String message) {
		System.out.println("���� : "+message);
	}
	
	void hangUp() {
		System.out.println("��ȭ�� �����ϴ�.");
	}
}
