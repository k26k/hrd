package virtualmethod;

public class TestA {

//	필드
	int num;

	void aaa() {
		System.out.println("aaa");
	}
	
	public static void main(String[] args) {
		TestA a1 = new TestA();
		a1.num = 10;
		a1.aaa();
		
		TestA a2 = new TestA();
		a2.num = 20;
		a2.aaa();
		
//		stack - a1, a2는 heap을 가리키는 번지
//		heap - a1의 num, a2의 num
//		data - aaa()
		
	}
	
}
