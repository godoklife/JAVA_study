package Day13_220318;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Day13_02 {
	public static void main(String[] args) {
		
		// P.539
			// Date Ŭ���� : �ý��� ��¥ / �ð� ������ �ֵ��� ����.
				// java.util Ŭ���� ����Ʈ �������. java.sql ����!!!!
		
		Date date = new Date();	// date ��ü ����
		System.out.println("���� ��¥�� �ð� : "+ date);
		System.out.println("��ü ���� �޼��� : "+date.toString());
		
			// SimpleDateFormat Ŭ���� : ��¥ / �ð� ���� ��ȯ
		SimpleDateFormat asd = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ss��");
		// ��¥�� ���� �����ϱ�.
		System.out.println("��¥ ���� ���� �� : "+asd.format(date));
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

		// P.540 
			// Calendar Ŭ���� : �ü�� �ð����� ��¥, �ð��� ���� ����
		Calendar now = Calendar.getInstance();	// CalendarŬ������ ��ü ������ ���� ����. �̹� ����Ǿ�����.
		System.out.println(now.get(Calendar.YEAR));
		
		
		// Calendar Ŭ������ ���� ���� ����(����)-> �ѱ� ��ȯ 
		int week = now.get(Calendar.DAY_OF_WEEK);	// 1: �Ͽ���, 2: ������... 7:�����.
		String ���� = null;
		switch(week){
			case 2: ����="������"; break;
			case 3: ����="ȭ����"; break;
			case 4: ����="������"; break;
			case 5: ����="�����"; break;
			case 6: ����="�ݿ���"; break;
			case 7: ����="�����"; break;
			case 1: ����="�Ͽ���";
		}
		
		System.out.println(����);
		
		
		// ���� ���� ǥ��
		
		System.out.println("���� / ����, 0: ���� | 1: ���� ��°� : "+now.get(Calendar.AM_PM));	// 0 : ����, 1 : ����
		String �������� = null;
		switch(now.get(Calendar.AM_PM)) {
		case 0: ��������="����";	break;
		case 1: ��������="����";
		}
		
		System.out.println("�������� ��ȯ �� ��� : "+��������);
		
		
		System.out.println("�� : "+now.get(Calendar.HOUR));
		System.out.println("�� : "+now.get(Calendar.MINUTE));
		System.out.println("�� : "+now.get(Calendar.SECOND));
		
		// ZonedDateTime Ŭ���� : ���� �����ð�
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("������ : "+zonedDateTime);
		zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println("�ƽþ�/���� : "+zonedDateTime);
		
		
		
		
		
		
	}	// main END
}	// class END
