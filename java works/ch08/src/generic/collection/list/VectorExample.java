package generic.collection.list;

import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		
//		벡터 리스트 선언
		List<Board> list = new Vector<>();
		
//		요소 추가
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		
//		출력
		for(int i=0; i<list.size(); i++) {
			Board b = list.get(i);
			System.out.println(b.subject+" "+b.content+" "+b.write);
		}
		System.out.println("");
		
		for(Board b:list) {
			System.out.println(b.subject+" "+b.content+" "+b.write);
		}
		System.out.println("");
		
		
//		2번 인덱스 삭제
		list.remove(2);
//		3번 인덱스 삭제
		list.remove(3);
//		앞에 있던 인덱스가 사라지면서 기존에 생각한 값과 다른 값을 제거할수도 있음 주의
		
		for(Board b:list) {
			System.out.println(b.subject+" "+b.content+" "+b.write);
		}
		System.out.println("");
		
		
		
	}
	
}
