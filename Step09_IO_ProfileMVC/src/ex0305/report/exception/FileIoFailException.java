package ex0305.report.exception;

public class FileIoFailException extends Exception{
	public FileIoFailException(){
		super();
	}
	public FileIoFailException(String message){
		super(message);
	}

}
