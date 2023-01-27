package chapter02.entity;

public class People {
	public String name;
	String gender; 
	int age;
	String adress;
	String email;
	
	People(String name, String gender){
		this.name = name;
		this.gender = gender;
	}
	
	public void eatBreakfast() {
		System.out.println("7시에 아침을 먹습니다.");
	}
}
