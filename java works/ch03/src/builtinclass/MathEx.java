package builtinclass;

public class MathEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Math class 사용
		
//		Math.abs(변수) 절대값을 만들어줌
		int v1 = Math.abs(-10);
//		Math.abs는 스태틱 메소드라 객체생성 없이 사용 가능
		
		System.out.println(v1);
		
//		Math.round(변수) 소수점을 반올림 해줌 float은 int로 반환하고 double은 long으로 반환
//		int v2 = Math.round(5.6);
		long v2 = Math.round(5.6);
//		Math.round에 ctrl + 클릭 해서 들어가보면 double은 반환 자료형이 long인것을 확인 가능 따라서 변수를 long으로 써줘야함
		System.out.println(v2);
		
		
//		Math.floor(변수) 소수점을 버림
//		Math.floor에 ctrl + 클릭 해서 들어가보면 자료형이 double
		double v3 = Math.floor(5.9);
		System.out.println(v3);
		
		
//		Math.max(변수1, 변수2) 둘 중에서 큰 수를 반환해줌
		int max = Math.max(10, -20);
		System.out.println(max);
		
		
//		Math.random() 0보다 크고 1보다 작은 무작위값 반환
		double rand = Math.random();
		System.out.println(rand);
		
//		주사위 만들기
		double dice= (int)(Math.random()*6+1);
		System.out.println(dice);
		
	}

}
