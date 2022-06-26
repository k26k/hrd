package loopExample;

import java.util.Scanner;

public class ForFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("행 수 : ");
		int rowNum= sc.nextInt();
		System.out.print("열 수 : ");
		int colNum= sc.nextInt();
		for(int i=1; i<=rowNum; i++) {
			for(int j=1; j<=colNum; j++) {
				System.out.print(i*j);
			}
			System.out.println();
		}
	}

}
