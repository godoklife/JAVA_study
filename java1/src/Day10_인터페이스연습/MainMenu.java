package Day10_�������̽�����;

import java.util.Scanner;



public class MainMenu {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		MainMenu menu = new MainMenu();
		menu.Menu();	// ���� �̷��� ����� �ʿ�� ����. ��ĳ�� ����ƽ���� ��� �ϴ� �޸𸮳���
		
	}	// main END
	
	void Menu() {
		while(true) {	// ���ѹݺ�, �������� : ����
			System.out.println("=============����� ��ŷ ���α׷�=============");
			System.out.println("1. �츮���� | 2. �������� | 3. ��������");
			System.out.print("������ �����ϼ��� >");
			int ch = scanner.nextInt();
			
		}	// Menu while END
	}	// Menu END
	
}	// MainMenu class END
