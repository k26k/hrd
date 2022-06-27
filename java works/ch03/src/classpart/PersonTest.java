package classpart;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		생성자 오버로딩 - 클래스 이름은 같고 매개변수나 자료형이 다른것
		Person p1 = new Person();
		
		p1.name="손흥민";
		p1.height=183.2F;
		p1.width=76.7F;
		
		p1.showInfo();
		
//		매개변수에 따라 멤버를 다르게 선언 가능
		Person p2 = new Person("추신수");
		
		p2.height=180.3F;
		p2.width=90.2F;
		
		p2.showInfo();
		
		Person p3 = new Person("장그래", 165.9f, 55.3f);

		p3.showInfo();
	}
}
