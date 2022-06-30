package singleton.car;

public class Car {
	private static int serialNum = 10000;
	private int carNum;
	
	public Car() {
		serialNum++;
		carNum = serialNum;
	}
	
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
	public int getCarNum() {
		return this.carNum;
	}
}
