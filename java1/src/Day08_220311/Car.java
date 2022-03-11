package Day08_220311;

public class Car {

	// 1. 필드
	
	private int speed;
	private boolean stop;	// 조기화를 안했으니 false가 들어가있음.
	
	
	// 2. 생성자
	
	// 3. 메서드
	public int getSpeed() {		// private 필드 호출시 사용되는 메서드.		게터
		return speed;
	}	// getSpeed END
	
	public void setSpeed(int speed) {
		if(speed < 0) {			
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}	// setSpeed END
	
	public boolean isStop() {
		return stop;	// false 들어있음.
	}	// isStop END
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}	// setStop END
	
}	// car END
	
