package test6_5.calc;

public class Calculator {

	static double pi = 3.14159;
	int num = 1;
	
	static int plus(int a, int b) {
//		num = 1 ; // static 함수는 인스턴트 변수 사용 불가능
		return  a+b;
	}
	
	static int minus(int a, int b) {
		return  a-b;
	}
	
}
