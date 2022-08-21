package generic.collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample1 {

	public static void main(String[] args) {
		
//		List 인터페이스 타입으로 LinkedList 객체 생성
		List<String> myList = new LinkedList<>();
		
//		자료 추가
		myList.add("A");
		myList.add("B");
		myList.add("C");
		
//		출력
		System.out.println(myList);
		
//		특정 인덱스에 요소 삽입
		myList.add(2, "D");
		System.out.println(myList);
		
//		삭제
		myList.remove(1);
		System.out.println(myList);
		
//		전체 출력
		for(int i=0; i<myList.size(); i++) {
			System.out.print(myList.get(i)+" ");
		}
		System.out.println("");
		
		for(String s:myList) {
			System.out.print(s+" ");
		}
		System.out.println("");
		
		
	}
	
}
