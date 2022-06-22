package operator;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		변수 교환 프로그램
		int x = 0;
		int y = 1;
		System.out.println("교환전");
		System.out.println("x = "+x+", y = "+y);
		System.out.println("----------------");
		
		int demo = x;
		x = y;
		y = demo;
		System.out.println("교환후");
		System.out.println("x = "+x+", y = "+y);
	}

}
