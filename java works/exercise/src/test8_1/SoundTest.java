package test8_1;

public class SoundTest {

	static void printSound(Sound sound) {
		System.out.println(sound.sound());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSound(new Cat());
		printSound(new Dog());
	}

}
