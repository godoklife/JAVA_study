package Day03_220303;

public class Day03_05 {	// c s
	public static void main(String[] args) {	// m s
		
		// �ݺ��� : 1. for	2. while	3. do.while[x]
		// for : 
			// ��𼭺��� ������ ��� ����/���� �ϸ鼭 �ݺ� ó��
			// 1���� 10���� 3�� �����ϸ鼭 �ݺ�ó�� = 4�� �����.
			// �ʼ���� : 1. �ʱⰪ	2. ���ǽ�	3. ������
			// ����
			//		for(1. �ʱⰪ ; 2. ���ǽ� ; 3. ������ ) {
			//			�ݺ����๮;
			//		}
			
		// for���� ��ø
			// for1 ( ) { for2 ( ) { for3 ( ) { } } }
		
		
		// P.121 ����
		for(int i = 1 ; i <= 10 ; i++ ) {
			// int i = 1	: �ʱⰪ ���� [ i�� �ݺ����� ]
				// i <= 10	: ���ǽ� [ i�� 10 �����̸� ���� �ƴϸ� for�� Ż�� ]
					// i++ 	: ������ [ ���๮ ���� �� ���� Ȥ�� ���� ���� ]
			// * ���� i�� 1���� 10���� 1�� �����ϸ鼭 ���๮ �ݺ� ó��.
			System.out.println(i+" ");
		}
		System.out.println("P.121 ���� ��� ��.\n");
		
		
		// P.122 ����
		int sum=0;
		for (int i=1; i<=100; i++)
			sum += i;
		
		System.out.println(sum);
		System.out.println("P.122 ���� ��� ��.\n");
		
		
		// ����3 : 1���� 100���� 7����� ���� �հ踦 ���Ͻÿ�
		int sum2 = 0;
		for (int i=0; i <= 100; i += 7)
			sum2 += i;
		
		System.out.println(sum2);
		System.out.println("����3 ��� ��.\n");
		
		
		// ����3_2 : 1���� 100���� 7����� ���� �հ踦 for�� if�� ����� ���Ͻÿ�
		int sum3 = 0;
		for(int i=1; i<=100; i++) {
			if(i%7==0) sum3 += i;
		}
		
		System.out.println(sum3);
		System.out.println("����3_2 ��� ��.\n");
		
		
		// ����4 : 2�� ������ �����
		for(int ��=1; ��<=9; ��++) {
			System.out.println("2 * " + �� + "= "+ (2*��));
		}
		
		System.out.println("����4 ��� ��.\n");
		
		
		// P.124 ���� : 2��~9�� ������ ����� [ ��, �� �� �� ���� ] 
			// �� : 2���� 9���� 8�� ����
			// �� : 1���� 9���� 9�� ����
				// �� 1�� ����� �� ���� �� 9�� ����
			// * ������ �� 72�� ����
		for(int ��=2; ��<=9; ��++) {
			System.out.printf("-----%d��-----\n", ��);
			for(int ��=1; ��<=9; ��++)
				System.out.printf("%d * %d = %d\n", ��, ��, ��*��);
		}
		
		System.out.println("P.124 ���� ��� ��.\n");
		
		
		
		
		
		
		
		
		
		
		
		
	}	// m e
}	// c e
