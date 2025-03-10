package ex0305.report.exception;

/**
 * 빈 파일일 경우 Exception
 */
public class EmptyFileException extends Exception{

	public EmptyFileException(){
		super();
	}
	public EmptyFileException(String message){
		super(message);
	}
	
}
