package chapter04;

import java.util.Random;

public class Example03 {
	public static void main(String[] args) {
		// Wrapper 클래스
		// 기본 데이터 타입을 클래스를 이용해서 객체로 다룸
		
		// int -> Integer
		Integer integer = 100;
		
		// 기본 타입일 경우 객체형의 문자열로 변경 불가능
		// int number = 100;
		// String numberStr = number;
		
		// Wrapper Class로 작성된 형태는 문자열로 변경 가능
		String numberStr = integer.toString();
		System.out.println(numberStr);
		
		// 기본 타입일 경우 null로 초기화가 불가능
		// int number = null;
		
		// Wrapper Class로 작성된 형태는 null로 초기화가 가능
		Integer number = null;
		int i = integer.intValue();
		double d = integer.doubleValue();
		
		// Random Class
		// 무작위의 int, long, boolean, float, double 값을 가져오는 Java API Class
		Random random = new Random();
		
		int rdInt = random.nextInt();
		System.out.println(rdInt);
		rdInt = random.nextInt(5) + 10;
		System.out.println(rdInt);
	}
}






