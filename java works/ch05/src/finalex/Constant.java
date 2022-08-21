package finalex;

public class Constant {
	
	int num = 10;
	final int NUM = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constant cons = new Constant();
		
		cons.num = 200;
//		cons.NUM = 200; // final 붙은 변수는 변경이 불가능한 상수로 취급되어 대입 불가능
		
		System.out.println(cons.num);
		System.out.println(cons.NUM);
		
	}

}
