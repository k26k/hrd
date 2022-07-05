package interfaceex.calculator;

public interface Calculator {
	
//	상수 필드 선언 가능, final을 생략해도 상수로 적용됨 
	int ERROR = -9999;
	
	int add(int n1, int n2);
	int subtract(int n1, int n2);
	int times(int n1, int n2);
	int divide(int n1, int n2);
}
