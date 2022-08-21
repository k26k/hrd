package enums;

import java.util.Calendar;

public class EnumWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Week today = null; // null - 객체 초기화
		
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		
		switch(week) {
			case 1:
				today=Week.MONDAY;
				break;
			case 2:
				today=Week.TUESDAY;
				break;
			case 3:
				today=Week.WEDNESDAY;
				break;
			case 4:
				today=Week.THIRSDAY;
				break;
			case 5:
				today=Week.FRIDAY;
				break;
			case 6:
				today=Week.SATURDAY;
				break;
			case 7:
				today=Week.SUNDAY;
				break;
			default:
				break;
		}
		
		System.out.println(today);
		
		if(today == Week.WEDNESDAY) {
			System.out.println("교재를 받는당");
		}
	}

}
