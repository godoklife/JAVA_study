package Day06_220308;

public class Day06_04 {
	public static void main(String[] args) {
		
		// 클래스에 생성자가 하나라도 있으면 기본생성자를 클래스 내에 별도로 작성해줘야함.
		// 아니면 에러생김
		Car2 yourCar = new Car2();	// 인수가 없는 객체는 클래스 내 인수 없는 생성자 따라감.
		
		
		// 생성자가 있는 객체 생성
		Car2 myCar = new Car2("검정", 3000);
			// new 생성자명(인수1, 인수2, 인수n);
			// 검정 -> color 변수에 저장
			// 3000 -> cc 변수에 저장
	}
}
