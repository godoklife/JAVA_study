package Day18_220325_�Ἦ3;

import java.util.Vector;

public class Day18_02 {
	public static void main(String[] args) {
		
		// P. 730 -> ���� ��ǿ� ���� �����߽��ϴ�.
		
		// Vector class
		// 1. Vector 
		Vector<Board> list = new Vector<>();
		// 2. ����Ʈ ��ü �� �ɹ� �߰�
			// 1. ��� �߰��ϸ鼭 �޸� �ٷ� �Ҵ�
			// ������ ��üȭ ���Ѽ� ���� �ʾƵ� ��. �׳� �ٷ� �޸� �Ҵ����ָ� �ǳ�
		list.add(new Board("����1", "����1", "�۾���1"));
			// 2. ��ü ���� �� ����Ʈ �� ��ü �߰�
		Board board = new Board("����2", "����2", "�۾���2");
		list.add(board);
			// �̰� ���� �׻� �ߴ� ������ ���
		
		list.add(new Board("����3", "����3", "�۾���3"));
		list.add(new Board("����4", "����4", "�۾���4"));
		list.add(new Board("����5", "����5", "�۾���5"));
		System.out.println("Ȯ�� : "+list);	// �޸� ��巹�� ��ȯ
		
		// 3. �˻� 
		System.out.println("T?F?��ü �˻� .contains(board) : "+list.contains(board));
		System.out.println("�ε����� ��ȯ - ��ü �˻� ��ġ : "+list.indexOf(board));
		
		// 4. ���� [ ������ �ε��� �ڷ� ��ĭ�� ����� ] 
		list.remove(2);
		System.out.println("2�� �ε��� ���� �� : "+ list);
		list.remove(2);
		System.out.println("2�� �ε��� ���� �� : "+ list);
		
		// 5-1 �ݺ����� �̿��� ��� ��ü�� ���
		System.out.println("=========================");
		for(int i=0; i<list.size(); i++) {
			Board tmp = list.get(i);
			System.out.printf("%s, %s, %s",tmp.����, tmp.����, tmp.�ۼ���);
			System.out.println();
		}
		
		// 5-2 
		System.out.println("=========================");
		for(Board tmp : list) {
			System.out.printf("%s, %s, %s", tmp.����, tmp.����, tmp.�ۼ���);
			System.out.println();
		}
		
	}	// m e
}	// c e
