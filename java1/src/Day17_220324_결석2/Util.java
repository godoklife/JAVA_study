package Day17_220324_�Ἦ2;

public class Util {
	
	// �޼��� 1
	public static<K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		// < �μ��� ���׸� > ��ȯŸ�� �޼���� (�μ� )
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p2.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	// �޼��� 2
	public static <T> Box<T> boxing(T t){
					// ��ȯŸ��	// ( �μ� )
		Box<T> box = new Box<T>();
		box.set(t);
		return box;	// ��ȯ��
		
	}
	
}
