package nestedclass;

class OutClass{
	
	int num = 10;
	static int sNum = 20;
	
	static class InClass{
		
		int inNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			
//			num = 1; // 외부 클래스의 인스턴스 변수에는 접근 불가
			sNum = 2;
			System.out.println(sNum + " 외부 클래스의 정적 변수");
			System.out.println(inNum + " 내부 클래스의 인스턴스 변수");
			System.out.println(sInNum + " 내부 클래스의 정적 변수");
			
		}
		
		static void sTest(){
			
//			num = 1; // 외부 클래스의 인스턴스 변수에는 접근 불가
			sNum = 2;
			System.out.println(sNum + " 외부 클래스의 정적 변수");
//			System.out.println(inNum + " 내부 클래스의 인스턴스 변수"); // 인스턴스 변수에 접근 불가
			System.out.println(sInNum + " 내부 클래스의 정적 변수");
			
		}
		
	}
	
}

public class StaticInnerClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	 	정적 내부 클래스는 외부클래스로 직접 접근하여 객체 생성
		OutClass.InClass inClass = new OutClass.InClass();
	
//	 	정적 내부 클래스의 인스턴스 메소드 사용
//		객체를 통해서 사용
		inClass.inTest();
		
//	 	정적 내부 클래스의 정적 메소드 사용
//		직접 접근하여 사용
		OutClass.InClass.sTest();
		
	}

}
