package Day02;

import java.util.Scanner;

public class Day02_test9 {
	public static void main(String[] args) {
		System.out.println("사다리꼴 넓이 구하기");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("윗변의 길이를 입력하시오 : ");
		double Upside = scanner.nextDouble();
		
		System.out.println("밑변의 길이를 입력하시오");
		double Downside = scanner.nextDouble();
		
		System.out.println("높이의 길이를 입력하시오");
		double Height = scanner.nextDouble();
		
		
		System.out.println("사다리꼴 넓이는 " + ( ( (Upside * Downside) * Height ) / 2 ) );
		
		scanner.close();
	}
}
