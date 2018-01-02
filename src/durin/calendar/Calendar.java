package durin.calendar;

public class Calendar {

	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int maxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	/**
	 * 월을 입력하면 해당월의 달력을 출력한다 달력의 모양은 1단계에서 작성한 모양으로 만든다 1일은 일요일로 정해도 무방하다 -1을
	 * 입력받기 전까지 반복입력반든다 -프롬프트 출력
	 */

	public void printCalendar(int year, int month, int weekday) {
		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println("    일    월    화   수    목    금    토");
		System.out.println("---------------------");

		
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
}
