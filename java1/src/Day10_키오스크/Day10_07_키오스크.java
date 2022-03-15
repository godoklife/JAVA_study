package Day10_키오스크;

import java.util.Scanner;

public class Day10_07_키오스크 {

	// 상속 : 점포
	// 클래스 : 롯데리아, 버거킹
	// 인터페이스 : 키오스크(UI)
	// 파일처리 : 제품 재고
	
	public static void main(String[] args) {
		/*
		 * 프로그램 실행 하면 아무것도 안뜸.
		 * 1 누르면 [ 히든 관리자매뉴 ] 상품등록매뉴 뜸
		 */
		키오스크 롯데리아 = new 롯데리아();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			롯데리아.제품목록();
			int ch = scanner.nextInt();
			if(ch==1) {
				롯데리아.상품추가();
			}
		}	// while END
	}	// main END
}	// class END
