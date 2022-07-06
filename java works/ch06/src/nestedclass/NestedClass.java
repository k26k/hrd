package nestedclass;

class A{
	
	A(){
		System.out.println("A객체가 생성됨");
	}
	
//	필드 - 멤버 클래스 
	
//	인스턴트 멤버 클래스 static 사용 불가
	class B{
		int field1;
//		static int field2;
		B(){System.out.println("B객체가 생성됨");}
		void method1() {}
//		static void method2() {}
	}
	
//	정적 멤버 클래스
	static class C{		
		int field1;
		static int field2;
		C(){System.out.println("C객체가 생성됨");}
		void method1() {}
		static void method2() {}
	}
	
//	로컬 클래스 
	void method() {
		class D{ // static 사용 불가
			int field1;
//			static int field2;
			D(){System.out.println("D객체가 생성됨");}
			void method1() {}
//			static void method2() {}
		}	
		
		D d = new D(); 
		d.field1 = 1;
		d.method1();
	}

	
}

public class NestedClass {

	public static void main(String[] args) {

//		기존 클래스 객체 생성 방법
		A a = new A();
		
//		인스턴스 멤버 클래스 객체 생성 방법
		A.B b = a.new B();
		b.field1 = 1;
	
//		정적 멤버 클래스 객체 생성 방법
		A.C c = new A.C(); // 정적 멤버 클래스 생성 
		c.method1(); // 정적 멤버 클래스의 메소드 사용 
		A.C.method2(); //  정적 멤버 클래스의 정적 메소드 사용 
		
//		로컬 클래스 객체 생성 방법
		a.method(); // 메소드를 실행하면서 선언되고 생성됨
		
	}

}
