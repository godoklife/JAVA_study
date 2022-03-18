package Day13_220318;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_03_Calendar_Scanner {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		// 1. Ķ���� Ŭ���� �� ���� ��¥, �ð� ��ü ȣ��
		
		// 2. ����, ��, ��
		System.out.println("���� �Է� ");
		int year = scanner.nextInt();
		System.out.println("�� �Է�");
		int month = scanner.nextInt();	// 1���̸� 0�� ��ȯ�ϱ� ������ +1�� ���ִ°�!!!

		�޷�(year, month);
	}	// main END
	
	public static void �޷�(int year, int month) {
		while(true) {	// �������� : 3�� ������ ���� ������.
			try {
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
			System.out.println("");
			System.out.println("1. ������ | 2. ������ | 3. �ٽð˻� | 4. ����");
			int ch=scanner.nextInt();
			if(ch==1){
				month -= 1;
				if(month==0) {
					year-=1;
					month=12;
				}
				
			}else if(ch==2) {
				month += 1;
				if(month==13) {
					year+=1;
					month=1;
				}
			}else if(ch==3) {
				System.out.println("���� �Է� ");
				year = scanner.nextInt();
				System.out.println("�� �Է�");
				month = scanner.nextInt();	// 1���̸� 0�� ��ȯ�ϱ� ������ +1�� ���ִ°�!!!
			}else if(ch==4) {
				System.out.println("�����մϴ�.");
				return;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			} catch(Exception e){
				System.out.println("���� �߻�! �ʱ�Ŵ��� ���ư��ϴ�.");
				System.out.println(e);
				scanner = new Scanner(System.in);
			}
			
		}	// while END
	}	// �޷� END
}	// class END
