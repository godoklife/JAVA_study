package Day10_Ű����ũ;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10_07_Ű����ũ {

	// ��� : ����
	// Ŭ���� : �Ե�����, ����ŷ
	// �������̽� : Ű����ũ(UI)
	// ����ó�� : ��ǰ ���
	
	public static void main(String[] args) {
		/*
		 * ���α׷� ���� �ϸ� �ƹ��͵� �ȶ�.
		 * 1 ������ [ ���� �����ڸŴ� ] ��ǰ��ϸŴ� ��
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		
		ArrayList<��ǰ> ��ǰ����Ʈ = new ArrayList<>();
		
		// ���� �Է� [ ���� -> �ڹ� ]
		
		
		try {	// try { } �ȿ� ������ �߻��Ұ� ���� �ڵ� �ֱ� (����)
		// 1. ���� �Է� ��ü
		FileInputStream fileInputStream = new FileInputStream("d:/java/�Ե��������.txt");
		// 2. ���� �о���� [ ���� -> ��Ʈ��(����Ʈ��) -> �ڹ� ]
			// 1. ����Ʈ �迭 ����
		byte[] bytes = new byte[1024];	// 1KB¥�� �迭 ����
		
			// 2. �о�ͼ� �迭�� ����
		fileInputStream.read(bytes);
		
			// 3. , : �ʵ� ���� | \n : ��ü(��ǰ)����    ->���� �Ե����� Ŭ���� (4. �������)���� �׷��� ���� �� ����.
		String ���ϳ��� = new String(bytes);	// �о���� ����Ʈ�� -> ���ڿ��� ����
				
		String[] ��ǰ��� = ���ϳ���.split("\n");	// ���� ���ڿ��� ��ǰ���� �����ص� �� �迭�� ����
			// String ���� �޼��� -> split("����");
		
		for(String tmp : ��ǰ���) {			// �迭�� ����� ��ǰ�� ��ǰ��, ���, ������ �и��ϴ� for��.
			String[] �ʵ��� = tmp.split(",");
			��ǰ ��ǰ = new ��ǰ(�ʵ���[0], Integer.parseInt(�ʵ���[1]), Integer.parseInt(�ʵ���[2]));	
							// ���ڿ� -> ������ ��ȯ [ Integer.parseInt(���ڿ�) ]
							// ��ǰ��, ���, ���� ���ε� ���� ������ int���̱� ������ String���� int������ ��ȯ���ذ�.
			��ǰ����Ʈ.add(��ǰ);
		}
		
		
		} catch (Exception e) { }	// catch : ���� ��� ->Exception Ŭ������ ��ü�� ����.
		
		Ű����ũ �Ե����� = new �Ե�����("���缮", ��ǰ����Ʈ);		// ������ ���缮�� �Ե����� ��ü ����
		
		while(true) {
			
			�Ե�����.��ǰ���();
			int ch = scanner.nextInt();
			if(ch==1) {
				�Ե�����.��ǰ�߰�();
			}
		}	// while END
	}	// main END
}	// class END
