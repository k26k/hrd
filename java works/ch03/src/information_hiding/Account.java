package information_hiding;

public class Account {

	private String ano;
	private String owner;
	private int balance;
	
	Account() {}

	Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		
	}
	
	void setAno(String ano){
		this.ano = ano;
	}
	
	String getAno() {
		return this.ano;
	}
	
	void setOwner(String owner) {
		this.owner = owner;
	}
	
	String getOwner() {
		return this.owner;
	}
	
	void setBalance(int balance) {
		this.balance = balance;
	}
	
	int getBalance() {
		return this.balance;
	}
	
	
	
}
