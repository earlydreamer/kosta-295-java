package ex0305.report.exception;

/**
 * 파일입출력 실패 관련 Exception
 */
public class FileIoFailException extends Exception{
	public FileIoFailException(){
		super();
	}
	public FileIoFailException(String message){
		super(message);
	}

}
