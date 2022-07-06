package nestedclass;

class Outter{

	int outNum = 100;
	int sOutNum = 200;
	
	Runnable getRunnable() {
		int num = 10;
		
		class MyRunnable implements Runnable{

			@Override
			public void run() {
				System.out.println(outNum+"외부 클래스의 인스턴스 변수");
				System.out.println(sOutNum+"외부 클래스의 정적 변수");
				System.out.println(num+"내부 클래스의 멤버 변수");
			}
			
		}
		
		Runnable myRun = new MyRunnable();
		return myRun;
	}	
	
}

public class LocalInnerTest {

	public static void main(String[] args) {

		Outter outter = new Outter();
		outter.getRunnable();
		
	}

}
