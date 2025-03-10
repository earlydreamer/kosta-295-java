package ex0305.report.exception;

/**
 * 동명이인 발견 Exception
 */
public class DuplicatedNameException extends Exception{
	public DuplicatedNameException (){
		super();
	}
	public DuplicatedNameException (String message){
		super(message);
	}


}
