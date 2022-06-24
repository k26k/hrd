package seats;

import java.util.Scanner;

public class Seats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("입장객 수 입력 : ");
		int peopleNum = sc.nextInt();
		System.out.print("좌석 열의 수 입력 : ");
		int SeatColNum= sc.nextInt();
		sc.close();
		
		int SeatRowNum = peopleNum/SeatColNum;
		if(SeatColNum*SeatRowNum != peopleNum) {
			SeatRowNum++;
		}
		for(int i=1; i<=SeatRowNum; i++) {
			System.out.print(" ");
			for(int j=1; j<=SeatColNum; j++) {
				if(peopleNum<i*j) {
					break;
				}else {
					if(i*j<10) {
						System.out.print("[  "+i*j+"] ");
					}else if(i*j<100){
						System.out.print("[ "+i*j+"] ");
					}else if(i*j<1000){
						System.out.print("["+i*j+"] ");
					}else {
						System.out.print("["+i*j+"] ");
					}
				}
			}
			System.out.println("");
		}
	}

}
