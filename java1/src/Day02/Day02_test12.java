package Day02;

import java.util.Scanner;

public class Day02_test12 {
	public static void main(String[] args) {
		System.out.println("inch를 입력받아 cm으로 변환하기 [ 1inch = 2.54cm ]");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("inch를 입력하시오 : ");
		float inch = scanner.nextFloat();
		float cm = inch * 2.54f;
		
		System.out.println("입력한 값을 cm으로 변환한 값은 " + (inch * 2.54) + " cm 입니다.");
		System.out.printf("입력한 값을 cm으로 변환한 값은 %.3f cm 입니다.",cm);
		
		scanner.close();
	}

}
