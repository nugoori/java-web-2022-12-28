package chapter05;

import java.util.ArrayList;
import java.util.List;

import chapter02.entity.Developer;

class MyInfo<JI, TMP> {
	String name;
	String job;
	// 직업의 정보
	JI jobInfo;
	TMP tmp;
	
	<T, TM> void getTmpList(List<T> list, TM tmp) {
		
	}
}

public class Example01 {

	@SuppressWarnings({ "removal", "rawtypes" })
	public static void main(String[] args) {
		// 제너릭
		// 다양한 타입을 다루는 클래스 혹은 메서드에서 타입을 지정해 주는 것
		List strList = new ArrayList();
		strList.add("기본 문자열");
		// 제너릭을 사용하지 않으면 매번 작업시 마다 형변환 작업을 진행해야 함
		String str = (String) strList.get(0);
		
		List<String> strList2 = new ArrayList<String>();
		strList2.add("기본 문자열");
		// 제너릭을 사용하면 이미 다루고자하는 데이터의 타입을 알고 있기 때문에
		// 형변환 작업이 필요 없음
		String str2 = strList2.get(0);
		
		MyInfo info1 = new MyInfo();
		info1.jobInfo = new Developer();
		Developer developer = (Developer) info1.jobInfo;
		
		MyInfo<Developer, Integer> info2 = new MyInfo<Developer, Integer>();
		info2.jobInfo = new Developer();
		Developer developer2 = info2.jobInfo;
		
		// 제너릭 클래스의 타입 변수는
		// 다형성이 적용되지 않기 때문에
		// 선언시 사용한 타입변수와 생성시 사용하는 타입변수가 같아야 함
		Object obj = new Developer();
		MyInfo<Object, Object> info3 = new MyInfo<Devloper, Integer>();
		
		// ? 키워드를 사용하여 타입변수의 다형성을 적용시킬 수 있음
		MyInfo<?, ?> info4 = new MyInfo<Developer, Integer>();
		info4.getTmpList(new ArrayList<Developer>(), new Integer(10));
	}

}










