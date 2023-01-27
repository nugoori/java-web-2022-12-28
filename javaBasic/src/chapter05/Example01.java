package chapter05;

import java.util.ArrayList;
import java.util.List;

import chapter02.entity.Developer;

class MyInfo<I, TMP> {	
	String name;
	String job;
	// 직업의 정보 받기
	I jobInfo;
	TMP tmp;
	
	<T, TM> void getTmpList(List<T> list, TM tmp) {
		
	}
}

public class Example01 {

	public static void main(String[] args) {
	// 제너릭
	// 다양한 타입을 다루는 클래스 혹은 메서드에서 타입을 지정해 주는 것
	List strList = new ArrayList();
	strList.add("기본 문자열");
	// 제너릭을 사용하지 않으면 작업마다 형변환 작업을 진행 해야 함
	String str = (String) strList.get(0); // 다형성 떄문에 강제 형변환을 해줘야함 >>> 제너릭 사용으로 쉽게 가능
	
	List<String> strList2 = new ArrayList<String>();
	strList2.add("기본 문자열");
	// 제너릭을 사용하면 다루고자 하는 데이터의 타입을 이미 알고있기 때문에 형변환 작업이 필요없음
	String str2 = strList2.get(0);
	
	MyInfo info1 = new MyInfo();
	info1.jobInfo = new Developer();
	Developer developer = (Developer) info1.jobInfo;
	
	MyInfo<Developer, Integer> info2 = new MyInfo<Developer, Integer>(); // I 타입 = Developer ? 제네릭 에 타입변수를 추가로 넣르면 사용할 때 모두 적어야 함
	info2.jobInfo = new Developer();
	Developer developer2 = info2.jobInfo;
	
	Object obj = new Object(); // 원시타입은 클래스이기 때문에 다형성이 적용됨
	MyInfo<Object, Object> info3 = new MyInfo<Developer, Integer>(); // 제네릭 타입변수는 다형성이 적용 되지 않음 > 선언시 사용한 타입변수와 사용하는 타입 변수가 같아야함
	
	// ? 키워드를 사용하여 타입변수에 다형성을 적용 시킬 수 있음
	MyInfo<? , ?> info4 = new MyInfo<Developer, Integer>();
	info4.getTmpList(new ArrayList<Developer>(), new Integer(10));
	
	
	
	
	}
}
