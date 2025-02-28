package ex0227.shoppingException;

/**
 * Visitor 나이가 조건에 맞지 않을때 지정된 메시지를 반환하는 exception
 */
public class VisitorAgeException extends Exception {
	//Runtime에 발생하는 Exception...
	public VisitorAgeException(){
		super("애들은 안돼...");
	}
	
	public VisitorAgeException(String message){
		super(message);
		
	}
	
}
