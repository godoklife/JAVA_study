package Day18_220325_결석3;

import java.util.Vector;

public class Day18_02 {
	public static void main(String[] args) {
		
		// P. 730 -> 개인 노션에 별도 정리했습니다.
		
		// Vector class
		// 1. Vector 
		Vector<Board> list = new Vector<>();
		// 2. 리스트 객체 내 맴버 추가
			// 1. 멤버 추가하면서 메모리 바로 할당
			// 귀찮게 객체화 시켜서 넣지 않아도 됨. 그냥 바로 메모리 할당해주면 되네
		list.add(new Board("제목1", "내용1", "글쓴이1"));
			// 2. 객체 생성 후 리스트 내 객체 추가
		Board board = new Board("제목2", "내용2", "글쓴이2");
		list.add(board);
			// 이게 내가 항상 했던 귀찮은 방식
		
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		System.out.println("확인 : "+list);	// 메모리 어드레스 반환
		
		// 3. 검색 
		System.out.println("T?F?객체 검색 .contains(board) : "+list.contains(board));
		System.out.println("인덱스값 반환 - 객체 검색 위치 : "+list.indexOf(board));
		
		// 4. 삭제 [ 삭제된 인덱스 뒤로 한칸씩 땡기기 ] 
		list.remove(2);
		System.out.println("2번 인덱스 삭제 후 : "+ list);
		list.remove(2);
		System.out.println("2번 인덱스 삭제 후 : "+ list);
		
		// 5-1 반복문을 이용한 모든 객체의 출력
		System.out.println("=========================");
		for(int i=0; i<list.size(); i++) {
			Board tmp = list.get(i);
			System.out.printf("%s, %s, %s",tmp.제목, tmp.내용, tmp.작성자);
			System.out.println();
		}
		
		// 5-2 
		System.out.println("=========================");
		for(Board tmp : list) {
			System.out.printf("%s, %s, %s", tmp.제목, tmp.내용, tmp.작성자);
			System.out.println();
		}
		
	}	// m e
}	// c e
