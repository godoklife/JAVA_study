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
		calendar.set(year, month-1, 1);	// ex. 3�� 1��
		System.out.println("����ڰ� ��¥ ����� : "+calendar.toString());
			// 2. 3�� 1���� ����
		int sweek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(sweek);
			// 3. 3���� ������ ��
		
	
		
		
		System.out.println("====================== "+year+"�� "+month+"�� ======================");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
	}	// main END
}	// class END