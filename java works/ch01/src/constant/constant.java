package constant;

public class constant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = 12;
		month = 6;
		System.out.println(month);
		
		final int month2 = 12; // final을 붙이면 상수처럼 취급됨
//		month2 = 6; 변수값 변경 불가
		System.out.println(month2);
		
//		원의 넓이 계산
		final double PI = 3.14159;
		double radious = 10;
		double area = radious * radious * PI;
		System.out.println(area);
	}

}
