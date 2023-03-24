package chapter03;

// public : 클래스, 메서드 주로 사용
// private : 멤버 변수 주로 사용
public class Modifier {

	private String name;
	private String address;
	private String telNumber;
	
	// private으로 선언된 멤버변수를 초기화하기 위한
	// 첫번째 방법 : 생성자를 이용
	// 생성자를 이용한 방법은 인스턴스를 생성할 때만 멤버 변수를 초기화
	public Modifier (String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	// 두번째 방법 : Setter 메서드들 이용
	public void setName(String name) {
		this.name = name;
	}
	
	// 외부에서 멤버변수에 접근하기 위한 방법
	// Getter 메서드를 이용
	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Modifier(String name, String address, String telNumber) {
		this.name = name;
		this.address = address;
		this.telNumber = telNumber;
	}
	
}





