package 프로그래밍언어활용_김용준_성적표;

import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		Student[] students = new Student[100];		// 학생 정보를 담을 Student 클래스 배열 100개 선언
		int[] ranking = new int[students.length];	// 석차 정보를 담을 int형 배열을 students 길이만큼 선언
		
		
		while(true) {	// 프로그램 무한 반복, 종료조건 : 없음
			try {
				System.out.println("---------------------------------------------------------------");
				System.out.println("\t\t성\t적\t표");
				System.out.println("---------------------------------------------------------------");
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");

				
				for(int i=0; i<ranking.length;i++) {	// 석차 저장하는 배열 초기화
					ranking[i]=1;
				}
				
				for(int i=0; i<ranking.length; i++) {	// 학생의 좀 점수를 비교하고 석차를 저장하는 반복문
					if(students[i]!=null) {
						for(int j=i; j<ranking.length; j++) {
							if(students[j]!=null && students[i].getSum() < students[j].getSum()) {
								ranking[i]++;
							}
							else if(students[j]!=null && students[i].getSum() > students[j].getSum()) {
								ranking[j]++;
							}
						}
					}
				}
				
				for(int i=0; i<students.length; i++) {	// 학생 성적 출력 반복문
					if(students[i]!=null) {
						System.out.printf("%2d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\t\n", students[i].getNum(), students[i].getName(),
								students[i].getKor(), students[i].getEng(), students[i].getMath(), students[i].getSum(), students[i].getAvg(), ranking[i]);	// 마지막 0은 석차 차리
					}
				}	// 학생 성적 출력 반복문 END
				
				System.out.println("---------------------------------------------------------------");
				System.out.println("매뉴 : 1. 학생점수 등록 2. 학생점수 삭제");
				System.out.print("선택 >");
				int ch1=scanner.nextInt();
				
				if(ch1==1) {
					boolean isPointCorrect = true;		// 국영수 각각의 점수가 1점~100점 범위내에 있는지 확인하고 아니라면 false 저장
					boolean isNumberAvailable = true;	// 중복된 학생 번호 발견하면 false 저장
					System.out.println("학생점수 등록 메뉴");
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
					
					if(kor<1 || kor>100 || eng<1 || eng>100 | math<1 || math>100) {	// 만약 국영수 중 하나라도 1점~100점 범위를 벗어난다면
						System.out.println("점수를 1점이상, 100점 미만으로 입력하세요.");
						isPointCorrect=false;										// 처리 안함
					}
					if(isPointCorrect==true) {										// 국영수 점수가 멀쩡하면 
						int sum = kor+eng+math;	
						float avg = (kor+eng+math)/3.0f;
						Student newStudent = new Student(num, name, kor, eng, math, sum, avg);	// 입력 받은 정보와 그걸 바탕으로 만든 총점, 평균을 객체화
						int studentsIndexCount = 0;
						for(Student tmp : students) {	// 학생번호 중복 검사
							if(tmp!=null && tmp.getNum()==num) {
								System.out.println("학생번호가 이미 존재합니다.");
								isNumberAvailable = false;
								break;
							}
						}	// 학생번호 중복검사 반복문 END
						if(isNumberAvailable==true) {
							for(Student tmp : students) {
								if(tmp==null) {
									System.out.println(name+" 학생의 정보가 정상적으로 저장되었습니다.");
									students[studentsIndexCount] = newStudent;
									break;
								}
								studentsIndexCount++;
							}	// for(Student tmp : students) 객체를 studends 배열에 저장 반복문 END
						}	// if(isNumberAvailable==true) END
					}	// if(isPointCorrect==true) END
					
					
				}	// 학생 점수 등록 메뉴 END
				else if(ch1==2) {
					System.out.println("학생점수 삭제 메뉴");
					System.out.print("삭제할 학생 번호를 입력하세요. >");
					int findNum = scanner.nextInt();
					
					int studentsIndexCount = 0;
					for(Student tmp : students) {	// students 배열에서 해당 번호의 학생 검색 후 삭제
						if(tmp!=null && tmp.getNum()==findNum) {
							System.out.println(findNum+"번 학생 점수 삭제 완료.");
							students[studentsIndexCount]=null;
							break;	// 해당 번호의 학생은 한명밖에 없으니 그만 검색하고 반복문 탈출
						}
						studentsIndexCount++;	
					}	// students 배열에서 해당 번호의 학생 검색 후 삭제 END
					
					for(int i=studentsIndexCount; i<students.length; i++) {	// 위 반복문에서 삭제하면 배열이 이빨빠진채로 남는데 앞으로 한칸씩 다 땡겨주는 반복문 실행
						if(i==students.length-1) {	// 가장 마지막 인덱스를 찾으면 무조건 null값 넣고 반복문 탈출
							students[i]=null;
							break;
						}
						students[i] = students[i+1];	// 뒤에 있는 데이타를 앞으로 한칸씩 땡김. 널이든 정보든 상관없이.
					}	// 배열에서 빈칸 없애는 반복문 END
				}	// 학생 점수 삭제 메뉴 END
				else
					System.out.println("번호를 확인하세요.");
				
			}catch(Exception e) {	// 예외 발생시 실행
				System.out.println("예외발생! 초기매뉴로 돌아갑니다.");
				System.out.println(e);
				scanner = new Scanner(System.in);	// 스캐너에 잘못된 형식 데이타 들어갔을때를 대비해 스캐너 메모리 초기화
			}	// catch END
		}	// while END
	}	// main END
}	// class END
