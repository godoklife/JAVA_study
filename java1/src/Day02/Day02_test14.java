package Day02;

public class Day02_test14 {
	public static void main(String[] args) {
		System.out.println("���� ���� �����ϰ� X�� Y�� �����ϱ�");
		/*
		 *	����14 :  ���� ���� ���� �ϰ� x�� y�� �����ϱ�
		  	int x = 10;
			int y = x-- + 5 + --x;
			printf(" x�� �� : %d , y�ǰ� :  %d ", x, y) 
			
			int x = 10
			int y = 23
			System.out.printf("x�� �� : 
			
			
		 */
		int x = 10;
		//int y = x-- + 5 + --x;
		int y = x--;
		
		System.out.println(x);
		System.out.println(y);
		
		y += 5;
		
		System.out.println(x);
		System.out.println(y);
		
		y = --x;
		
		System.out.println(x);
		System.out.println(y);
		
	}
	
}
