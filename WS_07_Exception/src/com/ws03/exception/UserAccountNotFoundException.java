package com.ws03.exception;

public class UserAccountNotFoundException extends Exception {

	UserAccountNotFoundException(){
		super();
	}
	public UserAccountNotFoundException(String message){
		super(message);
	}	
	
}
