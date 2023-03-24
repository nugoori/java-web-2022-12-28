package chapter01;

public class Example06 {

	public static void main(String[] args) {
		// 제어문 (반복문) for
		int a = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		System.out.println("==========");
		for (int x = 0; x < numbers.length; x++) {
			System.out.println(numbers[x]);
		}

		System.out.println("==========");
		System.out.println("==========");
		
		for (int number : numbers) {
			System.out.println(number);
		}
		
//		System.out.println(numbers[0]);
//		System.out.println(numbers[1]);
//		System.out.println(numbers[2]);
//		System.out.println(numbers[3]);
//		System.out.println(numbers[4]);
	}

}
