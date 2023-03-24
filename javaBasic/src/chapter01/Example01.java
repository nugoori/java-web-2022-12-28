package chapter01;

import java.util.Scanner;

public class Example01 {

	public static void main(String[] args) {
		// 데이터 타입
		
		// 정수형 타입
		// byte (1 byte), short (2 byte), int (4 byte), long (8 byte)
		byte b1 = 0;
		byte b2 = 127;
		byte b3 = -128;
		
		short s1 = 128;
		short s2 = 32767;
		short s3 = -32768;
		
		int i1 = 32768;
		int i2 = 2_147_483_647;
		int i3 = -2_147_483_648;
		
		long l1 = 2_147_483_648L;
		
		// 실수 타입
		// float (4 byte), double (8 byte)
		float f1 = 3.1415F;
		double d1 = 3.1415;
		
		// 논리 타입
		// boolean (1 byte)
		boolean bool1 = true;
		boolean bool2 = false;
		
		// 문자 타입
		// char (2 byte)
		char c1 = 'a';
		char c2 = 97;
//		char c3 = 'abc';
//		System.out.println(c1);
//		System.out.println(c2);
		
		// 입력 (System.in)
		// java.util.Scanner Scanner 객체
//		Scanner sc = new Scanner(System.in);
//		int inputNumber = sc.nextInt();
//		System.out.println(inputNumber);
//		long inputCharacter = sc.nextLong();
//		System.out.println(inputCharacter);
		
		// 형변환
		// 묵시적 (자동) 형변환
		byte by1 = 100;
		int number1 = by1;
		System.out.println(number1);
		
		float float1 = number1;
		System.out.println(float1);
		
		// 명시적 (강제) 형변환
		// 사이즈(byte)가 큰 변수에서 작은 변수로 데이터를 저장할 때
		int number2 = 1000;
		byte by2 = (byte) number2;
		System.out.println(by2);
		
	}

}




