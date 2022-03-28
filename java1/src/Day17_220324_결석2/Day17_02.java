package Day17_220324_결석2;

public class Day17_02 {
	public static void main(String[] args) {
		
		// P.661~662
		
		// 1. box 객체 생성 [ 제네릭 : Integer ]
		Box<Integer> box1 = new Box<>();
		// 2. 메서드 호출 후 결과값을 객체에 대입
		box1 = Util.<Integer>boxing(100);
		
		
	}	// m e
}	// c e
