package interfaceex.vehicle_casting;

public class Texi implements Vehicle{

	@Override
	public void run() {
		System.out.println("택시가 달린당");
	}
	
	public void name() {
		System.out.println("택시당");
	}
	
}