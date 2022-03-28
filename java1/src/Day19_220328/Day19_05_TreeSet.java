package Day19_220328;

import java.util.TreeSet;

import javax.swing.event.TreeSelectionEvent;

public class Day19_05_TreeSet {
	public static void main(String[] args) {
		
		// P.753
		
		// 1. TreeSet Ŭ������ ��ü ����
		TreeSet<Integer> score = new TreeSet<>();
			// 1. �ϳ��� ��ü = ���
			// 2. �� ���� �ִ� 2���� �ڽ� ��带 ���� �� �ִ�.
			// 3. �θ𺸴� ������ ���� �ڽ� / ũ�� ������ �ڽ����� ��ġ
			// 4. Ʈ�� �������� ���� ���ʿ� �ִ°� ���� ������. / �������� ���� ū ��.
			
		
		
		// 2. TreeSet ��ü�� ��ü(���) �߰�
			// * �ڵ����� �������� ��������(����->ū)
		System.out.println("-------TreeSet�� ���� �ڵ� �������� ����-------");
		score.add(87); System.out.println("Ȯ�� : "+ score);
		score.add(98); System.out.println("Ȯ�� : "+ score);
		score.add(75); System.out.println("Ȯ�� : "+ score);
		score.add(95); System.out.println("Ȯ�� : "+ score);
		score.add(80); System.out.println("Ȯ�� : "+ score);
		
		// 3. 
		System.out.println(score.first());	// ���� ���� ��ü�� ���
		System.out.println(score.last()); 	// ���� ���� ��ü�� ����
		System.out.println(score.lower(95));	// �־��� ��ü(95)���� �ٷ� �Ʒ� ��ü�� ����
		System.out.println(score.higher(95)); 	// �־��� ��ü(95)���� �ٷ� �� ��ü�� ����.
		System.out.println( score.floor(95) );  // 95���� �������� ���� ��� [ 95���� ���ų� ���� ] 
		System.out.println( score.ceiling(85) ); // 85���� �������� ������ ��� [ 85���� ���ų� ū ]
		
	}
}
