package Day03_220303;

import java.util.Scanner;

public class Day03_04_test01 {
	public static void main(String[] args) {
		System.out.println("����, ����, ���� ������ �Է¹޾� ��� 90�̻��̸� A���, 80�̻��̸� B, ������ Ż�� ����ġ�� ���");
		
		Scanner scanner = new Scanner(System.in);
		int kor, eng, math, avg;
		
		System.out.println("���� ���� �Է� : ");
		kor = scanner.nextInt();
		
		System.out.println("���� ���� �Է� : ");
		eng = scanner.nextInt();
		
		System.out.println("���� ���� �Է� : ");
		math = scanner.nextInt();
		
		avg = (kor+eng+math)/3;
		System.out.println("��� : "+avg);
		
		switch(avg/10) {	
			// 1�ڸ����� �ʿ� ������ �����°���. ����ġ������ 1�ڸ������� ������ ä�� �ۼ��Ϸ��� �밡�� �ʹ� ����.
		case 9 : System.out.println("A���");	break;
		case 8 : System.out.println("B���");	break;
		default : System.out.println("Ż��");
		}
		
		scanner.close();
	}
}
