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
		String[] num = new String[10];	
		// int형으로 하면 안됨! 랜덤생성했을때 1단위, 10단위, 100단위 숫자 생성되면 자리수가 안맞음
		
		
		for(int i=0; i<num.length; i++) {
			int randomNum=random.nextInt(10000);	// 0~9999 까지의 무작위 수를 배열에 저장하는 반복문
			num[i] = String.format("%04d", randomNum);	
			// 빈자리에는 0 넣은뒤 4자리 문자열로 변환해 문자열 클래스 배열에 저장.
				// int  68 -> String 0068
//			System.out.printf("%d번째 차량 번호 : %s\n", i+1, num[i]);
		}
		
		for(int i=0; i<num.length; i++) {
			int a = Integer.parseInt(num[i]);
			if(a%2==0) {
				System.out.println(i+1+"번쨰 차량은 짝수 차량입니다. 차량번호 : "+num[i]);
			}else{
				System.out.println(i+1+"번째 차량은 홀수 차량입니다. "+num[i]);
			}
		}
		
	}	// main END
}	// class END
