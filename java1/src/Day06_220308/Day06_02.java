package Day06_220308;

public class Day06_02 {	// c s
	public static void main(String[] args) {	// m s
		Car myCar = new Car();	// ��ü ����
			// 1. Car : ���ǵ� Ŭ������
			// 2. MyCar : ��ü �̸� [ �ƹ��ų�, �����ϸ� Ŭ������ �ҹ��� ���� ]
			// 3. new : �޸� �Ҵ� ������
			// 4. Car() : ������
		
		// 2. ��ü �� �ʵ� ȣ��		[ .(��ħǥ) : ���ٿ����� ]
		System.out.println("���� ȸ�� : " +myCar.company);
			// myCar ��ü �� �ʵ� ����
			// ��ü��.�����
		System.out.println("�𵨸� : "+myCar.model);
			// myCar�� model �ʵ� ȣ��
		System.out.println("���� : "+myCar.color);
			// myCar.color : color �ʵ� ȣ��
		System.out.println("�ְ�ӵ� : "+myCar.maxSpeed);
			// myCar.maxspeed : maxspeed �ʵ� ȣ��
		System.out.println("����ӵ� : "+myCar.speed);
			// myCar.speed : speed �ʵ� ȣ��

		// 3. ��ü �� �ʵ� �� ����
		myCar.speed = 60;
			// myCar ��ü �� speed �ʵ带 ȣ���ؼ� 60�̶�� ������ ����.
		System.out.println("������ �ӵ� : "+myCar.speed);
		
		// ���ο� �ڵ��� ��ü�� �����غ��ÿ�
		Car yourcar = new Car();
		System.out.println(yourcar.speed);
		
		// * ���� Car��� Ŭ������ ��������� myCar�� yourcar�� speed�ʵ带 �������� �ʴ´�!!!
		
		
	}	// m e
}	// c e
