package com.hackbulgaria.corejava;

public class InvalidTimeException extends Exception {
	String message;
	
	InvalidTimeException(String msg){
		this.message=msg;
	}
	
	public String toString(){
		return message;
	}

}
