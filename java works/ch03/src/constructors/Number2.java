package constructors;

public class Number2 {

	int x;
	
	public Number2(int num) {
		x = num;
	}
	
	public static void main(String[] args) {
		Number2 myNum = new Number2(5);
		System.out.println(myNum.x);
	}
}
