package information_hiding;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setAno("100-1234");
		account.setOwner("다이소");
		account.setBalance(1000);
		System.out.println("계좌 : "+account.getAno());
		System.out.println("명의 : "+account.getOwner());
		System.out.println("잔고 : "+account.getBalance());
		
		Account account2 = new Account("100-1235", "안산", 2000); // set대신 생성자로 변수 초기화
		System.out.println("계좌 : "+account2.getAno());
		System.out.println("명의 : "+account2.getOwner());
		System.out.println("잔고 : "+account2.getBalance());
		
	}

}
