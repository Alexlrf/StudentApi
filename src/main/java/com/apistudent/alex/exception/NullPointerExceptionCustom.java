package com.apistudent.alex.exception;

public class NullPointerExceptionCustom extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NullPointerExceptionCustom(String message) {
		super(message);
	}

}
