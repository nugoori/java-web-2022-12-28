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
	
	// 생성자
	Monkey(String arms, String eyes, String ears, String legs) {
		super.ears = ears;
		super.eyes = eyes;
		super.legs = legs;
		this.arms = arms;
	}
}


public class Polymorphism {
	public static void main(String[] args) {
		Animal bird = new Bird();
		bird.ears = "ear";
		bird.eyes = "eye";
		bird.legs = "leg";
		// bird.wings = "wing"; bird는 Animal타입이기 때문에 Bird타입인 wings를 볼 수 없음
		
		Bird bird2 = (Bird) bird;
		bird2.ears = "ear";
		bird2.eyes = "eye";
		bird2.legs = "leg";
		bird2.wings = "wing";
		
		Monkey monkey1 = new Monkey("arms", "eyes", "ears", "legs");
		System.out.println(monkey1);
		System.out.println(monkey1.arms +  monkey1.eyes + monkey1.ears + monkey1.legs );
		
		Animal animal1 = monkey1;
		System.out.println(animal1);
		System.out.println(animal1.eyes + animal1.ears + animal1.legs );
		
		System.out.println(animal1 instanceof Monkey);
		System.out.println(animal1 instanceof Animal);
		
		// 보는 타입(방법)이 달라진다고 데이터가 사라지는게 아님!
		Monkey monkey2 = (Monkey) animal1;
		System.out.println(monkey2);
		System.out.println(monkey2.arms +  monkey2.eyes + monkey2.ears + monkey2.legs );
		
		
		
		
		
	}
	
}
