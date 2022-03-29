package Day18_220325_�Ἦ3;

import java.util.ArrayList;

public class Day18_01 {
	
	// P.722 �÷��� �����ӿ�ũ
		// ���� ��� 18������ �����߽��ϴ�.
	public static void main(String[] args) {
		
		// 1. ����Ʈ Ŭ������ ��ü ���� [ ����Ʈ �ȿ� ������ �׸��� �ڷ��� -> ���׸� ] 
		ArrayList<String> list = new ArrayList<String>();
			// 1. ArrayList : ����Ʈ Ŭ����
				// 2. <���׸�> : ����Ʈ Ŭ���� ���ο� ���� �ڷ��� ����
					// 3. list : ����Ʈ ��ü �̸� -> �������
						// 4. new ArrayList<���׸�,��������>(����,��������,�⺻�� 10) 
		// 2. ����Ʈ ��ü��.add ( ��ü�� = ���׸�Ÿ�� ) : ����Ʈ ��ü �� ��� �߰�
		list.add("java"); // �ڵ����� �ε��� 0�� �����
		list.add("jdbc"); // �ε��� 1�� ����
		list.add("servlet/jsp");	// �ε��� : 2
		System.out.println("����Ʈ �� ��ҵ� Ȯ�� : "+ list);	
			// �����ϰ� �޸��ּҰ� ������ �ʰ� "[java, jdbc, servlet/jsp]" ��µ�.
		list.add(2, "Database");	// 2�� �ε����� ��� ����. ������ �ڵ����� 3���ε����� ����.
		System.out.println("����Ʈ �� ��ҵ� Ȯ�� : "+ list);	
			// ���� ����
		list.add("iBATIS");	// 4�� �ε����� �����.
		
		// 3. ����Ʈ��ü��.size() : ����Ʈ��ü �� ��ҵ��� ���� [ ����, =�ε���+1 ]
		System.out.println("list.size() : "+list.size());
		
		// 4. ����Ʈ��ü��.get(�ε���) : �ش� �ε����� ��� ȣ��
		System.out.println("list.get(2) : "+list.get(2));
		
		// 5-1. �ݺ��� Ȱ��
		for(int i=0; i<list.size(); i++) {	// 0���� �ش� ����Ʈ ��ü�� ����-1���� i�� 1�� �����ϸ� �ݺ�
			String tmp = list.get(i);	// i�� �ε����� ��Ҹ� tmp���ڿ��� ����
			System.out.println(i + " : " +tmp);	// ���
		}
		
		// 5-2. �ݺ��� Ȱ��
		int indexCount = 0;
		for(String tmp : list) {
			System.out.println(indexCount+" : "+tmp);
			indexCount++;
		}
		
		// 6. ����Ʈ��ü��.remove(�ε��� �Ǵ� ��ü)
		list.add("java");	// java�� 0��, 5�� �ε����� ��ġ��.
		System.out.println("���� �� ����Ʈ ��� : "+list);
		list.remove(2);
		System.out.println("2�� �ε��� ���� �� Ȯ�� : "+list);
		list.remove(2);
		System.out.println("2�� �ε��� �� ���� �� Ȯ�� : "+list);
		list.remove("java");
		System.out.println("java ��ü ���� �� Ȯ��"+list);	
		// �ߺ����� ���� ��� �տ��� �ϳ��� ����°� �� �� �ִ�.
		list.clear();
		System.out.println("����Ʈ �� �� ������ .clear() : "+list);
	}
}
