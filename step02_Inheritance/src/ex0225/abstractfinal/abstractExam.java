package ex0225.abstractfinal;

/**
 * 모든 동물의 공통의 속성과 메소드를 정의
 */
public class abstractExam {

	/**
	 * 동물들이 가진 메소드를 모두 호출
	 */
	public static void test(Animal anim) {//매개변수를 이용한 다형성
		anim.eat();
		anim.sound();
		anim.run();
	}
	
	public static void main (String args[]) {
		
	//필드를 이용한 다양성
		Animal anim = null;
		anim = new Dog();
		test(anim);
		anim = new Cat();
		test(anim);
		anim = new Pig();
		test(anim);

		
		
	}
	
}


class  Dog extends Animal{
	public void sound() {
		System.out.println("멍");
	}
	public void run() {
		System.out.println("뛴다");;
		
	}
	
}

class Pig extends Animal{
	public void eat(){
		System.out.println("으어어");
	}
	public void sound() {
		System.out.println("꿀꿀");
	}
	public void run() {
		System.out.println("빠르지않다");;
		
	}
	
	
}

class Cat extends Animal{
	@Override
	public void sound() {
		// TODO Auto-generated method stub\
		System.out.println("야옹");
	}
		public void run() {
			System.out.println("잘 올라간다");
			
		}
		
	}
	

 abstract class Animal{
	 int feed;
	 public abstract void sound(); 
	 public void run() {};
	 public void eat() {
		 System.out.println("냐무");
	 };
	 
	 
 
	 
 
 }
 
 
 
 
