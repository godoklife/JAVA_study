package Day17_220324_결석2;

public class Pair<K, V> {
			// K,V는 단순 이름임.
	// 1. 필드
	private K key;
	private V value;
	// 2. 생성자
		// 이하 자동생성
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public Pair() {}
	// 3. 메서드
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
