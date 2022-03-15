package Day10_키오스크;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 롯데리아 extends 점포{	// 점포는 키오스크를 구현하므로 결국 롯데리아도 키오스크를 사용할수 있다.

	// 1. 필드
	private String 점주;
	private ArrayList<상품> 상품리스트 = new ArrayList<>();
	
	// 2. 생성자
	public 롯데리아() {
	}
	


	public 롯데리아(String 점주, ArrayList<상품> 상품리스트) {
		super();
		this.점주 = 점주;
		this.상품리스트 = 상품리스트;
	}



	// 3. 메서드
	@Override
	public void 제품목록() {
		System.out.println("======= 롯데리아 제품 목록 =======");
		int i=1;
		for(상품 tmp : 상품리스트) {
			System.out.println(i+". \t"+tmp.get상품명()+"\t"+tmp.get가격());
			i++;
		}
	}
	
	public void 상품추가() {
		// 1. 입력
		Scanner scanner = new Scanner(System.in);
		System.out.println("*** 롯데리아 상품 추가 ***");
		System.out.print("상품명 : ");
		String 상품명 = scanner.next();
		System.out.print("재고 : ");
		int 재고 = scanner.nextInt();
		System.out.print("가격 : ");
		int 가격 = scanner.nextInt();
		
		// 2. 객체화
		상품 상품추가용메서드 = new 상품(상품명, 재고, 가격);
		
		// 3. 리스트에 저장
		상품리스트.add(상품추가용메서드);
		
		// 4. 파일처리
		try {	// 오류가 발생할것 같은 코드 묶음 [ 예상 ]
			FileOutputStream fileOutputStream = new FileOutputStream("d:/java/롯데리아재고.txt", true);
			String 내보내기 = 상품명+","+재고+","+가격+"\n";	// 콤마 : 필드 구분용 | \n : 재품 구분
			fileOutputStream.write(내보내기.getBytes());
		}catch(Exception e) {	// 
			
		}
		System.out.println("알림) 상품 저장 완료");
		
	}
		
	
}
