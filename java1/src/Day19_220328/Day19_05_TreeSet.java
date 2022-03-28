package Day19_220328;

import java.util.TreeSet;

import javax.swing.event.TreeSelectionEvent;

public class Day19_05_TreeSet {
	public static void main(String[] args) {
		
		// P.753
		
		// 1. TreeSet 클래스의 객체 선언
		TreeSet<Integer> score = new TreeSet<>();
			// 1. 하나의 객체 = 노드
			// 2. 각 노드는 최대 2개의 자식 노드를 가질 수 있다.
			// 3. 부모보다 작으면 왼쪽 자식 / 크면 오른쪽 자식으로 배치
			// 4. 트리 구조에서 가장 왼쪽에 있는게 가장 작은값. / 오른쪽이 가장 큰 값.
			
		
		
		// 2. TreeSet 객체에 객체(요소) 추가
			// * 자동으로 오름차순 정렬해줌(작은->큰)
		System.out.println("-------TreeSet에 의한 자동 오름차순 정렬-------");
		score.add(87); System.out.println("확인 : "+ score);
		score.add(98); System.out.println("확인 : "+ score);
		score.add(75); System.out.println("확인 : "+ score);
		score.add(95); System.out.println("확인 : "+ score);
		score.add(80); System.out.println("확인 : "+ score);
		
		// 3. 
		System.out.println(score.first());	// 가장 낮은 객체를 출력
		System.out.println(score.last()); 	// 가장 높은 객체를 리턴
		System.out.println(score.lower(95));	// 주어진 객체(95)보다 바로 아래 객체를 리턴
		System.out.println(score.higher(95)); 	// 주어진 객체(95)보다 바로 위 객체를 리턴.
		System.out.println( score.floor(95) );  // 95포함 기준으로 왼쪽 노드 [ 95보다 같거나 작은 ] 
		System.out.println( score.ceiling(85) ); // 85포함 기준으로 오른쪽 노드 [ 85보다 같거나 큰 ]
		
	}
}
