package com.apistudent.alex.domain;

public enum ExceptionMessage {
	
	NOT_FOUND("Not Found"),
	BAD_REQUEST("Bad Request"),
	INTERNAL_ERROR("Internal Error");
	
	
	private String exceptionMessage;
	
	ExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	public String getText() {
        return this.exceptionMessage;
    }


}
