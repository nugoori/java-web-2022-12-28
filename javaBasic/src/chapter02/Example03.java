package chapter02;

class MyMath {
	static double getEquilateralTriangleArea (double side) {
//		매개변수 검증
		if (side <= 0) {return 0;}
	
		double result = (Math.sqrt(3) / 4 ) * Math.pow(side , 2);
		return result;
	}
//	정삼각형의 높이를 구하는 메소드
	static double getEquilateralTriangleheight (double side) {
//		매개변수 검증
		if (side <= 0) {return 0;}
		
		double equilateralTriangleheight = (Math.sqrt(3) / 2) * side;
		return equilateralTriangleheight;
	}
	
	// 1증가 메소드
	static int increase (int number) {
		number++;
		System.out.println("In Of Method");
		System.out.println(number);
		return number;
	}
	
	static void increaseTriangle(Triangle triangle) {
		triangle.base++;
		triangle.height++;
		triangle.diagonal++;
	}
}

public class Example03 {

	public static void main(String[] args) {
		double side = 10.0;
		double equilateralTriangleArea = MyMath.getEquilateralTriangleArea(side);
		System.out.println(equilateralTriangleArea);
				
		double equilateralTriangleheight = MyMath.getEquilateralTriangleheight(-10);
		System.out.println(equilateralTriangleheight);
	
		int number = 10;
		int afterNumber = MyMath.increase(number);
		System.out.println("Out Of Method");
		System.out.println(number);
//		복사해서 넘어간 int 10을 메소드 실행 후의 값으로 받기위해 number를 바꿔줘야
		number = MyMath.increase(number);
	
//			 참조 변수는 메모리 주소를 가진다
		Triangle triangle = new Triangle();
		triangle.createAndPrint();
		System.out.println(triangle);
		
		MyMath.increaseTriangle(triangle);
		System.out.println(triangle.base);
		System.out.println(triangle);
	
	
	}

}
