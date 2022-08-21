package finalex;

public class SportCar extends Car {

	@Override
	public void speedUp() {
		speed += 10;
	}
	
//	@Override
//	public final void stop() {
//		System.out.println("차를 멈춥니다.");
//		speed = 0;
//	}
//	 final로 정의된 함수는 재정의 불가능
	
}
