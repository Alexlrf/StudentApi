package com.apistudent.alex.domain;

public enum MaritalStatus {
	
	single("single"),
	married("married"),
	widow("widow"),
	do_not_declare("do_not_declare");
	
	private String maritalState;
	
	MaritalStatus(String maritalState) {
		this.maritalState = maritalState;
	}

}
