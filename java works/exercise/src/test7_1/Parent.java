package test7_1;

public class Parent {
	
	public String nation;
	
	public Parent() {
		this("대한민국");
		System.out.println("Parene() call");
	}
	
	public Parent(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
	
}
