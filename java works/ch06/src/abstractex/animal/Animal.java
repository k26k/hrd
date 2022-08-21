package abstractex.animal;

public abstract class Animal { // 추상 클래스에 abstract 사용
	
	public String kind;
	
	public void breathe() {
		System.out.println("쿰척쿰척");
	}
	
	public abstract void sound(); // 추상 메소드에 abstract 사용
	
}
