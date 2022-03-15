package Day10_인터페이스연습;

import java.util.Scanner;



public class MainMenu {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		MainMenu menu = new MainMenu();
		menu.Menu();	// 굳이 이렇게 사용할 필요는 없음. 스캐너 스테틱으로 써야 하니 메모리낭비
		
	}	// main END
	
	void Menu() {
		while(true) {	// 무한반복, 종료조건 : 없음
			System.out.println("=============모바일 뱅킹 프로그램=============");
			System.out.println("1. 우리은행 | 2. 신한은행 | 3. 국민은행");
			System.out.print("은행을 선택하세요 >");
			int ch = scanner.nextInt();
			
		}	// Menu while END
	}	// Menu END
	
}	// MainMenu class END
