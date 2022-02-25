package com.apistudent.alex.domain;

public enum EnumExceptionMessage {
	
	NOT_FOUND("Not Found"),
	BAD_REQUEST("Bad Request"),
	INTERNAL_ERROR("Internal Error");
	
	private String exceptionMessage;
	
	EnumExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	public String getText() {
        return this.exceptionMessage;
    }


}
