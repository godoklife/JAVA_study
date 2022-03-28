package Day19_220328;

import java.util.HashMap;

public class Day19_03 {
	public static void main(String[] args) {
		// P.740
		// 1. Map �÷��� = Json
			// * Ű(��ü), ��(��ü) = ��Ʈ�� ��� �θ�.
			// Ű : set �÷��� ���(�ߺ� �Ұ���)
			// �� : list �÷��� ���(�ߺ� ����)
			// HashMap Ŭ���� 
				// 1. map��ü��.put( key��ü, value��ü) : ��Ʈ�� (Ű=��) �߰�
				// 2. map��ü��.size() : ��Ʈ�� ���� ��ȯ
				// 3. map��ü��.get(key��ü) : �ش� Ű�� value ȣ��
				// 4. map��ü��.keySet() : map ��ü�� ��� Ű ȣ��
				// 5. map��ü��.values() : map ��ü �� ��� �� ȣ��
					// * key�� �˰� ������ ���� �� �� �ִ�.
					// for(���׸� �ӽð�ü�� : map) { ���๮ }
//		����)			for(String tmp : map.keySet()) {
//						System.out.println(tmp + " : " + map.get(tmp));
//							// HashMap��ü��.get(Key��) -> �ش� value ��ȯ
//					}
				// 6. map��ü��.remove(Ű����) : �ش� key���� key�� ����� value ����.
				// 7. map��ü��.clear() : �ش� map��ü ��� ��Ʈ�� �ʱ�ȭ.
		
			// * List �÷��� : ������(�ε���) ���� = �迭�� ����
			// * Set �÷��� : ���� ���� ���� : ���� �Ұ���
			// * Map �÷��� : Key(Set����)�� Value(List����)�� �̷���� ��Ʈ���� ������ ����
		
		// P.743 ����
		// 1. HashMap Class�� ��ü ����
		HashMap<String, Integer> map = new HashMap<>();
			// K = key, V = value
// HashMap : �÷��� �����ӿ�ũ map Ŭ����
	// < ���׸�, ���׸� > : K = key, V = value �� ����    <- �ٽ� Ű����
		// map : ��ü �̸�.
			// new : ��ü ������ �޸� �Ҵ� ������
				// HashMap<>() : ������
		
		// 2. map ��ü�� �߰�
		map.put("��ȣ��", 30);
		System.out.println("Ȯ�� : "+map);
			// ����Ʈ = ��½� ���ȣ [ ��ü, ��ü, ��ü ] 
			// ��Ʈ = ��½� ���ȣ [ ��ü, ��ü, ��ü ] 
			// �� = ��½� �߰�ȣ { Ű = �� }
		map.put("���缮", 40); System.out.println("Ȯ�� : "+map);
		map.put("�̸��", 50); System.out.println("Ȯ�� : "+map);
		map.put("���缮", 40); System.out.println("Ȯ�� : "+map);
		map.put("���缮", 40); System.out.println("Ȯ�� : "+map);
		map.put("���缮", 45); System.out.println("Ȯ�� : "+map);	// ���缮�� value�� �ٸ����� key�� �ߺ��� �ȵǱ⿡ ���� ���缮�� 45�� �������.
		
		// 3. map�� ������ ȣ��
		System.out.println("map ��ü �� ��Ʈ�� �� : "+ map.size());
		
		// 4. key ȣ���� ���� value�� ��ȯ
		System.out.println("map ��ü �� �� ȣ�� (key ȣ��� ->value ��ȯ) : "+map.get("���缮"));
		
		// 5. ��� key ȣ��
		System.out.println("map ��ü �� ��� key ȣ��  : "+map.keySet());	// ��Ʈ�� ���·� ��ȯ
		
		// 6. ��� value ȣ��
		System.out.println("map ��ü �� ��� value ȣ�� : "+map.values());	// ����Ʈ�� ���·� ��ȯ	
		
		// 7. �ݺ��� Ȱ�� [ key �ݺ��� �̿��ؼ� ��� value ȣ�� ���� ]
		for(String tmp : map.keySet()) {
			System.out.println(tmp + " : " + map.get(tmp));
				// HashMap��ü��.get(Key��) -> �ش� value ��ȯ
		}
		
		// 8. ����
		map.remove("�̸��");
		System.out.println("Ȯ�� : "+map);
		
		// 9. �� �� ����
		map.clear();
		System.out.println("Ȯ�� : "+map);
		
	}
}
