package ex2;

import java.util.Scanner;

public class Test3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		1.
		byte b = 5;
//		b = -b; -연산을 실행할때 b를 int형으로 변환후 연산하게 됨 그래서 byte형으로 다시 변환해줘야 함
		b = (byte)-b;
		int result = 10/b;
		System.out.println(result);
		
//		2.
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(x); // 11
		System.out.println(y); // 19
		System.out.println(z); // 31
//		x 앞에 붙인 ++는 z 계산 전에 연산 하지만 y뒤의 --는 z 계산 후에 연산해서 차이가 생김
		
//		3.
		boolean stop = false;
		while(!stop) {
			stop = true;
			System.out.println("실행");
		}
		
//		4.
		int pancils = 534;
		int students = 30;
		
//		단위 학생당 단위 연필의 수
		int pencilsPerStudents = pancils/students;
		System.out.println(pencilsPerStudents); // 17
		
//		나머지 연필
		int pencilsLeft = pancils%students;
		System.out.println(pencilsLeft); //24
		
//		5.
		int var1 = 5;
		int var2 = 2;
		double var3 = var1/var2;
		System.out.println(var3); // 2.0
		int var4 = (int)(var3*var2);
		System.out.println(var4); // 4
//		var3 계산시 int로 계산후 double로 들어감 그래서 5/2인 2.5에서 소수점을 버린 2가 var3에 저장됨 해결방법은 둘 중 하나에 (double) 붙이기
		
//		6.
		int value = 356;
		System.out.println(value-value%100); // 300
		
//		7.
		float f1 = 10f;
		float f2 = f1/100;
		if(f2 == 0.1) {
			System.out.println("10%입니다.");
		}else{
			System.out.println("10%가 아닙니다.");
		}
//		double 0.1과 float 0.1이 같아보이지만 세부 비트를 보면 달라서 그럼 0.1f를 써줘야함
		
//		8.
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop+lengthBottom)*height*0.5;
		System.out.println(area); // 52.5
		
//		9.
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수 : ");
		double b1 = Double.parseDouble(sc.nextLine());
		System.out.print("두 번째 수 : ");
		double b2 = Double.parseDouble(sc.nextLine());
		System.out.println("--------------------");
		if(b2 == 0 || b2 == 0.0) {
			System.out.println("결과 : 무한대");
		}else {
			System.out.printf("결과 : %.2f", (b1/b2));	
		}
		sc.close();
		*/
		
//		10.
		int var10 = 10;
		int var11 = 3;
		int var12 = 14;
		double var13 = var10*var10*Double.parseDouble(var11+"."+var12);
		System.out.println("원의 넓이 : "+var13);
		
//		11.
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("패스워드 : ");
		String strPassword = sc.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(id.equals("java")) {
			if(password == 12345) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패 : 패스워드 오류");
			}
		}else {
			System.out.println("로그인 실패 : 아이디 오류");
		}
		sc.close();
		*/
		
//		12.
		int x1 = 10;
		int y1 = 5;
		System.out.println((x1>7)&&(y1<=5)); // true
		System.out.println((x1%3 == 2) || (y1%2 != 1)); // false
		
//		13.
		int value1 = 0;
		value1 = value1+10; // = value1 += 10;
		value1 = value1-10; // = value1 -= 10;
		value1 = value1*10; // = value1 *= 10;
		value1 = value1/10; // = value1 /= 10;			
		
//		14.
		int score = 85;
		String result1 = (!(score>90))?"가":"나";
		System.out.println(result1); // "가"
		
		
	}

}
