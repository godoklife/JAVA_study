package Day19_220328;

import java.util.Hashtable;
import java.util.Scanner;

public class Day19_04 {
	public static void main(String[] args) {
		// P. 747 Hashtable
		
		// 1. Hashtable Ŭ���� ��ü ����
		Hashtable<String , String> map = new Hashtable<>();
		
		// 2. map ��ü�� ��Ʈ�� �߰��ϱ�
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("���̵�� ��й�ȣ�� �Է��Ͻÿ�.");
			System.out.print("���̵� : ");
			String id = scanner.next();
			
			System.out.print("��й�ȣ : ");
			String pw = scanner.next();
			System.out.println();
			
			if(map.containsKey(id)) {	// �Է��� id�� map.��ü �� key�� �����ϸ�
				if(map.get(id).equals(pw)) {
					System.out.println("�α��� �Ǿ����ϴ�.**");
				}else {
					System.out.println("��й�ȣ�� Ȯ���ϼ���.");
				}
			}else {
				System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.");
			}
		}	// w e
	}	// m e
}	// c e
