package Day13_220318;

import java.util.Calendar;

public class Day13_03 {
	public static void main(String[] args) {
		
		// 1. Ķ���� Ŭ���� �� ���� ��¥, �ð� ��ü ȣ��
		Calendar calendar = Calendar.getInstance();	// �̹� ��ü�� ����� API��. new������ �ʿ� ����
		// 2. ����, ��, ��
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;	// 1���̸� 0�� ��ȯ�ϱ� ������ +1�� ���ִ°�!!!
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		// * �ش� ���� 1���� ���� ã��?
			// 1. ����� ���� Ķ���� ����.
		calendar.set(year, month-1, 1);	// calendar ��ü�� 2022�� 3�� 1�Ϸ� ����.
		System.out.println("����ڰ� ��¥ ����� : "+calendar.toString());
			// 2. 3�� 1���� ����
		int sweek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(sweek);
			// 3. 3���� ������ ��
		int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("3�� ������ �� : "+eday);
		
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
			if(sweek%7==0) System.out.println("");
			sweek++;
		}
		
		
		
		
		
		
		
	}	// main END
}	// class END
