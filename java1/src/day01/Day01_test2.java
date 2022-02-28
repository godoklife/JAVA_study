package day01;

import java.util.Scanner;

public class Day01_test2 {	// c s

	public static void main(String[] args) {	// m s
		
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("방명록 입력을 받습니다");
		System.out.print("작성자 : ");
		String name = scan.next();
		
		System.out.println("내용을 입력해주세요");
		String data = scan.next();
		
		System.out.print("날짜 : ");
		String date = scan.next();
		
		scan.close();
		
		
		/*	간편하게 테스트 할때 주석 풀고 사용
		String name = "강호동";
		String data = "안녕하세요";
		String date = "09:21";
		*/
		
		
		System.out.println("* -----------방명록-----------");
		System.out.printf("%-6s%-5s%-10s%-8s\n", "* |순번|","작성자|","내용", "|날짜  |");
		System.out.printf("%-6s|%-3s|%-10s|%-5s|\n", "* |1", name, data, date);
		System.out.println("* --------------------------");
		
		
		System.out.printf("\n\n");
		System.out.println("* -----------방명록-----------");
		System.out.println("* |순번|작성자| 내용\t\t|날짜   |");
		System.out.println("* | 1 | " + name + "|" + data + "\t|"+ date + " |");
		System.out.println("* --------------------------");
		
		
	}	// m e
	
}	// c e
