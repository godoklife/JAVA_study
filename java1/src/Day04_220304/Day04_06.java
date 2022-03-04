package Day04_220304;

import java.util.Random;
import java.util.Scanner;

public class Day04_06 {	// c s
	public static void main(String[] args) {	// m s
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		String[] samok = new String[9];		// 1. 게임판 9칸 생성
		
		System.out.printf("삼목 게임을 시작합니다.\n빈 공간은 [ ], 선택된 공간은 [O]로 표시합니다.\n");
		
		for(int i=0; i<samok.length; i++) 	// 게임판 초기화
			samok[i]="[ ]";
		
		
		// 메인게임
		while(true) {
			
			for(int i=0; i<samok.length; i++) {	// 게임판 출력
				System.out.printf(samok[i]);
				
				if(i%3==2)	// 3칸마다 줄 바꿈
					System.out.printf("\n");
			}
			
			while(true) {	// 사용자한테서 조건에 맞는 값을 입력받을때까지 반복
				System.out.println("1~9칸을 선택하세요");
				int user = scanner.nextInt()-1;
				
				if(!(user<=8 && user>=0))	// 사용자가 1~9를 벗어난 값을 입력한 경우
					System.out.println("1~9칸 범위 내에서 입력하세요.");
				
				else if(!(samok[user].equals("[ ]")))	// 사용자가 이미 선택된 칸을 선택한 경우
					System.out.println("이미 놓여진 칸 입니다.");
				
				else {	// 사용자가 똑바로 선택한 경우
					samok[user] = "[O]";
					break;
				}
				
				
			}	// while2 end
			
			while(true) {	// 빈 공간을 찾을때만 체크. 사용자때와 달리 나머지 값은 다 필요없음.
			int cpu = random.nextInt(9);
			
				if(samok[cpu].equals("[ ]")) {
					samok[cpu]="[X]";
					break;
				}
			}	// while3 end
			
		}	// w e
	}	// m e
}	// c e
