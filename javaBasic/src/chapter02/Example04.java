package chapter02;

class Manufacturer {
	// 제조사명
	String name;
	// 제조사 국가
	String country;
	// 제조사 홈페이지 주소
	String webUrl;
	
	void print() {
		System.out.println("name : " + name + " / country : " + country + " / webUrl : " + webUrl);
		print();
	}
}

class Car {
	// 제조사
	Manufacturer manufacturer;
	// 외장컬러
	String exteriorColor;
	// 내장컬러
	String interiorColor;
	// 모델명
	String modelName;
	
	Manufacturer createManufacturer(String name, String country, String webUrl) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.name = name;
		manufacturer.country = country;
		manufacturer.webUrl = webUrl;
		
		System.out.println(manufacturer);
		
		return manufacturer;
	}
}

public class Example04 {

	public static void main(String[] args) {
		Car myCar = new Car();
		Manufacturer manufacturer = myCar.createManufacturer("Hyundai", "Korea", "hyundai.com");
		System.out.println("==========");
		System.out.println(manufacturer);
		System.out.println(manufacturer.name);
		System.out.println("==========");
		manufacturer.print();
	}

}




