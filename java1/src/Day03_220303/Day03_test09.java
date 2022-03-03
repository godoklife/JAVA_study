package Day03_220303;
import java.util.Scanner;

public class Day03_test09 {
	public static void main(String[] args) {
		System.out.println("[ 문제9 ] 국어, 영어, 수학 입력받기");
		
		int kor, eng, math;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("국어 점수 입력 : ");
		kor = scanner.nextInt();
		
		System.out.println("영어 점수 입력 : ");
		eng = scanner.nextInt();
		
		System.out.println("수학 점수 입력 : ");
		math = scanner.nextInt();
		
		if((kor+eng+math)/3>=90) {
			if(kor==100) System.out.println("국어 우수");
			if(eng==100) System.out.println("영어 우수");
			if(math==100) System.out.println("수학 우수");
			System.out.println("평균 90점 이상");
		}
		else if((kor+eng+math)/3>=80) {
			if(kor>=90) System.out.println("국어 장려");
			if(eng>=90) System.out.println("영어 장려");
			if(math>=90) System.out.println("수학 장려");
			System.out.println("평균 80점 이상");
		}
		else System.out.println("재시험");
		
	scanner.close();
	}
}
