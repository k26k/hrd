package builtinclass;

import java.util.Calendar;

public class PassedTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getInstance로 인스턴스를 받아와 Calendar 객체 생성
		Calendar startDay = Calendar.getInstance();
		Calendar toDay = Calendar.getInstance();
		
//		객체 값 설정
		startDay.set(2022, 5, 9);
		System.out.println(startDay.get(Calendar.YEAR)+"년"+startDay.get(Calendar.MONTH)+"월"+startDay.get(Calendar.DATE)+"일");

//		객체 값 설정
		toDay.set(2022, 6, 29);
		System.out.println(toDay.get(Calendar.YEAR)+"년"+toDay.get(Calendar.MONTH)+"월"+toDay.get(Calendar.DATE)+"일");
		
//		지난 시간 = 현재 시간 - 시작 시간
		long passedTime = toDay.getTimeInMillis()-startDay.getTimeInMillis();
//		밀리초 출력후 환산 출력
		System.out.println(passedTime+"밀리초");
		System.out.println((passedTime/(1000*60*60*24))+"일");
		
	}

}
