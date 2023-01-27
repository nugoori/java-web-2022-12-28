package chapter01;

public class Example07 {

	public static void main(String[] args) {
		// 제어문 (반복) while
		boolean flag = true;
		int number = 0;
		
		while (flag) {
			System.out.println("Loop" + number);			
//			number = number + 1;
//			number += 1;
//			number++;
//     마지막 number에 증감 연산식
	
			
//			if (number == 10) {
//				flag = false;
//			}
			
			flag = ++number != 10;
		}
			
		System.out.println("flag : " + flag);
		// 제어문 (반복) do - while
		while (flag) {
			System.out.println("While Loop!");
		}
		
		do {
			System.out.println("Do While Loop!");
		} while (flag);
		
		System.out.println("-------------");
		
		// continue, break (종종 쓰임)
		number = 0;
		while (true) {
			if (number % 3 == 0) {                 // continue 조건검사 조건을 변경해야 무한루프에 빠지지 않는다
				number++;
				System.out.println("Continue!");
				continue;
			}
			if (number > 10) {
				System.out.println("Break!");
				break;
			}			
			System.out.println(number++);
			}
		
			System.out.println("Out of Loop");
		
	}

}
