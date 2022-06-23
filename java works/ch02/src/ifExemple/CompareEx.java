package ifExemple;

import java.util.Scanner;

public class CompareEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int n1 = sc.nextInt();
		System.out.print("숫자 입력 : ");
		int n2 = sc.nextInt();
		sc.close();
		int max;
		 
//		조건 연산자 이용
		max = (n1<n2)?n2:n1;
		System.out.println("큰 수는 "+max);
		
//		if문 이용
		if(n1<n2) {
			max = n2;
		}else {
			max = n1;
		}
		System.out.println("큰 수는 "+max);
	}

}
