package Day02;

import java.util.Scanner;

public class Day02_test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("금액을 입력하세요 : ");
		int money = scanner.nextInt();
		
		//내가 한거
		System.out.println("십만원권 : " + money/100000 + "장");
		System.out.println("만원권 : " + (money%100000)/10000 + "장");
		System.out.println("천원권 : " + (money%10000)/1000 + "장");
		System.out.println("백원짜리 : " + (money%1000)/100 + "개");
		
		//강사님 강의
		System.out.println("십만원권 : " + money/100000 + "장");
		money -= (money/100000)*100000;	// 10만원 단위를 빼버린 후 money에 저장
		System.out.println("만원권 : " + money/10000 + "장");
		money -= (money/10000)*10000;
		System.out.println("천원권 : " + money/1000 + "장");
		money -= (money/1000)*1000;
		System.out.println("백원짜리 : " + money/100 + "개");
		
		
		
		scanner.close();
		
	}
	
}
