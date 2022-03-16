package 시험연습;

import java.util.Scanner;

public class 시험연습1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Student[] student = new Student[100];
		while(true) {
			try {
				
				//석차매기는부분
				
				
				
				
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("\t\t성\t적\t표\t\t\t");
				System.out.println("-------------------------------------------------------------------------");
				System.out.println(" 번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				System.out.println("-------------------------------------------------------------------------");
				for(Student tmp : student) {
					if(tmp!=null) {
						System.out.printf("%d\t%3s\t%d\t%d\t%d\t%d\t%.1f\n",tmp.getNum(),tmp.getName(),
								tmp.getKor(),tmp.getEng(),tmp.getMath(), tmp.getSum(), tmp.getAvg());
					}
				}
				
				System.out.print("1. 점수 추가 | 2. 점수 삭제 \n 선택 >");
				int ch = scanner.nextInt();
				if(ch==1) {
					boolean isPointIsRight=true;
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
					int sum= kor+eng+math;
					double avg = (kor+eng+math)/3.0;
					if(kor<1 || kor>100 || eng<1 || eng>100 || math<1 || math>100) {
						System.out.println("점수가 잘못 입력되었습니다. 다시 입력하세요.");
						isPointIsRight=false;
					}
					if(isPointIsRight == true) {
						Student newStudent = new Student(name, num, kor, eng, math, sum, avg, 0);
						int i=0;
						for(Student tmp2 : student) {
							if(tmp2==null) {
								student[i]=newStudent;
								break;
							}
							i++;
						}
					}
				}
				else if(ch==2) {
					System.out.println("========== 학생 점수 추가 매뉴 ==========");
					
				}
				else {
					System.out.println("잘못 입력하셨습니다.");
				}
				}
				catch(Exception e) {
				System.out.println("예외발생. 초기 매뉴로 돌아갑니다.");
				System.out.println(e);
				scanner = new Scanner(System.in);
				}
		}	// while END
		
		
	}	// main END
}	// class END