package durin.calendar;

import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int maxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}
	
	/**
	 * 월을 입력하면 해당월의 달력을 출력한다
	 * 달력의 모양은 1단계에서 작성한 모양으로 만든다
	 * 1일은 일요일로 정해도 무방하다
	 * -1을 입력받기 전까지 반복입력반든다
	 * -프롬프트 출력
	 */

	public void printSampleCode() {
		System.out.println("일   월   화   수   목   금   토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {

		
		
		for(;;){
		
		System.out.println("\n월을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		if(month==-1){
			break;
		}
		
		Calendar cal = new Calendar();
		int maxDay = cal.maxDaysOfMonth(month);
		
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("---------------");
		for(int i = 1; i<=maxDay; i++){
		System.out.print(i+" ");
		if((i%7)==0){
		System.out.println();	
		}
		
		}
		
		}
		System.out.println("Bye~");
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	String prompt = "cal> ";
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		
		System.out.println("반복횟수를 입력하세요.");
		
		int repeat = sc.nextInt();

		for(int i = 0; i<repeat; i++){
			System.out.println("달을 입력해");
			System.out.print(prompt);
			int month = sc.nextInt();
			if(month == -1){
				break;
			}
			else if(month > 12){
				System.out.println("1~12월범위");
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n",month, cal.maxDaysOfMonth(month));
		}
		System.out.println("Bye~");
		sc.close();*/
		
		
/*		int repeat = sc.nextInt();

		Calendar cal = new Calendar();
		// cal.printSampleCode();

		int[] arr = new int[repeat];

		System.out.println("월을 입 력하세요");
		for (int i = 0; i < repeat; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			int maxDay = cal.maxDaysOfMonth(arr[i]);
			System.out.printf("%d월은 %d일까지 입니다\n", arr[i], maxDay);
		}
		
		*/
		
	}
}
