package ex2;

public class ContinueKeyCodeReadExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int keyCode;
		
		while(true) {
			keyCode = System.in.read();
			System.out.println(keyCode);
			if(keyCode == 113) {
				break;
			}
		}
	}

}
