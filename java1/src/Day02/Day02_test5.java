package Day02;

import java.util.Scanner;

public class Day02_test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� : ");
		int num = scanner.nextInt();
		
		System.out.println("7�� ����̸鼭 ¦���ΰ�? " + ((num%7==0) && (num%2==0)));
		//System.out.println("7�� ����̸鼭 ¦���ΰ�? " + ((scanner.nextInt()%7==0) && (scanner.nextInt()%2==0)));
		
		scanner.close();
	}
}
