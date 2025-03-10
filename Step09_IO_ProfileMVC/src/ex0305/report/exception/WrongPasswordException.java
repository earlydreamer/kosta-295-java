package ex0305.report.exception;

/**
 * 비밀번호가 틀렸을 경우의 예외
 */
public class WrongPasswordException extends Exception{
	public WrongPasswordException(){
		super();
	}
	
	public WrongPasswordException(String message){
		super(message);
	}
}
