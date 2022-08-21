package scoreArray;

public class ScoreRanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		5명의 자바 과목 함수
		int[] score = {80,90,70,100,50};
		
//		총점
		int sumV = 0;
		for(int s:score) {
			sumV+=s;
		}
		System.out.println(sumV);
		
//		평균
		double avgV = 0.0;
//		평균 = 총점 / 개수
		avgV = sumV/(double)score.length;
		System.out.println(avgV);
		
//		최고점수
		int maxV = score[0];
		for(int s:score) {
			if(maxV<s) {
				maxV=s;
			}
		}
		System.out.println(maxV);
		
//		최저점수
		int minV = score[0];
		for(int s:score) {
			if(s<minV) {
				minV=s;
			}
		}
		System.out.println(minV);
		
	}

}
