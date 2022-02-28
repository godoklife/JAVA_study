package day01;

import java.util.Scanner;

public class Day01_test1 {	// c s
	public static void main(String[] args) {	// m s

		Scanner scan = new Scanner(System.in);
		
		System.out.println("회원가입을 위한 정보를 입력받습니다.");
		System.out.print("아이디를 입력해주세요 : ");
		String id = scan.next();
		
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = scan.next();
		
		System.out.print("성함을 입력해주세요 : ");
		String name = scan.next();
		
		System.out.print("이메일 주소를 입력해주세요 : ");
		String email = scan.next();
		
		System.out.println("\n>>>>>>>>>>회원가입 완료  아래 내용을 확인해주세요.<<<<<<<<<<");
		System.out.println("아이디\t비밀번호\t성명\t이메일");
		System.out.println(id + "\t" + pw + "\t" + name + "\t" + email);
		System.out.println("===============================");

		scan.close();
		
	}	// m e

}	// c e
