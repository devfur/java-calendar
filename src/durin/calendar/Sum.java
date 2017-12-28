package durin.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		//입력: 키보드로 두 수의 입력을 받는다.
		//출력: 화면에 두 수의 합을 출력한다.
		
		System.out.println("두 수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int a, b;
		String s1 = sc.next();
		String s2 = sc.next();
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		
		System.out.println("두 수의 합은 "+ (a+b));
		System.out.printf("%d와 %d의 합은 %d입니다", a, b , a + b);
		sc.close();
	}
}
