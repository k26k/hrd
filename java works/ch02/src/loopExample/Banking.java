package loopExample;

import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		은행 업무 프로그램
		
		Scanner sc = new Scanner(System.in);
		int balance = 0;
		int money = 0;
		boolean power = true;
		
		while(power) {
//			화면(ui) 제작
			System.out.println("==============================");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료 ");
			System.out.println("==============================");
			System.out.print("선택 > ");
			String mode = sc.next();
			switch(mode) {
				case "1":
					System.out.print("예금액 > ");
					money = sc.nextInt();
					balance += money;
					if(money < 0) {
						System.out.println("금액을 다시 입력해 주세요");
					}else {
						balance += money;
						System.out.printf("%d원 정상처리 되었습니다.\n", money);
					}
					break;
				case "2":
					System.out.print("출금액 > ");
					money = sc.nextInt();
					if(money < 0) {
						System.out.println("금액을 다시 입력해 주세요");
					}else if(balance < money) {
						System.out.println("잔고가 부족합니다.");
					}else {
						balance -= money;
						System.out.printf("%d원 정상처리 되었습니다.\n", money);
					}
					break;
				case "3":
					System.out.println("잔고 > "+ balance);
					break;
				case "4":
					power = false;
					break;
				default:
					System.out.println("다시 입력해 주세요.");
					break;
			}
			
		}
		System.out.println("프로그램을 종료 합니다.");
		sc.close();
	}

}
