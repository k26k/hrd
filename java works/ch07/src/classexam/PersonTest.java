package classexam;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Person p1 = new Person();
		
		System.out.println("=== 클래스 이름 가져오기 ===");
		
		System.out.println("이미 생성한 객체의 클래스를 받아오기 / 클래스 이름을 모를때");
		Class<?> pClass1 = p1.getClass();
		System.out.println(pClass1.getName());
		
		System.out.println("클래스의 주소에서 클래스를 받아오기 / 클래스 이름을 알때");
		Class<?> pClass2 = Class.forName("classexam.Person");
		System.out.println(pClass2.getName());
		
		
		
		System.out.println("=== 생성자 정보 가져오기 === ");
		
		Constructor<?>[] cons = pClass1.getConstructors(); 
		for(Constructor<?> con:cons) {
			System.out.println(con);
		}
		System.out.println("");
		
		
		
		System.out.println("=== 멤버 변수(필드) 가져오기 === ");
		Field[] fields = pClass1.getDeclaredFields();
		for(Field field:fields) {
			System.out.println(field);
		}
		System.out.println("");
		
		
		
		System.out.println("=== 메서드 가져오기 === ");
		Method[] methods = pClass1.getMethods();
		for(Method method:methods) {
			System.out.println(method);
		}
		System.out.println("");
		
		
	}

}
