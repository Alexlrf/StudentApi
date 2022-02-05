package com.apistudent.alex.domain;

public enum ExceptionMessage {
	
	not_found("Student not found"),
	bad_request("Invalid Request"),
	internal_error("Internal Errors");
	
	
	private String exceptionMessage;
	
	ExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	public String getText() {
        return this.exceptionMessage;
    }


}
