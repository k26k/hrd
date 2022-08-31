package streamtex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
//		List<String> companyList = new ArrayList<>();
//		
//		companyList.add("LG");
//		companyList.add("SAMSUNG");
//		companyList.add("HYUNDAI");
		
		
//		배열 생성 클래스 Arrays
		List<String> companyList = Arrays.asList("LG", "SAMSUNG", "HYUNDAI");
		
//		배열 출력
		for(String company:companyList) {
			System.out.println(company);
		}
		
//		stream 클래스 - 람다식으로 구현
		Stream<String> stream = companyList.stream();
		stream.forEach( company -> System.out.println(company) );
	}
	
}
