package Day10;

public class Audio implements RemoteControl{
	
	private int volume;
	
	// turnOn�� �߻� �޼���� ��ü �޼���
	public void turnOn() {
		System.out.println("������� �մϴ�.");
	}	// turnOn END
	
	// turnOff�� �߻� �޼���, ��ü �޼���
	public void turnOff() {
		System.out.println("������� ���ϴ�.");
	}	// turnOff END
	
	//setVolume�� �߻� �޼���� ��ü �޼���
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("���� ����� ���� : "+ this.volume);
	}	// setVolume END

}	// class END
