package Day19_220328;

import java.util.HashSet;
import java.util.Scanner;

public class Day19_02 {
	
	// set : 중복값 저장 불가
		// 객체 내 "모든 필드"가 동일하면 중복 불가능.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(true) {
			System.out.println("1~45 숫자를 선택하세요.(중복X)");
			int num=scanner.nextInt();
			
			if(num<1 || num> 45) {	// 입력한 값이 1~45 밖이면
				System.out.println("값이 범위를 벗어났습니다. 다시 입력하시오.");
			}
			else {
				set.add(num);
				System.out.println("확인 : "+set);
			}
			if(set.size() == 6)
				break;
		}
	}
}
