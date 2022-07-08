package system;

public class ExitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			if(i==3) {
				System.out.println(i);
//				break;
				System.exit(0);
			}
		}
		System.out.println("반복 종료");
	}

}
