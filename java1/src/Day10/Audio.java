package Day10;

public class Audio implements RemoteControl{
	
	private int volume;
	
	// turnOn의 추상 메서드와 실체 메서드
	public void turnOn() {
		System.out.println("오디오를 켭니다.");
	}	// turnOn END
	
	// turnOff의 추상 메서드, 실체 메서드
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
	}	// turnOff END
	
	//setVolume의 추상 메서드와 실체 메서드
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 오디오 볼륨 : "+ this.volume);
	}	// setVolume END

}	// class END
