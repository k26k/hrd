package abstractex.animal;

public class Dog extends Animal {
	
	@Override
	public void sound() { // 추상 메서드 재정의(구현) 필수
		System.out.println("컹컹쓰");
	}
	
}
