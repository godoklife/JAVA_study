package Day10_키오스크;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
		
		Scanner scanner = new Scanner(System.in);
		
		
		ArrayList<상품> 상품리스트 = new ArrayList<>();
		
		// 파일 입력 [ 파일 -> 자바 ]
		
		
		try {	// try { } 안에 오류가 발생할것 같은 코드 넣기 (예상)
		// 1. 파일 입력 객체
		FileInputStream fileInputStream = new FileInputStream("d:/java/롯데리아재고.txt");
		// 2. 파일 읽어오기 [ 파일 -> 스트림(바이트열) -> 자바 ]
			// 1. 바이트 배열 선언
		byte[] bytes = new byte[1024];	// 1KB짜리 배열 선언
		
			// 2. 읽어와서 배열에 저장
		fileInputStream.read(bytes);
		
			// 3. , : 필드 구분 | \n : 객체(상품)구분    ->내가 롯데리아 클래스 (4. 파일출력)에서 그렇게 정의 한 거임.
		String 파일내용 = new String(bytes);	// 읽어들인 바이트열 -> 문자열로 저장
				
		String[] 상품목록 = 파일내용.split("\n");	// 먼저 문자열을 상품별로 구분해둔 뒤 배열에 저장
			// String 분해 메서드 -> split("기준");
		
		for(String tmp : 상품목록) {			// 배열에 저장된 상품의 상품명, 재고, 가격을 분리하는 for문.
			String[] 필드목록 = tmp.split(",");
			상품 상품 = new 상품(필드목록[0], Integer.parseInt(필드목록[1]), Integer.parseInt(필드목록[2]));	
							// 문자열 -> 정수형 변환 [ Integer.parseInt(문자열) ]
							// 상품명, 재고, 가격 순인데 재고와 가격은 int형이기 때문에 String에서 int형으로 변환해준것.
			상품리스트.add(상품);
		}
		
		
		} catch (Exception e) { }	// catch : 예외 잡기 ->Exception 클래스의 객체에 저장.
		
		키오스크 롯데리아 = new 롯데리아("유재석", 상품리스트);		// 점장이 유재석인 롯데리아 객체 생성
		
		while(true) {
			
			롯데리아.제품목록();
			int ch = scanner.nextInt();
			if(ch==1) {
				롯데리아.상품추가();
			}
		}	// while END
	}	// main END
}	// class END
