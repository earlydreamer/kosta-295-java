package ex0305.report.exception;

/**
 * 사용자정의 예외
 * @author 박재현
 * 2025-03-06
 */
public class ProfileNotFoundException extends Exception {

	public ProfileNotFoundException() {
		super();
	}
	
	public ProfileNotFoundException(String message) {
		super(message);
	}
	
	
}
