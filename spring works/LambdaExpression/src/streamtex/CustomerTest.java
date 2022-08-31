package streamtex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CustomerTest {

	public static void main(String[] args) {
		
		List<Customer> list = Arrays.asList(
			new Customer("이순신", 40, 100),
			new Customer("강감찬", 30, 100),
			new Customer("홍길동", 14, 50)
		);
		
		Stream<Customer> stream;
		
		System.out.println("=== 고객명단 추가된 순서대로 출력 ===");
		stream = list.stream();
		stream.map(c -> c.getName()).forEach(s -> System.out.println(s));
		
		System.out.println("=== 총 여행 비용 출력 ===");
		stream = list.stream();
		int total = stream.mapToInt(c -> c.getPrice()).sum();
		System.out.println(total+"원");
		
		System.out.println("=== 20세 이상 고객명단 출력 ===");
		stream = list.stream();
		stream.filter(c -> c.getAge()>=20).map(c -> c.getName()).sorted().forEach(n -> System.out.println(n));
		
	}
	
}
