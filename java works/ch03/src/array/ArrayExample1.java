package array;

import java.util.Iterator;

public class ArrayExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		배열의 선언과 사용
		
//		변수 사용시
		int std1KorScore = 0;
		int std2KorScore = 0;
		int std3KorScore = 0;

		int std1MathScore = 0;
		int std2MathScore = 0;
		int std3MathScore = 0;
		
//		배열 사용시
//		int[] korScore = new int[3];
//		korScore[0] = 70;
//		korScore[1] = 80;
//		korScore[2] = 90;
		
//		선언과 동시에 초기화
//		int[] korScore = new int[]{70,80,90};
		int[] korScore = {70,80,90};
//		같은 선언 방법
		 
//		배열의 갯수 출력
		System.out.println(korScore.length+"개");
		 
//		배열의 특정 요소 출력
		System.out.println(korScore[1]);
		 
//		배열의 수정
		System.out.println(korScore[2]);
		korScore[2] = 99;
		System.out.println(korScore[2]);
		 
//		배열의 메모리값
		System.out.println(korScore);
		 
//		배열의 전체 조회
		for(int i=0; i<korScore.length; i++) {
			System.out.println(korScore[i]);
		}
		for(int i=0; i<korScore.length; i++) {
			System.out.print(korScore[i]+", ");
		}
		System.out.println("");
	}

}
