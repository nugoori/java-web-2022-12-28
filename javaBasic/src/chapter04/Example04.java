package chapter04;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

class Batch1 extends TimerTask {

	@Override
	public void run() {
		System.out.println("Batch1 동작");
	}
	
}

class Batch2 extends TimerTask {

	@Override
	public void run() {
		System.out.println("Batch2 동작");
	}
	
}

public class Example04 {

	public static void main(String[] args) {
		// 시스템 시간
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		
		// Calendar class
		// 날짜 관련된 java.util package
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = new GregorianCalendar();
		
		System.out.println(calendar1.toString());
		
		// 연도
		System.out.println(calendar1.get(Calendar.YEAR));
		// 월 (Calendar 클래스는 1월 = 0)
		System.out.println(calendar1.get(Calendar.MONTH));
		// 일
		System.out.println(calendar1.get(Calendar.DATE));
		// 요일 (일요일: 1, 월요일: 2, ... 토요일: 7)
		System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));
		
		calendar2.set(2022, 11, 25);
		System.out.println(calendar2);
		
		// 밀리초 단위를 시간, 분, 초
		int millToHours = 32400000 / (60 * 60 * 1000);
		System.out.println(millToHours);
		
		// java.util package의 Date 클래스
		Date date = new Date();
		
		// java.text package의 SimpleDateFormat 클래스
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd. MM. yyyy. HH:mm");
		
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		
		// Date 클래스와 Calendar 클래스의 단점을 보완한
		// java.time package의 클래스
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.toString());
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime.toString());
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.toString());
		
		LocalDateTime localDateTimeOf = LocalDateTime.of(2022, 12, 25, 8, 20);
		System.out.println(localDateTimeOf.toString());
		
		System.out.println(localDateTime.getMonth());
		System.out.println(localDateTime.getDayOfWeek());
		
		localDateTime.minusYears(10).plusMonths(5);
		
		// TimerTask
		Batch1 batch1 = new Batch1();
		Batch2 batch2 = new Batch2();
		
		Timer timer = new Timer(true);
		
		timer.schedule(batch1, 5000);
		timer.schedule(batch2, 3000);
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		// Decimal Text Format
		DecimalFormat decimalFormat = new DecimalFormat("$##,###.00");
		System.out.println(decimalFormat.format(50000.55));
		
	}

}









