package Day02;

public class Day02_test14 {
	public static void main(String[] args) {
		System.out.println("연산 순서 나열하고 X와 Y값 예측하기");
		/*
		 *	문제14 :  연산 순서 나열 하고 x와 y값 예측하기
		  	int x = 10;
			int y = x-- + 5 + --x;
			printf(" x의 값 : %d , y의값 :  %d ", x, y) 
			
			int y의 실행 순서
			1. x-- + 5	-> 10 + 5 = 15 (후위감소)
			2. x--		-> x 감소 [ x = 9 ]
			3. 15 + --x	-> x 감소 먼저 연산 [ x = 8 ]
			4. 15 + 8	-> 23
			5. int y = 23
			
			
			
			int x = 10
			int y = 23
			System.out.printf("x의 값 : 
			
			
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
