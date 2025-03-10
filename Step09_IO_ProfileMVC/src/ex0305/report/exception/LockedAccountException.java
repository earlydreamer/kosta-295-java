package ex0305.report.exception;

/**
 * 잠금처리된 계정 커스텀 예외
 */
public class LockedAccountException extends Exception{
	public LockedAccountException(){
		super();
	}
	
	public LockedAccountException(String message){
		super(message);
	}

}
