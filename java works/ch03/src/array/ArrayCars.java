package array;

public class ArrayCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		문자형 배열 선언과 사용
//		자동차 배열 선언
//		String[] cars = new String[4];
//		cars[0]="Morning";
//		cars[1]="Sonata";
//		cars[2]="Sportage";
//		cars[3]="K7";
		
		String[] cars = {"Morning", "Sonata", "Sportage", "K7"};
		
//		전체 조회
		for(int i=0; i<cars.length; i++) {
			System.out.println(cars[i]);
		}
		System.out.println("");
//		내용 변경
		cars[2]="BMW";
		
		for(int i=0; i<cars.length; i++) {
			System.out.println(cars[i]);
		}
		System.out.println("");
		
//		향상된 for(객체 방식)
		for(String car:cars) {
			System.out.println(car);
		}
		
	}

}
