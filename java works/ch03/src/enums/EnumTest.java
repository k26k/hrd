package enums;

enum Level{
	LOW,
	MEDIUM,
	HIGH
}

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level level= Level.MEDIUM; // 상수이므로 new를 사용하지 않음
		
		switch(level){
			case LOW:
				System.out.println("low");
				break;
			case MEDIUM:
				System.out.println("medium");
				break;
			case HIGH:
				System.out.println("high");
				break;
			default:
				System.out.println("none");
				break;
		}
	}

}
