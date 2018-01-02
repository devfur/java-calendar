package durin.calendar;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calendar {

	private final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap<Date, String> planMap;

	public Calendar(){
		planMap = new HashMap<Date, String>();
	}
	
	/**
	 * 
	 * @param date ex:"2017-06-20""
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan) throws ParseException{
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		planMap.put(date, plan);
	}
	
	public String searchPlan(String strDate) throws ParseException{
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date); 
		return plan;
	}
	
	public boolean isLeapYear(int year) {

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int maxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}

	/**
	 * 월을 입력하면 해당월의 달력을 출력한다 달력의 모양은 1단계에서 작성한 모양으로 만든다 1일은 일요일로 정해도 무방하다 -1을
	 * 입력받기 전까지 반복입력반든다 -프롬프트 출력
	 */

	public void printCalendar(int year, int month) {
		System.out.printf("     <<%d년 %d월>>\n", year, month);
		System.out.println("    일    월    화   수    목    금    토");
		System.out.println("---------------------");

		
		
		//get weekday automatically
		int weekday = getWeekDay(year, month, 1);
		
		//print blank space
		for(int i = 0; i < weekday; i++){
			System.out.print("   ");
		}
		
		int maxDay = maxDaysOfMonth(year, month);

		
		int count = 7 -weekday;
		int delim = (count < 7) ? count : 0;
		
		//print first line
		for(int i = 1; i <= count; i++){
			System.out.printf("%3d", i);
		}

		System.out.println();
		
		//print from second line to last
		count++;
		for (int i = count; i <=maxDay; i++) {
			System.out.printf("%3d", i);
			if(i%7==delim){
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();
	}

	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; //1970/JAN/1st =  Thursday
		
		int count = 0;
		for(int i = syear; i < year; i++){
			int delta = isLeapYear(i) ? 366: 365 ;
			count += delta;
		}
//		System.out.println(count);
		for(int i = 1; i < month; i++){
			int delta = maxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day - 1;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7 ;
		return weekday;
	}
	
	//simple test code here
	public static void main(String[] args) throws ParseException {
		Calendar c = new Calendar();
		c.getWeekDay(1970, 1, 1);
		c.getWeekDay(1971, 5, 1);
		c.getWeekDay(1972, 5, 1);
		c.getWeekDay(1973, 5, 1);
		
		c.registerPlan("2017-06-23", "Let's eat beef!");
//		System.out.println(c.searchPlan("2017-06-23").equals("Let's eat beef!"));
	}
	
	
	
	
}
