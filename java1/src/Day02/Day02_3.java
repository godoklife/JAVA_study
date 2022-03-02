package Day02;

import java.util.Scanner;

public class Day02_3 {	// c s

	public static void main(String[] args) {	// m s
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("급여 계산을 시작합니다.");
		System.out.print("기본급 : ");
		int income = scan.nextInt();
		
		System.out.print("수당 : ");
		int sudang = scan.nextInt();
		
		scan.close();
		
		int realincome = (income + sudang - (int)(income * 0.1));
		
		
		System.out.println("실 수령액 : 기본급 + 수당 - 세금(기본급의 10%)");
		System.out.println("실 수령액은 " + realincome + "입니다.");
		
		
		
	}	// m e
	
}	// c s
