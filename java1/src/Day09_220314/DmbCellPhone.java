package Day09_220314;

public class DmbCellPhone extends CellPhone {
	// CellPhone 클래스의 필드 생성자 메서드를 모두 끌어옴.
	// 그 후 아래 내용을 추가해서 DmbCellPhone이라는 클래스가 완성됨.
	// 이게 상속의 기본 개념(extends)
	
	
	// 1. 필드
	int channel;
	// 2. 생성자
	DmbCellPhone(String model, String color, int channel){
		this.model = model;	// model
		this.color = color;	// color는 상속받은 CellPhone 클래스에 있는 필드들임.
		// 현재 클래스에 없는 필드임으로 슈퍼클래스 내 멤버호출
		// CellPhone 클래스의 color 필드를 가리키는것임.
		this.channel = channel;
	}
	// 3. 메서드
	void turnOnDmb() {
		System.out.println("채널"+channel+"번 DMB 방송 수신을 시작합니다.");
	}
	
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널"+channel +"번으로 바꿉니다.");
	}
	
	void turnOffDmb() {
		System.out.println("DMB방송 수신을 종료합니다.");
	}
	
}
