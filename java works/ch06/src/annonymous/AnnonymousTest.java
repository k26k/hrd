package annonymous;

public class AnnonymousTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Annoymous annoy = new Annoymous();
		
		annoy.field.wake();
		
		annoy.method1();
		
		annoy.method2(new Person() {
			
			void study() {
				System.out.println("공부합니다");
			}
			
			@Override
			void wake() {
				System.out.println("8시에 일어납니다");
				study();
			}
			
		});
		
	}

}
