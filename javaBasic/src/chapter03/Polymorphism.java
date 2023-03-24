package chapter03;

class Animal {
	String ears;
	String eyes;
	String legs;
}

class Bird extends Animal {
	String wings;
}

class Monkey extends Animal {
	String arms;
	
	Monkey() {}
	
	Monkey(String arms, String eyes, String ears, String legs) {
		// super : 상위 클래스
		super.ears = ears;
		super.eyes = eyes;
		super.legs = legs;
		// this : 자기 자신
		this.arms = arms;
	}
}

public class Polymorphism {
	
	public static void main(String[] args) {
		
		Animal bird = new Bird();
		bird.ears = "ear";
		bird.eyes = "eye";
		bird.legs = "leg";
		// bird.wings = "wing";
		
		Bird bird2 = (Bird) bird;
		bird2.wings = "wing";
		
		Monkey monkey1 = new Monkey("arm", "eye", "ear", "leg");
		System.out.println(monkey1);
		System.out.println(monkey1.arms + monkey1.eyes + monkey1.ears + monkey1.legs);
		
		Animal animal1 = monkey1;
		System.out.println(animal1);
		System.out.println(animal1.eyes + animal1.ears + animal1.legs);
		
		System.out.println(animal1 instanceof Monkey);
		System.out.println(animal1 instanceof Animal);
		
		Monkey monkey2 = (Monkey) animal1;
		System.out.println(monkey2);
		System.out.println(monkey2.arms + monkey2.eyes + monkey2.ears + monkey2.legs);
	}
	
}








