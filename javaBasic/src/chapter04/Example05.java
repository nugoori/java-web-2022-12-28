package chapter04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Example05 {

	public static void main(String[] args) {
		// Set Interface
		Set<String> hashSet = new HashSet<String>();
		
		// set 구조에 데이터를 추가
		hashSet.add("apple");
		hashSet.add("carrot");
		hashSet.add("apple");
		hashSet.add("banana");
		hashSet.add("apple");
		
		// set은 순서가 없기 때문에 인덱스로 접근 불가능
		// set[0];
		// Iterator로 set 컬렉션에 접근
		Iterator<String> hashSetIterator = hashSet.iterator();
		
		// Iterator의 hasNext() 메서드로 다음 요소가 있으면 반복
		while(hashSetIterator.hasNext()) {
			// Iterator의 next() 메서드로 다음 요소를 가져옴
			System.out.println(hashSetIterator.next());
		}
		
		System.out.println("====================");
		
		Set<String> treeSet = new TreeSet<String>();

		treeSet.add("hello");
		treeSet.add("apple");
		treeSet.add("carrot");
		treeSet.add("apple");
		treeSet.add("banana");
		treeSet.add("apple");
		
		Iterator<String> treeSetIterator = treeSet.iterator();
		while(treeSetIterator.hasNext()) {
			System.out.println(treeSetIterator.next());
		}
		
		// size() 메서드로 길이 혹은 크기를 가져옴
		System.out.println(treeSet.size());
		
		// List Interface
		List<Integer> numbers = new ArrayList<Integer>(); 
		numbers.add(2);
		numbers.add(9);
		numbers.add(-1);
		numbers.add(50);
		
		// 특정한 위치에 특정 데이터를 넣음
		numbers.add(2, 100);
		// 특정한 위치에 데이터를 변경
		numbers.set(3, 1);
		// 특정한 위치에 있는 데이터를 제거
		numbers.remove(0);
		
		// List는 순서가 존재함
		for (Integer number: numbers) {
			System.out.println(number);
		}
		
		List<String> arrayList = new ArrayList<String>();
		List<String> linkedList = new LinkedList<String>();
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) arrayList.add(0, String.valueOf(i));
		long end = System.currentTimeMillis();
		System.out.println("ArrayList 작업 시간 : " + (end - start));
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) linkedList.add(0, String.valueOf(i));
		end = System.currentTimeMillis();
		System.out.println("LinkedList 작업 시간 : " + (end - start));
		
		// Map Interface
		Map<String, String> hashMap = new HashMap<String, String>();
		
		// hash map에 데이터를 추가할 땐 put!
		hashMap.put("key", "value");
		hashMap.put("name", "John doe");
		hashMap.put("address", "United State");
		
		// hash map 에서 특정한 키에 해당하는 값을 가져옴
		System.out.println(hashMap.get("name"));
		
		Set<String> keys = hashMap.keySet();
		Iterator<String> keyIterator = keys.iterator();
		
		while(keyIterator.hasNext()) {
			System.out.println(keyIterator.next());
		}
		
		if (hashMap.containsKey("age"))
			System.out.println(hashMap.get("age"));
		
	}

}









