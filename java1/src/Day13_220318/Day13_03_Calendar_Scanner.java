package Day13_220318;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_03_Calendar_Scanner {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 1. Ķ���� Ŭ���� �� ���� ��¥, �ð� ��ü ȣ��
		
		// 2. ����, ��, ��
		System.out.println("���� �Է� ");
		int year = scanner.nextInt();
		System.out.println("�� �Է�");
		int month = scanner.nextInt();	// 1���̸� 0�� ��ȯ�ϱ� ������ +1�� ���ִ°�!!!

		�޷�(year, month);
	}	// main END
	
	public static void �޷�(int year, int month) {
		
		Calendar calendar = Calendar.getInstance();	// �̹� ��ü�� ����� API��. new������ �ʿ� ����
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		// * �ش� ���� 1���� ���� ã��?
			// 1. ����� ���� Ķ���� ����.
		calendar.set(year, month-1, 1);	// calendar ��ü�� 2022�� 3�� 1�Ϸ� ����.
			// 2. 3�� 1���� ����
		int sweek = calendar.get(Calendar.DAY_OF_WEEK);
			// 3. 3���� ������ ��
		int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// 3. ���
		System.out.println("====================== "+year+"�� "+month+"�� ======================");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		// * ���� �� 1���� ��ġ �տ� ���� ä���
		for(int i=1; i<sweek; i++) {
			System.out.printf("\t");
		}
		
		// 1�Ϻ��� ��������¥ ���� ���.
		for(int i = 1; i<=eday; i++) {
			System.out.print(i+"\t");
			// ����ϸ��� �ٹٲ� ó��
			if(sweek%7==0) 
				System.out.println("");
			
			sweek++;
		}
	}
	
}	// class END
