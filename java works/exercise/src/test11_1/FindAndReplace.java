package test11_1;

public class FindAndReplace {

	public static void main(String[] args) {
		
		String str = "모든 프로그래밍 언어는 자바 언어로 개발될 수 있다";
		
		int index = str.indexOf("자바");
		
		if(index == -1) {
			System.out.println("자바 문자열이 포함되지 않음");
		}else{
			System.out.println("자바 문자열이 포함됨");
			str = str.replace("자바", "JAVA");
			System.out.println("==> "+str);
		}
		
	}
	
}
