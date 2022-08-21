package builtinclass;

import java.util.Calendar;

public class CalendarEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Calendar 객체 생성
		Calendar cal = Calendar.getInstance();
		
//		날짜
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); 
		int date = cal.get(Calendar.DATE);
		System.out.println(year+"년 "+month+"월 "+date+"일");
		
//		시간
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int milliSec = cal.get(Calendar.MILLISECOND);
		System.out.println(hour+"시 "+minute+"분 "+second+"("+milliSec+")"+"초");
		
//		요일 1부터 7까지 일월화수목금토
		int day = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
	}

}
