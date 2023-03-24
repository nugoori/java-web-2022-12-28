package chapter02.entity;

public class People {
	String name;
	String gender;
	int age;
	String address;
	String email;
	
	People(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	void eatBreakfast() {
		System.out.println("7시에 아침 밥을 먹습니다.");
	}
}
