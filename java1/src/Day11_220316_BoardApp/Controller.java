package Day11_220316_BoardApp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;




public class Controller {
	// ��� �޼���� static���� ����.
	
	// 0. �Խù� ����Ʈ [ ��� �Խù��� ��� ����Ʈ ] 
	public static ArrayList<Board> boardlist = new ArrayList<>();
	// 1. ��� �޼���
	public static void boardlist() {
		// �Խù� ����� ���� �ҷ����� �޼��� ȣ��
	}
	
	// 2. ���� �޼���
	public static void write(String ����, String ����, String �ۼ���, String ��й�ȣ) {
		// 1. ��üȭ
		Board board = new Board(����, ����, ��й�ȣ, �ۼ���);
		// 2. ����Ʈ�� ����
		boardlist.add(board);
		// 3. ���Ͽ� ����
		save();
	}
	
	// 3. ���� �޼���
//	public static void view() {}	BoardApp���� ó����.
	// 4. ���� �޼���
	public static boolean update(int index, String title, String content, String password) {
		if(password.equals(boardlist.get(index).getPassword())){	// �ش� ���� ��� Ȯ��
			boardlist.get(index).setTitle(title);
			boardlist.get(index).setContent(content);
			save();
			return true;	// ���������� ���� �Ϸ�
		}
		else
			return false;	// ��� Ʋ����.
	}
	
	// 5. ���� �޼���
	public static boolean delete(int index, String password) {

		if (password.equals(boardlist.get(index).getPassword())) {
			// ���� �Խù��� �н������ ������
			boardlist.remove(index);
			save();	// �����Ѱ� ����.
			return true;	// ���� �����ϸ� true ��ȯ.
		}
		else {
			return false;	// ����� ��ġ���� �ʾ� �����ϸ� false ��ȯ
		}
	}
	// 6. ���۾��� �޼���
	public static void replywrite() {}
	// 7. �Խù����� �޼���
	public static void save() { 		// ����Ʈ�� ��� �Խù��� ���Ͽ� ����
		try {
			// 1. ������� Ŭ���� 
			FileOutputStream outputStream = new FileOutputStream("D:/java/Day11_BoardApp.txt");
			// 2. ���Ͽ� �ۼ��� ���� [ ����Ʈ�� ��ü 1���� = ���پ� = �Խù� 1���� = ��ü 1���� ]
			for( Board board : boardlist ) { // , : �ʵ屸�п�     \n : ��ü���п�
				String �ۼ����� = board.getTitle() +","+board.getContent()+","+
						board.getPassword()+","+board.getWriter()+","+
						board.getViewcount()+","+board.getDate()+"\n";
				// 3. ����[���ڿ�] -> ����Ʈ�� ��ȯ  [ �ܺ����(��Ʈ��) : ��Ŵ��� : ����Ʈ ]
				outputStream.write( �ۼ�����.getBytes() ); // 4. �������� [ write() ]
			}
		}catch( Exception e ) {  System.err.println(" �˸�]] �������� ����( �����ڿ��Թ��� )"); }
	}
	// 8. �Խù��ҷ����� �޼���
	public static void load() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/Day11_BoardApp.txt"); // 1. �����Է�Ŭ���� 
			byte[] bytes = new byte[1000]; // 2. ����Ʈ�迭 ����
			inputStream.read( bytes ); // 3. ��� ����Ʈ �о�ͼ� ����Ʈ�� ���� 
			String file = new String( bytes ); // 4. ����Ʈ -> ���ڿ� ��ȯ 
			String[] boards = file.split("\n"); // 5. ���ڿ� �ڸ��� [ ���پ� [ \n ] -> 1����ü ] 
			for( String temp : boards ) { // �迭�� ���ڿ� �ϳ��� ������ 
				String[] field = temp.split(","); // 6. ���ڿ� �ڸ��� [ ���� [,] -> ���ʵ� ] 
				Board board = new Board( field[0], field[1],
						field[2], field[3], Integer.parseInt(field[4]),field[5], null);  // 7. ��üȭ 
										// ��ȸ���� �ʵ�� �������̹Ƿ� ���������� ����ȯ [ Integer.parseInt( ���ڿ� ) ]
				boardlist.add(board);// 8. ����Ʈ ��� 
			}
		}catch( Exception e ) { }
	}
	// 9. �������� �޼���
	public static void replysave() {}
	// 10. ���ۺҷ����� �޼���
	public static void replyload() {}
	
}
