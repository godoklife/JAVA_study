package Day08_220311;

public class Day08_03 {
	public static void main(String[] args) {
		
		// 패키지 : 폴더 기능 [ 클래스 식별 ]
			// 하위 패키지 : 패키지명.하위패키지명
		// import : 현 패키지를 제외한 외부, 상단 패키지 내 클래스 호출
			// 클래스 파일 상단에 작성
			// * : 모든 클래스
			// 클래스 자동 완성시 -> 해당 클래스 improt 자동 완성
		// 접근제한자
			// public : 모든 곳에서 접근 
			// private : 현 클래스 내에서만 접근 
			// protected : 동일한 패키지 내에서만 접근, 상속된 클래스는 예외
				// * 자식클래스 패키지 -----------> 부모클래스 패키지
			// default : 동일한 패지키 내에서만 접근 (그냥 기본값, 따로 붙일거 없음) 
		
			// 클래스 설계 관례
			// 필드는 private로 처리
			// 생성자는 public
			// 메서드는 public / private 선택 
		
	}
}
