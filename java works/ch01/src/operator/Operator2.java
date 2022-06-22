package operator;

public class Operator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		증가, 감소 연산자
		int num = 10;
		int val = 0;
		
		val = num++; // val = num, num = num += 1;
		System.out.println(val); // num++가 나중에 계산 돼서 반영 안됨
		System.out.println(num);
		
		num = 10;
		val = 0;
		val = ++num; // num = num += 1, val = num;
		System.out.println(val); // ++num가 먼저 계산 돼서 반영 됨
		System.out.println(num);
		
		num = 10;
		val = 0;
		val = num--; // val = num, num = num -= 1;
		System.out.println(val); // num--가 나중에 계산 돼서 반영 안됨
		System.out.println(num);
		
		num = 10;
		val = 0;
		val = --num; // num = num -= 1, val = num;
		System.out.println(val); // --num가 먼저 계산 돼서 반영 됨
		System.out.println(num);
		
//		산술연산자 - 총점과 평균
		int mathScore = 90, engScore = 75;
		double totalScore = 0.0;
		double evgScore = 0.0;
		
//		총점
		totalScore = mathScore + engScore;
		
//		평균
		evgScore = totalScore / 2;
		
//		출력
		System.out.println(totalScore);
		System.out.println(evgScore);
		
	}

}
