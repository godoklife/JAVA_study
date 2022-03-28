package Day17_220324_결석2;

// 이 클래스 다시한번 읽어보자
// 전체적으로 이해 안된다...;;
// 	public static <제네릭타입1> Box<제네릭타입1> boxing(제네릭타입1 kind){ }


public class Product <제네릭타입1, 제네릭타입2> {
				// < 외부로부터 받을 자료형 이름 : 내맘대로~ >
	// 필드
	private 제네릭타입1 kind;	// Tv, Car
	private 제네릭타입2 model;	// Integer, String, Double
	
	public static <제네릭타입1> Box<제네릭타입1> boxing(제네릭타입1 kind){
// 메서드 선언부
// 접근제한자, 정적형태, 반환타입=제네릭타입1 Box1<제네릭타입1> boxing:메서드이름(제네릭타입)		
		Box<제네릭타입1> box = new Box<>();
		box.set(kind);
		return box;
	}
	
	
	// 이하 겟, 셋 자동생성
	public 제네릭타입1 getKind() {
		return kind;
	}

	public void setKind(제네릭타입1 kind) {
		this.kind = kind;
	}

	public 제네릭타입2 getModel() {
		return model;
	}

	public void setModel(제네릭타입2 model) {
		this.model = model;
	}
	
	// set 메서드
	
	
}
