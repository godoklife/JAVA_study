package Day12_220317;

import java.util.Random;

public class Day12_04 {
	public static void main(String[] args) {
		
		// 문제 : 차량번호 구분 프로그램
		// 조건
			// 1. 난수 0000 ~ 9999 10개 발생 후 배열에 저장
			// 2. 모든 차량 번호를 배열에 저장
			// 3. 끝자리 번호로 홀, 짝 구분
			// 4. 홀수인 차량 출력
			// 5. 짝수인 차량 출력
		Random random = new Random();
		int[] num = new int[10];
		
		
		for(int i=0;i<num.length;i++) {
			num[i]=random.nextInt(10000);	// 0~9999 까지의 무작위 수를 배열에 저장하는 반복문
			System.out.printf("%d번째 차량 번호 : %04d\n", i, num[i]);
		}
		
		int i=0;
		for(int tmp : num) {
			
			
		}
		
		
	}	// main END
}	// class END
