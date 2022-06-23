package loopExample;

import java.util.Scanner;

public class CoffeMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int price = 500;
		int coffeCount = 5;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("돈을 넣어주세요. : ");
			int money = sc.nextInt();
			if(money<price) {
				System.out.println("돈을 돌려주고 커피는 나오지 않습니다.");
				System.out.println("남은 커피의 양은 "+coffeCount+"개 입니다");
			}else if(money==price) {
				coffeCount--;
				System.out.println("커피가 나옵니다.");
				System.out.println("남은 커피의 양은 "+coffeCount+"개 입니다");
			}else {
				coffeCount--;
				System.out.println("거스름돈 "+(money-price)+"원을 돌려주고 커피가 나옵니다.");
				System.out.println("남은 커피의 양은 "+coffeCount+"개 입니다");
			}
			if(coffeCount<=0) {
				System.out.println("커피가 전부 팔렸습니다. 판매를 중지 합니다.");
				break;
			}
		}
		sc.close();
	}

}
