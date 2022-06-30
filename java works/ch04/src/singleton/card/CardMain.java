package singleton.card;

public class CardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardCompany company = CardCompany.getInstance();
		
		Card card1 = company.creatCard();
		System.out.printf("카드번호 : %d\n", card1.getCardNumber());
		
		Card card2 = company.creatCard();
		System.out.printf("카드번호 : %d\n", card2.getCardNumber());
		
		Card card3 = company.creatCard();
		System.out.printf("카드번호 : %d\n", card3.getCardNumber());
		
		
	}

}
