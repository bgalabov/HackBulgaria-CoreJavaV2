package com.hackbulgaria.corejava;

public class GoOutTask extends Task{

	public GoOutTask() {
		this.hoursToComplete = 0.5f;
		this.priority = 5;
	}
	public GoOutTask(float hours) {
		this.hoursToComplete = hours;
		this.priority = 5;
	}
	
	public String ToString() {
		return this.getClass().getName();
	}
}
