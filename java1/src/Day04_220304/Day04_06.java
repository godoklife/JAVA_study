package Day04_220304;

import java.util.Random;
import java.util.Scanner;

public class Day04_06 {	// c s
	public static void main(String[] args) {	// m s
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		String[] samok = new String[9];		// 1. ������ 9ĭ ����
		
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
			
		}	// w e
	}	// m e
}	// c e
