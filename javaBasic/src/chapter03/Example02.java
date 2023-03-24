package chapter03;

// 제어자
// - 클래스, 변수, 메서드의 선언부에 함께 사용되는 부가적인 조건
// 1. 접근 제어자
//    - public, protected, default(package), private 
// 2. 일반 제어자
//    - static, final, abstract, synchronized...
public abstract class Example02 {
	
	// 접근 제어자를 사용하는 이유
	// 캡슐화
	// 1. 외부로부터 데이터를 보호하기 위한 용도
	// 2. 외부에서 불필요한, 내부적으로만 사용되는 부분을 감추기 위함
	
	// public 접근 제어자
	// 프로젝트 어디서든 접근이 가능하도록 함
	public int number1;
	
	// protected 접근 제어자
	// 같은 패키지 내에 있거나 해당 클래스를 상속받은 sub 클래스에서만 접근이 가능
	protected int number2;
	
	// default(package) 접근 제어자
	// 같은 패키지 내에서만 접근이 가능
	int number3;
	
	// private 접근 제어자
	// 같은 클래스 내에서만 접근이 가능
	private int number4;
	
	// static, final
	// static 제어자 : 해당 멤버변수와 메서드를 클래스 단위로 관리하기 위한 용도
	// final 제어자 : 초기화 이후 값을 변형시키지 않고자 할 때 사용
	static final int NUMBER_5 = 10;
	
	// abstract 제어자
	// 메서드를 선언부만 작성하고 실제 구현부는 상속받는 클래스가 구현하고자 할 때
	// 클래스, 메서드에서만 사용가능
	// 만약 abstract 제어자가 붙은 method가 있다면
	// 반드시 class에 abstract 제어자가 존재해야 함
	abstract void abstractMethod();
	
	// 제어자를 조합할 때 주의할 사항
	// 메서드에 static과 abstract를 동시에 사용할 수 없음
	// 클래스에 final과 abstract를 동시에 사용할 수 없음
	// abstract 메서드의 접근제어자는 private일 수 없음
	// final과 private은 동시에 사용할 필요가 없음

	public static void main(String[] args) {
		
		// Modifier 클래스의 경우 public으로 선언되었기 때문에
		// 모든 위치에서 사용 가능
		Modifier modifier = new Modifier("John doe", "Busan");
		
		modifier.setName("James");
		modifier.getName();
		
		// The field Modifier.name is not visible
		// Modifier 클래스의 멤버 변수들을 private으로 선언했기 때문에
		// 클래스 외부에서 접근이 불가능
//		modifier.name;
		
	}

}




