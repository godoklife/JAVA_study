package Day04_220304;

import java.util.Random;
import java.util.Scanner;

public class Day04_05 {	//c s
	public static void main(String[] args) {	// m s
		int[] lotto = new int[6];		// 사용자 입력값 저장할 배열 
		int[] lotto_cpu = new int[6];	// 난수 저장할 배열
		int same_number=0;				// 사용자가 맞춘 로또번호 개수

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("------------로또추첨기------------");
		for(int i=0; i<lotto.length; i++) {
			System.out.println("1에서 45까지의 숫자를 입력하세요.("+(i+1)+"번째)");
			int input = scanner.nextInt();
			boolean check = true;	// 유효성 검사 스위치
			
			if(input>45 || input<1) {	// 1-1. 1~45범위의 수만 입력받으시오
				System.out.println("1~45 범위 초과. 다시입력하시오.");
				i--;
				check = false;		// 유효하지 않은 값, 스위치 끔.
			}
			
			for(int tmp:lotto) {	// 1-2 중복확인
				if(tmp==input) {	
					System.out.println("이미 입력한 값입니다. 다시 입력하시오.");
					i--;
					check = false;	// 유효하지 않은 값, 스위치 끔.
				}
			}
			
			if(check==true)			// 유효하지 않은 값이 없었어서 스위치가 살아있으면
				lotto[i]=input;		// 사용자가 입력한 값을 배열에 저장
		}	// f e
		
		for(int i=0; i<6; i++) {	// 사용자 입력값 최종 확인용
			System.out.printf(lotto[i]+"\t");
		}
		System.out.println("");
		
		System.out.println("------------난수생성기 실행------------");
		for(int i=0; i<lotto_cpu.length; i++) {
			boolean check = true;	// 유효성 검사 플래그
			int random_number = random.nextInt();	// 난수생성기, 범위지정 안해주면 +-20억 중에서 골라내느라 좀 걸림
			if(random_number>45 || random_number<1) {	// 조건 2-1 난수가 1~45 범위 내인지 확인
				i--;
				check = false;
			}
			
			for(int tmp:lotto_cpu) {	
				if(tmp==random_number) {
					i--;
					check = false;
				}
			}

			if(check==true)
				lotto_cpu[i]=random_number;
		}
		
		for(int i=0; i<6; i++) {	// 로또값 확인용
			System.out.printf(lotto_cpu[i]+"\t");
		}
		System.out.println("");
		
		// 조건3 내가 맞춘 로또번호 갯수
		
//		for(int i=0; i<lotto.length; i++) {
//			for(int j=0; j<lotto_cpu.length; j++) {
//				if(lotto[i]==lotto_cpu[j])
//					same_number++;
//			}
//		}
		
		for(int tmp:lotto) {
			for(int tmp2:lotto_cpu) {
				if(tmp==tmp2)
					same_number++;
			}
		}
		
		System.out.println("내가 맞춘 로또번호 개수 : "+same_number);
		
	}	// m e
}	// c e
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for(int i=0; i<lotto.length; i++) {
//			while(true) {
//				System.out.println("1에서 45까지의 숫자를 입력하세요.("+(i+1)+"번째)");
//				int input = scanner.nextInt();
//
//				if ((input > 45) || (input < 1))
//					System.out.println("1에서 45 사이의 숫자만 입력하세요.");
//				else {
//					lotto[i] = input;
//					break;
//				}
//			}
		// while문으로 만들기 실패 ㅠㅠ

