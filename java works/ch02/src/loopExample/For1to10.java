package loopExample;

public class For1to10 {
	public static void main(String[] args) {
//		1부터 10까지 출력
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
//		1부터 10까지 합산
		int sumV=0;
		for(int i=1; i<=10; i++) {
			sumV+=i;
		}
		System.out.println(sumV);
	}
}
