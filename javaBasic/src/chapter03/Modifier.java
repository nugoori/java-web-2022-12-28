package chapter03;

// public : 클래스, 메소드에 주로 사용
// private : 맴버 변수에 주로 사용
public class Modifier {

	private String name;
	private String adress;
	private String telNumber;
	
	// private으로 선언된 멤버 변수를 초기화 하기 위한 방법
	// 1. 생성자를 이용
	// 생성자를 이용한 방법은 인스턴스를 생성할 떄만 멤버 변수를 초시화 가능 (변수 추가가 힘듦?)
	public Modifier(String name, String adress) {
		this.name = name;
		this.adress = adress;
	}
	
	// 2. Setter 메서드를 이용 **
	public void setName(String name) {
		this.name = name;
	}
	
	// 외부에서 멤버변수에 접근하기 위한 방법
	// Getter 메서드를 이용
	public String getName() {
		return this.name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Modifier(String name, String adress, String telNumber) {
//		super();
		this.name = name;
		this.adress = adress;
		this.telNumber = telNumber;
	}
	
	
	
	
	
	
}



