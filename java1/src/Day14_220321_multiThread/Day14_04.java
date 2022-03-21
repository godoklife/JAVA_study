package Day14_220321_multiThread;

import java.awt.Toolkit;

public class Day14_04 {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// �Ҹ� ���� �޼��� ����. ���� ���Ͼ���
		
		
		// P. 581 ����1
			// �̱۽����� (main�޼���)
			// 0.5�� �������� �Ҹ� ���
			// �� �� 0.5�� �������� �� ���
		for(int i=0; i<5; i++) {
			toolkit.beep();	// �Ҹ� ���
			try {
				Thread.sleep(500);	// �Ϲݿ��� �߻�
			} catch (Exception e) {	}
		}
		
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		
		System.out.println("==============�̱۽����� �Ϸ�=====================");
		
		
		// P.582 ����2 Runnable �������̽� ���
			// ��Ƽ������
		// 1. �������̽��� ������ü
		Runnable beepTask = new BeepTask();
		// 2. Thread Ŭ���� ��ü ������ �����ڿ� ������ü �ֱ�.
		Thread thread = new Thread(beepTask);
		// 3. thread ��ü �� start()�޼��� ȣ��.
		thread.start();
//		
//		for(int i=0; i<5; i++) {
//			toolkit.beep();	// �Ҹ� ���
//			try {
//				Thread.sleep(500);	// �Ϲݿ��� �߻�
//			} catch (Exception e) {	}
//		}
//		
		for(int i=0; i<5; i++) {
			System.out.println("main");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		
		System.out.println("===============���ʺ� �������̽� �Ϸ�===================");
		
		
		// P.584 ����3 thread
		
		// 1. Ŭ���� ��ü ����
		Thread thread2 = new BeepThread();
		// ����Ŭ���� 	   = �ڽ�Ŭ������ ������
		// 			�θ� <--- �ڽ� [ �ڵ�����ȯ ]
		//			�θ� ---> �ڽ� [ ��������ȯ ]
		// 2. Thread ��ü �� start() �޼��� ȣ��
			// start�޼����� ���� : run�޼��� ȣ�� -> ��Ƽ������ ����
		thread2.start();
		
		// ���
		for(int i=0; i<5; i++) {
			System.out.println("main���");
			try {
				thread.sleep(500);	// 
			} catch (Exception e) {	}
		}
		System.out.println("==============������ Ŭ���� �Ϸ�====================");

		// �������̽� ��� ���
			// 1. Ŭ�������� implements ���� �� ����. => ������ü
			// 2. �������̽��� new �����ڸ� ���� �߻�޼ҵ带 ���� => �͸�ü
		
		// * �͸� ������ ��ü
		
		Runnable runnable = new Runnable() {	// ���⼭ Runnable�� �������̽���.
			// �������̽��� new ������ ����(�޸� �Ҵ��)
			// �߻�޼��带 ���� ����!!!
			// �߻�޼��带 �������� ������ �͸�ü ���� �Ұ���.
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i<5; i++) {
					System.out.println("�͸�Thread��ü ���");
					try {
						Thread.sleep(500);
					} catch (Exception e) {	}
				}
			}
		};
		
		Thread thread3 = new Thread(runnable);
		thread3.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("main���");
			try {
				thread.sleep(500);	// 
			} catch (Exception e) {	}
		}
		
		
		System.out.println("==============�͸� ��ü ������ �Ϸ�====================");

		
		
		System.out.println("main�޼��� �ȿ� �ִ� ������ �̸� : "+ thread.currentThread().getName());
			// Thread.currentThread() : �� �ڵ带 �о��ִ�(��������) ������ ȣ��
				// .getName() : ������ �̸� ȣ�� | setName() : ������ �̸� ����
		System.out.println("�۾������� 1 �̸� : "+thread.getName());
		System.out.println("�۾������� 2 �̸� : "+thread2.getName());
		System.out.println("�۾������� 3 �̸� : "+thread3.getName());
		
		System.out.println("===================================================");

		
		
		// P. 590
		
		for(int i=1; i<=10; i++) {
			
			// i�� 1���� ���ʴ�� ����������, CPU�� ��ȯ�Ҵ翡 ���� ó���ϹǷ�
			// ���ʴ�� i�� ��µ��� ����.(���Լ����� �ƴ�.)
			Thread thread4 = new CalcThread("Thread"+i);
			if(i!=10){
				thread4.setPriority(Thread.MIN_PRIORITY);
			}
			else {
				thread4.setPriority(Thread.MAX_PRIORITY);
			}
			thread4.start();
			
		}
		
		

		
	}
}
