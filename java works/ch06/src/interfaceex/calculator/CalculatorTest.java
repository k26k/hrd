package interfaceex.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalculator calc = new MyCalculator();
		int num1 = 10;
		int num2 = 2;
		
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.subtract(num1, num2));
		System.out.println(calc.times(num1, num2));
		System.out.println(calc.divide(num1, num2));
		
		
	}

}
