package Day18_220325_결석3;
import java.util.*;

public class Day18_03 {
	public static void main(String[] args) {
		// p.731 ~ 732 LinkedList 클래스 -> 노션에 정리했습니다.
		
		// 1. ArrayList 객체 선언 [ 제네릭 : String ]
		ArrayList<String> list1 = new ArrayList<>();
		// 2. LinkedList 객체 선언 [ 제네릭 : String ] 
		LinkedList<String> list2 = new LinkedList<>();
		// 2-1 형변환?? 걸리는 시간 확인해보자?? -> 별상관없는듯
		List<String> list3 = new LinkedList<>();
		
		
		// 3. 시간 변수
		Long starttime;
		Long endtime;
		// 4. ArrayList 객체에 10,000개 객체를 삽입하는데 걸리는 시간을 체그
		starttime = System.nanoTime();	// 현재 시간을 나노초로 리턴(시간차 재는 데 사용)
		for(int i = 0; i<10000; i++) {
			list1.add(0, i+""); // 정수열-> 문자열 변환 : 정수에다가 "" 더하기 / String.valueOf(정수)
								// 문자열-> 정수열 변환 : Integer.parseInt(문자열)
		}
		endtime = System.nanoTime();
		System.out.println("ArrayList가 10,000개 삽입하는데 걸린 시간(단위:ns) : "+(endtime - starttime));
		
		// 5. LinkedList 객체에 10,000 객체를 삽입하는데 걸린 시간 확인
		starttime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0, i+"");
		}
		endtime=System.nanoTime();
		System.out.println("LinkedList가 10,000개 삽입하는데 걸린 시간(단위:ns) : "+(endtime - starttime));
		
		starttime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list3.add(0, i+"");
		}
		endtime=System.nanoTime();
		System.out.println("List가 10,000개 삽입하는데 걸린 시간(단위:ns) : "+(endtime - starttime));
		
	}	// m e
}	// c e
