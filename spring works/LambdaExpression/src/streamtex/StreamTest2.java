package streamtex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		
		List<Student> list = Arrays.asList(
			new Student("콩쥐", 90),
			new Student("팥쥐", 70),
			new Student("심청", 80)
		);
		
		Stream<Student> stream = list.stream();
		
		stream.forEach(student -> {
			String name = student.getName();
			int score = student.getScore();
			System.out.println(name+", "+score);
		});
		
//		stream 객체는 1회용이므로 반복 사용시 계속 생성해줘야함
		stream = list.stream();
		stream.map(std -> std.getName()).forEach(s-> System.out.println(s));

		stream = list.stream();
		stream.map(std -> std.getScore()).forEach(s-> System.out.println(s));
		
		
//		조건 처리 filter()
		list.stream().filter(std -> (std.getScore() > 80)).map(std -> std.getName()).forEach(s -> System.out.println(s));
		
		
	}
	
}
