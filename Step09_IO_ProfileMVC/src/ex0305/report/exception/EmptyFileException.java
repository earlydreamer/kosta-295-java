package ex0305.report.exception;

public class EmptyFileException extends Exception{

	public EmptyFileException(){
		super();
	}
	public EmptyFileException(String message){
		super(message);
	}
	
}
