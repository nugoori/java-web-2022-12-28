package chapter04;

import java.util.Scanner;

public class Example01 {
			                         // 예외 던지기 *
	static void printArray(int index) throws Exception {
		int[] array = new int[] {1, 2, 3};
		System.out.println(array[index]);
	}

	public static void main(String[] args) {
		// 예외 처리 *
		// 컴파일이나 메모리 공간 부족 등 개발자가 코드상으로 조치를 취할 수 없는 에러가 아니라
		// 예측하고 처리 할 수 있는 문제
		
		// 0으로 나누는 상황
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		
		// 예외 처리
		try {
			// 예외가 발생 할 수 있는 로직
			int result = 10 / a;
			System.out.println(result);
		} catch (Exception e) {
			// try 구문에서 예외가 발생 했을 때 실행하는 로직
			System.out.println("0으로 나눌 수는 없습니다.");
		}
		
		
		// 배열 인덱스 조회 시 범위를 벗어난 경우
		int[] array = new int[] {1, 2, 3};
//		array[a] = 10;
		
		// 예외 처리
		try {
			for (int i = 0; i < array.length; i++) {
				if (array[i] > array[i + 1]) {
					System.out.println("앞의 수가 큽니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); //에러 코드 출력
		} finally {
			System.out.println("정상 종료");
		}
		
		try {
			printArray(a);
		} catch (Exception e) {
			System.out.println("인덱스 범위 밖입니다.");
		}
		
		
		
		
		
		
		
		
		
	}

}
