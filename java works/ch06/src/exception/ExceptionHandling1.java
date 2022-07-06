package exception;

public class ExceptionHandling1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			int[] num = new int[2];
			
			num[0] = 1;
			num[1] = 2;
			num[2] = 3;
			
			System.out.println("배열 생성 성공");
			
		}catch(ArrayIndexOutOfBoundsException e){
			
			System.out.println("배열 범위 초과\n"+e);
	
		}
		
		System.out.println("Done");
		
	}

}
