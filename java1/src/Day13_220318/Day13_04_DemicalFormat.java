package Day13_220318;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Day13_04_DemicalFormat {
	public static void main(String[] args) throws Exception {
		
		// P. 544 DecimalFormat Ŭ����
		
		double num = 1234567.89;
		
		System.out.println("�ʱⰪ : 1234567.89");
		DecimalFormat df = new DecimalFormat("");
		System.out.println("DecimalFormat("+") : "+df.format(num));
		
		df = new DecimalFormat("0");
		System.out.println("DecimalFormat(0"+") : "+df.format(num));
		
		df = new DecimalFormat("0.0");
		System.out.println("DecimalFormat(0"+") : "+df.format(num));
		
		df = new DecimalFormat("#");
		System.out.println("DecimalFormat(#"+") : "+df.format(num));
		
		df = new DecimalFormat("#.#");
		System.out.println("DecimalFormat(#.#"+") : "+df.format(num));
		
		df = new DecimalFormat("0000000000.00000");
		System.out.println("DecimalFormat(0000000000.00000"+") : "+df.format(num));
		
		df = new DecimalFormat("###########.#####");
		System.out.println("DecimalFormat(##########.#####"+") : "+df.format(num));
		
		df = new DecimalFormat("#.0");
		System.out.println("DecimalFormat(#.0"+") : "+df.format(num));
		
		//****************���� ���� ����, õ���� ���� ��ǥ
		df = new DecimalFormat("#,##0��");
		System.out.println("DecimalFormat(#,##0��"+") : "+df.format(num));
		
		df = new DecimalFormat("#,###��");
		System.out.println("DecimalFormat(0"+") : "+df.format(0));	// 0 �� ���
		
		df = new DecimalFormat("0,000��");
		System.out.println("DecimalFormat(0"+") : "+df.format(0));	// 0,000 �� ���
		
		df = new DecimalFormat("0.0E0");
		System.out.println("DecimalFormat(0.0E0"+") : "+df.format(num));	// E : ��������
		
		df = new DecimalFormat("[��]+#,### ; [��]-#,###");
		System.out.println("DecimalFormat([��]+#,### ; [��]-#,###"+") : "+df.format(num));	// �����ݷ��� �������� ��, ���� ���� �� �����.
		
		df = new DecimalFormat("#,###%");
		System.out.println("DecimalFormat(#,###%"+") : "+df.format(num));
		
		df = new DecimalFormat("\u00A4 #,###");
		System.out.println("DecimalFormat(\u00A4"+") : "+df.format(num));
		
		System.out.println("====================================================");
		
		// P. 547 MessageFormat Ŭ���� : ���� ���� ��ȯ
		
		String id = "java";
		String name= "�ſ��";
		String tel = "010-123-5678";
		String text = "ȸ�� ID : {0} \nȸ�� �̸� : {1} \nȸ�� ��ȭ : {2}";
		String result1 = MessageFormat.format(text, id, name, tel);
		System.out.println(result1);

		String sql = "insert info member values( {0}, {1}, {2} )";
		Object[] test = {id, name, tel};
		String result2 = MessageFormat.format(sql, test);
		System.out.println(result2);
		
		
		System.out.println("====================================================");

		
		// JAVA 7 ���� ���� : Date, ���Ŀ��� �������� API �߰�����!!
		LocalDate currDate = LocalDate.now();	// new ��� X static �޼�����.
		System.out.println("���� ��¥ : "+currDate);
		
		LocalTime currTime = LocalTime.now();
		System.out.println("���� �ð� : "+currTime);
		
		// Date ���� ��¥ / �ð� [ ������ �ȵǰų� �񱳱���� ������ϴ�! ]
		// VS
		// LocalDate : ���� ��¥	LocalTime : ���� �ð�	LocalDateTime : ���� ��¥ �ð�
		
		LocalDateTime currdatetime = LocalDateTime.now();
		System.out.println("���糯¥ / �ð� : "+currdatetime);
		
		// **** �񱳴���� �ð��� ���
		Instant instant1 = Instant.now();
		
		Thread.sleep(1000);	// 1�� ��� [ �ڵ� �帧�� 1�ʵ��� �Ͻ� �����ñ� ] -> �Ϲݿ��� �߻�
		Instant instant2 = Instant.now();
		
		if(instant1.isBefore(instant2)) {
			System.out.println("instant1�� �� ����.");
		}else if(instant1.isAfter(instant2)) {
			System.out.println("instant2�� �� ����.");
		}
		
		System.out.println("����(ns) : "+instant1.until(instant2, ChronoUnit.NANOS));
		
	}
}
