package Day09_220314;

public class Day09_02 {
	public static void main(String[] args) {
		
		// ��� 
			// �θ𿡰Լ� �����޴°�
			// ���� : �θ� ---> �ڽ� ���� 	// ���α׷��� : �ڽ� ---> �θ� ����
			// extends : �����ϴ� [ ����ϴ� ]
			// ���� : ���� ���� [ ������ �ִ� Ŭ������ �����ؼ� ���ο� Ŭ������ ���� ] 
				// 
		
		// ���� P. 290~292
	// 1. ����Ŭ������ ��ü ����
	DmbCellPhone dmbCellPhone = new DmbCellPhone("�ڹ�phone", "��ũ�Ѻ�", 10);
	
	// 2. ����Ŭ������ ������� ��ü�� ����Ŭ���� �� ��� ����
	System.out.println("�� : "+ dmbCellPhone.model);
	System.out.println("���� : "+dmbCellPhone.color);
	
	// 3. ����Ŭ������ ������� ��ü�� ���� ��� ����
	System.out.println("ä�� : " + dmbCellPhone.channel);
	
	// 4. ����Ŭ������ ������� ��ü�� ����Ŭ���� �� ��� [�޼���] ����
	dmbCellPhone.powerOn();
	dmbCellPhone.bell();
	dmbCellPhone.sendVoice("��������");
	dmbCellPhone.receiveVoice("�ȳ��ϼ���! ���� ������ε���");
	dmbCellPhone.sendVoice("�� �ݰ����ϴ�.");
	dmbCellPhone.hangUp();
	
	// 5. ����Ŭ������ ������� ��ü�� ���� ���� ����
	dmbCellPhone.turnOnDmb();
	dmbCellPhone.changeChannelDmb(20);
	dmbCellPhone.turnOffDmb();
	
	}
}
