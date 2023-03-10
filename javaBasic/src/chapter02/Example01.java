package chapter02;

// class : 객체를 생성하는 설계도 / 기준
class SmartPhone {
	
	// 멤버 변수
	String nation;
	String os;
	String owner;
	String telNumber;
	
	// 메서드
	void tel(String toTellNumber) {
		// 전화번호가 빈값이면 '전화번호룰 입력하세요.'
		if (toTellNumber.isEmpty()) {
			System.out.println("전화번호를 입력하세요.");
			return;
		}
		// 빈값이 아니면 'toTellNumber에 전화중입니다.'
			System.out.println(toTellNumber + " toTellNumber에 전화중입니다.");
	}
	
	void sendMessage(String toTellNumber, String message) {
		System.out.println(toTellNumber + "에 " + message + "를 보냅니다.");
	}
}

public class Example01 {

	public static void main(String[] args) {
		
		// 인스턴스 선언 및 생성
		SmartPhone myPhone;
		myPhone = new SmartPhone();
		
		SmartPhone yourPhone = new SmartPhone();

		System.out.println(myPhone);
		System.out.println(yourPhone);
		
//		인스턴스의 속성(멤버 변수)에 '접근'
		myPhone.nation = "Korea";
		myPhone.os = "android";
		myPhone.owner = "서지훈";
		myPhone.telNumber = "010-7777-7777";
		
		System.out.println(myPhone.nation);
		System.out.println(myPhone.os);
		System.out.println(myPhone.owner);
		System.out.println(myPhone.telNumber);
		
//		인스턴스의 기능을 사용(메서드를 '호출')
		myPhone.tel("");
		
//		String hisPhone = new SmartPhone();   타입일치
//				   새 참조변수
		SmartPhone hisPhone = new SmartPhone();
		yourPhone.nation = "United State";
		
		System.out.println("======");
		System.out.println("yourPhone" + yourPhone);
		System.out.println("hisPhone" + hisPhone);
		hisPhone = yourPhone; // 인스턴스 자체가 교체되는것이 아니라 주소가 복사되어 들어감
		System.out.println("yourPhone" + yourPhone);
		System.out.println("hisPhone" + hisPhone);
		System.out.println("======");
		
		System.out.println(hisPhone.nation);
		
//		참조 변수(his phone)가 바라보는 주소가 바뀜
		yourPhone.nation = "United Kingdom";
		System.out.println(hisPhone.nation);
		
		int a = 10;
		int b = a;
		
		System.out.println(b);
		a = 12;

		
		
	}

}
