package exception;

class Arrayutil{
	public void call() throws Exception{
		System.out.println("call 메서드 시작");
		int[] num = new int[2];
		num[0] = 1;
		num[1] = 2;
		num[2] = 3;
		
		System.out.println("call 메서드 종료");
	}
}

public class ThrowsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrayutil arrayutil = new Arrayutil();
		
		try {
			arrayutil.call();
			System.out.println("안녕하세요");
		}catch (Exception e) {
			System.out.println("main method 예외처리");
		}
		System.out.println("감사합니다");
	}

}
