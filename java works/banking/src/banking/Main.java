package banking;

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
				switch(selectNo) {
					case "1":
						System.out.println(createAccount());
						break;
						
					case "2":
						System.out.println(accountList());
						break;
						
					case "3":
						System.out.println(deposit());
						break;
						
					case "4":
						System.out.println(withdraw());
						break;
						
					case "5":
						bankingOff();
						run = false;
						break;
						
					default:
						System.out.println("지원되지 않는 기능입니다.");
						break;
				}
			}catch(NullPointerException e) {
				System.out.println("결과 : 계좌가 없습니다.");
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
	
	
	public static String createAccount(){
		printMenu("1");
		
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
				accountArray[i] = newAccount;
				System.out.println();
				return "결과 : 계좌가 생성되었습니다.";
			}else if(account.getAno().equals(newAccount.getAno())) {
				return "결과 : 계좌가 중복됩니다.";
			}
		}
		return "결과 : 계좌를 생성하지 못했습니다.";
	}
	
	
	public static String accountList() {
		printMenu("2");
		
		if(accountArray[0] == null) {
			return "결과 : 계좌가 없습니다.";
		}
		
		for(int i=0; i<accountArray.length; i++) {
			Account account = accountArray[i];
			if(account == null) {
				return "결과 : 계좌 "+i+"개 검색 완료";
			}
			System.out.print((i+1)+". ano: "+account.getAno()+" , ");
			System.out.print("owner: "+account.getOwner()+" , ");
			System.out.println("balance: "+account.getBalance());
		}
		
		return "결과 : 계좌 "+accountArray.length+"개 검색 완료";
	}
	
	
	public static String deposit() {
		printMenu("3");
		
		if(accountArray[0] == null) {
			return "결과 : 계좌가 없습니다.";
		}
		
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		
		for(Account account:accountArray) {
			if(account.getAno().equals(ano)) {
				System.out.print("입금액 : ");
				int money = Integer.parseInt(sc.next());
				account.setBalance(account.getBalance()+money);
				return "결과 : "+money+"원 입금완료 , 잔고: "+account.getBalance()+"원";
			}
		}
		return "결과 : 해당 계좌가 없습니다." ;
	}
	
	
	public static String withdraw() {
		printMenu("4");
		
		if(accountArray[0] == null) {
			return "결과 : 계좌가 없습니다.";
		}
		
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		
		for(Account account:accountArray) {
			if(account.getAno().equals(ano)) {
				System.out.print("출금액 : ");
				int money = Integer.parseInt(sc.next());
				if(money <= account.getBalance()) {
					account.setBalance(account.getBalance()-money);
					return "결과 : "+money+"원 출금완료 , 잔고: "+account.getBalance()+"원";
				}else{
					return "결과 : 잔고부족 , "+money+"원 출금실패 , 잔고: "+account.getBalance()+"원";
				}
			}
		}
		return "결과 : 해당 계좌가 없습니다." ;
		
	}
	
	
	public static void bankingOff() {
		printMenu("5");
	}
	
	

	
}
