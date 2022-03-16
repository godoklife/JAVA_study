package Day11_220316_BoardApp;

import java.util.Scanner;

public class Day11_04_BoardApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {	// 예상되는 발생 예외 : 사용자가 숫자 이외의 값 입력.
			Controller.boardlist();	// static으로 선언했으므로 객체없이 호출 가능!!!!
			System.out.print("1.쓰기 2.보기 선택 >");
			int ch = scanner.nextInt();
			if(ch==1) {
				
			}
			else if(ch==2) {
				
			}
			else {
				
			}
			} catch (Exception e) {
				System.out.println("경고) 보기에 있는것만 누르시오.");
				scanner = new Scanner(System.in);	
					// 기존 스캐너를 다시 메모리 할당 해줌으로써 메모리를 비워줌.
			}
			
		}	// while END
	}	// main END
}	// class END
