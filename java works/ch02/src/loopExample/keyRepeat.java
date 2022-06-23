package loopExample;

import java.util.Scanner;

public class keyRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("계속 반복 할까요? [Y/N]  : ");
			String key = sc.nextLine();
			System.out.println(key+"를 입력 하셨습니다.");
			
			if(key.equals("y")||key.equals("Y")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(key.equals("n")||key.equals("N")) {
				System.out.println("프로그램을 반복합니다.");
			}else {
				System.out.println("다시 입력해 주세요.");
			}
		}
		System.out.println("프로그램이 종료됐습니다.");
		sc.close();
	}

}
