package chapter05;

class SuperClass {
	void superMethod() {
		System.out.println("조상 메서드");
	}
}

class SubClass extends SuperClass {

	@Override
	void superMethod() {
		System.out.println("자손 메서드");
	}
}

public class Example02 {
	// 열거형
	enum EXAMPLE_ENUM {FIRST(0), SECOND(1), THIRD(2);

		EXAMPLE_ENUM(int i) {
		
		}
	};
	final int FIRST = 0;
	final int SECOND = 1;
	final int THIRD = 2;

	public static void main(String[] args) {
		
		System.out.println(EXAMPLE_ENUM.THIRD);
		
		
		
		
		
		
		

	}

}
