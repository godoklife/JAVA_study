package 시험연습;

import java.util.Scanner;

public class 시험연습1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		시험연습_학생[] student = new 시험연습_학생[100];
		while(true) {
			try {
				
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("\t\t성\t적\t표\t\t\t");
				System.out.println("-------------------------------------------------------------------------");
				System.out.println(" 번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				System.out.println("-------------------------------------------------------------------------");
				System.out.print("1. 점수 추가 | 2. 점수 삭제 \n 선택 >");
				int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("========== 학생 점수 추가 매뉴 ==========");
					System.out.print("번호 입력 : ");
					int num=scanner.nextInt();
					System.out.print("이름 입력 : ");
					String name=scanner.next();
					System.out.print("국어점수 입력 : ");
					int kor=scanner.nextInt();
					System.out.print("영어점수 입력 : ");
					int eng=scanner.nextInt();
					System.out.print("수학점수 입력 : ");
					int math=scanner.nextInt();
					
				}
				else if(ch==2) {
					System.out.println("1번 선택");
					
				}
				else
					System.out.println("잘못 입력하셨습니다.");
				
			}
			catch(Exception e) {
				System.out.println("예외발생. 초기 매뉴로 돌아갑니다.");
				scanner = new Scanner(System.in);
			}
		}	// while END
		
		
	}	// main END
}	// class END