package Day14_220321_multiThread;

import java.util.Scanner;

public class Day14_�÷��̾� {
	
	// ���� [ 1. �Ҹ���� / ���� | 2. ������� / ���� ]
		// ���� : �Ҹ� �Ǵ� ���� ����ÿ� 
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean soundsw = true;
		boolean moviesw = true;
		
		while(true) {
			System.out.println("[ 1. �Ҹ���� / ���� | 2. ������� / ���� ]");
			int ch=scanner.nextInt();
			Sound sound = new Sound();

			if(ch==1) {
				if(soundsw) {
					sound.soundStop(true);
					sound.start();
					soundsw=false;	// �Ҹ� ����
				}
				else {
					sound.soundStop(soundsw);
					soundsw=true;
					
				}
				
			}
			else if(ch==2) {
				Movie movie = new Movie();
				if(moviesw) {
					movie.Moviestop(true);
					movie.start();
					moviesw=false;
					
				}
				else {
					movie.Moviestop(moviesw);
					moviesw=true;
				}
				
			}
			
		}	// while END
	}	// main END
}	// class END
