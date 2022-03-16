package Day11_220316_Exception;

public class Day11_02 {
	public static void main(String[] args) {
		
		// P.423 NullPointerException
	try {
		String data = null;
		System.out.println(data.toString());	// 메모리 주소가 없는 null을 불러온다.
	} catch(NullPointerException 에러저장용객체이름) {
		System.out.println("예외 발생!!! : "+에러저장용객체이름);
	}
	//--------------------------------------------------------------------
		// P.424 ArrayIndexOutOfBoundsException
	try {
	String[] 배열 = new String[10];
	
	배열[10]="10";	// 인덱스는 0~9인데 10번 인덱스에 저장한다.
	}
	catch(ArrayIndexOutOfBoundsException 에러저장용객체이름) {
		System.out.println("예외 발생!!! : "+에러저장용객체이름);
	}
	
	//--------------------------------------------------------------------
		// P. 426
	try {
	String data1 = "100";
	String data2 = "a100";
	int value1 = Integer.parseInt(data1);
	int value2 = Integer.parseInt(data2);
			//	 Integer.parseInt(문자열);  문자열 -> 정수 면환
	}
	catch(NumberFormatException 에러저장용객체이름) {
		System.out.println("예외 발생!!! : "+에러저장용객체이름);
	}
	
	//--------------------------------------------------------------------
		// P. 428	// 이거는 예외처리 불가능. 코드가 틀려먹은것
	try {
	String 문자열 = "유재석";	// 자바 클래스 중 하나
	Object 수퍼객체;			// Object : 자바 클래스 내 최최최상위 수퍼갑 클래스
	
	수퍼객체 = 문자열;			// 자식은 부모에게 갈 수 있지만
	문자열 = (String)수퍼객체;	// 부모는 자식에게 (자동형변환)갈 수 없다.	강제형변환 해야 함.
	}
	catch(Exception 에러저장용객체이름) {
		System.out.println("에러발생!!! : "+에러저장용객체이름);
	}
	finally {
		System.out.println("finally");
	}
	
	}	// main END
}	// class END