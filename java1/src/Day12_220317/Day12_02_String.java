package Day12_220317;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Day12_02_String {
	public static void main(String[] args) throws IOException {
		
		// P. 499 String �޼���
		// charAt() : ���ڿ����� Ư�� ���� ����
		String ssn = "930101-1212121";
		char sex = ssn.charAt(7);
		
		switch(sex) {	// switch ��� [switch(�˻���) { }
		case'1': // 1���� �ƹ��͵� ������ 3���� ����.
		case'3': System.out.println("����"); break;
		case'2': // 2���� �ƹ��͵� ������ 4���� ����.
		case'4': System.out.println("����"); break;	// ����� �������̴ϱ� break ����
		}
		
		// P.501 equals() : ���ڿ� ��
			// �⺻�ڷ����� ����ϴ� ������ ������ ��� ����
			// String Ŭ���� ����ϴ� ��ü�� == ������ ��� �Ұ� [ ��� .equals(���ڿ�) ��� ]
		
		String strVar1 = new String("�̸��̴پƾ�");
		String strVar2 = ("�̸��̴پƾ�");
			// String Ŭ������!!! new ������ ���� ��ü ���� ����. ���� String Ŭ������.
		
		if(strVar1 == strVar2) {
			System.out.println("���� String ��ü�� ����");
		} else {
			System.out.println("�ٸ� String ��ü�� ����");
		}
		if(strVar1.equals(strVar2)) {
			System.out.println("���� String ��ü�� ����");
		} else {
			System.out.println("�ٸ� String ��ü�� ����");
		}
		
		
		// P. 502 .getBytes() : ���ڿ� -> ����Ʈ���� ��ȯ
		String str = "�ȳ��ϼ���";
		
		byte[] bytes1 = str.getBytes();	// ���ڿ� -> ����Ʈ���� ��ȯ
		System.out.println(bytes1.length);
		
		String str1 = new String(bytes1);	// ����Ʈ�� -> ���ڿ��� ��ȯ
		System.out.println(str1);
		
		// ���ڵ���� ������ �Ϲݿ��� �߻�.
		byte[] bytes2 = str.getBytes("EUC-KR");	
		System.out.println("EUC-KR ���� : "+ bytes2.length);
		
		String str2 = new String(bytes2, "EUC-KR");
		System.out.println("����Ʈ�� -> ���ڿ� : "+str2);
		
		byte[] bytes3 = str.getBytes("UTF-8");	// ���ڵ���� ������ �Ϲݿ��� �߻�.
		System.out.println("UTF-8 ���� : "+ bytes3.length);
		
		String str3 = new String(bytes3, "UTF-8");
		System.out.println("����Ʈ�� -> ���ڿ� : "+str3);
		
		
		
		// P. 504 indexOf() : ���� ��ġ [ �ε��� ] ã��
		String subject = "�ڹ� ���α׷���";
		// ���ڿ� �� Ư�����ڿ� ��ġ[�ε���] ã��
		int location = subject.indexOf("���α׷���");
		System.out.println(location);	// 3�� �ε������� ���α׷��� ã�� ����
		
		// ���ڿ��� Ư�� ���ڿ� ��ġ [ �ε��� ] ã�� / ���࿡ ������ -1 [����]
		System.out.println(subject.indexOf(" "));
		if(subject.indexOf("�ڹ�") != -1) {	// �ε����� 0�� ���� [ -1 �ε����� ���� ]
			System.out.println("�ڹٿ� ���õ� å");
		} else {
			System.out.println("�ڹٿ� ���� ���� å");
		}
		System.out.println("==============================");
		
		// P. 505 length() : ���ڿ� ����
		String ssn2 = "123213214523";
		int length = ssn2.length();
		if(length == 13) {
			System.out.println("�ι� �ڸ����� �½��ϴ�.");
		} else {
			System.out.println("�ι� �ڸ����� ��ġ���� �ʽ��ϴ�.");
		}
		System.out.println("==============================");

		// P. 506 replace("��������", "���ο��") : ���ڿ� ��ü [ ���� ]
		String oldStr = "�ڹٴ� ��ü������ �Դϴ�. �ڹٴ� ǰ���� API�� �����մϴ�.";
		String newStr = oldStr.replace("�ڹ�","JAVA");
						// ���ڿ�.replace("��������", "���ο��")
		System.out.println("�������ڿ� : "+oldStr);
		System.out.println("���ο�ڿ� : "+newStr);
		
		System.out.println("==============================");
		
		
		// P. 507 substring() vs split() : ���ڿ� �ڸ���
		String ssn3 = "880815-1234567";
		
		String firstNum = ssn3.substring(0,6);	// �����ε���, �������ε��� (�������ε����� ���� ����.)
		String secondNum = ssn3.substring(7);	// �����ε����� ������ �����ε��� ���� �� ����
		System.out.println("Ȯ�� : "+firstNum);	// 880815
		System.out.println("Ȯ�� : "+secondNum);	// 1234567
		
		// split
			// ssn3.split("-") �Է��ϸ� 880815-1234567�� "-" �������� �߶� 2�� �迭�� ��ȯ, ������ "-"�� �����.
			// [0] : 880815
			// [1] : 1234567
		System.out.println("Ȯ�� : "+ssn3.split("-")[0]);
		
		System.out.println("==============================");
		
		// P. 510 valueOf() : �⺻Ÿ���� ���ڿ��� ��ȯ
		
		String str10 = String.valueOf(10);		// 10 ���ڷ�	 ��ȯ
		String str11 = String.valueOf(10.5);	// 10.5 ���ڷ� ��ȯ
		String str12 = String.valueOf(true);	// true��� ���ڰ� ����ȴ�. boolean���� �ƴ�!!
		String str13 = 10+"";					// + �����ڿ� ���� 10�̶�� ���ڷ� ��ȯ. ��, " " ���� ū����ǥ�� ���� ���� �ȵ�.
		
		System.out.println(str10);
		System.out.println(str11);
		System.out.println(str12);
		System.out.println(str13);
		
		
		
		
		
		
		
		
	}
}
