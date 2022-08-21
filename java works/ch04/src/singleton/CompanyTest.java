package singleton;

public class CompanyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company myCompany1 = Company.getInstance();
		Company myCompany2 = Company.getInstance();
		
		System.out.println(myCompany1);
		System.out.println(myCompany2);
		System.out.println(myCompany1 == myCompany2);
//		객체 2개를 만들었지만 결국 하나의 메모리 주소를 공유하는 하나의 객체임
	}

}
