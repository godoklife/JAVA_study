package Day02;
import java.util.Scanner;

public class Day02_test8 {
	public static void main(String[] args) {
		System.out.println("두 실수를 입력받아 앞 실수의 값이 뒤의 값의 몇 %인지 출력하기");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("실수를 입력하시오 : ");
		float float1 = scanner.nextFloat();
		
		System.out.println("다음 실수를 입력하시오 : ");
		float float2 = scanner.nextFloat();
		
		double 비율 = (float1 / float2) * 100;
		
		System.out.printf("일수1의 실수2 백분율 : %.2f %%\n", 비율);	// 소수 둘째자리까지 표현
		
		System.out.println("처음 입력한 실수는 두번째 값의 " + ((float1/float2)*100f) + "% 입니다.");
		
		scanner.close();
		
	}
}
