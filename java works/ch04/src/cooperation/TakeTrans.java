package cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("안산", 10000);
		Person p2 = new Person("류현진", 5000);
		
		Bus bus100 = new Bus(100);
		
		Subway subway2 = new Subway("2호선");
		
		p1.takeBus(bus100);
		p1.showInfo();
		p2.takeBus(bus100);
		p2.showInfo();
		
		bus100.showInfo();
		
		p1.takeSubway(subway2);
		p1.showInfo();;
		p2.takeSubway(subway2);
		p2.showInfo();
		
		subway2.showInfo();
		
	}

}
