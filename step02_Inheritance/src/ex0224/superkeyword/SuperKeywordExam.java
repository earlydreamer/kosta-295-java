package ex0224.superkeyword;

class Animal{
	int age = 0;
	String bodyColor;
	
	public void sound() {
		System.out.println("super.sound");	
	}
	
	public void eat() {
	System.out.println("super.eat");
		
	}
		
	Animal(){
		
	}
}

class Cat extends Animal{ // Cat is a Animal
	int age = 2;
	int weight=1;
	
	@Override //Override Annotation
	public void sound() {
		System.out.println("meow my weight is " +weight); // 자기 멤버변수를 이용한 값 호출... 부모형으로 선언해도 내부적으로는 자식형의 멤버변수에 접근할수있다
	}

//	@Override
//	public void eat() {
//		System.out.println("eat");
//	}
	
	public void run() {
		System.out.println("run");
	}
	
	public void test() {
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(super.age);
		System.out.println("--");
		System.out.println(bodyColor);
		System.out.println(this.bodyColor);
		System.out.println(super.bodyColor);
		System.out.println("---");
		System.out.println(weight);
		System.out.println(this.weight);
		//System.out.println(super.weight); //weight는 부모 클래스에 없다
		System.out.println("---");
		sound();
		this.sound();
		super.sound();
		System.out.println("---");
		eat();
		this.eat(); 
		super.eat();
		System.out.println("---");
		run();
		this.run();
		//super.run(); //자식에만 있는 메소드는 super 키워드로 접근 불가능함
		System.out.println("---");
	}
	
	Cat(){
		
	}
}


public class SuperKeywordExam {
	public static void main (String args[]) {
//		Cat cat = new Cat();
//		cat.test();
//		System.out.println(cat.age); 
//		System.out.println(cat.bodyColor);
//		System.out.println(cat.weight);
		
		
		
		Animal cat2 = new Cat(); //Animal 영역에 선언된 항목에만 접근 가능
		System.out.println(cat2.age); 
		System.out.println(cat2.bodyColor);
//		System.out.println(cat2.weight); //부모클래스에 없으므로 바로접근불가능
		cat2.eat();
		cat2.sound(); //Super클래스에 sound가 있지만 자식클래스에 있는 오버라이딩된 메소드가 동작함 (이걸 바탕으로 Strategy 패턴이 동작한다)
//		cat2.run(); //부모클래스에 없으므로 바로접근불가능
		
		//Downcasting을 이용해서 접근가능하도록 하면 자식클래스에만 있는 영역에 접근가능하다.
		Cat cat3 = null;
		if(cat2 instanceof Cat) {//Animal 형인 cat2가 Cat3형의 인스턴스가 될수있으면
			cat3 = (Cat)cat2; // cat3에 cat2를 연결해준다 Animal형 cat2와 Cat형 cat3는 같은 주소를 가리키지만 접근가능한 영역이 다르다	
		}		
		cat3.weight = 3; //접근이된다
		cat3.sound();
		cat2.sound(); //cat3에서 바꾼 값이 cat2에도 적용되었다
		
	}
	
}
