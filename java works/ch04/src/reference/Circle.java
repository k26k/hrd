package reference;

public class Circle {
	
	Point point = null;
	int radius;
	
	public Circle(int x, int y, int radius){
		this.point = new Point(x, y);
		this.radius = radius;
	}
	
	public String showInfo() {
		return "원의 중심점("+this.point.x+", "+this.point.y+"), 반지름"+radius;
	}
}
