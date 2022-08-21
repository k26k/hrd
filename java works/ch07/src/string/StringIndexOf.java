package string;

public class StringIndexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// string.indexOf("str") - string에서 str이 시작되는 인덱스를 리턴
		String subject = "자바 프로그래밍";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		// 문자열 검색
		if(subject.indexOf("자바") != -1) {
			// indexOf는 문자열에 해당 요소가 없으면 -1을 반환 
			System.out.println("자바와 관련있는 책");
		}else{
			System.out.println("자바와 관련없는 책");
		}
		
		
	}

}
