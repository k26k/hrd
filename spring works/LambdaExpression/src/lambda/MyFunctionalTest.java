package lambda;

public class MyFunctionalTest {

	public static void main(String[] args) {
		
		MyFunctionalEx fi;
		
		fi = () -> {System.out.println("hello lambda");};
		fi.method();
		
		fi = () -> System.out.println("hello lambda");
		fi.method();
		
	}
	
}
