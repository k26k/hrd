package string;

public class StringBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// StringBuilder - 내부에 변경 가능한 char[] 변수를 가지고 있음
		// 문자열이 변경가능해서 변경되어도 기존에 사용하던 메모리가 유지됨
		
		String javaStr = "java";
		
		StringBuilder buffer = new StringBuilder(javaStr);
		
		System.out.println(javaStr);
		System.out.println(System.identityHashCode(javaStr));
		System.out.println(buffer);
		System.out.println(System.identityHashCode(buffer));
		
		buffer.append("android");
		buffer.append("android");
		buffer.append("android");
		buffer.append("android");
		
		javaStr = buffer.toString();
		
		System.out.println(javaStr);
		System.out.println(System.identityHashCode(javaStr));
		System.out.println(buffer);
		System.out.println(System.identityHashCode(buffer));

		
	}

}
