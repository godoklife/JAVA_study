package Day07_220310;

import java.util.Scanner;

public class Day07_02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ���� �Է��غ��ÿ�.");
		// 1. ��ü ���� [ �� ������ = �⺻ ������ ]
		Car myCar = new Car();
		// 2. �޼��� ȣ�� [ �μ� 1�� ]
		myCar.setGas(scanner.nextInt());	// myCar.gas = 5; �̶� ����� ������ ĸ��ȭ�� ���� ������ ������ ����. ���������� ������ �ִ� ���� �ſ� ���.
		
		if(myCar.isLeftGas()) {
			System.out.println("����մϴ�.");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas�� ������ �ʿ䰡 �����ϴ�.");
		}
		else
			System.out.println("������ �����ϼ���.");
		
		
	}
}
