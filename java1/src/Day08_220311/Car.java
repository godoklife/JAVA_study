package Day08_220311;

public class Car {

	// 1. �ʵ�
	
	private int speed;
	private boolean stop;	// ����ȭ�� �������� false�� ������.
	
	
	// 2. ������
	
	// 3. �޼���
	public int getSpeed() {		// private �ʵ� ȣ��� ���Ǵ� �޼���.		����
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
		return stop;	// false �������.
	}	// isStop END
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}	// setStop END
	
}	// car END
	
