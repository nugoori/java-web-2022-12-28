package chapter02;

class Triangle {
//	인스턴스 변수
//	밑변
	double base;
//	높이
	double height;
//	대각선
	double diagonal;
	
	void createAndPrint() {
		base = 3;
		height = 4;
		diagonal = 5;
		
		System.out.println("base : " + base + " / height : " + height + " / diagonal : " + diagonal);
	}
}

class Pythagoras {
//	클래스 변수
	static String creater = "Pythagoras";

//	인스턴스 메소드 / 클래스 메소드
//	대각선 길이를 구하는 공식
	static double getDiagonal(double base, double height) {
		return Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
	}
//	밑변의 길이를 구하는 공식
	static double getBase(double diagonal, double height) {
		return Math.sqrt(Math.pow(diagonal, 2) - Math.pow(height, 2));
	}
//	높이의 길이를 구하는 공식
	static double getHeight(double diagonal, double base) {
		return Math.sqrt(Math.pow(diagonal, 2) - Math.pow(base, 2));
	}
	
}

public class Example02 {

	public static void main(String[] args) {
//		객체 배열
		SmartPhone[] phones = new SmartPhone[3];
		
//		초기화 작업
		for (int i = 0; i < phones.length; i++) {
			System.out.println(phones[1]);
			phones[i] = new SmartPhone();
		}
		
			System.out.println("========");
			System.out.println(phones);
			System.out.println("========");
		
		for (SmartPhone phone : phones) {
			System.out.println(phone);
			phone.nation = "United States";
			phone.os = "iOS";
			phone.owner = "Jhon";
			phone.telNumber = "010-1111-1111";
		}
		
			System.out.println("========");
		for (SmartPhone phone : phones) {
			System.out.println(phone.nation);
			System.out.println(phone.os);
			System.out.println(phone.owner);
			System.out.println(phone.telNumber);
//			return;
		}
			System.out.println("========");
		
//			p
//			밑변
			int a = 10;
//			높이
			int b = 20;
//			대각선
			int c = 30;
			

//			Math.pow() : 거듭제곱
//			Math.sqrt()	: 제곱근
//			대각선의 길이
			double r1 = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
//			밑변의 길이
			double r2 = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
//			높이의 길이
			double r3 = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
			
			Pythagoras p = new Pythagoras();
//			p.base = 10;
//			p.height = 20;
//			p.diagonal = 30;
			
//			double diagonal = p.getDiagonal();
			System.out.println(p.creater);
			p.creater = "Newton";
			System.out.println(p.creater);
			
			Pythagoras p2 = new Pythagoras();
			System.out.println(p2.creater);
			
			System.out.println(Pythagoras.creater);
			
			System.out.println(Pythagoras.getDiagonal(3, 4));
			
//			삼각형 인스턴스
			Triangle triangle1 = new Triangle();
//			Triangle 인스턴스를 초기화 하고 출력 -> 여러개를 만들면 중복된 코드가 인스턴스 갯수만큼 생성됨
			triangle1.base = 3;
			triangle1.height = 4;
			triangle1.diagonal = 5;
			
			System.out.println("base : " + triangle1.base);
			System.out.println("height : " + triangle1.height);
			System.out.println("diagonal : " + triangle1.diagonal);
			System.out.println("---------");
			
//			그냥 변수와 참조변수의 차이 :
//			삼각형 인스턴스 생성
			Triangle triangle6 = new Triangle();
			Triangle triangle7 = new Triangle();
			Triangle triangle8 = new Triangle();
			Triangle triangle9 = new Triangle();
			Triangle triangle10 = new Triangle();
//			메소드 사용
			triangle6.createAndPrint();
			triangle7.createAndPrint();
			triangle8.createAndPrint();
			triangle9.createAndPrint();
			triangle10.createAndPrint();
			
			
			
	}

}
