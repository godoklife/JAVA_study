package 시험연습4;

import java.util.Scanner;

public class Viewer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();
		
		while(true) {
			try {
				System.out.printf("------------------------ 주차 현황 표 ------------------------\n\n");
				System.out.printf("\t\t현재시간 : %s\n",controller.dateTimeFormat.format(controller.calendar.getTime()));
				System.out.printf("   날짜\t\t차량번호\t\t입차시간\t\t출차시간\t\t금액\n");
					// dateTimeFormat : 22-03-28일 15:30 형식으로 출력
					// timeFormat : 15:30 형식으로 출력
				for(int i=0; i<controller.carList.size(); i++){
					// 배열 내 맴버 출력 반복문
				}
				System.out.printf("-----------------------------------------------------------\n");
				System.out.printf("\t\t\t 1. 입차 2. 출차\n");
				int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("입차 선택");
					System.out.printf("차량번호를 입력하세요 : ");
					controller.입차();
				}
				else if(ch==2) {
					System.out.println("출차 매뉴");
				}
				else
					System.out.println("잘못 누르셨습니다.");

			} catch (Exception e) {
				System.out.println("잘못 누르셨습니다.");
				System.out.println(e);
				scanner = new Scanner(System.in);
					// 스캐너 메모리 초기화
				}
		}	// while END
	}	// main END
}	// class END
