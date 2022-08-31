package lambda;

public class MyFunctionalInterfaceTest {

	public static void main(String[] args) {
		
		MyFunctionalInterface fi;
		int num = 10;
		
		fi= (x) -> {
			x = x+10;
			System.out.println(x);
		};
		
		fi.method(num);
		

		fi= (x) -> {
			x = x*x;
			System.out.println(x);
		};
		
		fi.method(num);
		
		
	}
	
}
