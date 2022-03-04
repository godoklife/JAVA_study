package Day04_220304;

import java.util.Random;
import java.util.Scanner;

public class Day04_06 {	// c s
	public static void main(String[] args) {	// m s
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		String[] samok = new String[9];		// 1. ������ 9ĭ ����
		String win="";
		
		System.out.printf("��� ������ �����մϴ�.\n�� ������ [ ], ���õ� ������ [O]�� ǥ���մϴ�.\n");
		
		for(int i=0; i<samok.length; i++) 	// ������ �ʱ�ȭ
			samok[i]="[ ]";
		
		
		// ���ΰ���
		while(true) {
			
			for(int i=0; i<samok.length; i++) {	// ������ ���
				System.out.printf(samok[i]);
				
				if(i%3==2)	// 3ĭ���� �� �ٲ�
					System.out.printf("\n");
			}
			
			while(true) {	// ��������׼� ���ǿ� �´� ���� �Է¹��������� �ݺ�
				System.out.println("1~9ĭ�� �����ϼ���");
				int user = scanner.nextInt()-1;	
					// ����ڴ� 1~9�� ���������� �ε����� 0~8�̴� �ε��� �ڸ��� ȣ��� ������ user�� -1 ���ش�.
				
				if(!(user<=8 && user>=0))	// ����ڰ� 1~9�� ��� ���� �Է��� ���
					System.out.println("1~9ĭ ���� ������ �Է��ϼ���.");
				
				else if(!(samok[user].equals("[ ]")))	// ����ڰ� �̹� ���õ� ĭ�� ������ ���
					System.out.println("�̹� ������ ĭ �Դϴ�.");
				
				else {	// ����ڰ� �ȹٷ� ������ ���
					samok[user] = "[O]";
					break;
				}
				
				
			}	// while2 end
			
			while(true) {	// �� ������ ã������ üũ. ����ڶ��� �޸� ������ ���� �� �ʿ����.
			int cpu = random.nextInt(9);
			
				if(samok[cpu].equals("[ ]")) {
					samok[cpu]="[X]";
					break;
				}
			}	// while3 end
			
			
			/*
			 * �ڵ� ¥�� ����, �¸��ϴ� ��츦 ����ȭ�غ���.
			 * 1. ���η� �¸��ϴ� ��� : 0, 1, 2 / 3, 4, 5 / 6, 7, 8
			 * 2. ���η� �¸��ϴ� ��� : 0, 3, 6 / 1, 4, 7 / 2, 5, 8
			 * 3. �밢������ �¸��ϴ� ��� : 0, 4, 8 / 2, 4, 6
			 */
			
			// 1. ���η� �¸�
			for(int i=0; i<=6; i+=3) {
				if(samok[i].equals(samok[i+1]) && samok[i+1].equals(samok[i+2])) {
					win=samok[i];
				}
			}
			
			
			// 2. ���η� �¸�
//			for(int i=0; i<=2; i++) {
//				if(samok[i].equals(samok[i+3]) && samok[i+6].equals(samok[i+9])) {
//					win=samok[i];
//				}
//			}
			
			
			// �¸� ����
			if(win.equals("[O]")) {
				System.out.println("�÷��̾� ��");
				break;
			}
			
			if(win.equals("[X]")) {
				System.out.println("CPU ��");
				break;
				}
		}	// w e
	}	// m e
}	// c e
