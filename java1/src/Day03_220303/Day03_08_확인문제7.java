package Day03_220303;

import java.util.Scanner;

public class Day03_08_Ȯ�ι���7 {	// c s
	public static void main(String[] args) {	// m s
		boolean run = true;	// ���� ���� ����
		
		int balance = 0;	// ���ݾ� ����
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {	 // while���� ���ǽĿ� true�� ������ ���ѷ���
			System.out.println("--------------------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܰ� | 4. ����");
			System.out.println("--------------------------------");
			System.out.println("����> ");
			
			int input = scanner.nextInt();
						
			if(input==1) {
				System.out.println("���ݾ�> ");
				int ���ݾ� = scanner.nextInt();
				balance += ���ݾ�;
			}
			else if(input==2) {
				System.out.println("��ݾ�> ");
				int ��ݾ� = scanner.nextInt();
				if(��ݾ�>balance)				//
					System.out.println("�ܾ��� �����մϴ�.");
				else
					balance -= ��ݾ�;
			}
			else if(input==3) {
				System.out.println("�ܰ�>"+balance);
				
			}
			else if(input==4) {
				//break;	// while�� Ż��, ���ѷ��� Ż��.
				run=false;
			}
			else {
				System.out.println("�߸� �����̽��ϴ�.");
			}
		}	// w e
		System.out.println("�ý��� ����");
		
		scanner.close();
	}	// m e
}	// c e
