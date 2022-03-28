package Day16_220323_결석1;


public class Day16_01 {
	public static void main(String[] args) {
		// P. 656 제네릭 generic 
		
		// 예제1) 제네릭을 사용하지 않을 경우 꺼내올때마다 캐스팅을 해줘야 함으로 성능저하가 발생.
			// 단, 아무 형태나 저장 가능
		// 1. Box class의 객체 생성
		Box box = new Box();
		
		// 2. 객체 내 set메서드(인수 : String) 호출
		box.set("김용준");
		
		// 3. 객체 내 get메서드(반환형태 : Object) 호출
			// Object -> String형으로 강제형변환 필요.
		String name = (String)box.get();
		
		// 4. 
		box.set(new Apple());
			// 자식이 오브젝트라는 수퍼클래스에게 집어넣을때는 자동으로 형변환이 되나
		Apple apple = (Apple)box.get();
			// 수퍼클래스에서 서브클래스로 옮길때는 타입캐스팅 반 드 시 필요함
			
		
	}
}
