package Day09_220314;

public class Day09_02 {
	public static void main(String[] args) {
		
		// 상속 
			// 부모에게서 물려받는것
			// 현실 : 부모 ---> 자식 선택 	// 프로그래밍 : 자식 ---> 부모 선택
			// extends : 연장하다 [ 상속하다 ]
			// 목적 : 빠른 설계 [ 기존에 있던 클래스를 연장해서 새로운 클래스를 설계 ] 
				// 
		
		// 예제 P. 290~292
	// 1. 서브클래스로 객체 생성
	DmbCellPhone dmbCellPhone = new DmbCellPhone("자바phone", "시크한블랙", 10);
	
	// 2. 서브클래스로 만들어진 객체로 슈퍼클래스 내 멤버 접근
	System.out.println("모델 : "+ dmbCellPhone.model);
	System.out.println("색상 : "+dmbCellPhone.color);
	
	// 3. 서브클래스로 만들어진 객체로 본인 멤버 접근
	System.out.println("채널 : " + dmbCellPhone.channel);
	
	// 4. 서브클래스로 만들어진 객체로 슈퍼클래스 내 멤버 [메서드] 접근
	dmbCellPhone.powerOn();
	dmbCellPhone.bell();
	dmbCellPhone.sendVoice("여보세요");
	dmbCellPhone.receiveVoice("안녕하세요! 저는 김용준인데요");
	dmbCellPhone.sendVoice("네 반갑습니다.");
	dmbCellPhone.hangUp();
	
	// 5. 서브클래스로 만들어진 객체로 본인 벰버 접근
	dmbCellPhone.turnOnDmb();
	dmbCellPhone.changeChannelDmb(20);
	dmbCellPhone.turnOffDmb();
	
	}
}
