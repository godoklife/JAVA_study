package Day10;

public class Television implements RemoteControl, Searchable{
			// Ŭ������	implements	�������̽���
	
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
		System.out.println("���� ����� ���� : "+this.volume);
	}
	
	@Override
	public void turnOn() {
		System.out.println("�׷��� �մϴ�.");
	}
	@Override
	public void turnOff() {
		System.out.println("�׷��� ���ϴ�.");
	}
	@Override
	public void search(String url) {
			
	}
}
