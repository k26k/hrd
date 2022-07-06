package exception;

public class ThrowsException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			findClass();
		}catch(ClassNotFoundException e){
			System.out.println("클래스를 찾지 못함\n"+e);
		}
	}
	
	static void findClass() throws ClassNotFoundException{
		Class cls = Class.forName("java.lang.String2");
	}
	
}
