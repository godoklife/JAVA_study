package Day19_220328;

import java.util.Hashtable;
import java.util.Scanner;

public class Day19_04 {
	public static void main(String[] args) {
		// P. 747 Hashtable
		
		// 1. Hashtable 클래스 객체 선언
		Hashtable<String , String> map = new Hashtable<>();
		
		// 2. map 객체에 엔트리 추가하기
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력하시오.");
			System.out.print("아이디 : ");
			String id = scanner.next();
			
			System.out.print("비밀번호 : ");
			String pw = scanner.next();
			System.out.println();
			
			if(map.containsKey(id)) {	// 입력한 id가 map.객체 내 key로 존재하면
				if(map.get(id).equals(pw)) {
					System.out.println("로그인 되었읍니다.**");
				}else {
					System.out.println("비밀번호를 확인하세요.");
				}
			}else {
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			}
		}	// w e
	}	// m e
}	// c e
