package Day12_220317;

import java.util.Random;

public class Day12_04 {
	public static void main(String[] args) {
		
		// ���� : ������ȣ ���� ���α׷�
		// ����
			// 1. ���� 0000 ~ 9999 10�� �߻� �� �迭�� ����
			// 2. ��� ���� ��ȣ�� �迭�� ����
			// 3. ���ڸ� ��ȣ�� Ȧ, ¦ ����
			// 4. Ȧ���� ���� ���
			// 5. ¦���� ���� ���
		Random random = new Random();
		int[] num = new int[10];
		
		
		for(int i=0;i<num.length;i++) {
			num[i]=random.nextInt(10000);	// 0~9999 ������ ������ ���� �迭�� �����ϴ� �ݺ���
			System.out.printf("%d��° ���� ��ȣ : %04d\n", i, num[i]);
		}
		
		int i=0;
		for(int tmp : num) {
			
			
		}
		
		
	}	// main END
}	// class END
