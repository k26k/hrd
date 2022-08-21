package object;

import java.util.HashMap;

public class StudentTest {

	public static void main(String[] args) {
//		HashMap 객체 생성
//		Student 객체를 식별키로 Integer 값을 저장
		HashMap<Student, Integer> hashMap = new HashMap<>();
		
//		자료 삽입
		hashMap.put(new Student("1"), 95);
		
		int score = hashMap.get(new Student("1"));
		
		System.out.println(score);
				
		
		
	}
	
}
