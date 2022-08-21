package interfaceex.vehicle_casting;

public class Bus implements Vehicle{

	@Override
	public void run() {
		System.out.println("버스가 달린당");
	}
	
	public void name() {
		System.out.println("버스당");
	}
	
	
}
