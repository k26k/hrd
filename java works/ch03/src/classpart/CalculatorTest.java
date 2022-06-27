package classpart;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		
		int add = cal.add(10,20);
		int sub = cal.sub(10,20);
		int mul = cal.mul(10,20);
		double div = cal.div(10,20);
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
	}

}
