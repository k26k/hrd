package scannerEx;

import java.util.Scanner;

public class BonusPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		bonusPoint = price * bonusRatio
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("금액을 입력해 주세요 : ");
		int price = sc.nextInt();
		int bonusPoint = 0;
		double bonusRatio = 0.05;
		
		bonusPoint = (int)(price * bonusRatio);
		System.out.println(name+"님의 보너스 포인트는 "+bonusPoint+"포인트");
		sc.close();
	}

}
