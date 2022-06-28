package builtinclass;

import java.util.Scanner;

public class EngWordsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"a", "s", "d", "f"};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("영어타자 게임 준비되면 엔터");
		sc.nextLine();
		
		long start = System.currentTimeMillis();
				
		for(int i=1; i<=10; i++) {
			System.out.println("문제 "+i);
			String text = words[(int)(Math.random()*words.length)];
			while(true) {
				System.out.println(text);
				String in = sc.nextLine();
				if(text.equals(in)) {
					System.out.println("정답");
					break;
				}else {
					System.out.println(in);
					System.out.println("오답");
				}
			}
			
		}
		
		long end = System.currentTimeMillis();
		System.out.printf("게임 끝.\n소요시간은 %.2f초 입니다.", ((end-start)/(double)1000));
		
		sc.close();
	}

}
