package operator;

public class Operator1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		대입 연산자
		int num=10;
		System.out.println(num);
		System.out.println(-num); // 출력시에만 변경되고 변수값은 변하지 않음
		System.out.println(num);
		
//		값 변경
		num = -num;
		System.out.println(num); // 변수 데이터가 변함
		
//		배열
		String[] sessons = {"spring", "summer", "fall", "winter"};
		System.out.println(sessons[0]);
		System.out.println(sessons[1]);
		System.out.println("sessons 요소의 갯수는 "+sessons.length+"개");
		System.out.println("============");
		
		for(int i=0; i<4; i++) {
			System.out.println(sessons[i]);
		}
	}

}
