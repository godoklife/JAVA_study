package Day10_Ű����ũ;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class �Ե����� extends ����{	// ������ Ű����ũ�� �����ϹǷ� �ᱹ �Ե����Ƶ� Ű����ũ�� ����Ҽ� �ִ�.

	// 1. �ʵ�
	private String ����;
	private ArrayList<��ǰ> ��ǰ����Ʈ = new ArrayList<>();
	
	// 2. ������
	public �Ե�����() {
	}
	


	public �Ե�����(String ����, ArrayList<��ǰ> ��ǰ����Ʈ) {
		super();
		this.���� = ����;
		this.��ǰ����Ʈ = ��ǰ����Ʈ;
	}



	// 3. �޼���
	@Override
	public void ��ǰ���() {
		System.out.println("======= �Ե����� ��ǰ ��� =======");
		int i=1;
		for(��ǰ tmp : ��ǰ����Ʈ) {
			System.out.println(i+". \t"+tmp.get��ǰ��()+"\t"+tmp.get����());
			i++;
		}
	}
	
	public void ��ǰ�߰�() {
		// 1. �Է�
		Scanner scanner = new Scanner(System.in);
		System.out.println("*** �Ե����� ��ǰ �߰� ***");
		System.out.print("��ǰ�� : ");
		String ��ǰ�� = scanner.next();
		System.out.print("��� : ");
		int ��� = scanner.nextInt();
		System.out.print("���� : ");
		int ���� = scanner.nextInt();
		
		// 2. ��üȭ
		��ǰ ��ǰ�߰���޼��� = new ��ǰ(��ǰ��, ���, ����);
		
		// 3. ����Ʈ�� ����
		��ǰ����Ʈ.add(��ǰ�߰���޼���);
		
		// 4. ����ó��
		try {	// ������ �߻��Ұ� ���� �ڵ� ���� [ ���� ]
			FileOutputStream fileOutputStream = new FileOutputStream("d:/java/�Ե��������.txt", true);
			String �������� = ��ǰ��+","+���+","+����+"\n";	// �޸� : �ʵ� ���п� | \n : ��ǰ ����
			fileOutputStream.write(��������.getBytes());
		}catch(Exception e) {	// 
			
		}
		System.out.println("�˸�) ��ǰ ���� �Ϸ�");
		
	}
		
	
}
