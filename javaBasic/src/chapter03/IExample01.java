package chapter03;

// 인터페이스
// 추상도가 가장 큰 설계도
// 일반 메섣드, 멤버변수는 사용 불가능
// static final로 선언된 상수/  abstract로 선언된 추상 메소드만 가질 수 있음
interface IExample01 {
	
	// 인스턴스에는 static final로 선언된 상수 만 선언 가능
	public static final int NUMBER = 0;
	
	// 인터페이스에는 추상 메서드만 선언 가능
	void hello();
}

interface IExample03 {
	public static final String STRING = "string";
}

// 인터페이스의 상속
// 인터페이스 간의 상속은 extends 키워드를 사용
// 인터페이스는 다중 상속이 가능
interface IExample02 extends IExample01, IExample03 {
	
	public static final double DECIMAL = 10.5;
}

// 인터페이스 구현
// 인터페이스를 클래스에 구현 할 때는 implements 키워드를 사용

class Example implements IExample02 {
	
	int index;
	
	// 인터페이스에 작성된 추상 메서드는 반드시 모두 구현해야함
	public void hello() {
		System.out.println("hello");		
	}	
}
class Example2 implements IExample02{

	@Override
	public void hello() {
		System.out.println();		
	}	
}

class Example03 {
	public static void main(String[] args) {
		IExample02 exem1 = new Example();
		IExample02 exem2 = new Example2();
	}
}












