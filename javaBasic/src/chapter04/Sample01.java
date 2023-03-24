package chapter04;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Sample01 {

	public static void main(String[] args) {
		
		Random random = new Random();
		// 로또 번호를 저장할 배열
		int[] lottoList1 = new int[6];
		
		for (int i = 0; i <= lottoList1.length; i++) {
			boolean flag = false;
			
			int lotto = random.nextInt(45) + 1;
			System.out.println("i : " + i);
			
			for (int j = 0; j < lottoList1.length; j++) {
				if (lottoList1[j] == lotto) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				i--;
				continue;
			}
				
			lottoList1[i] = lotto;
		}
		
		for (int lotto: lottoList1) System.out.println(lotto);
		
		System.out.println("========================================");
		
		Set<Integer> lottoList2 = new TreeSet<Integer>();
		while(lottoList2.size() < 6) {
			lottoList2.add(random.nextInt(45) + 1);
		}

		for (Integer lotto: lottoList2) System.out.println(lotto);
		
	}

}
