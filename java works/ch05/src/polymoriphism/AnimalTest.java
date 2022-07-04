package polymoriphism;

class Animal{
	void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal{
	void move() {
		System.out.println("사람이 걷습니다.");
	}
}

class Eagle extends Animal{
	void move() {
		System.out.println("수리가 납니다.");
	}
}

class Tiger extends Animal{
	void move() {
		System.out.println("호랑호랑호랄이");
	}
}


	
public class AnimalTest {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalTest aTest = new AnimalTest();
		
		Animal humal = new Human();
		Animal eagle = new Eagle();
		Animal tiger = new Tiger();
		
		aTest.moveAnimal(humal);
		aTest.moveAnimal(eagle);
		aTest.moveAnimal(tiger);
		
	}
	
	void moveAnimal(Animal animal) {
		animal.move();
	}

}
