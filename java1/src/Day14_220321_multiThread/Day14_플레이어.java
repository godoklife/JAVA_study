package Day14_220321_multiThread;

import java.util.Scanner;

public class Day14_플레이어 {
	
	// 예제 [ 1. 소리재생 / 중지 | 2. 영상재생 / 중지 ]
		// 조건 : 소리 또는 영상 재생시에 
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean soundsw = true;
		
		while(true) {
			System.out.println("[ 1. 소리재생 / 중지 | 2. 영상재생 / 중지 ]");
			int ch=scanner.nextInt();
			Sound sound = new Sound();

			if(ch==1) {
				if(soundsw) {
					sound.soundStop(true);
					sound.start();
					soundsw=false;	// 소리 종료
				}
				else {
					sound.soundStop(soundsw);
					soundsw=true;
					
				}
				
			}
			else if(ch==2) {
				
			}
			
			
		}
	}
}
