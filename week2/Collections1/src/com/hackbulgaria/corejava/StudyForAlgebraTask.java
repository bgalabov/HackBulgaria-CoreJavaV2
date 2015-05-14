package com.hackbulgaria.corejava;


public class StudyForAlgebraTask extends Task{
	
	public StudyForAlgebraTask() {
		this.priority=Task.PRIORITY_TYPES.DEFAULT.getValue();
		this.hoursToComplete = this.priority*0.5f;
	}
	
	public StudyForAlgebraTask(int priority) {
		this.priority = priority;
		this.hoursToComplete = this.priority*0.5f;
	}
	
	public StudyForAlgebraTask(float hoursToComplete) {
		this.priority = Task.PRIORITY_TYPES.DEFAULT.getValue();
		this.hoursToComplete = hoursToComplete;
	}
	
	/*public String toString() {
		return this.getClass().getSimpleName();
	}*/
}
