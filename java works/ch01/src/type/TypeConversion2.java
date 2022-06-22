package type;

public class TypeConversion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		사칙연산
		int x = 10, y = 20;
		
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y); // int자료형은 계산도 int형으로 해서 소수점 아래 자리가 전부 버려짐
		System.out.println((double)x/(double)y); // 실수형 double로 컨버전 하고 계산하면 소수점 표시
	}

}
