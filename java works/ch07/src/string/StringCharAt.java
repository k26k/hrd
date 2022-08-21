package string;

public class StringCharAt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// charAt(index) String의 인덱스의 문자를 리턴
		String subject = "자바 프로그램";
		char charValue = subject.charAt(3);
		System.out.println(charValue);
		
		// 주민등록 번호에서 남여 구분
		String ssn = "912345-1234567";
		char gender = ssn.charAt(7);
		System.out.println(gender);
		switch(gender) {
			case '1':
			case '3':
				System.out.println("남자");
				break;
			case '2':
			case '4':
				System.out.println("여자");
				break;
			default:
				System.out.println("오류");
				break;
		}
		
	}

}
