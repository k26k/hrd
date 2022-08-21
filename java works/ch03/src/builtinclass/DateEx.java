package builtinclass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date();
		System.out.println(today);
//		Tue Jun 28 10:07:00 KST 2022
//		요일 월 일 시:분:초 기준표준시 연도
		
//		SimpleDateFormat 클래스 날짜/시간 형식
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date.format(today));

		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		System.out.println(time.format(today));
		
//		LocalDate 클래스 사용
		LocalDate localD = LocalDate.now();
		System.out.println(localD);
		
//		LocalDate 클래스 사용
		LocalTime localT = LocalTime.now();
		System.out.println(localT);
		
//		DateTimeFormatter 클래스 사용
		LocalDateTime localDT = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
		System.out.println(localDT.format(myFormat));
		
	}

}
