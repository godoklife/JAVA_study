package Day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day10_06 {
	public static void main(String[] args) throws IOException {
		
		// 1. 파일 출력 [ 자바 -> 파일 ]
		FileOutputStream 파일출력 = new FileOutputStream("D:/java/java1.txt");
		// FileOutputStream : 파일출력 클래스
		// FileOutputStream("d:/java/java1.txt"); : 파일경로\파일명.확장자  | txt : 메모장
		String test = "자바에서 입력한 내용입니다.";
		파일출력.write(test.getBytes());	// 예외
		
		// 2. 파일 입력 [ 파일 -> 자바 ]
		FileInputStream 파일입력 = new FileInputStream("D:/java/java1.txt");
		byte[] bytes = new byte[1000];
		파일입력.read(bytes);
		System.out.println("파일내용 : "+new String(bytes));
		
	}	// main END
}	// class END
