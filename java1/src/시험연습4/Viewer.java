package ���迬��4;

import java.util.Scanner;

public class Viewer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();
		
		while(true) {
			try {
				System.out.printf("------------------------ ���� ��Ȳ ǥ ------------------------\n\n");
				System.out.printf("\t\t����ð� : %s\n",controller.dateTimeFormat.format(controller.calendar.getTime()));
				System.out.printf("   ��¥\t\t������ȣ\t\t�����ð�\t\t�����ð�\t\t�ݾ�\n");
					// dateTimeFormat : 22-03-28�� 15:30 �������� ���
					// timeFormat : 15:30 �������� ���
				for(int i=0; i<controller.carList.size(); i++){
					// �迭 �� �ɹ� ��� �ݺ���
				}
				System.out.printf("-----------------------------------------------------------\n");
				System.out.printf("\t\t\t 1. ���� 2. ����\n");
				int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("���� ����");
					System.out.printf("������ȣ�� �Է��ϼ��� : ");
					controller.����();
				}
				else if(ch==2) {
					System.out.println("���� �Ŵ�");
				}
				else
					System.out.println("�߸� �����̽��ϴ�.");

			} catch (Exception e) {
				System.out.println("�߸� �����̽��ϴ�.");
				System.out.println(e);
				scanner = new Scanner(System.in);
					// ��ĳ�� �޸� �ʱ�ȭ
				}
		}	// while END
	}	// main END
}	// class END
