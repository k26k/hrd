package constant;

import java.util.Scanner;

public class scannerEx {

	public static void main(String[] args) {
//		입력 작업
		Scanner scan = new Scanner(System.in);
		
//		문자열 입력
		System.out.print("당신의 이름은 무엇 입니까? ");
		String name = scan.nextLine(); //이름 입력
		
//		문자열 출력
		System.out.println("이름 : "+name);
		
//		숫자 입력 출력
		System.out.print("당신의 나이는 몇 살 입니까? ");
		int age = scan.nextInt();
		System.out.println("나이 : "+age);
		
//		입력 종료
		scan.close();

	}

}
