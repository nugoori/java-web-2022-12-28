package chapter02;

import chapter02.entity.BusDriver;
// control shift o
import chapter02.entity.Developer;
import chapter02.entity.Police;

import chapter02.entity.*;

// 상속을 사용하는 이유
public class Example06 {

	public static void main(String[] args) {
		
		Developer developer = new Developer("John doe", "man", "Google");
		Police police = new Police();
		BusDriver busDriver = new BusDriver();
		
		// 참조형 변수에서 데이터가 미정인 상태일 떄 null
//		developer = null;
		
		developer.languageSkill = "";
		System.out.println(developer.name);
		
		developer.eatBreakfast();
		developer.eatBreakfast(11);
		police.eatBreakfast();
		busDriver.eatBreakfast();
		
	
		

	}

}






