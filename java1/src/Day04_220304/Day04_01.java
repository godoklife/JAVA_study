package Day04_220304;

import java.util.Scanner;

public class Day04_01 {	// c s
	public static void main(String[] args) {	// m s
		
		// ��� : if, switch
		// �ݺ��� : for, while
			// 1. �ʱⰪ	2. ���ǽ�	3. ������	4. ���๮
			// while���� ����
			// 1. �ʱⰪ; 
			// while( 2. ���ǽ� ) {
			// 	4. ���๮;
			//	3. ������;
			//	}
		// for�� ��1)
		for(int i=1; i<=10; i++) { 
			System.out.println(i);
		}
		System.out.println("\n���� ��1\n");
		
		
		// while�� ��1) [ ��� for���� ������ ��� ] 
		int i = 1; // 1. �ʱⰪ
		while (i<=10) {	// 2. ���ǽ�
			System.out.println(i + " "); 	// 4. ���๮
			i++;	// 3. ����
		}	// while end
		System.out.println("\n���� ��2\n");

		
		// for ��2) 1~100 �����հ�
		int sum=0;
		for(int j=1; j<=100; j++)
			sum += j;
		
		System.out.println(sum);
		System.out.println("\n���� ��3\n");

		
		// while ��2) 1~100 �����հ�
		int j=1; // 1. �ʱⰪ
		int sum2 =0;
		while(j<=100) {	// 2. ���ǹ�
			sum2 += j;	// 4. ���๮
			j++;		// 3. ������
		}
		
		System.out.println(sum2);
		System.out.println("\n���� ��4\n");

		
		// while ��3) ���ѷ���
		while(true) {	// ���ǽ��� true ����	// true=��� => ���ѷ���
			System.out.println("���ѷ���");
			System.out.println("3�� �Է��ϸ� ���� Ż��");
			Scanner scanner = new Scanner(System.in);
			int exit = scanner.nextInt();
			
			if(exit==3)
				break;		// if���� ������ ���� ����� �ݺ���, ��� Ż��
		}
		System.out.println("\n���� ��5\n");

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// m e
}	// c e
