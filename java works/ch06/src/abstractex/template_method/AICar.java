package abstractex.template_method;

public class AICar extends Car{

	@Override
	protected void drive() {
		System.out.println("자율 주행합니다");
		System.out.println("자동차가 스스로 방향을 전환합니다");
		
	}

	@Override
	protected void stop() {
		System.out.println("자동차가 스스로 정지합니다");
	}

}
