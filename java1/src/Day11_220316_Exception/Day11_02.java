package Day11_220316_Exception;

public class Day11_02 {
	public static void main(String[] args) {
		
		// P.423 NullPointerException
	try {
		String data = null;
		System.out.println(data.toString());	// �޸� �ּҰ� ���� null�� �ҷ��´�.
	} catch(NullPointerException ��������밴ü�̸�) {
		System.out.println("���� �߻�!!! : "+��������밴ü�̸�);
	}
	//--------------------------------------------------------------------
		// P.424 ArrayIndexOutOfBoundsException
	try {
	String[] �迭 = new String[10];
	
	�迭[10]="10";	// �ε����� 0~9�ε� 10�� �ε����� �����Ѵ�.
	}
	catch(ArrayIndexOutOfBoundsException ��������밴ü�̸�) {
		System.out.println("���� �߻�!!! : "+��������밴ü�̸�);
	}
	
	//--------------------------------------------------------------------
		// P. 426
	try {
	String data1 = "100";
	String data2 = "a100";
	int value1 = Integer.parseInt(data1);
	int value2 = Integer.parseInt(data2);
			//	 Integer.parseInt(���ڿ�);  ���ڿ� -> ���� ��ȯ
	}
	catch(NumberFormatException ��������밴ü�̸�) {
		System.out.println("���� �߻�!!! : "+��������밴ü�̸�);
	}
	
	//--------------------------------------------------------------------
		// P. 428	// �̰Ŵ� ����ó�� �Ұ���. �ڵ尡 Ʋ��������
	try {
	String ���ڿ� = "���缮";	// �ڹ� Ŭ���� �� �ϳ�
	Object ���۰�ü;			// Object : �ڹ� Ŭ���� �� �����ֻ��� ���۰� Ŭ����
	
	���۰�ü = ���ڿ�;			// �ڽ��� �θ𿡰� �� �� ������
	���ڿ� = (String)���۰�ü;	// �θ�� �ڽĿ��� (�ڵ�����ȯ)�� �� ����.	��������ȯ �ؾ� ��.
	}
	catch(Exception ��������밴ü�̸�) {
		System.out.println("�����߻�!!! : "+��������밴ü�̸�);
	}
	finally {
		System.out.println("finally");
	}
	
	}	// main END
}	// class END