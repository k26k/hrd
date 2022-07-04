package typeconversion;

import java.util.ArrayList;

class A {}

class B extends A {}
class C extends A {}

class D extends B {}
class E extends C {}

public class PromotionExample {
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
//		B b2 = e; // 상속관계가 아니라 안됨
//		C c2 = d;
		
		ArrayList<A> al = new ArrayList<>();
		al.add(b);
		al.add(c);
		al.add(d);
		al.add(e);
		
		for(A a:al) {
			System.out.print("");
			if(a instanceof B) {
				
			}
		}
		
		
	}

}
