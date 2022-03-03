package Day03_220303;

import java.util.Scanner;

public class Day03_06 {	// c s
	public static void main(String[] args) {	// m s
		Scanner scanner = new Scanner(System.in);
		
		// 별문제1 : 사용자가 입력한 수 만큼 별을 출력
		System.out.println("문제1) 별 개수 : ");
		int s1 = scanner.nextInt();
		
		for(int i = 1; i<=s1; i++) {
			// * i는 1부터 입력받는 수 까지 i는 1씩 증가
			System.out.print("*");
		}
		
		System.out.println("\n문제1 출력 끝.\n");
		
		
		// 별문제2 : 별 5개마다 줄바꿈
		System.out.println("문제2) 별개수 : ");
		int s2 = scanner.nextInt();
		
		for(int i = 1; i<=s2; i++) {
			// * i는 1부터 입력받은 수 까지 i는 1씩 증가 하면서 실행문 반복 처리
			System.out.print("*");
			if(i%5==0)
				System.out.println();
			
		}
		System.out.println("\n문제2 출력 끝.\n");
		
		
		// 문제3
		System.out.println("문제3) 별 개수 : ");
		int s3 = scanner.nextInt();
		for(int i=1; i<=s3; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n문제3 출력 끝.\n");
		
		
		// 문제4
		System.out.println("문제4) 별 개수 : ");
		int s4 = scanner.nextInt();
		for(int i=1; i<=s4; i++) {
			for(int j=s4; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("\n문제4 출력 끝.\n");
		/*
		 * 문제4 강사님 해설
		 * i는 줄, j는 별
		 * i=1	j= 1 2 3 4 5
		 * i=2	j= 1 2 3 4
		 * i=3	j= 1 2 3
		 * i=4	j= 1 2
		 * i=5	j= 1
		 * 입력받은 수에서 현재 줄 수를 빼면 뒤집어진 별이 나옴.
		 * 이러한 문제는 패턴을 찾는것이 중요하다.
		 */
		
		
		// 문제5
		System.out.println("문제5_ 별 개수 : ");
		int s5 = scanner.nextInt();
		
		for(int i=1; i<=s5; i++) {
			for(int j=1; j<=s5-i; j++) {
				System.out.print(" ");	// 1. 공백 찍기
			}
			for(int k=1; k<=i; k++) {
				System.out.print("*");	// 2. 별 찍기
			}
			System.out.println();	// 3. 줄바꿈
		}
		System.out.println("\n문제5 출력 끝.\n");
		
		// for속에 for속에 for속에 for 넣을 생각만 하지 말자!!!!!
		
		// 문제 6
		System.out.println("문제6_ 별 개수 : ");
		
		int s6 = scanner.nextInt();
		
		for(int i=1; i<=s6; i++) {
			for(int k=1; k<=i-1; k++) {	// 현재 줄 수의 -1개 공백 찍음
				System.out.print(" ");	//1. 공백찍기
			}
			for(int j=1; j<=s6-i+1; j++) {	// 현재 줄 수의 +1개 별을 찍음
				System.out.print("*");	//2. 별찍기
			}
			System.out.println();	// 3. 줄바꿈
		}
		System.out.println("\n문제6 출력 끝.\n");
		
		
		// 문제7 
		System.out.println("문제7_ 별 개수 : ");
		
		int s7 = scanner.nextInt();
		
		for(int i=1; i<=s7; i++) {
			
			// 1. 공백찍기
			for(int j=1; j<=s7-i; j++) {
				System.out.print(" ");
			}
			// 2. 별 찍기
			for(int k=1; k<=i*2-1; k++) {
				System.out.print("*");
			}
			System.out.println("");
			// 3. 줄 바꿈
		}
		System.out.println("\n문제7 출력 끝.\n");
		// 해설
		// i = 현재 줄 수	j = 공백	k = 별
		// i=1	j=1 2 3 4	k=1						(i*2)-1=1
		// i=2	j=1 2 3		k=1 2 3					(i*2)-1=3
		// i=3	j=1 2		k=1 2 3 4 5				(i*2)-1=5
		// i=4	j=1 		k=1 2 3 4 5 6 7			(i*2)-1=7
		// i=5	j=			k=1 2 3 4 5 6 7 8 9		(i*2)-1=9
		//
		// j는 1부터 입력받은 수 - 현재 줄 수 까지 1씩 증가
		// k는 1부터 13579~ 
		
		
		// 문제 8
		System.out.println("문제8 줄 갯수 : ");
		int s8 = scanner.nextInt();
		
		for(int i=1; i<=s8; i++) {			// 줄바꿈 for문
			for(int j=1; j<=s8-i; j++) {	// 공백 추가 for문
				System.out.print(" ");
			}
			for(int k=1; k<=i*2-1; k++) {	// 숫자 표시 for문
				System.out.print(i);
			}
			System.out.print("\n");			
		}
		System.out.println("\n문제8 출력 끝.\n");
		
		
		// 문제 9
		System.out.println("문제 9 줄 개수 : ");
		int s9 = scanner.nextInt();
		
		for(int i=1; i<=s9; i++) {
			
		}

		
		
		
		
		//for (int i = 1; i)
		
		
		
		
		
		
		scanner.close();
	}	// m e
	
}	// c s
