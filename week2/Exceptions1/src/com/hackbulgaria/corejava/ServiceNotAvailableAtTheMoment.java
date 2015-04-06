package com.hackbulgaria.corejava;

public class ServiceNotAvailableAtTheMoment extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	public ServiceNotAvailableAtTheMoment(String service, String reason) {
		this.message = service + "not avaible in current moment. " + "Reason: " +reason;
	}
	
	public ServiceNotAvailableAtTheMoment() {
		this.message = "Requested service is not avaible at the moment.";
	}
	
	public String toString() {
		return this.message;
	}

}
