package mvc.exception;

/**
 * 잘못된 입력이 들어왔을 때의 예외처리
 */
public class WrongInputException extends Exception{

	public WrongInputException(){
		super();
	}
	public WrongInputException(String message){
		super(message);
	}
}
