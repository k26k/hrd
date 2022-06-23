package ifExemple;

public class AdmissionFee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 9;
		int fee = 0;
		
		if(age < 8) {
			fee = 1000;
			System.out.println("미취학 아동 입니다.");
		}else if(age < 14) {
			fee = 2000;
			System.out.println("초등학생 입니다.");
		}else if( age < 20) {
			fee = 2500;
			System.out.println("중, 고등학생 입니다.");
		}else {
			fee = 3000;
			System.out.println("성인 입니다.");
		}
		System.out.println("입장료는 "+fee+"원 입니다.");
	}

}
