package Day02;

public class Day02_2 {
	public static void main(String[] args) {
	byte var1 = -128;
	byte var2 = -30;
	byte var3 = 0;
	byte var4 = 30;
	byte var5 = 127;
	// byte var6 = 128;
	byte var7 = 'j';
	
	// ������ �������� ����� �� ����.
	// byte�� ������ +127 ~ -128 �̴�.
	// byte�� ������ �����ϴ� �ڷ����̱⿡ var7ó�� ������ ������ �ش��ϴ� �ƽ�Ű�ڵ尪�� ��.
	
	System.out.println(var1);
	System.out.println(var2);
	System.out.println(var3);
	System.out.println(var4);
	System.out.println(var5);
	//System.out.println(var6);
	System.out.println(var7);
	
	// p. 43 char : 2����Ʈ [ 1���� ] 
	// �����ڵ�(�ڹ�, 2����Ʈ) vs �ƽ�Ű�ڵ�(C, 1����Ʈ)
	
	char c1 = 'a';	System.out.println( c1 );
	char c2 = 97;	System.out.println( c2 );		// 10����
		// char�� ������ ���ڷ� ��ȯ.
	
	char c3 = '\u0041';	System.out.println( c3 );	// 16����
	char c4 = '��';		System.out.println( c4 );	// ���� ���� ����
	char c5 = 44032;	System.out.println( c5 );	// 10����
	char c6 = '\uac00';	System.out.println( c6 ); 	// 16����
	// ���� [ ����ϴ� ����?? : ��ǻ�Ͱ� 2������ ����ϸ� ǥ�������� ����, ǥ�������� �پ缺�� ����. ]
		// 2����	: 0 ~ 1
		// 8����	: 0 ~ 8
		// 10����	: 0 ~ 9
		// 16����	: 0 ~ 9, a, b, c, d, e, f
	
	// P. 44 short : 2����Ʈ ����, +32,767 ~ -32,768
	short num1 = 30000 ; System.out.println(num1);
	// short num2 = 40000 ; System.out.println(num2); // ���� �߻�
	
	// P.44 int : 4����Ʈ ����, [ ������ �⺻ Ÿ�� ]
	int num2 = 10;	System.out.println(num2);
	int num3 = 012;	System.out.println(num3);	// �� �տ� 0�� ���̸� 8����. �ֿܼ� ǥ���� 10������ �ȴ�.
	int num4 = 0x4;	System.out.println(num4);	// �� �տ� 0x�� ���̸� 16����. ���������� ǥ���� 16������ �ȴ�.
	
	// P. 46 long : 8����Ʈ ����, +- 20�� �̻�
	long num5 = 10;	System.out.println(num5);
	long num6 = 100000000000L;	System.out.println(num6);
	
	// P. 47 float : 4����Ʈ �Ǽ� [ ������ �ڿ� f ���̱� ] / double : 8����Ʈ [ �Ǽ��� �⺻ Ÿ�� ]
	double num7 = 3.14;	System.out.println(num7);
	float num8 = 3.14f;	System.out.println(num8);
	// double�� �Ҽ��� 17�ڸ�(���� ���� 18�ڸ�), float�� �Ҽ��� 8�ڸ�(���� ���� 9�ڸ�)
	
	// P. 48 boolean 1��Ʈ [ true, false ], �Ҷ��� �ſ� ���� ����. 
		
	boolean bol = true;	System.out.println(bol);
	
	// P. 49 Ÿ�Ժ�ȯ
		// ---->>>---->>>---->>> �ڵ� �� ��ȯ ---->>>---->>>---->>>
		// * ũ�� ���� : byte -> short -> int -> long -> float -> double
		// 1. �ڵ� ����ȯ 
			// ���� ������ ū �����δ� �̵��� �����ϳ� �� ���� �Ұ���.
	byte ����Ʈ = 10;
	int ��Ʈ = ����Ʈ;	// �ڵ� ����ȯ ����
	//short ��Ʈ = ��Ʈ;	// �ڵ� ����ȯ �Ұ���
	
	
		// 2. ���� ����ȯ (ĳ����)
			// ū ������ ���� ������ ������ �ս��� ������ ��ȯ.
			// (������ �ڷ���)������
	short ��Ʈ = (short)��Ʈ;
	
	
	// �ڷ��� ����� �ڷ��� ��ȯ
		// 1. byte + byte	= int 
		// 2. int + byte 	= int
		// 3. int + float	= int 
		// 4. int + double 	= int
	
	
	}
}
