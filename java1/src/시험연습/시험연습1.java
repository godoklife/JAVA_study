package ���迬��;

import java.util.Scanner;

public class ���迬��1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		���迬��_�л�[] student = new ���迬��_�л�[100];
		while(true) {
			try {
				
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("\t\t��\t��\tǥ\t\t\t");
				System.out.println("-------------------------------------------------------------------------");
				System.out.println(" ��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
				System.out.println("-------------------------------------------------------------------------");
				System.out.print("1. ���� �߰� | 2. ���� ���� \n ���� >");
				int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("========== �л� ���� �߰� �Ŵ� ==========");
					System.out.print("��ȣ �Է� : ");
					int num=scanner.nextInt();
					System.out.print("�̸� �Է� : ");
					String name=scanner.next();
					System.out.print("�������� �Է� : ");
					int kor=scanner.nextInt();
					System.out.print("�������� �Է� : ");
					int eng=scanner.nextInt();
					System.out.print("�������� �Է� : ");
					int math=scanner.nextInt();
					
				}
				else if(ch==2) {
					System.out.println("1�� ����");
					
				}
				else
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				
			}
			catch(Exception e) {
				System.out.println("���ܹ߻�. �ʱ� �Ŵ��� ���ư��ϴ�.");
				scanner = new Scanner(System.in);
			}
		}	// while END
		
		
	}	// main END
}	// class END