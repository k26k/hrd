package lambda;

public class StringConcatTest {

	public static void main(String[] args) {
		
		StringConcat sc;
		
		sc = (s1, s2) -> System.out.println(s1+"+"+s2);
		sc.makeString("문장1", "문장2");
		
		
		sc = new StringConcatImpl();
		sc.makeString("문장1", "문장2");
		
	}
	
}
