package Day11_220316_Exception;

public class Day11_03 {
	
	// P. 422 ���� ���ѱ��
		// ���� : ��� �޼��忡�� try{} catch(){} ���� �ڵ尡 ����������.
		//		 ���� ��� ���ܸ� �� ������ ���Ƽ� ó���ϴµ� ������ �ִ�.
	
	public static void main(String[] args) {
		
		try {
		findclass();
		return;
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("finally");
		}
		
		try {
		withdraw(30000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}	// main END
		
	public static void findclass() throws Exception {	// throws Exception : ȣ���� ������ ���ܸ� ������. -> ȣ���Ѱ����� try~catch ��� ��.
		
//		1. ���� ������		
		Class cla���� = Class.forName("java.lang.String2");
		
//		2. try ~ catch		
//		try {
//		Class cla���� = Class.forName("java.lang.String2");
//		} catch(Exception e) {
//			System.out.println(e);
//		}
	}
		
		// P. 444~445 : ���� �����(���ܸ� ���� �����ϱ�)
		
	public static void withdraw(int money) throws Exception{
		if(20000<money) {
			throw new Exception("�������� ���� ����");
		}
	}
		
		
		
		
}	// class END
