package 시험연습2;

import java.util.Scanner;

public class Report {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student[] students = new Student[100];
		
		while(true) {
			try {
				System.out.println("---------------------------------------------------------------");
				System.out.println("\t\t성\t적\t표");
				System.out.println("---------------------------------------------------------------");
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				// 학생들 성적 들어갈 칸
				System.out.println("---------------------------------------------------------------");
				System.out.println("1. 성적 입력 | 2. 성적 삭제");
				System.out.print("선택 >");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					boolean isPointIsCorrect = true;
					System.out.println("성적 입력 메뉴");
					System.out.print("학생 번호 : ");
					int num = scanner.nextInt();
					System.out.print("학생 이름 : ");
					String name = scanner.next();
					System.out.print("국어 점수 : ");
					int kor = scanner.nextInt();
					System.out.print("영어 점수 : ");
					int eng = scanner.nextInt();
					System.out.print("수학 점수 : ");
					int math = scanner.nextInt();
					
					
					if(kor<1 || kor>100 || eng<1 || eng>100 || math<1 || math>100) {
						System.out.println("입력하신 점수가 올바르지 않습니다.");
						isPointIsCorrect = false;
					}
					if(isPointIsCorrect==true) {
						int sum = kor+eng+math;
						float avg = (kor+eng+math)/3.0f;
						Student newStudent = new Student(num, name, kor, eng, math, sum, avg);
						int studentsIndexCount=0;
						for(Student tmp : students) {
							if(tmp==null) {
								students[studentsIndexCount] = newStudent;
								System.out.println("저장완료");
								break;
							}
							studentsIndexCount++;
						}
					}
					
				}	// 학생추가매뉴 END
				else if(ch==2) {
					System.out.println("선택2");
				}	// 학생삭제매뉴 END
				else {
					System.out.println("번호를 확인하세요");
				}
				
			} catch(Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("예외 발생! 초기 매뉴로 돌아갑니다.");
				System.out.println(e);
			}
		}	// while END
	}	// main END
}	// class END
