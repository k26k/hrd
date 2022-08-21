package scoreArray;

public class ScoreExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		5명의 자바 과목 함수
		int[] score = {80,90,70,100,50};
		int[] rank = new int[score.length];
		
		for(int i=0;i<score.length; i++) {
			int count = 1;
			for(int s:score) {
				if(score[i]<s) {
					count++;
				}
			}
			rank[i]=count;
			System.out.print(rank[i]+" ");
		}
		
	}

}
