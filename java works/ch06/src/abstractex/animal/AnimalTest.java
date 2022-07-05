package abstractex.animal;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		기본 선언
//		Dog dog = new Dog();
//		Cat cat = new Cat();
//		
//		dog.sound();
//		dog.breathe();
//		cat.sound();
//		cat.breathe();
		
//		부모타입으로 객체 생성 - 자동 형병환
		Animal dog = new Dog();
		Animal cat = new Cat();
		
//		dog.sound();
//		dog.breathe();
//		cat.sound();
//		cat.breathe();
		
//		메소드로 사용
		animalSound(dog);
		animalSound(cat);
		
	}

	private static void animalSound(Animal animal) {
		// TODO Auto-generated method stub
		animal.sound();
		animal.breathe();
	}

}
