package Day12_220317;

import java.io.IOException;

public class Day12_03 {
	public static void main(String[] args) throws Exception {
		String[] ������� = {"�ȴ�! ���̹� ��α�&����Ʈ", "������ ��Ʈ ���� Ȱ�� ������", 
			"Trucker�� Go ��� ���α׷���", "ȥ�� �����ϴ� C ���"};
		
		while (true) {
			for(String tmp : �������) {
				System.out.println(tmp);
			}
			System.out.print("1. å ���� �˻� | 2. å ���� ���� | ���� >");
			byte[] bytes = new byte[100];
			int count = System.in.read(bytes);	// Ű����κ��� ����Ʈ�� �о	[ �Ϲݿ��� �߻� ] 
				// �о ����Ʈ ���� ����. ��??/ ���� -2(�ٹٲ�,����) �ؾ� �ϱ� ����.
			String ch = new String (bytes,0, count-2);	// 0�� �ε������� 
			
			if(ch.equals("1")) {
				System.out.println("�˻� �Ŵ�=============	");
				System.out.print("�˻��� å ���� : ");
				count = System.in.read(bytes);
				String search = new String(bytes, 0, count-2);	// �˻��� ����
				System.out.println(" *** �˻� ��� *** ");
				for( String temp : ������� ) { // ��� �迭�� ���ڿ��� �ϳ��� �������� 
					// ���1 
//					if( temp.indexOf(search) != -1 ) { // �ش� ���ڿ��� ã�������� �ε����� �����ϸ�
//						// indexOf �޼ҵ� -1 ��ȯ�Ǵ°��� ������ �ܾ ������� [ �˻�x]
//						System.out.println( temp ); // �ش� ���ڿ��� ã�����ڰ� �����ϸ� ��� 
//					}
					// ���2
					if( temp.contains(search) ) {	
						// ���ڿ�.contains("ã������") : ���ڿ��� ã�����ڰ� true[�ִ�] / false[����] ��ȯ
						System.out.println( temp );
					}
				}
				
			}else if( ch.equals("2") ) {
				System.out.println(" *** ���� *** ");
				System.out.print("������ ���� ���� �Ϻ� �Է� : ");
				count = System.in.read(bytes);
				String search = new String(bytes, 0, count-2);
				int i=0;
				for(String tmp : �������) {
					if(tmp.contains(search)) {
						// ���ڿ�.contains("ã������") : ���ڿ� �� ã�� ���ڰ� ������ true, ������ false ��ȯ
						System.out.println("������ȣ : "+i+", �������� : " +tmp);
					}
					i++;
				}
				// ���� ��ȣ [ �ε��� ] �Է¹޾� �����ϱ�
				System.out.print("������ȣ ���� : ");
				count = System.in.read(bytes);
				String ch2 = new String(bytes, 0, count-2);
				// ch2 ���ڿ��� �Է� ���� -> �ε��� [ ���� ] �� ��ȯ
				int index = Integer.parseInt(ch2);
				
				System.out.println("���� ���� : ");
				count = System.in.read(bytes);
				String oldStr = new String(bytes, 0, count-2);
				
				System.out.println("���ο� ���� : ");
				count = System.in.read(bytes);
				String newStr = new String(bytes, 0, count-2);
				
				// ���� ����
				�������[index]=�������[index].replace(oldStr, newStr);
				System.out.println("���� �Ϸ�");
				
				
			}
		}	// while END
	}	// main END
}	// class END
