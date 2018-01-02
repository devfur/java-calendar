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

	public void printCalendar(int year, int month, String day) {
		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println("    일    월    화   수    목    금    토");
		System.out.println("---------------------");

		int maxDay = maxDaysOfMonth(year, month);
		int[] days = new int[31];

		for (int i = 1; i <= maxDay; i++) {
			days[i - 1] = i;
		}

		int how = 0;
		if ("MO".equals(day)) {
			how = 1;
		} else if (("TU").equals(day)) {
			how = 2;
		} else if (("WE").equals(day)) {
			how = 3;
		} else if (("TH").equals(day)) {
			how = 4;
		} else if (("FR").equals(day)) {
			how = 5;
		}

		for (int k = 1; k <= how; k++) {
			System.out.printf("%3s", "-");
		}

		int cnt=how;
		for (int j = 0; j < maxDay; j++) {
			System.out.printf("%3d", days[j]);
			cnt++;
			if (j < 7-how && j > 0 && j % (6 - how) == 0) {
				System.out.println();
			}
			else if(j >0 && cnt%7==0){
				System.out.println();
			}
			
			

		}

		System.out.println();
	}

}
