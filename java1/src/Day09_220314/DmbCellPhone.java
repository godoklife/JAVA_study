package Day09_220314;

public class DmbCellPhone extends CellPhone {
	// CellPhone Ŭ������ �ʵ� ������ �޼��带 ��� �����.
	// �� �� �Ʒ� ������ �߰��ؼ� DmbCellPhone�̶�� Ŭ������ �ϼ���.
	// �̰� ����� �⺻ ����(extends)
	
	
	// 1. �ʵ�
	int channel;
	// 2. ������
	DmbCellPhone(String model, String color, int channel){
		this.model = model;	// model
		this.color = color;	// color�� ��ӹ��� CellPhone Ŭ������ �ִ� �ʵ����.
		// ���� Ŭ������ ���� �ʵ������� ����Ŭ���� �� ���ȣ��
		// CellPhone Ŭ������ color �ʵ带 ����Ű�°���.
		this.channel = channel;
	}
	// 3. �޼���
	void turnOnDmb() {
		System.out.println("ä��"+channel+"�� DMB ��� ������ �����մϴ�.");
	}
	
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("ä��"+channel +"������ �ٲߴϴ�.");
	}
	
	void turnOffDmb() {
		System.out.println("DMB��� ������ �����մϴ�.");
	}
	
}
