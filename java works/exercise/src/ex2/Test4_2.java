package ex2;

import java.util.Scanner;

public class Test4_2 {
	public static void main(String[] args) {
		
//		2.
		int sumV=0;
		for(int i=1; i<=100; i++) {
			if(i%3==0) {
				sumV+=i;
			}
		}
		System.out.println(sumV);
		System.out.println("");
		
//		3.
		while(true) {
			int num1 = (int)(Math.random()*6)+1;
			int num2 = (int)(Math.random()*6)+1;
			System.out.printf("(%d, %d)\n", num1, num2);
			
			if(num1+num2==5) {
				break;
			}
		}
		System.out.println("");
		
//		4.
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				if(i*4+j*5==60) {
					System.out.printf("(%d, %d)\n", i, j);
				}
			}
		}
		System.out.println("");
		
//		5.
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("");
		
//		6.
		for(int i=0; i<4; i++) {
			for(int j=3; 0<=j; j--) {
				if(j<=i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
		
//		7.
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int balance = 0;
		while(run) {
			System.out.println("----------------------------------");
			System.out.println(" 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료 ");
			System.out.println("----------------------------------");
			System.out.print("선택 > ");
			int mode = Integer.parseInt(sc.nextLine());
			switch(mode) {
				case 1:
					System.out.print("예금액 > ");
					balance+=Integer.parseInt(sc.nextLine());
					System.out.println("");
					break;
				case 2:
					System.out.print("출금액 > ");
					balance-=Integer.parseInt(sc.nextLine());
					System.out.println("");
					break;
				case 3:
					System.out.printf("잔고 > %d\n\n", balance);
					break;
				case 4:
					run = false;
					System.out.println("");
					break;
				default:
					System.out.println("재입력\n");
					break;
			}
		
		}
		System.out.println("프로그램 종료");
		
	}
}
