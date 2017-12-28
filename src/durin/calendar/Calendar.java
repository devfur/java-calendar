package durin.calendar;

import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS =  {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int maxDaysOfMonth(int month){
		
		return MAX_DAYS[month-1];
	}
	
	
	public void printSampleCode(){
		System.out.println("일   월   화   수   목   금   토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	
	public static void main(String[] args) {
		Calendar cal = new Calendar();

		cal.printSampleCode();
		
		System.out.println("숫자 하나 입력해");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		sc.close();
		
		int maxDay = cal.maxDaysOfMonth(month);
		
		
		System.out.printf("%d월은 %d일까지 입니다", month, maxDay);
		
		
	}
}
