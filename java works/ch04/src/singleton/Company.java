package singleton;

public class Company {

//	유일하게 생성된 인스턴스(객체 생성과 관계없이 필요한 곳에 바로 사용 가능)
	private static Company instance = new Company();
	
//	생성자를 외부에서 호출할수 없게함
	private Company() {}
	
//	외부에서 호출시 인스턴스를 반환
	public static Company getInstance() {
		return instance;
	}
	
	
}
