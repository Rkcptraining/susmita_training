package com.whatsapp.exception;

public class UserNotExistException extends Exception {
	String msg;
	public UserNotExistException(String msg) {
		this.msg=msg;
	}
	
	public String toString() {
		return "ha ha ha i am custom exception "+msg;
	}

}
