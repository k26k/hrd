package classexam;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExample {

	public static void main(String[] args) throws ClassNotFoundException {
		
//		Class의 정보 가져오기 (필드, 생성자, 메서드)
		System.out.println("=== 클래스의 이름 가져오기 === ");
		
		Class<?> pClass1 = Class.forName("java.lang.String");
		System.out.println(pClass1.getName());
		System.out.println("");
		
		
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
