package arrayobject;

public class ArrayCreateByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores;
		scores = new int[] {83,90,87};
		int sum = 0;
		
		for(int i=0;i<scores.length;i++) {
			sum+=scores[i];
		}
		System.out.println(sum);
		
		int sum2 = add(new int[] {83,90,87});
		System.out.println(sum2);
	}
	
	public static int add(int[] scores) {
		int sum = 0;
		for(int s:scores) {
			sum+=s;
		}
		return sum;
	}

}
