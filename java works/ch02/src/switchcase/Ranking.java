package switchcase;

public class Ranking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rank = 1;
		String medalColor = "";
		
		switch (rank) {
		case 1:
			medalColor = "금";
			break;
		case 2:
			medalColor = "은";
			break;
		case 3:
			medalColor = "동";
			break;
		default:
			medalColor = "무";
			break;
		}
		
		System.out.println("메달의 색상은 "+medalColor+"색 입니다.");
	}

}
