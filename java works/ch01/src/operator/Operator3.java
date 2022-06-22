package operator;

public class Operator3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		비교 연산자
		System.out.println(7 < 4);
		System.out.println(7 >= 4);
		System.out.println(7 == 4);
		System.out.println(7 != 4);
		
//		논리 연산자
		System.out.println((7 > 4)&&(7 == 4));
		System.out.println((7 > 4)||(7 == 4)); // 단락회로
		System.out.println(!(7 > 4));
		
//		단락 회로 예제
		int n = 10, i = 2;
		boolean x = ((n=n+10)<10)&&((i=i+2)<10);
		System.out.println(x); // false
		System.out.println(n); // 20
		System.out.println(i); // 2 
//		논리곱 연산의 경우 앞에서 거짓이 결정되면 뒤의 내용을 실행하지 않음
		
		n = 10;
		i = 2;
		boolean y = ((n=n+10) > 10)&&((i=i+2)<10);
		System.out.println(x); // false
		System.out.println(n); // 20
		System.out.println(i); // 4
//		앞의 수식이 참으로 판별 되어 논리곱 연산의 거짓이 결정되지 않아서 뒤의 i+2 연산이 실행됨 
	}

}
