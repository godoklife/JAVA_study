package Day11_220316_�������̽�_Ȯ�ι���;

public class Day11_01 {
	// P. 386 Ȯ�ι���
		// 1. 3 [ �������̽��� �ɹ� : 1. ����ʵ� 2. �߻�޼��� 3. ����Ʈ�޼��� 4. �����޼���
		// 2. 4 [ �������̽� ���� = ������ü ] 
			// ������ü ?? Ŭ������ implements�� ��ü
	
		// 3. ��� class : Dog, Cat
//	private static void printSound(Soundable soundable) {
////	����������	����		��ȯŸ��	�޼����	(�μ� [ ����, �迭, ��ü, �������̽� ] )	
//						//	������  (�������̽� ��ü)
//		System.out.println(soundable.Sound());
//	}
//	
//	public static void main(String[] args) {
//		printSound(new Cat());
//		printSound(new Dog());
//	}
//	
	
	// 4. 
		 // Dao : DB���ٰ�ü, 
//	public static void dbWork(DataAccessObject dao) {
//		dao.select();
//		dao.insert();
//		dao.update();
//		dao.delete();
//	}
//	public static void main(String[] args) {
//		dbWork(new OracleDao());
//		dbWork(new MySquDao());
//	}
	
	// 5. �͸�ü [ �������̽��� ���� ���� ]
		// ���� ��ü : �������̽� ��ü�� = new Ŭ����();
		// �͸� ��ü : �������̽� ��ü�� = new �������̽�() { ���� };  �����ݷ�!!!
			// �͸� ��ü�� ���� 1ȸ������ ���� �ַ� ���.
			// ���� ��ü�� ��� ��Ȱ���Ҷ��� ���.
	static Action action = new Action() {	// �̰� �͸� ��ü.
		
		@Override
		public void work() {	//
			System.out.println("���縦 �մϴ�.");
		}
	};
	
	public static void main(String[] args) {
		action.work();
	}
	
}
