package interface_inherit;

public class MyClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		마이클래스 형태의 마이클래스 객체 생성
		MyClass myClass = new MyClass();
		
//		부모인터페이스 형태로 변환후 자동완성에서 뭐가 나오는지 확인
//		부모인터페이스 형태에서는 부모인터페이스의 메소드만 사용 가능
		X x = myClass;
		x.x();
		
		Y y = myClass;
		y.y();
		
//		마이인터페이스 형태로 변환후 상속 확인 
//		전부 사용 가능
		MyInterface iClass = myClass;
		iClass.x();
		iClass.y();
		iClass.myMethod();
		
	}

}
