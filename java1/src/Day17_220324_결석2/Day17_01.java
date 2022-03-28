package Day17_220324_결석2;

public class Day17_01 {
	public static void main(String[] args) {
		
		// 제네릭 generic 
			// 선언 : public class 이름 < 제네릭이름 >
			// 목적 : 외부로부터 들어오는 데이터를 해당 제네릭으로만 제한.
		
		// P.658
		
		// 1. 객체 생성
		Box<String> box1 = new Box<String>();
		// 내맘대로 제네릭을 정의한 Box클래스에 String타입으로만 넣기
		box1.set("김용준");
		String string = box1.get();
		// String형으로만 넣는다고 생성할때 정의했으니 꺼내올때 강제형변환이 필요없다!
		
		// 2. 또다른 객체 생성
		Box<Integer> box2 = new Box<>();
			// 뒤에는 제네릭 생략 가능.
		box2.set(0);
		int value = box2.get();
		//----------------------------------------------------------------
		
		// P.659
		
		// 1. 객체를 생성할 때 제네릭타입 넣기 [ Tv, String ]
		Product<Tv, String> product1 = new Product<>();
		// 2. 객체 내 필드에 각각 제네릭 타입으로 값 넣기
		product1.setKind(new Tv());
		product1.setModel("스마트TV");
		// 3. 호출 [ 형 변환 X ] 
		Tv tv = product1.getKind();
		String tvmodel = product1.getModel();
		System.out.println(tv);	// 쓰잘데기없는 메모리어드레스 출력
		System.out.println(tvmodel);	// "스마트TV" 문자열 출력
		
		// 1. 위 예제와 마찬가지. 객체를 생성할 때 제네릭타입 넣기 [ Car, String ] 
		Product<Car, String> product2 = new Product<>();
		// 2. 객케 내 필드에 각 제네릭 타입으로 값 저장.
		product2.setKind(new Car());
		product2.setModel("카마로");
		// 3. 값 호출 [ 타입캐스팅 ㄴㄴ ]
		Car car = product2.getKind();
		String carmodel = product2.getModel();
		System.out.println(carmodel);
		
		
// 클래스 생성 후 리스트로 선언, 생성자 사용하는것과 다른점이 무엇인가 생각해볼 것.
		
	}
}
