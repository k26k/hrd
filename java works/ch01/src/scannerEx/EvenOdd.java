package scannerEx;

import java.util.Scanner;

public class EvenOdd {
	
	public static void main(String[] args) {
//		숫자를 입력받아 홀수/짝수를 판별하는 프로그램을 작성하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해 주세요 : ");
		int num = sc.nextInt();
		sc.close();
		String check = "";
		check = (num%2==0) ? "짝수" : "홀수";
		System.out.println(check);
		
		if(num%2==0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		
	}
}
