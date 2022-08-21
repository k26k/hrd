package builtinclass;

public class lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lottoNums = new int[6];
		int maxNum = 45;
		for(int i=0; i<lottoNums.length; i++) {
			lottoNums[i] = (int)(Math.random()*maxNum+1);
			for(int j=0; j<i; j++) {
				if(lottoNums[i]==lottoNums[j]) {
					System.out.println("불량 : "+lottoNums[i]);
					i--;
				}
			}
		}
		
		for(int i=0; i<lottoNums.length; i++) {
			System.out.print(+lottoNums[i]+" ");
		}
	}

}
