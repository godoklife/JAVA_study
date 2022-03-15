package Day10_인터페이스연습;

public interface BankInterface {
	// 1. 상수필드
	
	// 2. 추상 메서드 : 선언 O, 구현 X
	public boolean 계좌생성();	// 받아야 하는 데이터 없음. 처리결과 리턴
	public void 입금();		// 입금할 계좌, 금액 전달받아야 함. 처리결과 리턴해야함
	public void 출금();	
	public void 이체();
	public void 계좌목록조회();
	public void 게좌잔고조회();
	
	// 3. 디폴트 메서드 : 선언 O, 구현 O, 객체없이 호출 X		[ jre 8 이상 ]
	
	// 4. 정적 메서드 : 선언 O, 구현 O, 객체없이 호출 O		[ jre 8 이상 ]
}
