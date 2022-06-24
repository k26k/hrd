package ifExemple;

import java.util.Scanner;

public class Seat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("입장객 수 입력 : ");
		int peopleNum = sc.nextInt();
		System.out.print("좌석 열의 수 입력 : ");
		int SeatColNum= sc.nextInt();
		
		int SeatRowNum = peopleNum/SeatColNum;
		if(SeatColNum*SeatRowNum != peopleNum) {
			SeatRowNum++;
		}
		System.out.println("좌석 줄은 "+SeatRowNum+"줄 필요");
		
	}

}
