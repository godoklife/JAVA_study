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
		load();
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
	public static void view() {}
	// 4. 수정 메서드
	public static void update() {}
	// 5. 삭제 메서드
	public static void delete() {}
	// 6. 덧글쓰기 메서드
	public static void replywrite() {}
	// 7. 게시물저장 메서드
	public static void save() {	// 리스트 내 모든 게시물을 파일에 저장
		try {
			// 1. 파일 출력 클래스
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/Day11_BoardApp.txt",true);
			// 2. 파일에 작성할 내용 [ 한줄씩 ]
			for(Board board : boardlist) {	// 쉼표 : 필드 구분용 ---- 줄바꿈 : 객체 구분용
				String 작성내용 = board.getTitle() + "," + board.getContent() + "," + board.getPassword() + ","
						+ board.getWriter() + "," + board.getViewcount() + "," + board.getDate() + "\n";
			
			// 3. 내용 [ 문자열 ] -> 바이트열로 전환
			fileOutputStream.write(작성내용.getBytes());	
				
		}
		} catch(Exception e) {
			System.out.println("경고) 저장 실패, 관리자에게 문의하시오.");
		}
	}
	// 8. 게시물불러오기 메서드
	public static void load() {
		try {
			// 1. 파일 입력 클래스
			FileInputStream fileInputStream = new FileInputStream("D:/java/Day11_BoardApp.txt");
			// 2. 파일 읽어오기 [ 파일 -> 스트림 -> 자바 ]
				// 1. 바이트 배열 선언
			byte[] bytes = new byte[1024];	// 1KB짜리 배열 선언
				// 2. 파일을 읽어와서 바이트 배열에 저장
			fileInputStream.read(bytes);
				// 3. 내가 정해둔 기준(쉼표 : 필드 ---- 줄바꿈 : 객체)에 따라 분리
			String 파일내용 = new String(bytes); // 바이트 배열을 문자열로 변환
			String[] 글 = 파일내용.split("\n");		// \n단위로 잘라서 '글' String 배열에 저장. 인덱스는 자동으로 결정됨.
			
			
			// 저장형식 필드0 : 제목 | 필드1 : 내용 | 필드2 : 비번 | 필드3 : 작성자 | 필드4 : 조회수 | 필드5 : 작성날짜
			for(String tmp : 글) {
				String[] field = tmp.split(",");
				Board board = new Board(field[0], field[1], field[2], field[3]
						, Integer.parseInt(field[4]), field[5], null);
				Controller.boardlist.add(board);
			}
			
		} catch (Exception e) {
			System.out.println("경고) 불러오기 실패, 관리자에게 문의하시오.");
			System.out.println(e);
		}
		
	}
	// 9. 덧글저장 메서드
	public static void replysave() {}
	// 10. 덧글불러오기 메서드
	public static void replyload() {}
	
}
