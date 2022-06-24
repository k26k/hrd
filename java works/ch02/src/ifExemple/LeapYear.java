package ifExemple;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.print("윤년을 계산할 연도 입력 : ");
			int year = sc.nextInt();
			
			if(((year%4==0)&&(year%100!=0))||(year%400==0)) {
				System.out.println(year+"년은 윤년입니다.");
			}else {
				System.out.println(year+"년은 윤년이 아닙니다.");
			}
			if(year == 0) {
				break;
			}
		}
		sc.close();
	}

}
