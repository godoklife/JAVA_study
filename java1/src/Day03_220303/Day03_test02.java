package Day03_220303;

import java.util.Scanner;

public class Day03_test02 {
	public static void main(String[] args) {
		System.out.println("3개의 정수를 입력받아서 가장 큰 수를 출력");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1) 정수를 입력하세요 : ");
		int num1 = scanner.nextInt();
		
		System.out.println("2) 정수를 입력하세요 : ");
		int num2 = scanner.nextInt();
		
		System.out.println("3) 정수를 입력하세요 : ");
		int num3 = scanner.nextInt();
		
		int max = num1;	// max에 첫번째 값 저장
		if(max < num2)
			max = num2;
		if(max < num3)
			max = num3;
		
		System.out.println(max);
		
		scanner.close();
//		if (max<num3) {	// 만약 max보다 num3가 더 크면 교체
//			int tmp = num3;	// 임시변수 [ 스왑용 ]
//			num3 = max;
//			max = tmp;
//		}
		
	}
}
