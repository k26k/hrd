package object.clone;

public class CircleMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Point point = new Point(1, 3);
		System.out.println(point.toString());
		
		Circle circle = new Circle(1, 3, 4);
		System.out.println(circle);
		
//		circle 객체 복사
		Circle copyCircle = (Circle) circle.clone();
		System.out.println(copyCircle);
		
	}
	
}
