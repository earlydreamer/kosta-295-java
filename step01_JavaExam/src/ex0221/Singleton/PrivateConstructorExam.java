package ex0221.Singleton;

/**
 * private 생성자 생성
 * static 멤버 필드를 이용해 자신 생성 // static Singleton singleton = new Singleton();
 * 멤버 필드 (현재 클래스를 생성한 필드)를 리턴해주는 메소드 제공
 */

class Singleton{
	
	private static Singleton singleton = new Singleton(); 
	private static int a=0;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public int getA() {
		return a;
	}
	
	
}

public class PrivateConstructorExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singleton s = Singleton.getInstance();		
		s.getA();
		
		Singleton s2 = Singleton.getInstance();
		s2.getA();
		

	}

}
