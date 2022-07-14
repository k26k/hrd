package banking_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//	배열의 크기가 100인 Account형 배열 선언
	private static ArrayList<Account> accountArrayList = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		while(run) {
			
			try {
				printMenu("0");
				System.out.print("선택 > ");
				String selectNo = sc.next();
				
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
						viewAccount();
						break;
						
					case "6":
						removeAccount();
						break;
						
					case "7":
						run = false;
						break;
						
					default:
						System.out.println("지원되지 않는 기능입니다.");
						break;
				}
			}catch(NullPointerException e) {
				System.out.println("[error] 결과 : 계좌가 없습니다.");
			}
		
		}
		
		System.out.println("프로그램 종료 성공");
		
	}
	
	
	private static void printMenu(String sNo) {
		
		System.out.println("---------------------------------------------------------------");
		switch(sNo) {
			case "0":
				System.out.println(" 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.계좌검색 | 6.계좌삭제 | 7.종료 ");
				break;
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
				System.out.println(" 5.계좌검색 ");
				break;
			case "6":
				System.out.println(" 6.계좌삭제 ");
				break;
			case "7":
				System.out.println(" 7.종료 ");
				break;
			default:
				System.out.println(" [ERROR] ");
				break;
		}
		System.out.println("---------------------------------------------------------------");		
	
	}
	
	
	private static void createAccount(){
		String ano;
		
		while(true) {
			System.out.print("계좌번호 : ");
			ano = sc.next();
			Account account = findAccount(ano);
			if(account == null) {
				break;
			}
			System.out.println("결과 : 계좌가 중복됩니다. 다시 생성 합니다.");
		}
		
		System.out.print("계좌주 : ");
		String owner = sc.next();
		
		int balance;
		while(true) {
			System.out.print("초기 입금액 : ");
			balance = Integer.parseInt(sc.next());
			if(balance >= 0) {
				break;
			}
			System.out.println("결과 : 초기 입금액은 음수일수 없습니다.");
		}
		
		Account newAccount = new Account(ano, owner, balance);
		accountArrayList.add(newAccount);
		System.out.println("결과 : 계좌가 생성되었습니다.");
		
	}
	
	
	private static void accountList() {
		if(accountArrayList.size() == 0) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		for(int i=0; i<accountArrayList.size(); i++) {
			Account account = accountArrayList.get(i);
			System.out.print((i+1)+". ano: "+account.getAno()+" , ");
			System.out.print("owner: "+account.getOwner()+" , ");
			System.out.println("balance: "+account.getBalance());
		}
		System.out.println("결과 : 계좌 "+accountArrayList.size()+"개 검색 완료");
	}
	
	
	private static void deposit() {
		if(accountArrayList.size() == 0) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		while(true) {
			System.out.print("계좌번호 : ");
			String ano = sc.next();
			
			Account account = findAccount(ano);
			
			if(account != null) {
				while(true) {
					System.out.print("입금액 : ");
					int money = Integer.parseInt(sc.next());
					
					if(money<=0) {
						System.out.println("결과 : "+money+"원 입금 불가");
					}else {
						account.setBalance(account.getBalance()+money);
						System.out.println("결과 : "+money+"원 입금완료 , 잔고: "+account.getBalance()+"원");
						return;	
					}
				}
			}
			System.out.println("결과 : 해당 계좌가 없습니다.");
		}
	}
	
	
	private static void withdraw() {
		if(accountArrayList.size() == 0) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		while(true) {
			System.out.print("계좌번호 : ");
			String ano = sc.next();
			
			Account account = findAccount(ano);
			
			if(account != null) {
				int balance = account.getBalance();
				if(balance > 0) {
					while(true) {
						System.out.print("출금액 : ");
						int money = Integer.parseInt(sc.next());
						if(money<=0) {
							System.out.println("결과 : "+money+"원 출금 불가");
						}else {
							if(money <= balance) {
								account.setBalance(balance-money);
								System.out.println("결과 : "+money+"원 출금완료 , 잔고: "+account.getBalance()+"원");
								return;
							}else{
								System.out.println("결과 : 잔고부족 , "+money+"원 출금실패 , 잔고: "+account.getBalance()+"원");
							}
						}
					}
				}else {
					System.out.println("결과 : 잔고 "+balance+"원 출금 불가");
					return;
				}
			}
			System.out.println("결과 : 해당 계좌가 없습니다.");
		}
	}
	
	
	private static void viewAccount() {
		if(accountArrayList.size() == 0) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		String ano;
		Account account;
		while(true) {
			System.out.print("계좌번호 : ");
			ano = sc.next();
			account = findAccount(ano);
			if(account != null) {
				break;
			}
			System.out.println("결과 : 해당 계좌가 없습니다.");
		}
		System.out.print(". ano: "+account.getAno()+" , ");
		System.out.print("owner: "+account.getOwner()+" , ");
		System.out.println("balance: "+account.getBalance());
	}
	
	
	private static void removeAccount() {
		if(accountArrayList.size() == 0) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		String ano;
		Account account;
		while(true) {
			System.out.print("계좌번호 : ");
			ano = sc.next();
			account = findAccount(ano);
			if(account != null) {
				break;
			}
			System.out.println("결과 : 해당 계좌가 없습니다.");
		}
		accountArrayList.remove(account);
		System.out.println("결과 : 계좌번호 "+ano+" 삭제 완료.");
	}
	
	
	private static Account findAccount(String ano) {
		for(Account account:accountArrayList) {
			if(account.getAno().equals(ano)) {
				return account;
			}
		}
		return null;
	}

	
}
