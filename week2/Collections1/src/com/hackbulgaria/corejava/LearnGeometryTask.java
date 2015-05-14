package com.hackbulgaria.corejava;

public class LearnGeometryTask extends Task{

	public LearnGeometryTask() {
		this.priority=Task.PRIORITY_TYPES.DEFAULT.getValue();
		this.hoursToComplete = this.priority*0.5f;
	}
	
	public LearnGeometryTask(int priority) {
		this.priority = priority;
		this.hoursToComplete = this.priority*0.5f;
	}
	
	public LearnGeometryTask(float hoursToComplete) {
		this.priority = Task.PRIORITY_TYPES.DEFAULT.getValue();
		this.hoursToComplete = hoursToComplete;
	}

}
