package Day18_220325_�Ἦ3;
import java.util.*;

public class Day18_03 {
	public static void main(String[] args) {
		// p.731 ~ 732 LinkedList Ŭ���� -> ��ǿ� �����߽��ϴ�.
		
		// 1. ArrayList ��ü ���� [ ���׸� : String ]
		ArrayList<String> list1 = new ArrayList<>();
		// 2. LinkedList ��ü ���� [ ���׸� : String ] 
		LinkedList<String> list2 = new LinkedList<>();
		// 2-1 ����ȯ?? �ɸ��� �ð� Ȯ���غ���?? -> ��������µ�
		List<String> list3 = new LinkedList<>();
		
		
		// 3. �ð� ����
		Long starttime;
		Long endtime;
		// 4. ArrayList ��ü�� 10,000�� ��ü�� �����ϴµ� �ɸ��� �ð��� ü��
		starttime = System.nanoTime();	// ���� �ð��� �����ʷ� ����(�ð��� ��� �� ���)
		for(int i = 0; i<10000; i++) {
			list1.add(0, i+""); // ������-> ���ڿ� ��ȯ : �������ٰ� "" ���ϱ� / String.valueOf(����)
								// ���ڿ�-> ������ ��ȯ : Integer.parseInt(���ڿ�)
		}
		endtime = System.nanoTime();
		System.out.println("ArrayList�� 10,000�� �����ϴµ� �ɸ� �ð�(����:ns) : "+(endtime - starttime));
		
		// 5. LinkedList ��ü�� 10,000 ��ü�� �����ϴµ� �ɸ� �ð� Ȯ��
		starttime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0, i+"");
		}
		endtime=System.nanoTime();
		System.out.println("LinkedList�� 10,000�� �����ϴµ� �ɸ� �ð�(����:ns) : "+(endtime - starttime));
		
		starttime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list3.add(0, i+"");
		}
		endtime=System.nanoTime();
		System.out.println("List�� 10,000�� �����ϴµ� �ɸ� �ð�(����:ns) : "+(endtime - starttime));
		
	}	// m e
}	// c e
