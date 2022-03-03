package Day03_220303;

import java.util.Scanner;

public class Day03_08_확인문제7 {	// c s
	public static void main(String[] args) {	// m s
		boolean run = true;	// 실행 여부 변수
		
		int balance = 0;	// 예금액 변수
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {	 // while문의 조건식에 true를 넣으면 무한루프
			System.out.println("--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.println("선택> ");
			
			int input = scanner.nextInt();
						
			if(input==1) {
				System.out.println("예금액> ");
				int 예금액 = scanner.nextInt();
				balance += 예금액;
			}
			else if(input==2) {
				System.out.println("출금액> ");
				int 출금액 = scanner.nextInt();
				if(출금액>balance)				//
					System.out.println("잔액이 부족합니다.");
				else
					balance -= 출금액;
			}
			else if(input==3) {
				System.out.println("잔고>"+balance);
				
			}
			else if(input==4) {
				//break;	// while문 탈출, 무한루프 탈출.
				run=false;
			}
			else {
				System.out.println("잘못 누르셨습니다.");
			}
		}	// w e
		System.out.println("시스템 종료");
		
		scanner.close();
	}	// m e
}	// c e
