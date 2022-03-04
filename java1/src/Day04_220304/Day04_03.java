package Day04_220304;

import java.util.Random;
import java.util.Scanner;

public class Day04_03 {	// c s
	
	
	public static void main(String[] args) {	// m s
		int user;	// 사용자가 지정한 수를 저장
		int cpu;	// 컴퓨터 생성한 난수를 저장
		int games=0; 	// 게임 실행 횟수 저장
		int userwin=0;	// 사용자 승리 횟수 저장
		int cpuwin=0;	// 컴퓨터 승리 횟수 저장
		Scanner scanner = new Scanner(System.in);
		
		//프로그램 실행 [ 무한루프 종료 조건 : 3번 입력시 종료(break) ] 
		while(true) {
			games++;
			System.out.println("------------가위 바위 보 게임------------");
			System.out.println("가위(0) | 바위(1) | 보(2) | 종료(3)");
			System.out.println("선택하세요>");
			user=scanner.nextInt();	// 사용자가 입력한 수를 저장
			System.out.println("플레이어가 낸 수 : " + user);
			
			Random random = new Random();	// 난수 객체 선언
				// random.nextInt() : int가 표현할 수 있는 범위내 난수 발생
				// random.nextInt(수) : 0 ~ 수 미만 난수 발생
				// random.nextInt(5) : 5가지 범위(0~4)
			cpu = random.nextInt(3);	// 난수를 정수(int)형으로 가져오기
			
			// 승자 판단
			if(user==3) {
				System.out.printf("게임을 종료합니다.\n총 게임 횟수 : %d, 인간이 이긴 횟수 : %d, 기계가 이긴 횟수 : %d\n", (games-1), userwin, cpuwin);
					// 프로그램 켜자마자 게임 횟수부터 올리고 시작하기때문에 총 게임횟수 출력할때 1회 차감하고 출력.
				if(userwin>cpuwin)
					System.out.println("인간의 승리입니다.");
				else if(userwin<cpuwin)
					System.out.println("기계의 승리다.");
				else
					System.out.println("무승부");
				break;
			}
			else if(user>=4) {
				System.err.println("잘못누르셨습니다.");
				games--;
			}
			else if((user==0&&cpu==2)||(user==1&&cpu==0)||(user==2&&cpu==1)) {	// 사용자가 이기는 경우의 수
				System.out.println("인간이 이겼습니다");
				userwin++;
			} 
			else if (user==cpu) {	// 비기는 경우의 수
				System.out.println("비겼습니다");
			}
			else {	// 컴퓨터가 이기는 경우의 수
				System.out.println("기계가 이겼습니다.");
				cpuwin++;
			}
			
		}	// w e
	}	// m e
}	//c e
