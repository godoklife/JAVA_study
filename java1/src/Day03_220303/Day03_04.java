package Day03_220303;

public class Day03_04 {
	public static void main(String[] args) {
		
		// 제어문 : 1. if문  2. switch문
			// if : 논리검사 ( true 혹은 false ) -> 경우의 수가 정해져 있지 않은 경우
				// 
			// switch : 데이터검사 -> 경우의 수가 정해져 있는 경우
			// 형태
				// switch( 검사대상[논리검사 불가 == >= 등등] ) {
				// 		case '값' : 실행문;
				//		case '값' : 실행문;
				//		case '값' : 실행문;
				//		default : 실행문;
				// }
			// break : 가장 가까운 중괄호{}를 탈출한다. [ 거의 switch와 세트로 사용한다. ]
		
		//예제1
		int 점수1 = 80;
		
		if (점수1 == 90) System.out.println("A등급");
		else if(점수1 == 80) System.out.println("B등급");
		else if(점수1 == 70) System.out.println("C등급");
		else System.out.println("탈락");
		
		switch(점수1) {
			case 90 : System.out.println("A등급");	break;
			case 80 : System.out.println("B등급");	break;
			case 70 : System.out.println("C등급");	break;
			default : System.out.println("탈락");		break;
		}
		
		
		//예제2
		int 버튼 = 3;
		switch(버튼) {
			case 1: System.out.println("1층으로 이동");	break;
			case 2: System.out.println("2층으로 이동");	break;
			case 3: System.out.println("3층으로 이동");	break;
			case 4: System.out.println("4층으로 이동");	break;
			default: System.out.println("정지");
		}
		
		
		//예제3
		char 등급 = 'B';
		switch(등급) {
			case 'A' : System.out.println("우수회원"); break;
			case 'B' : System.out.println("우수회원"); break;
			case 'C' : 
			case 'D' : System.out.println("일반회원"); break;
			default : System.out.println("손님");
			//A, B가 같은 우수회원 C, D가 일반회원
		}
		
		
		// 예제4
		String 직급 = "과장";
		switch(직급) {
		case "부장" : System.out.println("700만원");	break;
		case "과장" : System.out.println("500만원");	break;
		default : System.out.println("300만원");	
		}
		
		
		
		
		
		
		
		
		
	}
}
