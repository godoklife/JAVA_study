package 시험연습;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] report = new String[100][7];
		boolean firstTimeWrite = true;
		
		
		
		while(true) {	// 종료조건 : 없음!
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("\t\t성\t적\t표\t\t\t");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(" 번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("-------------------------------------------------------------------------");
		for(int i=0; i<report.length;i++) {
			if(report[i][0]!=null) {	
				for(int j=0; j<report[i].length; j++) {
					System.out.printf("%03s\t",report[i][j]);
				}	// 학생의 번호, 이름, 국어, 영어, 수학, 총점, 평균 출력. 석차는 일단 나중에
				System.out.printf("\n");
			}	// 학생이 들어있는 행 확인하는 if문 END
			
		}	// 학생 출력 배열for문 END
		System.out.println("1. 학생 점수 추가 | 2. 학생 점수 삭제");
		System.out.print("선택 >");
		String ch=scanner.next();
		
		if(ch.equals("1")) {
			
			System.out.println("============ 학생 점수 추가 매뉴 ============");
			if(firstTimeWrite==true)
				System.out.println("초기 5명의 학생 점수를 입력받습니다.");	// 처음 입력받을때만 출력
			
			int count = 0;	// switch문 제어용 변수
			
			while(firstTimeWrite) {
				switch(count) {
				case 0 : {
					System.out.print("학생 번호를 입력하세요");
//					int i= scanner.next();
					
				}
				case 4 : {
					firstTimeWrite = false;	
					break;
					}
				}
			}	// 처음만 돌아가는 5명 입력 while END
		}	// 1번 선택 if END
		else if(ch.equals("2")) {
			System.out.println("============ 학생 점수 추가 매뉴 ============");
			
		}	// 2번 선택 if END
		else {
			System.out.println("에러) 잘못 누르셨습니다.");
		}	// 예외 if END
		
		
		}	// while END
	}	// main END
}	// class END
