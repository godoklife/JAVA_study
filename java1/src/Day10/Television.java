package Day10;

public class Television implements RemoteControl, Searchable{
			// 클래스명	implements	인터페이스명
	
	private int volume;
	
	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 오디오 볼륨 : "+this.volume);
	}
	
	@Override
	public void turnOn() {
		System.out.println("테레비를 켭니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("테레비를 끕니다.");
	}
	@Override
	public void search(String url) {
			
	}
}
