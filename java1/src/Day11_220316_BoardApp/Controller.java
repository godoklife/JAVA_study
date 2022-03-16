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
		load();
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
	public static void view() {}
	// 4. ���� �޼���
	public static void update() {}
	// 5. ���� �޼���
	public static void delete() {}
	// 6. ���۾��� �޼���
	public static void replywrite() {}
	// 7. �Խù����� �޼���
	public static void save() {	// ����Ʈ �� ��� �Խù��� ���Ͽ� ����
		try {
			// 1. ���� ��� Ŭ����
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/Day11_BoardApp.txt",true);
			// 2. ���Ͽ� �ۼ��� ���� [ ���پ� ]
			for(Board board : boardlist) {	// ��ǥ : �ʵ� ���п� ---- �ٹٲ� : ��ü ���п�
				String �ۼ����� = board.getTitle() + "," + board.getContent() + "," + board.getPassword() + ","
						+ board.getWriter() + "," + board.getViewcount() + "," + board.getDate() + "\n";
			
			// 3. ���� [ ���ڿ� ] -> ����Ʈ���� ��ȯ
			fileOutputStream.write(�ۼ�����.getBytes());	
				
		}
		} catch(Exception e) {
			System.out.println("���) ���� ����, �����ڿ��� �����Ͻÿ�.");
		}
	}
	// 8. �Խù��ҷ����� �޼���
	public static void load() {
		try {
			// 1. ���� �Է� Ŭ����
			FileInputStream fileInputStream = new FileInputStream("D:/java/Day11_BoardApp.txt");
			// 2. ���� �о���� [ ���� -> ��Ʈ�� -> �ڹ� ]
				// 1. ����Ʈ �迭 ����
			byte[] bytes = new byte[1024];	// 1KB¥�� �迭 ����
				// 2. ������ �о�ͼ� ����Ʈ �迭�� ����
			fileInputStream.read(bytes);
				// 3. ���� ���ص� ����(��ǥ : �ʵ� ---- �ٹٲ� : ��ü)�� ���� �и�
			String ���ϳ��� = new String(bytes); // ����Ʈ �迭�� ���ڿ��� ��ȯ
			String[] �� = ���ϳ���.split("\n");		// \n������ �߶� '��' String �迭�� ����. �ε����� �ڵ����� ������.
			
			
			// �������� �ʵ�0 : ���� | �ʵ�1 : ���� | �ʵ�2 : ��� | �ʵ�3 : �ۼ��� | �ʵ�4 : ��ȸ�� | �ʵ�5 : �ۼ���¥
			for(String tmp : ��) {
				String[] field = tmp.split(",");
				Board board = new Board(field[0], field[1], field[2], field[3]
						, Integer.parseInt(field[4]), field[5], null);
				Controller.boardlist.add(board);
			}
			
		} catch (Exception e) {
			System.out.println("���) �ҷ����� ����, �����ڿ��� �����Ͻÿ�.");
			System.out.println(e);
		}
		
	}
	// 9. �������� �޼���
	public static void replysave() {}
	// 10. ���ۺҷ����� �޼���
	public static void replyload() {}
	
}
