package Day19_220328;

import java.util.HashSet;

public class Day19_01 {
	public static void main(String[] args) {
		
		
		// P.737
		// 1. Hashset Ŭ������ ��ü ����
		HashSet<String> set = new HashSet<>();
								// ����(���׸�)�� ���ʿ� �־��൵ �ȳ־��൵ ������ �����ɷ� �־������.
		// HashSet<String> set = new HashSet<int>();	�̰Ŵ� �ȵȴٴ� ���
		// 1) HashSet : �÷��� �����ӿ�ũ Ŭ����
			// 2) <���׸�> : SetŬ���� �ȿ� ���� �ڷ���
				// 3) set : ��ü�� 
					// 4) new : ��ü ������ �޸� �Ҵ� ������
						// 5) HashSet<���׸�(��������)>() : ������
		// 2. set ��ü �� ��ü �ֱ� [ set��ü��.add(��ü��) ]
		set.add("java");	System.out.println("Ȯ�� : "+ set);
		set.add("test");	System.out.println("Ȯ�� : "+ set);
		set.add("�ڹپƾƾƾ�");	System.out.println("Ȯ�� : "+ set);
		
		// 3. set��ü�� ��ü ��
		System.out.println();
		
		
	}
}
