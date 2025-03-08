package mvc.exception;

/**
 * 중복 Id가 발견되었을때의 예외
 */
public class DuplicatedIdFoundException extends Exception{

	public DuplicatedIdFoundException(){
		super();
	}
	public DuplicatedIdFoundException(String message){
		super(message);
	}

	
}
