package Day17_220324_�Ἦ2;

public class Day17_01 {
	public static void main(String[] args) {
		
		// ���׸� generic 
			// ���� : public class �̸� < ���׸��̸� >
			// ���� : �ܺηκ��� ������ �����͸� �ش� ���׸����θ� ����.
		
		// P.658
		
		// 1. ��ü ����
		Box<String> box1 = new Box<String>();
		// ������� ���׸��� ������ BoxŬ������ StringŸ�����θ� �ֱ�
		box1.set("�����");
		String string = box1.get();
		// String�����θ� �ִ´ٰ� �����Ҷ� ���������� �����ö� ��������ȯ�� �ʿ����!
		
		// 2. �Ǵٸ� ��ü ����
		Box<Integer> box2 = new Box<>();
			// �ڿ��� ���׸� ���� ����.
		box2.set(0);
		int value = box2.get();
		//----------------------------------------------------------------
		
		// P.659
		
		// 1. ��ü�� ������ �� ���׸�Ÿ�� �ֱ� [ Tv, String ]
		Product<Tv, String> product1 = new Product<>();
		// 2. ��ü �� �ʵ忡 ���� ���׸� Ÿ������ �� �ֱ�
		product1.setKind(new Tv());
		product1.setModel("����ƮTV");
		// 3. ȣ�� [ �� ��ȯ X ] 
		Tv tv = product1.getKind();
		String tvmodel = product1.getModel();
		System.out.println(tv);	// ���ߵ������ �޸𸮾�巹�� ���
		System.out.println(tvmodel);	// "����ƮTV" ���ڿ� ���
		
		// 1. �� ������ ��������. ��ü�� ������ �� ���׸�Ÿ�� �ֱ� [ Car, String ] 
		Product<Car, String> product2 = new Product<>();
		// 2. ���� �� �ʵ忡 �� ���׸� Ÿ������ �� ����.
		product2.setKind(new Car());
		product2.setModel("ī����");
		// 3. �� ȣ�� [ Ÿ��ĳ���� ���� ]
		Car car = product2.getKind();
		String carmodel = product2.getModel();
		System.out.println(carmodel);
		
		
// Ŭ���� ���� �� ����Ʈ�� ����, ������ ����ϴ°Ͱ� �ٸ����� �����ΰ� �����غ� ��.
		
	}
}
