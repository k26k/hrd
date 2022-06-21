package ch01;

public class CharType {
	public static void main(String[] args) {
//		문자 자료형 - 아스키 코드 < 유니코드
//		char = 2Byte
		char ch1 = 'A';
		System.out.println(ch1);
		System.out.println((int)ch1);
		
		char ch2 = 'B';
		System.out.println((int)ch2);
		
		System.out.println("======== 유니코드 ========");
		
		char uniCode1 = '한';
		System.out.println(uniCode1);
				
		char uniCode2 = '\uD55C'; // 유니코드 표기
		System.out.println(uniCode2);
		
//		영어 소문자 출력
		char startNum = 97;
		char countNum = 26;
		for(char i = startNum; i<startNum+countNum; i++){
			System.out.println((char)i);
		}
		
	}
}
