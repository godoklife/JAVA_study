package Day17_220324_�Ἦ2;

// �� Ŭ���� �ٽ��ѹ� �о��
// ��ü������ ���� �ȵȴ�...;;
// 	public static <���׸�Ÿ��1> Box<���׸�Ÿ��1> boxing(���׸�Ÿ��1 kind){ }


public class Product <���׸�Ÿ��1, ���׸�Ÿ��2> {
				// < �ܺηκ��� ���� �ڷ��� �̸� : �������~ >
	// �ʵ�
	private ���׸�Ÿ��1 kind;	// Tv, Car
	private ���׸�Ÿ��2 model;	// Integer, String, Double
	
	public static <���׸�Ÿ��1> Box<���׸�Ÿ��1> boxing(���׸�Ÿ��1 kind){
// �޼��� �����
// ����������, ��������, ��ȯŸ��=���׸�Ÿ��1 Box1<���׸�Ÿ��1> boxing:�޼����̸�(���׸�Ÿ��)		
		Box<���׸�Ÿ��1> box = new Box<>();
		box.set(kind);
		return box;
	}
	
	
	// ���� ��, �� �ڵ�����
	public ���׸�Ÿ��1 getKind() {
		return kind;
	}

	public void setKind(���׸�Ÿ��1 kind) {
		this.kind = kind;
	}

	public ���׸�Ÿ��2 getModel() {
		return model;
	}

	public void setModel(���׸�Ÿ��2 model) {
		this.model = model;
	}
	
	// set �޼���
	
	
}
