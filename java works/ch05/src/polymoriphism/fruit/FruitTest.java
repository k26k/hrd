package polymoriphism.fruit;

import java.util.Scanner;

public class FruitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" 1.포도 | 2.복숭아 | 3.바나나 ");
		System.out.print("선택 > ");
		int selectNum = Integer.parseInt(sc.nextLine());
		
		Fruits fruit = null;
		
		if(selectNum == 1) {
			fruit = new Grape(); // 부모 클래스로 객체 생성 - 자동 타입 변환
		}else if(selectNum == 2) {
			fruit = new Peach();
		}else if(selectNum == 3) {
			fruit = new Banana();
		}else {
			System.out.println("잘못 선택");
		}
		
		fruit.showInfo();
		
		sc.close();
		
	}

}
