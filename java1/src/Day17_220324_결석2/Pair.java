package Day17_220324_�Ἦ2;

public class Pair<K, V> {
			// K,V�� �ܼ� �̸���.
	// 1. �ʵ�
	private K key;
	private V value;
	// 2. ������
		// ���� �ڵ�����
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public Pair() {}
	// 3. �޼���
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
