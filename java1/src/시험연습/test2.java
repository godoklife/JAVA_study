
// try ~ catch 써. 하나하나 if문으로 잡지 말고.

package 시험연습;

import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
		학생[] 학생배열 = new 학생[100];
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("학생목록");
				
				System.out.println("1. 추가 2. 삭제");
				int ch = scanner.nextInt();
				
				if (ch==1) {
					System.out.println("ch1선택");
				}else if(ch==2){
					System.out.println("ch2선택");
				}else
					System.out.println("잘못누르셨습니다.");
			} catch(Exception e) {
				System.out.println("에러발생. 초기메뉴로 돌아갑니다.");
				scanner = new Scanner(System.in);
			}
		}
		
		
	}
}
