package switchcase;

public class SwitchNoBreakCaseExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time = (int)(Math.random()*4+8);
		System.out.printf("[현재 시각 : %d시]\n", time);
		
		switch (time) {
			case 8:
				System.out.println("출근");
			case 9:
				System.out.println("회의");
			case 10:
				System.out.println("업무");
			default:
				System.out.println("외근");
		}
		
	}

}
