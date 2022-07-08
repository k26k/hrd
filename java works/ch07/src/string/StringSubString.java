package string;

public class StringSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// subString(start, end) start부터 end까지 문자열 반환
		// subString(start) start부터 끝까지 문자열 반환
		
		String ssn = "912345-1234567";
		String firstNum = ssn.substring(0,6);
		String secondNum = ssn.substring(7);
		
		System.out.println(firstNum+"-"+secondNum);
		
	}

}
