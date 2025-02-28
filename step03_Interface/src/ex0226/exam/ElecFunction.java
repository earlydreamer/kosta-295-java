package ex0226.exam;
/**
 * 		인터페이스에서 정의되는 모든 필드는 public static final이다
 * 		모든 메소드는 public abstract이다
 * 		public static final과 public abstract 제한자는 생략할 시 자동으로 붙는다. 
 * 		JDK 1.8 이상에서는 static과 default, private 제한자 설정이 가능하긴 하다 (흑마법 같은 것)
 * 
 */
public interface ElecFunction {
	//Elec에서 사용할 기능을 선언
	void start(); // public abstract 생략할 수 있다
	public abstract void stop();
	void display();

}
