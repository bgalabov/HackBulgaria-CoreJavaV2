package com.hackbulgaria.corejava;

public class IllegalModificationException extends RuntimeException {
	private String message=IllegalModificationException.class.getName() +"\n";
	
	public IllegalModificationException() {
		this.message += "You are trying to modify immuted object.";
	}
	
	public String toString() {
		return this.message;
	}
}
