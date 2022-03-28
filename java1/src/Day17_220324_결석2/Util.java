package Day17_220324_결석2;

public class Util {
	
	// 메서드 1
	public static<K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		// < 인수의 제네릭 > 반환타입 메서드명 (인수 )
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p2.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	// 메서드 2
	public static <T> Box<T> boxing(T t){
					// 반환타입	// ( 인수 )
		Box<T> box = new Box<T>();
		box.set(t);
		return box;	// 반환값
		
	}
	
}
