package com.apistudent.alex.exception;

public class StudentBadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public StudentBadRequestException(String message) {
		super(message);
	}

}
