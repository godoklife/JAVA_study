package Day03_220303;

import java.util.Scanner;

public class Day03_06 {	// c s
	public static void main(String[] args) {	// m s
		Scanner scanner = new Scanner(System.in);
		
		// ������1 : ����ڰ� �Է��� �� ��ŭ ���� ���
		System.out.println("����1) �� ���� : ");
		int s1 = scanner.nextInt();
		
		for(int i = 1; i<=s1; i++) {
			// * i�� 1���� �Է¹޴� �� ���� i�� 1�� ����
			System.out.print("*");
		}
		
		System.out.println("\n����1 ��� ��.\n");
		
		
		// ������2 : �� 5������ �ٹٲ�
		System.out.println("����2) ������ : ");
		int s2 = scanner.nextInt();
		
		for(int i = 1; i<=s2; i++) {
			// * i�� 1���� �Է¹��� �� ���� i�� 1�� ���� �ϸ鼭 ���๮ �ݺ� ó��
			System.out.print("*");
			if(i%5==0)
				System.out.println();
			
		}
		System.out.println("\n����2 ��� ��.\n");
		
		
		// ����3
		System.out.println("����3) �� ���� : ");
		int s3 = scanner.nextInt();
		for(int i=1; i<=s3; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n����3 ��� ��.\n");
		
		
		// ����4
		System.out.println("����4) �� ���� : ");
		int s4 = scanner.nextInt();
		for(int i=1; i<=s4; i++) {
			for(int j=s4; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n����4 ��� ��.\n");
		/*
		 * ����4 ����� �ؼ�
		 * i�� ��, j�� ��
		 * i=1	j= 1 2 3 4 5
		 * i=2	j= 1 2 3 4
		 * i=3	j= 1 2 3
		 * i=4	j= 1 2
		 * i=5	j= 1
		 * �Է¹��� ������ ���� �� ���� ���� �������� ���� ����.
		 * �̷��� ������ ������ ã�°��� �߿��ϴ�.
		 */
		
		
		// ����5
		System.out.println("����5_ �� ���� : ");
		int s5 = scanner.nextInt();
		
		for(int i=1; i<=s5; i++) {
			for(int j=1; j<=s5-i; j++) {
				System.out.print(" ");	// 1. ���� ���
			}
			for(int k=1; k<=i; k++) {
				System.out.print("*");	// 2. �� ���
			}
			System.out.println();	// 3. �ٹٲ�
		}
		System.out.println("\n����5 ��� ��.\n");
		
		// for�ӿ� for�ӿ� for�ӿ� for ���� ������ ���� ����!!!!!
		
		// ���� 6
		System.out.println("����6_ �� ���� : ");
		
		int s6 = scanner.nextInt();
		
		for(int i=1; i<=s6; i++) {
			for(int k=1; k<=i-1; k++) {	// ���� �� ���� -1�� ���� ����
				System.out.print(" ");	//1. �������
			}
			for(int j=1; j<=s6-i+1; j++) {	// ���� �� ���� +1�� ���� ����
				System.out.print("*");	//2. �����
			}
			System.out.println();	// 3. �ٹٲ�
		}
		System.out.println("\n����6 ��� ��.\n");
		
		
		// ����7 
		System.out.println("����7_ �� ���� : ");
		
		int s7 = scanner.nextInt();
		
		for(int i=1; i<=s7; i++) {
			
			// 1. �������
			for(int j=1; j<=s7-i; j++) {
				System.out.print(" ");
			}
			// 2. �� ���
			for(int k=1; k<=i*2-1; k++) {
				System.out.print("*");
			}
			System.out.println("");
			// 3. �� �ٲ�
		}
		System.out.println("\n����7 ��� ��.\n");
		// �ؼ�
		// i = ���� �� ��	j = ����	k = ��
		// i=1	j=1 2 3 4	k=1						(i*2)-1=1
		// i=2	j=1 2 3		k=1 2 3					(i*2)-1=3
		// i=3	j=1 2		k=1 2 3 4 5				(i*2)-1=5
		// i=4	j=1 		k=1 2 3 4 5 6 7			(i*2)-1=7
		// i=5	j=			k=1 2 3 4 5 6 7 8 9		(i*2)-1=9
		//
		// j�� 1���� �Է¹��� �� - ���� �� �� ���� 1�� ����
		// k�� 1���� 13579~ 
		
		
		// ���� 8
		System.out.println("����8 �� ���� : ");
		int s8 = scanner.nextInt();
		
		for(int i=1; i<=s8; i++) {			// �ٹٲ� for��
			for(int j=1; j<=s8-i; j++) {	// ���� �߰� for��
				System.out.print(" ");
			}
			for(int k=1; k<=i*2-1; k++) {	// ���� ǥ�� for��
				System.out.print(i);
			}
			System.out.print("\n");			
		}
		System.out.println("\n����8 ��� ��.\n");
		
		
		// ���� 9
		System.out.println("���� 9 �� ���� : ");
		int s9 = scanner.nextInt();
		
		for(int i=1; i<=s9; i++) {
			
		}

		
		
		
		
		//for (int i = 1; i)
		
		
		
		
		
		
		scanner.close();
	}	// m e
	
}	// c s
