package generic.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		List<String> vegeList = new ArrayList<>();
		
//		리스트에 객체 추가
		vegeList.add("양파");
		vegeList.add("마늘");
		vegeList.add("감자");
		
		
//		특정 위치에 객체 삽입 ( 해당 위치 이상에 있던 객체는 한칸씩 밀려남 )
//		인덱스 값이 리스트의 크기보다 커서 중간에 빈 인덱스가 있는 경우 오류발생
		vegeList.add(2, "고추");
		
		
		System.out.print(vegeList);
		
		
//		리스트 크기 출력
		System.out.println(" "+vegeList.size()+"개");
		
		
//		특정 인덱스의 객체 가져오기
		System.out.println(vegeList.get(1));
		
		
//		객체 목록 출력
		for(int i=0; i<vegeList.size(); i++) {
			System.out.print(vegeList.get(i)+" ");
		}
		System.out.println("");
		
		for(String vege:vegeList) {
			System.out.print(vege+" ");
		}
		System.out.println("");
		
		
//		특정 인덱스의 객체 변경
		vegeList.set(3, "고구마");
		
		
//		특정 인덱스의 객체 삭제
		vegeList.remove(0);
		
		System.out.println(vegeList);
		
	}
	
}
