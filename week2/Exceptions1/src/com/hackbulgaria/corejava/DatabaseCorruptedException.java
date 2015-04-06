package com.hackbulgaria.corejava;

public class DatabaseCorruptedException extends RuntimeException{
	String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DatabaseCorruptedException(String msg) {
		this.message = msg;
	}
	
	@Override
	public String toString() {
		return this.message;
	}

}
