package lambda;

public class MyNumberTest {
	
	public static void main(String[] args) {
		
		MyNumber num;
		
		num = (x, y) -> {
			return (x >= y) ? x:y;
		};
		
		System.out.println(num.getMax(10,5));
		
		
		num = (x, y) -> (x >= y) ? x:y;
		
		System.out.println(num.getMax(10,5));
		
		
	}
	
}
