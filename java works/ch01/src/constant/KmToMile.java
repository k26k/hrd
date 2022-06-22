package constant;

import java.util.Scanner;

public class KmToMile {

	public static void main(String[] args) {
//		상수 선언
		final double MPK = 1.609344;
		
//		변수 선언
		double kph = 140.5;
		double mph = 0.0;
		
//		스캔
		Scanner scan = new Scanner(System.in);
		System.out.print("공의 구속[k/h]을 입력해 주세요. \n 구속 : ");
		kph = scan.nextDouble();
//		스캔 종료
		scan.close();
		
//		연산
		mph = kph / MPK;
		
//		System.out.println(mph);
//		printf("문자열 포맷", 객체(변수))
//		서식 문자 (정수 - %d, 실수 - %f)
//		%.2f = 소수점 2자리 까지만
		System.out.printf("공의 속도는 %.2f[m/h]입니다.", mph);

	}

}
