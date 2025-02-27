package ex0227.shoppingException;

/**
 * 방문객 Class
 */
public class Visitor {

	private int age;
	
	//Constructor
	
	Visitor(){
		age = 0;
	}
	Visitor(int age){
		this.age=age;
	}
	
	//getter-setter
	
	public void setAge(int age) {
		this.age =age;
	}
	
	public int getAge() {
		return this.age;
	}
	
}
