package Day10;

import Day10_�������̽�����.RemoteControl;

public class Day10_02 {
	public static void main(String[] args) {
		// �������̽�
				// ��ǿ� ���������ϴ�. [ 10���� ]
			
		// 1. �������̽� ��ü ����
		RemoteControl rc;
		//�������̽���	  ��ü��;
		
		// �������̽��� �ڷ����� Ŭ���� �޸� �Ҵ�
		rc = new Television();
		rc.turnOn();
		
		rc.setVolume(20);
		
		rc.turnOff();
		
		
		// �������̽� �� Ŭ���� �޸� ��ü
		System.out.println("rc = new Audio();");
		rc = new Audio();	// rc��ü�� �׷��񿡼� ������� ��ü!
		
		rc.turnOn();
		rc.setVolume(30);
		rc.setVolume(5);
		rc.turnOff();
		
		RemoteControl rc2 = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("�͸�����ü on");
			}
			
			@Override
			public void turnOff() {
				System.out.println("�͸�����ü off");
				
			}
			
			@Override
			public void setVolume(int volume) {
				System.out.println("�͸�����ü volume");
				
			}
		};
		
		rc2.turnOn();
		rc2.turnOff();
		rc2.setMute(true);
		
		// ���� �޼��� ȣ��
		RemoteControl.changeBattery();	// ��ü ���� ȣ�� �����ϴ�.
		
		// �޸� �Ҵ� �޴� ���
			// �޸� �Ҵ� �ϴ� ����?? 
				//�ܺ� Ŭ����&�������̽� �� �ʵ�, �޼���, ���� ��� ����Ϸ��� �޸𸮿� �Ҵ� ���־�߸� ��.
			// 1. new ������
			// 2. static ������
		
		
	}
}
