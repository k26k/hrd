package builtinclass;

import java.util.Calendar;

public class PassedTime2 {

	public static void main(String[] args) {
		
//		getInstance로 인스턴스를 받아와 Calendar 객체 생성
		Calendar startDay = Calendar.getInstance();
		Calendar toDay = Calendar.getInstance();
		
//		객체 값 설정
		startDay.set(2022, 5, 9);
		System.out.print("시작일 : ");
		printDate(startDay);
		
//		객체 값 설정
		toDay.set(2022, 6, 29);
		System.out.print("현재일 : ");
		printDate(toDay);
		
//		지난 시간 = 현재 시간 - 시작 시간
		long passedTime = toDay.getTimeInMillis()-startDay.getTimeInMillis();
//		밀리초 출력후 환산 출력
		System.out.println(passedTime+"밀리초");
		System.out.println((passedTime/(1000*60*60*24))+"일");
		
	}

	private static void printDate(Calendar date) {
		
		System.out.println(date.get(Calendar.YEAR)+"년"+date.get(Calendar.MONTH)+"월"+date.get(Calendar.DATE)+"일");
		
	}

}
