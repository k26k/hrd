package operator;

public class Operator4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		복합 대입 연산자
		int num = 10;
		System.out.println(num += 1); // 11
		System.out.println(num); // 11
		System.out.println(num %= 10); // 1
		System.out.println(num); // 1
		num-=1;
		System.out.println(num); // 0
		
		boolean x = (5 > 3) ? true : false;
		System.out.println(x);
		
		int fatherAge = 45, motherAge =47;
		char ch;
		ch = (fatherAge > motherAge)? 'T':'F';
		System.out.println(ch);
	}

}
