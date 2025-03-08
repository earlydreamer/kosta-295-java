package mvc.exception;

/**
 * 파일 입출력 관련 오류가 발생했을때의 예외
 */
public class FileIoFailException extends Exception {
	public FileIoFailException(){
		super();
	}
	
	public FileIoFailException(String message){
		super(message);
	}
	
	
}
