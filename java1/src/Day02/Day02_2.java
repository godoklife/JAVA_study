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
	
	// 동일한 변수명은 사용할 수 없다.
	// byte의 범위는 +127 ~ -128 이다.
	// byte는 정수를 저장하는 자료형이기에 var7처럼 영문을 넣으면 해당하는 아스키코드값이 들어감.
	
	System.out.println(var1);
	System.out.println(var2);
	System.out.println(var3);
	System.out.println(var4);
	System.out.println(var5);
	//System.out.println(var6);
	System.out.println(var7);
	
	// p. 43 char : 2바이트 [ 1문자 ] 
	// 유니코드(자바, 2바이트) vs 아스키코드(C, 1바이트)
	
	char c1 = 'a';	System.out.println( c1 );
	char c2 = 97;	System.out.println( c2 );		// 10진수
		// char는 정수를 문자로 변환.
	
	char c3 = '\u0041';	System.out.println( c3 );	// 16진수
	char c4 = '가';		System.out.println( c4 );	// 문자 직접 저장
	char c5 = 44032;	System.out.println( c5 );	// 10진수
	char c6 = '\uac00';	System.out.println( c6 ); 	// 16진수
	// 진법 [ 사용하는 이유?? : 컴퓨터가 2진수만 사용하면 표현단위가 적음, 표현단위의 다양성을 위해. ]
		// 2진수	: 0 ~ 1
		// 8진수	: 0 ~ 8
		// 10진수	: 0 ~ 9
		// 16진수	: 0 ~ 9, a, b, c, d, e, f
	
	// P. 44 short : 2바이트 정수, +32,767 ~ -32,768
	short num1 = 30000 ; System.out.println(num1);
	// short num2 = 40000 ; System.out.println(num2); // 오류 발생
	
	// P.44 int : 4바이트 정수, [ 정수의 기본 타입 ]
	int num2 = 10;	System.out.println(num2);
	int num3 = 012;	System.out.println(num3);	// 맨 앞에 0을 붙이면 8진수. 콘솔에 표현은 10진수로 된다.
	int num4 = 0x4;	System.out.println(num4);	// 맨 앞에 0x를 붙이면 16진수. 마찬가지로 표현은 16진수로 된다.
	
	// P. 46 long : 8바이트 정수, +- 20억 이상
	long num5 = 10;	System.out.println(num5);
	long num6 = 100000000000L;	System.out.println(num6);
	
	// P. 47 float : 4바이트 실수 [ 데이터 뒤에 f 붙이기 ] / double : 8바이트 [ 실수형 기본 타입 ]
	double num7 = 3.14;	System.out.println(num7);
	float num8 = 3.14f;	System.out.println(num8);
	// double은 소수점 17자리(정수 포함 18자리), float은 소수점 8자리(정수 포함 9자리)
	
	// P. 48 boolean 1비트 [ true, false ], 불란은 매우 자주 쓴다. 
		
	boolean bol = true;	System.out.println(bol);
	
	// P. 49 타입변환
		// ---->>>---->>>---->>> 자동 형 변환 ---->>>---->>>---->>>
		// * 크기 순서 : byte -> short -> int -> long -> float -> double
		// 1. 자동 형변환 
			// 작은 형에서 큰 형으로는 이동이 가능하나 그 역은 불가능.
	byte 바이트 = 10;
	int 인트 = 바이트;	// 자동 형변환 가능
	//short 쇼트 = 인트;	// 자동 형변환 불가능
	
	
		// 2. 강제 형변환 (캐스팅)
			// 큰 형에서 작은 형으로 데이터 손실을 동반한 변환.
			// (변경할 자료형)변수명
	short 쇼트 = (short)인트;
	
	
	// 자료형 연산시 자료형 변환
		// 1. byte + byte	= int 
		// 2. int + byte 	= int
		// 3. int + float	= int 
		// 4. int + double 	= int
	
	
	}
}
