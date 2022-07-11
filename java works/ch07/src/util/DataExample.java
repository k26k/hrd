package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DataExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date now = new Date();
		System.out.println(now);
		
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM일 dd일");
		
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		
	}

}
