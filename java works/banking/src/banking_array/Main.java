package banking_array;

import java.util.Scanner;

public class Main {

//	배열의 크기가 100인 Account형 배열 선언
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		while(run) {
				
			printMenu("");
			System.out.print("선택 > ");
			
			String selectNo = sc.next();
			try {
				printMenu(selectNo);
				
				switch(selectNo) {
					case "1":
						createAccount();
						break;
						
					case "2":
						accountList();
						break;
						
					case "3":
						deposit();
						break;
						
					case "4":
						withdraw();
						break;
						
					case "5":
						run = false;
						break;
						
					default:
						System.out.println("지원되지 않는 기능입니다.");
						break;
				}
			}catch(NullPointerException e) {
				System.out.println("결과 : 계좌가 없습니다. [e]");
			}
		
		}
		
		System.out.println("프로그램 종료 성공");
		
	}
	
	
	public static void printMenu(String sNo) {
		
		System.out.println("--------------------------------------------");
		switch(sNo) {
			case "1":
				System.out.println(" 1.계좌생성 ");
				break;
			case "2":
				System.out.println(" 2.계좌목록 ");
				break;
			case "3":
				System.out.println(" 3.예금 ");
				break;
			case "4":
				System.out.println(" 4.출금 ");
				break;
			case "5":
				System.out.println(" 5. 종료 ");
				break;
			default:
				System.out.println(" 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5. 종료 ");
				break;
		}
		System.out.println("--------------------------------------------");		
	
	}
	
	
	public static void createAccount(){
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		
		System.out.print("계좌주 : ");
		String owner = sc.next();
		
		System.out.print("초기 입금액 : ");
		int balance = Integer.parseInt(sc.next());
		
		Account newAccount = new Account(ano, owner, balance);
		for(int i=0; i<accountArray.length; i++) {
			Account account = accountArray[i];
			if(account == null) {
				while(newAccount.getBalance()<0) {
					System.out.println("초기 입금액은 음수일수 없습니다");
					System.out.print("초기 입금액 : ");
					newAccount.setBalance(Integer.parseInt(sc.next()));
				}
				accountArray[i] = newAccount;
				System.out.println("결과 : 계좌가 생성되었습니다.");
				return;
			}else if(account.getAno().equals(newAccount.getAno())) {
				System.out.println("결과 : 계좌가 중복됩니다. 다시 생성 합니다.");
				createAccount();
				return;
			}
		}
		System.out.println("결과 : 계좌를 생성하지 못했습니다.");
	}
	
	
	public static void accountList() {
		if(accountArray[0] == null) {
			System.out.println("결과 : 계좌가 없습니다.");
		}else {
			for(int i=0; i<accountArray.length; i++) {
				Account account = accountArray[i];
				if(account == null) {
					System.out.println("결과 : 계좌 "+i+"개 검색 완료");
					return;
				}
				System.out.print((i+1)+". ano: "+account.getAno()+" , ");
				System.out.print("owner: "+account.getOwner()+" , ");
				System.out.println("balance: "+account.getBalance());
			}
			System.out.println("결과 : 계좌 "+accountArray.length+"개 검색 완료");
		}
	}
	
	
	public static void deposit() {
		if(accountArray[0] == null) {
			System.out.println("결과 : 계좌가 없습니다.");
		}else {
			System.out.print("계좌번호 : ");
			String ano = sc.next();
			
			for(Account account:accountArray) {
				if(account == null) {
					System.out.println("결과 : 해당 계좌가 없습니다.");
					deposit();
					return;
				}else if(account.getAno().equals(ano)) {
					while(true) {
						System.out.print("입금액 : ");
						int money = Integer.parseInt(sc.next());
						if(money<0) {
							System.out.println("결과 : 음수 "+money+"원 입금 불가");
						}else if(money==0){
							System.out.println("결과 : 0원 입금 불가");
						}else {
							account.setBalance(account.getBalance()+money);
							System.out.println("결과 : "+money+"원 입금완료 , 잔고: "+account.getBalance()+"원");
							return;	
						}
					}
				}
			}
			System.out.println("결과 : 해당 계좌가 없습니다.");
			deposit();
		}
	}
	
	
	public static void withdraw() {
		if(accountArray[0] == null) {
			System.out.println("결과 : 계좌가 없습니다.");
		}else {
			System.out.print("계좌번호 : ");
			String ano = sc.next();
			
			for(Account account:accountArray) {
				if(account == null) {
					System.out.println("결과 : 해당 계좌가 없습니다.");
					withdraw();
					return;
				}else if(account.getAno().equals(ano)) {
					while(true) {
						System.out.print("출금액 : ");
						int money = Integer.parseInt(sc.next());
						if(money<0) {
							System.out.println("결과 : 음수 "+money+"원 출금 불가");
						}else if(money==0){
							System.out.println("결과 : 0원 출금 불가");
						}else {
							if(money <= account.getBalance()) {
								account.setBalance(account.getBalance()-money);
								System.out.println("결과 : "+money+"원 출금완료 , 잔고: "+account.getBalance()+"원");
								return;
							}else{
								System.out.println("결과 : 잔고부족 , "+money+"원 출금실패 , 잔고: "+account.getBalance()+"원");
							}
						}
					}
				}
			}
			System.out.println("결과 : 해당 계좌가 없습니다.");
			withdraw();
		}
	}
	

	
}
