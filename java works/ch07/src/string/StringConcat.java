package string;

public class StringConcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// concat() 문자열 연결하기
		// String은 변경이 불가능하다 그래서 문자열이 변경될때마다 새로운 메모리에 저장해 메모리 낭비가 심함
		
		String javaStr = new String("java");
		String androidStr = new String("android");
		String buffer = javaStr.toString()+1;
		
		System.out.println(javaStr);
		System.out.println(System.identityHashCode(javaStr));
		System.out.println(buffer);
		System.out.println(System.identityHashCode(buffer));
		System.out.println(androidStr);
		System.out.println(System.identityHashCode(androidStr));

		javaStr = javaStr.concat(androidStr);
		
		System.out.println(javaStr);
		System.out.println(System.identityHashCode(javaStr));
		System.out.println(androidStr);
		System.out.println(System.identityHashCode(androidStr));
		
		javaStr = javaStr.concat(androidStr);
		
		System.out.println(javaStr);
		System.out.println(System.identityHashCode(javaStr));
		System.out.println(androidStr);
		System.out.println(System.identityHashCode(androidStr));
		
		javaStr = javaStr.concat(androidStr);
		
		System.out.println(javaStr);
		System.out.println(System.identityHashCode(javaStr));
		System.out.println(androidStr);
		System.out.println(System.identityHashCode(androidStr));
		
		
		
	}

}
