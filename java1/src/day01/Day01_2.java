package day01;

public class Day01_2 { // c s (class start)
	// 1. ���
		// 1. print()	: ��¸�
		// 2. printf()	: ��¿� �ٹ̱�(f�� format, ������)
		// 3. println()	: ��� �� �ٹٲ� ����
			// ���Ĺ���
				// %s : ���ڿ� ���� �ڸ�
				// %c : ���� 
				// %d : ����
			// �����
				// \n : �ٹٲ�
				// \t : �鿩����[5ĭ �������]
				// \\ : \
				// \" : "
	
	// 1. System : �ý��� Ŭ���� [ ����� ���� ������� �ڵ� ���� ]
	// 2. out : ��� ��Ʈ��
	// 3. print() : ��� �Լ�
	// 4. �����ݷ� : ���� �ڵ��� ���� �˸�
	// * �ý��� Ŭ���� �� out �̶�� ��½�Ʈ���� �緡 print �Լ��� ����ؼ� console�� ���ϴ� ��� ����� �� �ִ�.
	public static void main(String[] args) { // m s (main start)
		
		// 1. �⺻���
		System.out.print("print");		// ; �ڵ� ���� ����
		System.out.print("�ڹ� 1����");	// ���ڿ��� ū ����ǥ ó��
		System.out.print(123);			// ��, ���ڿ��� ū ����ǥ ó�� X
			// * �̸� ������� �ܾ� [ ����� ] �� ������ ��� ���ڴ� " " ó��
		// 2. �ڵ��ϼ� ( syso + ctrl + space_bar)
		System.out.println("syso + �����̽��ٴ� println");
		System.out.println(123);
		
		// 3. ���� ���
		System.out.printf("%s", "printf�� %s�� ȣ��");
		System.out.printf("\njava %d����", 1);
		
		// ����1 [ �⼮�� ]
		System.out.println("\n\t\t[[�⼮��]]");
		System.out.println("----------------------------------------");
		System.out.println("�̸�\t1����\t2����\t3����\t���");
		System.out.println("��ȣ��\t�⼮\t�Ἦ\t�⼮");
		System.out.println("���缮\t�⼮\t�Ἦ\t�⼮");
		System.out.println("----------------------------------------");
		
		// ����2 [ ����1���� printf�� �ٲ㺸�ÿ� ]
		System.out.printf("\n\t\t%s", "[[�⼮��]]");
		System.out.printf("\n%s", "----------------------------------------");
		System.out.printf("\n%s\t%s\t%s\t%s\t%s", "�̸�", "1����", "2����", "3����", "���");
		System.out.printf("\n%s\t%s\t%s\t%s\t", "��ȣ��", "�⼮", "�Ἦ", "�⼮");
		System.out.printf("\n%s\t%s\t%s\t%s\t", "���缮", "�⼮", "�Ἦ", "�⼮");
		System.out.printf("\n%s", "----------------------------------------\n\n");
		
		// ����1 : �����
		System.out.println("\\    /\\");	// �齽���� ��½� \\
		System.out.println(" )  ( ')");
		System.out.println("(  /  )");
		System.out.println(" \\(_)|");
		
		// ����2 : ������ 
				/*
						|\_/|
						|q p|   /}
						( 0 )"""\
						|"^"`    |
						||_/=\\__|
				*/
		System.out.println("\n|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");	// ū����ǥ ��½� \"
		System.out.println("|\"^\"'    |");
		System.out.println("||_/=\\\\__|");
		
	} // m e (main end)
	
} // c e (class end)
