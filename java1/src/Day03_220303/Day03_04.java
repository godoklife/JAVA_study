package Day03_220303;

public class Day03_04 {
	public static void main(String[] args) {
		
		// ��� : 1. if��  2. switch��
			// if : ���˻� ( true Ȥ�� false ) -> ����� ���� ������ ���� ���� ���
				// 
			// switch : �����Ͱ˻� -> ����� ���� ������ �ִ� ���
			// ����
				// switch( �˻���[���˻� �Ұ� == >= ���] ) {
				// 		case '��' : ���๮;
				//		case '��' : ���๮;
				//		case '��' : ���๮;
				//		default : ���๮;
				// }
			// break : ���� ����� �߰�ȣ{}�� Ż���Ѵ�. [ ���� switch�� ��Ʈ�� ����Ѵ�. ]
		
		//����1
		int ����1 = 80;
		
		if (����1 == 90) System.out.println("A���");
		else if(����1 == 80) System.out.println("B���");
		else if(����1 == 70) System.out.println("C���");
		else System.out.println("Ż��");
		
		switch(����1) {
			case 90 : System.out.println("A���");	break;
			case 80 : System.out.println("B���");	break;
			case 70 : System.out.println("C���");	break;
			default : System.out.println("Ż��");		break;
		}
		
		
		//����2
		int ��ư = 3;
		switch(��ư) {
			case 1: System.out.println("1������ �̵�");	break;
			case 2: System.out.println("2������ �̵�");	break;
			case 3: System.out.println("3������ �̵�");	break;
			case 4: System.out.println("4������ �̵�");	break;
			default: System.out.println("����");
		}
		
		
		//����3
		char ��� = 'B';
		switch(���) {
			case 'A' : System.out.println("���ȸ��"); break;
			case 'B' : System.out.println("���ȸ��"); break;
			case 'C' : 
			case 'D' : System.out.println("�Ϲ�ȸ��"); break;
			default : System.out.println("�մ�");
			//A, B�� ���� ���ȸ�� C, D�� �Ϲ�ȸ��
		}
		
		
		// ����4
		String ���� = "����";
		switch(����) {
		case "����" : System.out.println("700����");	break;
		case "����" : System.out.println("500����");	break;
		default : System.out.println("300����");	
		}
		
		
		
		
		
		
		
		
		
	}
}
