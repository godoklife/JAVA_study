package Day12_220317;

import java.io.IOException;

public class Day12_03 {
	public static void main(String[] args) throws Exception {
		String[] 도서목록 = {"된다! 네이버 블로그&포스트", "스프링 부트 실전 활용 마스터", 
			"Trucker의 Go 언어 프로그래밍", "혼자 공부하는 C 언어"};
		
		while (true) {
			for(String tmp : 도서목록) {
				System.out.println(tmp);
			}
			System.out.print("1. 책 제목 검색 | 2. 책 제목 수정 | 선택 >");
			byte[] bytes = new byte[100];
			int count = System.in.read(bytes);	// 키보드로부터 바이트를 읽어봄	[ 일반예외 발생 ] 
				// 읽어본 바이트 개수 저장. 왜??/ 개수 -2(줄바꿈,개행) 해야 하기 때문.
			String ch = new String (bytes,0, count-2);	// 0번 인덱스부터 
			
			if(ch.equals("1")) {
				System.out.println("검색 매뉴=============	");
				System.out.print("검색할 책 제목 : ");
				count = System.in.read(bytes);
				String search = new String(bytes, 0, count-2);	// 검색할 문자
				System.out.println(" *** 검색 결과 *** ");
				for( String temp : 도서목록 ) { // 모든 배열내 문자열을 하나씩 꺼내오기 
					// 방법1 
//					if( temp.indexOf(search) != -1 ) { // 해당 문자열내 찾을문자의 인덱스가 존재하면
//						// indexOf 메소드 -1 반환되는경우는 동일한 단어가 없을경우 [ 검색x]
//						System.out.println( temp ); // 해당 문자열내 찾을문자가 존재하면 출력 
//					}
					// 방법2
					if( temp.contains(search) ) {	
						// 문자열.contains("찾을문자") : 문자열내 찾을문자가 true[있다] / false[없다] 반환
						System.out.println( temp );
					}
				}
				
			}else if( ch.equals("2") ) {
				System.out.println(" *** 수정 *** ");
				System.out.print("수정할 도서 제목 일부 입력 : ");
				count = System.in.read(bytes);
				String search = new String(bytes, 0, count-2);
				int i=0;
				for(String tmp : 도서목록) {
					if(tmp.contains(search)) {
						// 문자열.contains("찾을문자") : 문자열 내 찾을 문자가 있으면 true, 없으면 false 반환
						System.out.println("도서번호 : "+i+", 도서제목 : " +tmp);
					}
					i++;
				}
				// 도서 번호 [ 인덱스 ] 입력받아 수정하기
				System.out.print("도서번호 선택 : ");
				count = System.in.read(bytes);
				String ch2 = new String(bytes, 0, count-2);
				// ch2 문자열로 입력 받음 -> 인덱스 [ 숫자 ] 로 변환
				int index = Integer.parseInt(ch2);
				
				System.out.println("기존 문자 : ");
				count = System.in.read(bytes);
				String oldStr = new String(bytes, 0, count-2);
				
				System.out.println("새로운 문자 : ");
				count = System.in.read(bytes);
				String newStr = new String(bytes, 0, count-2);
				
				// 수정 시작
				도서목록[index]=도서목록[index].replace(oldStr, newStr);
				System.out.println("변경 완료");
				
				
			}
		}	// while END
	}	// main END
}	// class END
