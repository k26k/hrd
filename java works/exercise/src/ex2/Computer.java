package ex2;

public class Computer {
	
	int sum1(int[] values) {
		int sum = 0;
		for(int v:values) {
			sum+=v;
		}
		return sum;
	}
	
	int sum2(int ... values) {
		int sum = 0;
		for(int v:values) {
			sum+=v;
		}
		return sum;
	}
}
