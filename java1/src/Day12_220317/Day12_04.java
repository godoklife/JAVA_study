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
		String[] num = new String[10];	
		// int������ �ϸ� �ȵ�! �������������� 1����, 10����, 100���� ���� �����Ǹ� �ڸ����� �ȸ���
		
		
		for(int i=0; i<num.length; i++) {
			int randomNum=random.nextInt(10000);	// 0~9999 ������ ������ ���� �迭�� �����ϴ� �ݺ���
			num[i] = String.format("%04d", randomNum);	
			// ���ڸ����� 0 ������ 4�ڸ� ���ڿ��� ��ȯ�� ���ڿ� Ŭ���� �迭�� ����.
				// int  68 -> String 0068
//			System.out.printf("%d��° ���� ��ȣ : %s\n", i+1, num[i]);
		}
		
		for(int i=0; i<num.length; i++) {
			int a = Integer.parseInt(num[i]);
			if(a%2==0) {
				System.out.println(i+1+"���� ������ ¦�� �����Դϴ�. ������ȣ : "+num[i]);
			}else{
				System.out.println(i+1+"��° ������ Ȧ�� �����Դϴ�. "+num[i]);
			}
		}
		
	}	// main END
}	// class END
