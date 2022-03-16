package Day11_220316_Exception;

public class Day11_03 {
	
	// P. 422 예외 떠넘기기
		// 목적 : 모든 메서드에서 try{} catch(){} 사용시 코드가 복잡해진다.
		//		 따라서 모든 예외를 한 곳으로 몰아서 처리하는데 목적이 있다.
	
	public static void main(String[] args) {
		
		try {
		findclass();
		return;
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("finally");
		}
		
		try {
		withdraw(30000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}	// main END
		
	public static void findclass() throws Exception {	// throws Exception : 호출한 곳으로 예외를 던진다. -> 호출한곳에서 try~catch 써야 함.
		
//		1. 예외 던지기		
		Class claㅋㅋ = Class.forName("java.lang.String2");
		
//		2. try ~ catch		
//		try {
//		Class claㅋㅋ = Class.forName("java.lang.String2");
//		} catch(Exception e) {
//			System.out.println(e);
//		}
	}
		
		// P. 444~445 : 예외 만들기(예외를 새로 정의하기)
		
	public static void withdraw(int money) throws Exception{
		if(20000<money) {
			throw new Exception("에러종류 내가 지정");
		}
	}
		
		
		
		
}	// class END
