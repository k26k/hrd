package banking_db;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static AccountDAO dao = new AccountDAO();
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
						run = systemEnd();
						break;
						
					default:
						System.out.println("지원되지 않는 기능입니다.");
						break;
				}
			}catch(NullPointerException e) {
				System.out.println("[error] 결과 : 계좌가 없습니다.");
			}
		}
		
		sc.close();
		System.out.println("프로그램 종료 성공");
	}
	
	

	private static void printMenu(String sNo) {
		
		System.out.println("---------------------------------------------------------------");
		switch(sNo) {
			case "0":
				System.out.println(" 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.계좌검색 | 6.계좌삭제 | 7.종료 ");
				break;
			case "1":
				System.out.println(" 1.계좌생성		취소[0]");
				break;
			case "2":
				System.out.println(" 2.계좌목록		취소[0]");
				break;
			case "3":
				System.out.println(" 3.예금			취소[0]");
				break;
			case "4":
				System.out.println(" 4.출금			취소[0]");
				break;
			case "5":
				System.out.println(" 5.계좌검색		취소[0]");
				break;
			case "6":
				System.out.println(" 6.계좌삭제		취소[0]");
				break;
			case "7":
				System.out.println(" 7.종료			종료[Y/N]");
				break;
			default:
				System.out.println(" [ERROR] ");
				break;
		}
		System.out.println("---------------------------------------------------------------");		
	
	}
	
	
	private static void createAccount(){
		String ano;
		Account account = null;
		while(true) {
			System.out.print("계좌번호 : ");
			ano = sc.next();
			
			if(ano.equals("0")) {
				System.out.println("결과 : 취소되었습니다.");
				return;
			}
			
			account = dao.getAccount(ano);
			if(account != null) {
				System.out.println("결과 : 계좌가 중복됩니다. 다시 입력합니다.");
				continue;
			}
			
			break;
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
		
		account = new Account(ano, owner, balance);
		dao.createAccount(account);
		System.out.println("결과 : 계좌가 생성되었습니다.");
		
	}
	
	
	private static void accountList() {
		List<Account> accountArrayList = dao.getAccountList();
		if(accountArrayList.size() == 0) {
			System.out.println("결과 : 계좌가 없습니다.");
			return;
		}
		for(int i=0; i<accountArrayList.size(); i++) {
			Account account = accountArrayList.get(i);
			String ano = account.getAno();
			String owner = account.getOwner();
			int balance = account.getBalance();
			System.out.println((i+1)+". 계좌: "+ano+" , 주인: "+owner+" , 잔고: "+balance);
		}
		System.out.println("결과 : 계좌 "+accountArrayList.size()+"개 검색 완료");
	}
	
	
	private static void deposit() {
		while(true) {
			System.out.print("계좌번호 : ");
			String ano = sc.next();
			
			if(ano.equals("0")) {
				System.out.println("결과 : 취소되었습니다.");
				return;
			}
			
			Account account = dao.getAccount(ano);
			
			if(account == null) {
				System.out.println("결과 : 해당 계좌가 없습니다.");
				continue;
			}
			
			while(true) {
				System.out.print("입금액 : ");
				int money = Integer.parseInt(sc.next());
				
				if(money<=0) {
					System.out.println("결과 : "+money+"원 입금 불가");
				}else {
					account.setBalance(account.getBalance()+money);
					dao.updateAccount(account);
					account = dao.getAccount(ano);
					System.out.println("결과 : "+money+"원 입금완료 , 잔고: "+account.getBalance()+"원");
					return;	
				}
			}
			
		}
	}
	
	
	private static void withdraw() {
		while(true) {
			System.out.print("계좌번호 : ");
			String ano = sc.next();
			
			if(ano.equals("0")) {
				System.out.println("결과 : 취소되었습니다.");
				return;
			}
			
			Account account = dao.getAccount(ano);
			
			if(account == null) {
				System.out.println("결과 : 해당 계좌가 없습니다.");
				continue;
			}
			
			int balance = account.getBalance();
			
			if(balance <= 0) {
				System.out.println("결과 : 잔고 "+balance+"원 출금 불가");
				return;
			}
			
			while(true) {
				System.out.print("출금액 : ");
				int money = Integer.parseInt(sc.next());
				
				if(money<=0) {
					System.out.println("결과 : "+money+"원 출금 불가");
					continue;
				}
				
				if(balance < money) {
					System.out.println("결과 : 잔고부족 , "+money+"원 출금실패 , 잔고: "+balance+"원");
					continue;
				}
					
				account.setBalance(balance-money);
				dao.updateAccount(account);
				account = dao.getAccount(ano);
				System.out.println("결과 : "+money+"원 출금완료 , 잔고: "+account.getBalance()+"원");
				return;
			}
		}
	}
	
	
	private static void viewAccount() {
		while(true) {
			System.out.print("계좌번호 : ");
			String ano = sc.next();

			if(ano.equals("0")) {
				System.out.println("결과 : 취소되었습니다.");
				return;
			}
			
			Account account = dao.getAccount(ano);
			
			if(account == null) {
				System.out.println("결과 : 해당 계좌가 없습니다.");
				continue;
			}
			
			ano = account.getAno();
			String owner = account.getOwner();
			int balance = account.getBalance();
			System.out.println("계좌: "+ano+" , 주인: "+owner+" , 잔고: "+balance);
		}
	}
	
	
	private static void removeAccount() {
		while(true){
			System.out.print("계좌번호 : ");
			String ano = sc.next();
			
			if(ano.equals("0")) {
				System.out.println("결과 : 취소되었습니다.");
				return;
			}
			
			Account account = dao.getAccount(ano);
			
			if(account == null) {
				System.out.println("결과 : 해당 계좌가 없습니다.");
				continue;
			}
			
			dao.deleteAccount(ano);
			
			account = dao.getAccount(ano);
			
			if(account == null) {
				System.out.println("결과 : 계좌번호 "+ano+" 삭제 완료.");
				return;
			}

		}
	}

	
	private static boolean systemEnd() {
		while(true) {
			System.out.print("종료하시겠습니까? > ");
			String str = sc.next();
			if(str.equals("y") || str.equals("Y")) {
				System.out.println("프로그램을 종료합니다.");
				return false;
			}else if(str.equals("n") || str.equals("N")) {
				System.out.println("프로그램 종료를 취소합니다.");
				return true;
			}else {
				System.out.println("다시 입력해 주세요.");
			}
		}
	}
	
	
}
