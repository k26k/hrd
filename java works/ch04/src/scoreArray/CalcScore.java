package scoreArray;

import java.util.Scanner;

public class CalcScore {

	public static void main(String[] args) {
		
		boolean run = true;
		int num = 0;
		int[] scores = new int[num];
		Scanner sc = new Scanner(System.in);
		
//		메인 시작
		while(run==true) {
			System.out.println("============================================================");
			System.out.println(" 1. 학생 수 입력 | 2. 점수 입력 | 3.점수 리스트 출력 | 4. 분석 | 5. 종료 ");
			System.out.println("============================================================");
			System.out.print("선택 > ");
			switch(Integer.parseInt(sc.nextLine())) {
				case 1:
					System.out.print("학생수 > ");
					num = Integer.parseInt(sc.nextLine());
					scores = new int[num];
					System.out.println("학생수 : "+num+"명 입력 완료");
					break;
				case 2:
					System.out.println("점수 입력 "+num+"회 실행");
					for(int i=0; i<num; i++) {
						System.out.print((i+1)+"번 점수 > ");
						scores[i] = Integer.parseInt(sc.nextLine());
					}
					System.out.println("점수 입력 "+num+"회 완료");
					break;
				case 3:
					System.out.println("점수 리스트 출력 실행");
					for(int s:scores) {
						System.out.print(s+" ");
					}
					System.out.println("");
					System.out.println("점수 리스트 출력 완료");
					break;
				case 4:
					System.out.println("분석 실행");
					int sumV=0, maxV=0;
					double avgV=0.0;
					for(int s:scores) {
						sumV+=s;
						if(maxV<s) {
							maxV=s;
						}
					}
					avgV=sumV/(double)scores.length;
					System.out.printf("최고점수 : %d, 평균점수 : %.2f\n", maxV, avgV);	
					System.out.println("분석 완료");
					break;
				case 5:
					System.out.println("종료 실행");
					run=false;
					break;
				default:
					System.out.println("다시 입력해 주세요");
					break;
			
			}
		}
		System.out.println("종료 완료");
//		메인 닫기
		sc.close();
		
	}
	
}
