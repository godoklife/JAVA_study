package ���迬��;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] report = new String[100][7];
		boolean firstTimeWrite = true;
		
		
		
		while(true) {	// �������� : ����!
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("\t\t��\t��\tǥ\t\t\t");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(" ��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("-------------------------------------------------------------------------");
		for(int i=0; i<report.length;i++) {
			if(report[i][0]!=null) {	
				for(int j=0; j<report[i].length; j++) {
					System.out.printf("%03s\t",report[i][j]);
				}	// �л��� ��ȣ, �̸�, ����, ����, ����, ����, ��� ���. ������ �ϴ� ���߿�
				System.out.printf("\n");
			}	// �л��� ����ִ� �� Ȯ���ϴ� if�� END
			
		}	// �л� ��� �迭for�� END
		System.out.println("1. �л� ���� �߰� | 2. �л� ���� ����");
		System.out.print("���� >");
		String ch=scanner.next();
		
		if(ch.equals("1")) {
			
			System.out.println("============ �л� ���� �߰� �Ŵ� ============");
			if(firstTimeWrite==true)
				System.out.println("�ʱ� 5���� �л� ������ �Է¹޽��ϴ�.");	// ó�� �Է¹������� ���
			
			int count = 0;	// switch�� ����� ����
			
			while(firstTimeWrite) {
				switch(count) {
				case 0 : {
					System.out.print("�л� ��ȣ�� �Է��ϼ���");
//					int i= scanner.next();
					
				}
				case 4 : {
					firstTimeWrite = false;	
					break;
					}
				}
			}	// ó���� ���ư��� 5�� �Է� while END
		}	// 1�� ���� if END
		else if(ch.equals("2")) {
			System.out.println("============ �л� ���� �߰� �Ŵ� ============");
			
		}	// 2�� ���� if END
		else {
			System.out.println("����) �߸� �����̽��ϴ�.");
		}	// ���� if END
		
		
		}	// while END
	}	// main END
}	// class END
