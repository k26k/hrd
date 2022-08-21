package exception;

public class TryCatchFinaly {

	public static void main(String[] args) {
		
		try {
			
			if(args.length == 0) {
				System.out.println("입력 없음");
			}else {
				System.out.print("입력: ");
				for(String arg:args) {
					System.out.print(arg+" ");					
				}
				System.out.println("");
			}
			
			String data1 = args[0]; 
			String data2 = args[1];
			
			int val1 = Integer.parseInt(data1);
			int val2 = Integer.parseInt(data2);
			int result = val1 + val2;
			
			System.out.println(data1+" + "+data2+" = "+result);
			
		}catch(ArrayIndexOutOfBoundsException e){
			
			System.out.println("배열 범위 초과\n"+e);
	
		}catch(NumberFormatException e) {
			
			System.out.println("숫자로 변환할수 없음\n"+e);
			
		}
		
		System.out.println("Done");
		
	}
	
}
