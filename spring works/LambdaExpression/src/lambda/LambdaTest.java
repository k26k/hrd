package lambda;

public class LambdaTest {

	public static void main(String[] args) {
		
		PrintString LambdaPrint = str -> System.out.println(str);
		LambdaPrint.showString("하이루");
		
		printString(LambdaPrint);
		
		LambdaPrint = null;
		LambdaPrint = getPrintString();
		LambdaPrint.showString("반갑다");
	}
	
	
	public static void printString(PrintString p) {
		p.showString("안녕하세요");
	}
	
	public static PrintString getPrintString() {
		System.out.println("getPrintString()");
		return str -> System.out.println(str);
	}
	
}
