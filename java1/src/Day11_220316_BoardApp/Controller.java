package Day11_220316_BoardApp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;




public class Controller {
	// 모든 메서드는 static으로 선언.
	
	// 0. 게시물 리스트 [ 모든 게시물을 담는 리스트 ] 
	public static ArrayList<Board> boardlist = new ArrayList<>();
	// 1. 목록 메서드
	public static void boardlist() {
		// 게시물 저장된 파일 불러오기 메서드 호출
	}
	
	// 2. 쓰기 메서드
	public static void write(String 제목, String 내용, String 작성자, String 비밀번호) {
		// 1. 객체화
		Board board = new Board(제목, 내용, 비밀번호, 작성자);
		// 2. 리스트에 저장
		boardlist.add(board);
		// 3. 파일에 저장
		save();
	}
	
	// 3. 보기 메서드
//	public static void view() {}	BoardApp에서 처리함.
	// 4. 수정 메서드
	public static boolean update(int index, String title, String content, String password) {
		if(password.equals(boardlist.get(index).getPassword())){	// 해당 글의 비번 확인
			boardlist.get(index).setTitle(title);
			boardlist.get(index).setContent(content);
			save();
			return true;	// 정상적으로 수정 완료
		}
		else
			return false;	// 비번 틀렸음.
	}
	
	// 5. 삭제 메서드
	public static boolean delete(int index, String password) {

		if (password.equals(boardlist.get(index).getPassword())) {
			// 현재 게시물의 패스워드와 같으면
			boardlist.remove(index);
			save();	// 삭제한거 저장.
			return true;	// 삭제 성공하면 true 반환.
		}
		else {
			return false;	// 비번이 일치하지 않아 실패하면 false 반환
		}
	}
	// 6. 덧글쓰기 메서드
	public static void replywrite() {}
	// 7. 게시물저장 메서드
	public static void save() { 		// 리스트내 모든 게시물을 파일에 저장
		try {
			// 1. 파일출력 클래스 
			FileOutputStream outputStream = new FileOutputStream("D:/java/Day11_BoardApp.txt");
			// 2. 파일에 작성할 내용 [ 리스트내 객체 1개씩 = 한줄씩 = 게시물 1개씩 = 객체 1개씩 ]
			for( Board board : boardlist ) { // , : 필드구분용     \n : 객체구분용
				String 작성내용 = board.getTitle() +","+board.getContent()+","+
						board.getPassword()+","+board.getWriter()+","+
						board.getViewcount()+","+board.getDate()+"\n";
				// 3. 내용[문자열] -> 바이트열 변환  [ 외부통신(스트림) : 통신단위 : 바이트 ]
				outputStream.write( 작성내용.getBytes() ); // 4. 내보내기 [ write() ]
			}
		}catch( Exception e ) {  System.err.println(" 알림]] 파일저장 실패( 관리자에게문의 )"); }
	}
	// 8. 게시물불러오기 메서드
	public static void load() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/Day11_BoardApp.txt"); // 1. 파일입력클래스 
			byte[] bytes = new byte[1000]; // 2. 바이트배열 선언
			inputStream.read( bytes ); // 3. 모든 바이트 읽어와서 바이트에 저장 
			String file = new String( bytes ); // 4. 바이트 -> 문자열 변환 
			String[] boards = file.split("\n"); // 5. 문자열 자르기 [ 한줄씩 [ \n ] -> 1개객체 ] 
			for( String temp : boards ) { // 배열내 문자열 하나씩 꺼내기 
				String[] field = temp.split(","); // 6. 문자열 자르기 [ 한줄 [,] -> 각필드 ] 
				Board board = new Board( field[0], field[1],
						field[2], field[3], Integer.parseInt(field[4]),field[5], null);  // 7. 객체화 
										// 조회수는 필드는 정수형이므로 정수형으로 형변환 [ Integer.parseInt( 문자열 ) ]
				boardlist.add(board);// 8. 리스트 담기 
			}
		}catch( Exception e ) { }
	}
	// 9. 덧글저장 메서드
	public static void replysave() {}
	// 10. 덧글불러오기 메서드
	public static void replyload() {}
	
}
