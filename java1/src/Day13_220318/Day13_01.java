package Day13_220318;

public class Day13_01 {
	public static void main(String[] args) {
		
		// P. 534 Math 클래스(java.lang패키지=import 불필요.) : 수학 관련 메서드 제공. 객체 없이 사용 가능!
		
		System.out.println("절대값 : "+Math.abs(-5));	// Math.abs(숫자) : 절대값 반환
		System.out.println("절대값 : "+Math.abs(-3.14));
		
		System.out.println("올림값 : "+Math.ceil(5.3487));	// 소수점 첫째자리에서 올림
		System.out.println("올림값 : "+Math.ceil(-5.3));		// -5 출력
		
		System.out.println("버림값 : "+Math.floor(5.3487));	// 소수점 첫째자리에서 버림
		System.out.println("버림값 : "+Math.floor(-5.322));		// -6 출력
		
		System.out.println("최대값 : "+Math.max(5,  9));		// 두 수 중 큰 값 반환
		System.out.println("최대값 : "+Math.max(-5,  -9));	// 두 수 중 큰 값 반환
		
		System.out.println("최대값 : "+Math.min(5,  9));		// 두 수 중 작은 값 반환
		System.out.println("최대값 : "+Math.min(-5,  -9));	// 두 수 중 작은 값 반환
		
		System.out.println("난수값 : "+Math.random());		// 0.0~1.0 사이의 무작위값 반환
		
		System.out.println("반올림 : "+Math.rint(5.5));		// 가까운 정수의 실수값 (반올림하고 정확하고 같지는 않음.)(실수 반환)
		System.out.println("반올림 : "+Math.rint(-5.5));
		
		System.out.println("반올림 : "+Math.round(5.5));		// 무조건 소수 첫째자리에서 반올림(정수 반환)
		System.out.println("반올림 : "+Math.round(-5.5));
		
		double value = 12.3456;
		double tmp1 = value * 100;
		long tmp2 = Math.round(tmp1);
		double v16 = tmp2 / 100.0;
		System.out.println("v16 : "+tmp2);
		
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		
		// P. 536 Math.random()을 사용한 주사위 만들기 [ 1 ~ 6 사이의 무작위값 ]
		System.out.println("0~1사이의 실수형 : "+Math.random());	// 0~1
		System.out.println(Math.random()*6);					// 0~1 * 6 = 0~6
		System.out.println(Math.random()*6+1);					// 0~6 +1 = 1~7	-> 정확히는 1.0~6.9
		int num = (int)(Math.random()*6+1);						// int형으로 강제형변환 함으로써 소수점 모두 날림.
		System.out.println(num);
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		
		
		
		
		
	}
}
