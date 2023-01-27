package chapter03;

// 추상 클래스 (우리가 만드는일은 거의 없고, 상속받아 사용하는 일이 많음)
// 클래스를 추상적으로만 표현해둔 클래스
// abstract 제어자를 포함
abstract class Animal2{
	String eyes;
	String ears;
	String legs;
	
	// 추상 메서드
	// 해당 메서드에 대해 선언만 해둔 메서드
	abstract void eat();
}

class Dog extends Animal2 {
	String tail;
	
	void eat() {
		System.out.println("사료를 먹습니다.");
	}
}

public class Abstract {

	public static void main(String[] args) {
		
//		Animal2 animal = new Animal2();
		Animal2 dog = new Dog();
		dog.eat();
		
		
		
		

	}

}
