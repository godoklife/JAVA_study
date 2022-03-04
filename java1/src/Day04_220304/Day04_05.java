package Day04_220304;

import java.util.Random;
import java.util.Scanner;

public class Day04_05 {	//c s
	public static void main(String[] args) {	// m s
		int[] lotto = new int[6];		// ����� �Է°� ������ �迭 
		int[] lotto_cpu = new int[6];	// ���� ������ �迭
		int same_number=0;				// ����ڰ� ���� �ζǹ�ȣ ����

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("------------�ζ���÷��------------");
		for(int i=0; i<lotto.length; i++) {
			System.out.println("1���� 45������ ���ڸ� �Է��ϼ���.("+(i+1)+"��°)");
			int input = scanner.nextInt();
			boolean check = true;	// ��ȿ�� �˻� ����ġ
			
			if(input>45 || input<1) {	// 1-1. 1~45������ ���� �Է¹����ÿ�
				System.out.println("1~45 ���� �ʰ�. �ٽ��Է��Ͻÿ�.");
				i--;
				check = false;		// ��ȿ���� ���� ��, ����ġ ��.
			}
			
			for(int tmp:lotto) {	// 1-2 �ߺ�Ȯ��
				if(tmp==input) {	
					System.out.println("�̹� �Է��� ���Դϴ�. �ٽ� �Է��Ͻÿ�.");
					i--;
					check = false;	// ��ȿ���� ���� ��, ����ġ ��.
				}
			}
			
			if(check==true)			// ��ȿ���� ���� ���� ����� ����ġ�� ���������
				lotto[i]=input;		// ����ڰ� �Է��� ���� �迭�� ����
		}	// f e
		
		for(int i=0; i<6; i++) {	// ����� �Է°� ���� Ȯ�ο�
			System.out.printf(lotto[i]+"\t");
		}
		System.out.println("");
		
		System.out.println("------------���������� ����------------");
		for(int i=0; i<lotto_cpu.length; i++) {
			boolean check = true;	// ��ȿ�� �˻� �÷���
			int random_number = random.nextInt();	// ����������, �������� �����ָ� +-20�� �߿��� ��󳻴��� �� �ɸ�
			if(random_number>45 || random_number<1) {	// ���� 2-1 ������ 1~45 ���� ������ Ȯ��
				i--;
				check = false;
			}
			
			for(int tmp:lotto_cpu) {	
				if(tmp==random_number) {
					i--;
					check = false;
				}
			}

			if(check==true)
				lotto_cpu[i]=random_number;
		}
		
		for(int i=0; i<6; i++) {	// �ζǰ� Ȯ�ο�
			System.out.printf(lotto_cpu[i]+"\t");
		}
		System.out.println("");
		
		// ����3 ���� ���� �ζǹ�ȣ ����
		
//		for(int i=0; i<lotto.length; i++) {
//			for(int j=0; j<lotto_cpu.length; j++) {
//				if(lotto[i]==lotto_cpu[j])
//					same_number++;
//			}
//		}
		
		for(int tmp:lotto) {
			for(int tmp2:lotto_cpu) {
				if(tmp==tmp2)
					same_number++;
			}
		}
		
		System.out.println("���� ���� �ζǹ�ȣ ���� : "+same_number);
		
	}	// m e
}	// c e
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for(int i=0; i<lotto.length; i++) {
//			while(true) {
//				System.out.println("1���� 45������ ���ڸ� �Է��ϼ���.("+(i+1)+"��°)");
//				int input = scanner.nextInt();
//
//				if ((input > 45) || (input < 1))
//					System.out.println("1���� 45 ������ ���ڸ� �Է��ϼ���.");
//				else {
//					lotto[i] = input;
//					break;
//				}
//			}
		// while������ ����� ���� �Ф�

