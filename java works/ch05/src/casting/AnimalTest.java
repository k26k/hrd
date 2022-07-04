package casting;

import java.util.ArrayList;

class Animal{
	void move() {
		System.out.println("동물이 움직입니다");
	}
}

class Human extends Animal{
	void move() {
		System.out.println("사람이 뚜벅뚜벅");
	}
	void read() {
		System.out.println("책을 봐요");
	}
}

class Eagle extends Animal{
	void move() {
		System.out.println("수리가 뚜벅뚜벅");
	}
	void fry() {
		System.out.println("수리가 나풀나풀");
	}
}

class Tiger extends Animal{
	void move() {
		System.out.println("호랑호랑호랑이");
	}
	void hunting() {
		System.out.println("호랑이펀치");
	}
}


	
public class AnimalTest {
	
	public static ArrayList<Animal> animalList = new ArrayList<>();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalTest aTest = new AnimalTest();
		
		animalList.add(new Human());
		animalList.add(new Eagle());
		animalList.add(new Tiger());
		animalList.add(new Animal());
		
		for(Animal animal:animalList) {
			animal.move();
		}
		
//		static이 없는 method는 객체를 생성해서 사용해야함
		aTest.testCasting();
		
	}
	
	void testCasting() {
		for(Animal animal:animalList) {
			if(animal instanceof Human) {
				Human human = (Human)animal;
				human.read();
//				((Human)animal).read();
			}else if(animal instanceof Eagle) {
				Eagle eagle = (Eagle)animal;
				eagle.fry();
			}else if(animal instanceof Tiger) {
				Tiger tiger = (Tiger)animal;
				tiger.hunting();
			}else {
				System.out.println("지원되지 않는 형입니다");
			}
		}
	}
	
}
