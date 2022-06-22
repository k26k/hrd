package type;

public class Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name; // 문자열 변수 name선언 (할당)
		name = "가나다";
		System.out.println(name);
		
		int grade; // 정수형 변수 grade 선언(할당)
		grade = 2;
//		int class 예약어는 변수 이름으로 사용할수 없다
		int schoolClass = 3;
		
		System.out.println(name+"는 "+grade+"학년 "+schoolClass+"반");
	}

}
