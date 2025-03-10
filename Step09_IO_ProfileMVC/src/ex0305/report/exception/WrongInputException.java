package ex0305.report.exception;

/**
 * 잘못된 입력 예외
 */
public class WrongInputException extends Exception {

	public WrongInputException(){
		super();
	}
	public WrongInputException(String message) {
		super(message);
	}
}
