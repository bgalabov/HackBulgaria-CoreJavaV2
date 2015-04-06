package com.hackbulgaria.corejava;

public class NullKeyOrValueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message=NullKeyOrValueException.class.getName() + "\n";

	public NullKeyOrValueException(Object s1, Object s2) {
		if(s1 == null) {
			this.message += "The <key> you're trying to put is null. ";
		}
		if(s2 == null) {
			this.message += "The <value> you're trying to put is null. ";
		}
		this.message += "NULL keys/values are disabled.";
	}
	
	public NullKeyOrValueException() {
		this.message = "aa";
	}

	public String toString() {
		return this.message;
	}

}
