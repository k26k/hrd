package test11_2;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		String[] days = new String[] {"일","월","화","수","목","금","토"};
		
		System.out.print(
			cal.get(cal.YEAR)+"년 "
			+(cal.get(cal.MONTH)+1)+"월 "
			+cal.get(cal.DAY_OF_MONTH)+"일 "
			+days[cal.get(cal.DAY_OF_WEEK)]+"요일 "
			+cal.get(cal.HOUR_OF_DAY)+"시 "
			+cal.get(cal.MINUTE)+"분 "
		);
		
	}
	
}
